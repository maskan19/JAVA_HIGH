package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.List;

public class ArrayListTest01 {

	public static void main(String[] args) {
	
		//ArrayList는 기본적인 사용법이 Vector와 같다.
		ArrayList list1 = new ArrayList();
		
		//add()메서드를 이용해 추가한다.
		list1.add("aaa");
		list1.add("bbb");
		list1.add(123);
		list1.add('k');
		list1.add(false);
		list1.add(123.45);
		
		System.out.println("size = " + list1.size()); //size = 6
		System.out.println("list1 = " + list1.toString()); //list1 = [aaa, bbb, 123, k, false, 123.45]
		
		//get()메서드로 데이터를 꺼내온다.
		System.out.println("1번째 데이터 : " + list1.get(1)); //1번째 데이터 : bbb
		
		//데이터 끼워넣기
		list1.add(3, "zzz");
		System.out.println("list1 = "+ list1); //list1 = [aaa, bbb, 123, zzz, k, false, 123.45]
		//데이터 변경하기
		String temp = (String)list1.set(3, "yyy"); //제네릭 설정을 하지 않아서 형변환까지 해야 함
		System.out.println("temp = " + temp); //temp = zzz
		System.out.println("list1 = " + list1); //list1 = [aaa, bbb, 123, yyy, k, false, 123.45]
		
		//삭제도 같다.
		list1.remove(3);// 3번 인덱스의 데이터 삭제 
		System.out.println("list1 = " + list1); //list1 = [aaa, bbb, 123, k, false, 123.45]
		
		list1.remove("bbb");
		System.out.println("list1 = " + list1); //list1 = [aaa, 123, k, false, 123.45]
		
		//제네릭을 사용할 수 있다.
		List<String> list2 = new ArrayList<>();
		list2.add("AAAA");
		list2.add("BBBB");
		list2.add("CCCC");
		list2.add("DDDD");
		list2.add("EEEE");
		list2.add("FFFF");
		
		for(int i = 0; i<list2.size(); i++){
			System.out.println(i + "> " + list2.get(i));
		}
//		0> AAAA
//		1> BBBB
//		2> CCCC
//		3> DDDD
//		4> EEEE
//		5> FFFF
		
		for(String str : list2){
			System.out.println(str);
		}
//		AAAA
//		BBBB
//		CCCC
//		DDDD
//		EEEE
//		FFFF
		
		//contains(비교객체) > 리스트에서 비교 객체가 있으면 true, 없으면 false를 반환한다.
		System.out.println("DDDD값 존재 여부 : " + list2.contains("DDDD")); //DDDD값 존재 여부 : true
		System.out.println("ZZZZ값 존재 여부 : " + list2.contains("ZZZZ")); //ZZZZ값 존재 여부 : false
		
		//indexOf(비교객체) > 리스트에 '비교객체'가 있으면 '비교객체가 위치한 index값을 반환하고 없는 경우 -1을 반환한다.
		System.out.println("DDDD의 위치값 : " + list2.indexOf("DDDD")); //DDDD의 위치값 : 3
		System.out.println("ZZZZ의 위치값 : " + list2.indexOf("ZZZZ")); //ZZZZ의 위치값 : -1
		
		// toArray() > 리스트 안의 데이터를 Object형 배열로 변환하여 반환한다. 
		// toArray(new 제네릭타입[0]) > 제네릭 타입의 배열로 변환해서 반환한다. [0]의 숫자는 아무거나 입력해도 됨.
		Object[] strArr = list2.toArray();
		System.out.println(strArr.length); //6
		
		for(int i = 0; i<strArr.length; i++){
			System.out.println(i + "> " + strArr[i]);
		}
//		0> AAAA
//		1> BBBB
//		2> CCCC
//		3> DDDD
//		4> EEEE
//		5> FFFF
		
		String[] strArr2 = list2.toArray(new String[0]);
		for(String str : strArr2){
			System.out.println(str);
		}
//		AAAA
//		BBBB
//		CCCC
//		DDDD
//		EEEE
//		FFFF
		
		System.out.println(list2);
		
		
	}
	
}
