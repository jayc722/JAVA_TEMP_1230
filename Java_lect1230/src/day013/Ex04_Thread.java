package day013;

public class Ex04_Thread {

	public static void main(String[] args) {

		MyThread1 th1 = new MyThread1();
		th1.start();
		//th1.run();								//start는 잘 되지만 오버라이딩한 run은 안 됨
				
		
		Thread th2 = new Thread(new MyThread2());
		th2.start();
		//th2.run();
		
		
		Thread th3 = new Thread(() ->{			//runable 인터페이스를 구현한 익명 클래스 이용(람다식)
			for(int i = 0; i<100; i++) System.out.print("*");
		});
		th3.start();
		
		for(int i = 0; i<100; i++) System.out.print("|");		//섞여서 나온다.
		
		
		
		
	}

}










class MyThread1 extends Thread{
	
	@Override
	public void run() {
		for(int i = 0; i < 100; i++)System.out.print("-");
	}
	
}


class MyThread2 implements Runnable{

	@Override
	public void run() {
		for(int i = 0; i < 100; i++)System.out.print("+");
	}
	
	
	
}