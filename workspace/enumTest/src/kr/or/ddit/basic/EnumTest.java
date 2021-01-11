package kr.or.ddit.basic;

/*
 * - enum(열거형) : 서로 관련있는 상수들의 집합을 나타낸다.
 * 클래스처럼 보이게 하는 상수
 * 열거형은 클래스처럼 독립된 java파일에 만들 수 있고, 
 * 하나의 java파일에 클래스와 함께 만들 수 있고,
 * 클래스 내부에 내부 클래스처럼 만들 수 있다.
 * 
 * - 열거형의 속성 및 메서드
 * 1) name() : 열거형 상수의 이름을 문자열로 반환한다.
 * 2) ordinal() : 열거형 상수가 정의된 순서값(index값)을 반환한다.(0부터 시작)
 * 3) valueOf("열거형 상수명") : 지정된 열거형에서 '열거형 상수명'과 일치하는 열거형 상수를 반환한다.
 * 4) 열거형 이름.상수명> valueOf()메서드와 기능이 같다.
 * 
 * - 열거형 선언하기
 * 방법1)
 * enum 열거형 이름 {상수명1, 상수명2, ...}
 */

public class EnumTest {

	public enum Color {
		RED, GREEN, BLUE
	}

	public enum Count {
		ONE, TWO, THREE
	}

	public static void main(String[] args) {

		System.out.println("Red = " + ConstTest.RED);
		System.out.println("Three = " + ConstTest.THREE);

		if (ConstTest.RED == ConstTest.ONE) {
			System.out.println("...");
		} else {
			System.out.println("???");
		}
		
		Color myCol = Color.valueOf("GREEN"); //Color.GREEN과 동일
		Count myCnt = Count.ONE; //Count.valueOf("ONE")과 동일
		
		System.out.println("myCol : " + myCol.name());
		System.out.println("myCnt : " + myCnt.name());
		
		System.out.println("myCol ordinal : " + myCol.ordinal());
		System.out.println("myCnt ordinal : " + myCnt.ordinal());

	}

}
