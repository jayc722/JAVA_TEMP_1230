package broadcast_sample;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TimeTable implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private int time;
	private int min;
	private String name;
	private String types;
	
	
	
	//toString 오버라이딩
	@Override
	public String toString() {
		String tmp = time + " " + min + name + " | 장르: " + types;
		/*for(String str : types) {
			tmp += "[" + str + "] ";
		}*/
		return tmp;
	}
	
	//public void update
	
	
	//equals 오버라이딩
	
	
}
