package day021;

import java.text.SimpleDateFormat;
import java.util.Date;

import lombok.Data;

@Data
public class Chat {

	//채팅 내역을 활용하는 클래스
	//메세지 대신 얘를 전달하는게 편함
	
	
	private String id;
	private String chat;
	private Date date;
	
	
	
	public String getDateStr() {
		SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return f.format(date);
	}
	
	
	@Override
	public String toString() {
		return id + " : " + chat + " (" + getDateStr() + ")";
	}


	public Chat(String id, String chat) {
		this.id = id;
		this.chat = chat;
		this.date = new Date();
	}
	
	
	
	
	
	
	
}
