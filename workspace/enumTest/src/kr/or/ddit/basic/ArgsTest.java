package kr.or.ddit.basic;

public class ArgsTest {

	/*
	 * 메서드 만들기 매개변수로 받은 정수들의 합계를 구하는 메서드를 작성하시오. 
	 * (매개 변수의 정수들은 상황에 따라 개수가 다르다.)
	 */

	// 배열을 이용한 메서드
	public int sumArr(int[] data) {
		int sum = 0;
		for (int i = 0; i < data.length; i++) {
			sum += data[i];
		}
		return sum;
	}

	// static : 대부분의 메서드들은 인스턴스 메서드

	// 가변형 인수 : 메서드의 매개변수의 개수가 호출될 때마다 다를 경우 사용한다.
	// 가변형 인수는 메서드 안에서는 배열로 처리된다.
	// 가변형 인수는 한가지 자료형만 사용할 수 있다.

	public int sumArg(int... data) { /* ...은 메서드 안에서 배열로 취급된다. */
		int sum = 0;
		for (int i = 0; i < data.length; i++) {
			sum += data[i];
		}
		return sum;
	}

	// 가변형 인수와 일반 인수를 같이 사용하는 경우
	// 가변형 인수를 제일 뒤쪽에 배치해야한다.
	public String sumArg2(String name, int... data) {
		int sum = 0;
		for (int i = 0; i < data.length; i++) {
			sum += data[i];
		}
		return name + "씨의 합계 : " + sum;
	}

	public void test(int a) {

	}

	public static void main(String[] args) {

		ArgsTest at = new ArgsTest();

		int[] nums = { 100, 200, 300 };
		int result = at.sumArr(nums);
		System.out.println(result);
		System.out.println(at.sumArr(new int[] { 100, 200, 300 }));
		System.out.println();

		int k = 10;
		at.test(k);
		at.test(300);

		System.out.println("가변형 인수 사용하기");
		System.out.println(at.sumArg(100, 200, 300));
		System.out.println(at.sumArg(10, 12, 15, 16, 17));

		System.out.println(at.sumArg2("홍길동", 1, 2, 4, 5, 1, 6, 9));

	}

}
