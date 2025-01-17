package student;

import java.util.Objects;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Subject {

	private int sbjGrade;					
	private int sbjSemester;
	private String sbjName;
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Subject other = (Subject) obj;
		return sbjGrade == other.sbjGrade && Objects.equals(sbjName, other.sbjName) && sbjSemester == other.sbjSemester;
	}
	@Override
	public int hashCode() {
		return Objects.hash(sbjGrade, sbjName, sbjSemester);
	}
	@Override
	public String toString() {
		return sbjGrade + "학년 " + sbjSemester + "학기 " + sbjName;
	}
	
	
	
}
