package homework.ex2.v2;
import java.io.Serializable;

///////////////////////////////숙제////////////////////////////////////////
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Subject implements Serializable{
		
	private static final long serialVersionUID = 1328042168303275018L;


	
	private int grade;					
	private int semester;
	private String name;
	
	
	
	@Override
	public String toString() { //
		return grade + "학년 " + semester + "학기 " + name;
	}
	
	
									
	
	
	
	
}
