package homework.ex2.v1;

import java.io.Serializable;
import java.util.Objects;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SubjectScore implements Serializable{

	private static final long serialVersionUID = 1328042168303275018L;

	
	private Subject subject;
	private int score;
	
	
	@Override	//과목만으로 비교 가능하게 오버라이딩
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SubjectScore other = (SubjectScore) obj;
		return Objects.equals(subject, other.subject);
	}


	@Override
	public String toString() {
		return subject + " " + score + "점";
	}
	
	
	
	
	
}
