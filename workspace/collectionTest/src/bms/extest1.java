package bms;

import java.util.Scanner;

public class extest1 {

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
//		3장 연산자
//
//
//		문제1 
//
//		변수 num의 값에 따라 양수, 음수, 0을 출력하는 코드를 작성하세요,
//		삼항연산자를  이용 
//
//		int num = 10
		int num = 10;
		String output  = num >= 0 ? (num == 0 ? "0" : "양수") : "음수";
		System.out.println("문제1 : "+ output);
		
//		문제2 
//
//		문자형 변수 ch가 영문(대문자 또는 소문자)자이거나 숫자일때만 
//		변수 b의 값이  true가 되도록 하는 코드를 작성하세요
//		삼항연산자이용 
//
//		char ch='z'
		char ch='z';
		boolean result = (ch >= 'A' && ch <= 'Z') || (ch >= 'a' && ch <= 'z') || (ch >= '0' && ch <= '9');
		System.out.println("문제2 : " + result);

//		문제3
//
//		문자형변수 ch의 값을 소문자로 변경하는 코드를 작성하세요
//		char ch='A'
		ch='A';
		System.out.println("문제3 : " + Character.toString(ch).toLowerCase());

//		4장 조건문과 반복문 (if, for, while, do~while)
//
//
//		문제 4
//		Math.random() 을 이용하여 1~6 사이의 임의의 정수를 변수 value 에 
//		저장하는 코드를 작성하세요 

		int value = (int)(Math.random()*6)+1;
		System.out.println("문제4 : " + value);

//		문제 5
//		1~100 까지의 합을 구하는 코드를 작성하세요 
		int sum = 0;
		for (int i = 1; i<=100; i++){
			sum +=i;
		}
		System.out.println("문제5 : " + sum);

//		문제6 
//		1~100사이의 랜덤수를 발생시켜 저장한다
//		 임의의 값을 입력받아 랜덤값을  맞추는 코드 작성하세요
//		 맞출때가지 계속 입력받고 맞추면 종료한다.
		int ran = (int)(Math.random()*100)+1;
		int input = 0;
		int count = 1;
		boolean check = true;
		System.out.println("문제6 : ");
		do{
			System.out.println(count + "회차 시도 : ");
			input = Integer.parseInt(s.nextLine());
			if(input==ran){
				check = false;
			}
			count++;
		}while(check);
		System.out.println("정답입니다.");

	}
}
