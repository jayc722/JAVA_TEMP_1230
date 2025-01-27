package day018;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import lombok.Data;

@Data
public class Account implements Serializable, Cloneable{

	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Bank bank;//은행
	private String num;//계좌번호
	private String name;//이름
	private String pw;//비밀번호
	private long money;//잔액
	
	List <Item> list;  //입출금 내역(아이템 클래스 이용)
	
	


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Account other = (Account) obj;
		return bank == other.bank && Objects.equals(num, other.num);
	}





	@Override
	public String toString() {
		return "Account [bank=" + bank + ", num=" + num + ", name=" + name + ", money=" + money + ", list=" + list
				+ "]";
	}


	public Account(Bank bank, String num, String name, String pw) {//super();생략해도 기본생성자로 들어감
		this.bank = bank;
		this.num = num;
		this.name = name;
		this.pw = pw;
		list = new ArrayList<Item>();
	}
	
	@Override
	public Object clone() throws CloneNotSupportedException {
		Account account = (Account)super.clone();
		
		
		//입출금 내역도 복사본을 만들어서 복제
		List<Item> tmpList = new ArrayList<Item>();
		tmpList.addAll(account.getList());
		
		account.setList(tmpList);
		return account;
		
	}
/*	//조회를 위해 수정 -> 복사할때 얘를 그대로 붙여넣어서 나올때 값이 안 바뀜 ->위처럼 수정
	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone(); //여기 빨간줄에다 throw하면 위에 저 긴거 안적어도됨
	}
*/


/*

	public boolean deposit(long money) {
		if(money <= 0)return false;
		this.money += money;
		
		//입출금 내역을 추가
		
		Item item = new Item(Type.입금, money);
		list.add(item);
		
		return true;
		
		
		
	}





	public boolean withdrawal(long money) {
		if(money <= 0) {
			return false;
		}
		money = -money;
		if(this.money + money < 0) {
			return false;
		}
		this.money += money;
		
		//입출금 내역을 추가
		
		Item item = new Item(Type.출금, money);
		list.add(item);
		
		return true;
	}



*/

	public boolean depositAndWithdrawal(long money, Type type) {
		if(money <= 0) {
			return false;
		}
		money = type == Type.입금 ? money : -money; 	//코드 한번에

		if(this.money + money < 0) {
			return false;
		}
		
		this.money += money;
		
		//입출금 내역을 추가
		
		Item item = new Item(Type.출금, money);
		list.add(item);
		
		return true;
	}





	public void print() {
		System.out.println("--------------------");
		System.out.println("은행 : " + bank);
		System.out.println("계좌 : " + num);
		System.out.println("이름 : " + name);
		System.out.println("잔액 : " + money);
		System.out.println("--------------------");
		
		if(list == null || list.isEmpty()) {
			System.out.println("입출금 내역이 없습니다.");
			System.out.println("--------------------");
			return;
			
		}
		for(Item item : list)System.out.println(list );
			
		
		
	}
	
	
	
}
