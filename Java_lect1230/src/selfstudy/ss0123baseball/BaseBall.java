package selfstudy.ss0123baseball;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

@Data
public class BaseBall implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2152622310542313785L;
	private int count;
	private String nickName;
	private Date date;
	
	
	public BaseBall(int count, String nickName) {
		this.count = count;
		this.nickName = nickName;
		this.date = new Date();
	}



	@Override
	public String toString() {
		return count + " : " + nickName;
	}
	
	
	
}
