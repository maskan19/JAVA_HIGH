package kr.or.ddit.basic;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public class SetText {

	public static void main(String[] args) {

		/*
		 * - List와 Set의 차이
		 * 
		 * 1. List
		 * - 데이터의 순서(index)가 있다.
		 * - 중복되는 데이터를 저장할 수 있다.
		 * 
		 * 2. Set
		 * - 데이터의 순서(index)가 없다.
		 * - 중복되는 데이터를 저장할 수 없다.
		 * 
		 * 
		 */
		
		HashSet<Object> hs1 = new HashSet<>();
		
//		Set에 데이터를 주가할 떄도 add()메서드를 사용한다.
//		add()메서드는 데이터 추가에 성공시 true, 실패시 false를 반환한다.
		hs1.add("AA");
		hs1.add("BB");
		hs1.add("CC");
		hs1.add(1);
		hs1.add("DD");
		hs1.add("EE");
		hs1.add(3);
		hs1.add(5);
		
		System.out.println("Set의 개수 : " + hs1.size()); //8
		System.out.println("Set데이터 : " + hs1); //[1, AA, 3, BB, 5, CC, DD, EE]
		
//		Set에 데이터를 추가할 때 중복되면 false를 반환하고
//		데이터 추가에 실패한다.
		boolean isAdd = hs1.add("FF");
		System.out.println("중복되지 않을 때 : " + isAdd); // true
		isAdd = hs1.add("AA");
		System.out.println("중복될 때 : " + isAdd); //false
		System.out.println("Set데이터 : " + hs1); //[1, AA, 3, BB, 5, CC, DD, EE, FF]
		
//		자료 삭제 메서드 remove(삭제할 데이터) 의 반환값 : 삭제 성공(true), 삭제 실패 (false)
//		자료 전체 삭제 메서드 clear() 
		
//		"FF"데이터를 "EE"로 변경하기
		
		hs1.remove("FF");
		hs1.add("EE");
		
//		hs1.clear();
//		System.out.println("set데이터 : " + hs1);
		
		/*
		 * Set의 데이터는 순서(index)가 없기 떄문에 List처럼 index로 데이터를 하나씩 불러올 수 없다.
		 * 데이터를 하나씩 얻기 위해서는 Iterator형 객체로 변환해야함.
		 * 
		 * Set형의 데이터를 Iterator형 객체로 변환하는 메서드 > iterator()
		 */
		
		//Set데이터를 Iterator로 변환하기
		Iterator<Object> it = hs1.iterator();
		
//		Iterator의 hasNext()메서드
//		Iterator의 포인터가 가리키는 곳의 다음 위치에 데이터가 있으면 true, 없으면 false 반환
		
//		Iterator의 next()메서드 >Iterator의 포인터를 다음번쨰 위치로 이동한 후 데이터를 반환
		while(it.hasNext()){
			System.out.print(it.next() + "\t");
		}// 1	AA	3	BB	5	CC	DD	EE
		System.out.println();
		
//		우리반의 학생들 중 번호를 이용하여 추첨하는 프로그램 작성하기
//		번호는 1번부터 25번까지 있고, 추첨할 인원은 3명이다.
//		당첨 번호를 출력하시오.
		HashSet<Integer> testSet = new HashSet<>();
		while (testSet.size() < 3) { // 중복일 경우 사이즈가 늘어나지 않음
			int random = (int) (Math.random() * 25) + 1;
			testSet.add(random);
		}
		System.out.println("당첨자 번호 : " + testSet);
		
//		Set유형의 데이터를 List형으로 변환하기
		ArrayList<Integer> testList = new ArrayList<>(testSet);
		
		System.out.println("List데이터 출력하기");
		for(int i : testList){
			System.out.println(i);
		}

	}

}
