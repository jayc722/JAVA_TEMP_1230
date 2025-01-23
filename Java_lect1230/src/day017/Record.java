package day017;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;


@Data
public class Record implements Serializable {	//시리얼라이저블 추가해야 주고받을수있음(중요)

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int count;
	private String nickName;
	private Date date;
	
	public Record(int count, String nickName) {
		this.count = count;
		//nickName은 최대3자, 3자 미만이면 ???로 채움
		
		if(nickName == null) nickName = " ";
		//nickname이 3자 이상이면 3자만 추출
		if(nickName.length() > 3) {
			this.nickName = nickName.substring(0, 3);
			return;
		}
		
		//3자 미만일 때 ?로 채움
		int repeatCount = 3 - nickName.length();
		this.nickName = nickName + "?".repeat(repeatCount);
		this.date = new Date();
		
		
	}

	@Override
	public String toString() {
		return nickName + " : " + count + "회";
	}
	
	
}
