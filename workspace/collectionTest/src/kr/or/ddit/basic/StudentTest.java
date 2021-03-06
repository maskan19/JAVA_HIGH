package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/*
 * 문제) 학번, 이름, 국어점수, 영어점수, 수학점수, 총점, 등수를 멤버로 갖는 Student 클래스를 작성한다.
 * 이 클래스의 생성자에서는 학번, 이름, 국어점수, 영어점수, 수학점수만 매개변수로 받아서 초기화 처리한다.
 * 이 Student 객체는 List에 저장하여 관리한다.
 * 
 * List에 저장된 데이터들을 학번의 오름차순으로 정렬할 수 있는 내부 정렬 기준을 구현하고, 
 * 총점의 역순으로 정렬하는데 총점이 같으면 이름의 오름차순으로 정렬되는 외부 정렬기준 클래스를 작성, 정렬된 결과를 출력하시오.
 * (등수는 List에 전체 데이터가 추가된 후에 저장되도록 한다.)
 */

public class StudentTest {
	
	public void setRanking(List<Student> studentlist) {
		for (Student std1 : studentlist) {
			int rank = 1;
			for (Student std2 : studentlist) {
				if (std1.getTotal() < std2.getTotal()) {
					rank++;
				}
			}
			std1.setRank(rank);
		}
	}

	public static void main(String[] args) {

		ArrayList<Student> scores = new ArrayList<>();
		for (int i = 1; i <= 99; i++) {
			scores.add(new Student((int) (Math.random() * 10000), "학생" + i,
					(int) (Math.random() * 101), (int) (Math.random() * 101),
					(int) (Math.random() * 101)));
		}

		StudentTest st = new StudentTest();
		st.setRanking(scores);
//		System.out.println(scores);
		
		Collections.sort(scores, new row());

		System.out.println("학번\t이름\t국어\t영어\t수학\t총점\t등수");
		for (Student mem : scores) {
			System.out.println(mem.getS_No() + "\t"
					+ mem.getS_name() + "\t"
					+ mem.getScoreKor() + "\t"
					+ mem.getScoreEng() + "\t"
					+ mem.getScoreMath() + "\t"
					+ mem.getTotal() + "\t" + mem.getRank());
		}

	}

}

class Student implements Comparable<Student> {

	private int s_No;
	private String s_name;
	private int scoreKor;
	private int scoreEng;
	private int scoreMath;
	private int total;
	private int rank;

	public Student(int s_No, String s_name, int scoreKor, int scoreEng,
			int scoreMath) {
		super();
		this.s_No = s_No;
		this.s_name = s_name;
		this.scoreKor = scoreKor;
		this.scoreEng = scoreEng;
		this.scoreMath = scoreMath;
		this.setTotal(scoreKor + scoreEng + scoreMath);

	}

	public int getS_No() {
		return s_No;
	}

	public void setS_No(int s_No) {
		this.s_No = s_No;
	}

	public String getS_name() {
		return s_name;
	}

	public void setS_name(String s_name) {
		this.s_name = s_name;
	}

	public int getScoreKor() {
		return scoreKor;
	}

	public void setScoreKor(int scoreKor) {
		this.scoreKor = scoreKor;
	}

	public int getScoreEng() {
		return scoreEng;
	}

	public void setScoreEng(int scoreEng) {
		this.scoreEng = scoreEng;
	}

	public int getScoreMath() {
		return scoreMath;
	}

	public void setScoreMath(int scoreMath) {
		this.scoreMath = scoreMath;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	@Override
	public String toString() {
		return "Student [s_No=" + s_No + ", s_name=" + s_name + ", scoreKor="
				+ scoreKor + ", scoreEng=" + scoreEng + ", scoreMath="
				+ scoreMath + ", total=" + total + ", rank=" + rank + "]";
	}

	@Override
	public int compareTo(Student stu) {
		return new Integer(this.s_No).compareTo(stu.s_No); /*아래와 동일*/
//		return Integer.compare(this.s_No, stu.s_No);
	}

}

class row implements Comparator<Student> {
	@Override
	public int compare(Student s1, Student s2) {
		if (s1.getTotal() == s2.getTotal()) {
			return s1.getS_name().compareTo(s2.getS_name());
		} else
			return Integer.compare(s1.getTotal(), s2.getTotal()) * -1;
	}

}
