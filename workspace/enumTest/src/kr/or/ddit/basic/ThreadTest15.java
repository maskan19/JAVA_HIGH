package kr.or.ddit.basic;

//쓰레드에서 객체를 공통으로 사용하는 예제

/* 원주욜을 계산하는 쓰레드와 계산된 원주율을 출력하는 쓰레드
 * 
 * 이 때 원주율을 저장하는 객체를 두 쓰레드에서 공통으로 사용해 처리한다.
 * 
 * */
public class ThreadTest15 {

	public static void main(String[] args) {
		
		//공통으로 사용할 객체 생성
		ShareData sd = new ShareData();

		// 각각의 쓰레드 객체를 생성하고 공통으로 사용할 객체를 쓰레드 객체에 파라미터로 넣는다.
		// CalcPIThread cal = new CalcPIThread(sd);
		CalcPIThread cal = new CalcPIThread();
		cal.setSd(sd);

		PrintPIThread prn = new PrintPIThread(sd);

		cal.start();
		prn.start();

	}

}

class CalcPIThread extends Thread {
	private ShareData sd;

	// 생성자
	// public CalcPIThread(ShareData sd) {
	// this.sd = sd;
	// }

	@Override
	public void run() {
		// 원주율(1 - 1/3 + 1/5 - 1/7 + 1/9 - ...) * 4
		double sum = 0.0;
		for (int i = 1; i <= 100000; i += 2) {
			if ((i / 2) % 2 == 0) {
				sum += (1.0 / i);
			} else {
				sum -= (1.0 / i);
			}
		}
		// 계산이 완료된 결과를 ShareData객체에 저장한다.
		sd.setResult(sum * 4);
		sd.setChk(true);
	}

	// 생성자 대신 세터 이용하기
	public ShareData getSd() {
		return sd;
	}

	public void setSd(ShareData sd) {
		this.sd = sd;
	}
}

class PrintPIThread extends Thread {
	private ShareData sd;

	public PrintPIThread(ShareData sd) {
		this.sd = sd;
	}

	@Override
	public void run() {
		while (true) {
			if (sd.isChk()) {
				System.out.println();
				System.out.println("결과 : " + sd.getResult());
				System.out.println("PI : " + Math.PI);
				break;
			}
		}
	}

}

class ShareData{
	
	private double result; //계산된 원주율이 저장될 변
	private boolean chk; //계산이 완료되었는지 확인하는 변수 false로 초기화 되어있음
	
	//volatile : 이 키워드가 붙은 변수는 값이 변경되는 즉시 변수에 적용시킨다. 
	// 즉  CPU의 코어에 캐쉬를 사용하지 않고 직접 메모리의 데이터를 입출력한다.
	
	public double getResult() {
		return result;
	}

	public void setResult(double result) {
		this.result = result;
	}

	public boolean isChk() {
		return chk;
	}

	public void setChk(boolean chk) {
		this.chk = chk;
	}

}
