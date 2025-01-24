package ss.day018.copy;

import java.io.Serializable;
import java.util.Objects;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Bank implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String bankName, userName, accountNum, password;
	private int balance;
	
	public Bank(String bankName, String accountNum, String password) {
		//확인용
		this.bankName = bankName;
		this.accountNum = accountNum;
		this.password = password;
		this.userName = "";
		
	}
	
	public Bank(String bankName, String userName, String accountNum, String password) {
		//생성용
		this.bankName = bankName;
		this.userName = userName;
		this.accountNum = accountNum;
		this.password = password;
		this.balance = 0;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Bank other = (Bank) obj;
		return Objects.equals(accountNum, other.accountNum);
	}


	@Override
	public int hashCode() {
		return Objects.hash(accountNum);
	}



	public void print() {
		System.out.println("은행이름 : " + this.bankName);
		System.out.println("예금주명 : " + this.userName);
		System.out.println("계좌번호 : " + this.accountNum);
		System.out.println("비밀번호 : " + this.password);
		
	}



	@Override
	public String toString() {
		return "Bank [bankName=" + bankName + ", userName=" + userName + ", accountNum=" + accountNum + ", password="
				+ password + "]";
	}
	
	
}
