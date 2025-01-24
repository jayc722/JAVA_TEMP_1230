package day018;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

@Data
public class Item implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Date date; //입출금 날짜
	//private String content; //입금 출금
	private Type type; //입출금 enum으로.. 어렵게도 가능하지만 일단은
	private int money; //금액

}
