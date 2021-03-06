package kr.or.ddit.basic;

import java.util.LinkedList;

public class StackQueueTest {

	/*
	 * 자료구조 (데이터를 관리하는 틀)
	 * 
	 * Stack : 후입선출(LIFO)의 자료 구조(동명의 클래스 있음)
	 * 
	 * Queue : 선입선출(FIFO)의 자료 구조(동명의 인터페이스 있음)
	 * 
	 * - Stack과 Queue는 LinkedList를 이용하여 사용할 수 있다.
	 */

	public static void main(String[] args) {

		/*
		 * Stack의 명령
		 * 1. 자료 입력 : push(입력값)
		 * 2. 자료 출력 : 
		 * 				pop() > 자료를 꺼내온 후 꺼내온 자료를 Stack에서 삭제한다.
		 * 				peek() > 삭제 없이 자료를 꺼내온다.(주로 자료 확인용으로 사용)
		 */

		LinkedList<String> stack = new LinkedList<>();

		stack.push("홍길동");
		stack.push("일지매");
		stack.push("강감찬");
		stack.push("변학도");

		System.out.println("현재 stack값 : " + stack);

		String data = stack.pop();
		System.out.println("꺼내온 값 : " + data); // 변학도
		System.out.println("꺼내온 값 : " + stack.pop()); // 강감찬

		System.out.println("현재 stack값 : " + stack);

		stack.push("성춘향");
		System.out.println("추가 후 stack값 : " + stack);
		System.out.println("꺼내온 값 : " + stack.pop()); // 성춘향

		System.out.println("삭제 없이 꺼내온 값 : " + stack.peek());
		System.out.println("현재 stack값 : " + stack);
		
		/*
		 * Queue의 명령
		 * 1. 자료 입력 : offer(입력값)
		 * 2. 자료 출력 : 
		 * 				poll() > 자료를 꺼내온 후 Queue에서 꺼내온 자료를 삭제한다.
		 * 				peek() > 삭제 없이 자료를 꺼내온다.(주로 자료 확인용으로 사용)
		 */

		LinkedList<String> queue = new LinkedList<>();

		queue.offer("홍길동");
		queue.offer("일지매");
		queue.offer("강감찬");
		queue.offer("변학도");

		System.out.println("현재 queue값 : " + queue);

		String temp = queue.poll();
		System.out.println("꺼내온 값 : " + temp);
		System.out.println("꺼내온 값" + queue.poll());
		System.out.println("현재 queue값 : " + queue);

		queue.offer("성춘향");
		System.out.println("현재 queue값 : " + queue);
		System.out.println("꺼내온 값" + queue.poll());
		System.out.println("현재 queue값 : " + queue);

		System.out.println("삭제 없이 꺼내온 값" + queue.peek());

	}

}
