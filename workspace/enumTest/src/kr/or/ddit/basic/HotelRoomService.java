package kr.or.ddit.basic;

import java.util.Scanner;

public class HotelRoomService {
	
	static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("*********************************************\n"
				+ "       호텔문을 열었습니다. 어서오십시요.\n"
				+ "*********************************************");
		while(true){
			System.out.print("-----------------------------------------------------------\n"
					+ "어떤 업무를 하시겠습니까?\n"
					+ "1. 체크인    2. 체크아웃    3. 객실상태    4. 업무종료\n"
					+ "-----------------------------------------------------------\n"
					+ "선택>>");
			String input = s.nextLine();
			switch(input){
			case "1" : 
				break;
			case "2" : 
				break;
			case "3" : 
				break;
			case "4" : 
				System.out.println("*********************************************\n"
						+ "       호텔문을 닫았습니다.\n"
						+ "*********************************************");
				System.exit(0);
			
			}
			
			
		}
		
		
		
	}
}

class Room{
	int roomNo;
	String roomK;
	String name;
	
	public Room(){
		
		
	}
}