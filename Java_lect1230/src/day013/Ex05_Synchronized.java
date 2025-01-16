package day013;

import lombok.AllArgsConstructor;
import lombok.Data;

public class Ex05_Synchronized {

	public static void main(String[] args) {
		BankBook bankBook = new BankBook("홍길동", 0);
		Customer1 c1 = new Customer1("홍길동", bankBook);
		Customer2 c2 = new Customer2("홍길동아빠", bankBook);
		

	}

}
@AllArgsConstructor
class Customer1 extends Thread{

	private String name;
	private BankBook bankBook;

	@Override
	public void run() {
		System.out.println(name + "님이" + 10000 + "원을 ATM으로 입금 중입니다.");
		bankBook.deposit(name, 10000);
	}
}
@AllArgsConstructor
class Customer2 extends Thread{

	private String name;
	private BankBook bankBook;

	@Override
	public void run() {
		System.out.println(name + "님이" + 10000 + "원을 ATM으로 입금 중입니다.");
		bankBook.deposit(name, 10000);

	}
}

@Data
@AllArgsConstructor
class BankBook{
	private String name;
	private int balance;


	public synchronized void deposit(String name, int money) {

		System.out.println(name + "님 - 입금 전 잔액 : ");
		balance += money;	//this 안붙여도 이름 달라서

		try {
			Thread.sleep(2000);			//2000밀리초(2초) 멈춤
		} catch (InterruptedException e) {

			e.printStackTrace();
		}	

		System.out.println(name + " : " + money + " 원 입금 . 잔액 : " + balance);


	}

}