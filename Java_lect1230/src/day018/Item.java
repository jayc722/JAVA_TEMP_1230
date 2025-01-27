package day018;

import java.io.Serializable;
import java.text.SimpleDateFormat;
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
	private long money; //금액

	public Item(Type type, long money) {
		
		this.type = type;
		this.money = money;
		this.date = new Date();
		
	}
	
	
	public String getDateStr() {			//->출력 위해
		SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return f.format(date);
	}

	@Override
	public String toString() {
		return getDateStr() + " " + type + " " + money + "원";
	}
}
