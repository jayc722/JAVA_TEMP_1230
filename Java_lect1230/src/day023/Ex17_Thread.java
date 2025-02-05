package day023;


public class Ex17_Thread {

	public static void main(String[] args) {
		MyThread1 th1 = new MyThread1();		//상속관계인 두 클래스는 형변환 가능
		th1.start();	//start는 새로운 쓰레드를 만들고 호출	
						//run은 해당 메쏘드를 직접 호출하는거기때문에 th1.run()하면 현재쓰레드에서 작동
				
		
		Thread th2 = new Thread(new MyThread2());	
		th2.start();
		
		

		
		
		Thread th3 = new Thread(() ->{			//runable 인터페이스를 구현한 익명 클래스 이용(람다식)
			for(int i = 0; i<100; i++) System.out.print("*");
		});
		
		th3.start();
		
			
		

	}
	

}
class MyThread1 extends Thread{	//thread 상속
	
	@Override	//run을 오버라이드 해줘야
	public void run() {
		for(int i = 0; i < 100; i++)System.out.print("-");
	}
	
}


class MyThread2 implements Runnable{	//runnable 인터페이스 구현

	@Override
	public void run() {
		for(int i = 0; i < 100; i++)System.out.print("+");
	}
	
}
	