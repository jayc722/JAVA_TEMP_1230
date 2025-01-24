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
	private int money;//잔액
	
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
		return super.clone(); //여기 빨간줄에다 throw하면 위에 저 긴거 안적어도됨
	}
	
}
