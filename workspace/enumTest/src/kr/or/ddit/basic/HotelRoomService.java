package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class HotelRoomService {

	static Map<Integer, Room> reserv = new HashMap<>();

	static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {
		HotelRoomService hrs = new HotelRoomService();
		int rNo = 0;
		String rNm = "";
		for (rNo = 200; rNo < 500; rNo += 100) {
			for (int i = 1; i < 10; i++) {
				if (rNo < 300) {
					rNm = "싱글룸";
				} else if (rNo < 400) {
					rNm = "더블룸";
				} else {
					rNm = "스위트룸";
				}
				Room hr = new Room();
				hr.setRoomNo(rNo + i);
				hr.setRoomK(rNm);
				hr.setName("-");
				reserv.put(rNo + i, hr);
			}
		}

		System.out.println("*********************************************\n"
				+ "       호텔문을 열었습니다. 어서오십시요.\n"
				+ "*********************************************");
		while (true) {
			System.out
					.print("-----------------------------------------------------------\n"
							+ "어떤 업무를 하시겠습니까?\n"
							+ "1. 체크인    2. 체크아웃    3. 객실상태    4. 업무종료\n"
							+ "-----------------------------------------------------------\n"
							+ "선택>>");
			String input = s.nextLine();
			switch (input) {
			case "1":
				hrs.chechIn();
				break;
			case "2":
				hrs.chechOut();
				break;
			case "3":
				hrs.roomStatus();
				break;
			case "4":
				System.out
						.println("*********************************************\n"
								+ "       호텔문을 닫았습니다.\n"
								+ "*********************************************");
				System.exit(0);

			}

		}

	}

	void chechIn() {
		System.out.print(""
				+ "----------------------------------------------\n"
				+ "   체크인 작업\n"
				+ "----------------------------------------------\n"
				+ " * 201~209 : 싱글룸\n" + " * 301~309 : 더블룸\n"
				+ " * 401~409 : 스위트룸\n"
				+ "----------------------------------------------\n"
				+ "방 번호 입력 >>");
		String rn = s.nextLine();
		int intrn = Integer.parseInt(rn);
		if (!reserv.containsKey(intrn)) {
			System.out.println(intrn + "호 객실은 존재하지 않습니다.");
		} else if (!reserv.get(intrn).getName().equals("-")) {
			System.out.println(intrn + "호 객실은 이미 손님이 있습니다.");
		} else {
			System.out.print("누구를 체크인 하시겠습니까?\n이름 입력 >> ");
			String name = s.nextLine();
			reserv.get(intrn).setName(name);
			System.out.println("체크인이 완료되었습니다.");
		}

	}

	void chechOut() {
		System.out.print(""
				+ "----------------------------------------------\n"
				+ "   체크아웃 작업\n"
				+ "----------------------------------------------\n"
				+ "체크아웃 할 방 번호를 입력하세요.\n" + "방번호 입력 >>");
		String rn = s.nextLine();
		int intrn = Integer.parseInt(rn);
		if (!reserv.containsKey(intrn)) {
			System.out.println(intrn + "호 객실은 존재하지 않습니다.");
		} else if (reserv.get(intrn).getName().equals("-")) {
			System.out.println(intrn + "호 객실에는 체크인 한 사람이 없습니다.");
		} else {
			System.out.println(intrn + "호 객실의 " + reserv.get(intrn).getName()
					+ "님 체크아웃을 완료하였습니다.");
			reserv.get(intrn).setName("-");
		}
	}

	void roomStatus() {

		System.out.println("----------------------------------------------\n"
				+ "		현재 객실 상태\n"
				+ "----------------------------------------------\n"
				+ "방 번호	 방 종류	 투숙객 이름\n"
				+ "----------------------------------------------");
		List<Room> room = new ArrayList<>(reserv.values());
		Collections.sort(room);
		for (Room rn : room) {
			System.out.println(rn.getRoomNo() + "\t" + rn.getRoomK() + "\t"
					+ rn.getName());
		}

	}

}

class Room implements Comparable<Room> {
	int roomNo;
	String roomK;
	String name;

	public int getRoomNo() {
		return roomNo;
	}

	public void setRoomNo(int roomNo) {
		this.roomNo = roomNo;
	}

	public String getRoomK() {
		return roomK;
	}

	public void setRoomK(String roomK) {
		this.roomK = roomK;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Room [roomNo=" + roomNo + ", roomK=" + roomK + ", name=" + name
				+ "]";
	}

	@Override
	public int compareTo(Room o) {
		// TODO Auto-generated method stub
		return new Integer(roomNo).compareTo(o.roomNo);
	}

}