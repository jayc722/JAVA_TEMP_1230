package selfstudy.day021;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;


@Data
@RequiredArgsConstructor
public class Chat implements Serializable, Cloneable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	
	private Account account;
	@NonNull
	private String chat;
	@NonNull
	private Date date;
	
	private String name;

	
	
	
	
	public Chat(@NonNull String chat, String name) {
		this.chat = chat;
		this.name = name;
		this.date = new Date();
	}
	
	
	
}
