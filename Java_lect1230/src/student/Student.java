package student;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class Student {

	private int stdGrade;
	private int stdClass;
	private int stdNum;
	private String stdName;
	private List<SubjectScore> scores = new ArrayList<SubjectScore>();
	
	
	
	public Student(int stdGrade, int stdClass, int stdNum, String stdName) {
		super();
		this.stdGrade = stdGrade;
		this.stdClass = stdClass;
		this.stdNum = stdNum;
		this.stdName = stdName;
	}
	public Student(int stdGrade, int stdClass, int stdNum) {
		super();
		this.stdGrade = stdGrade;
		this.stdClass = stdClass;
		this.stdNum = stdNum;
		this.stdName = null;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		return stdGrade == other.stdGrade && stdClass == other.stdClass && stdNum == other.stdNum;
	}



	@Override
	public int hashCode() {
		return Objects.hash(stdGrade, stdClass, stdNum);
	}
	@Override
	public String toString() {
		return "학생 " + stdName + " : " + stdGrade + "학년 " + stdClass + "반 " + stdNum + "번";
	}
	
	
		
		
	
	
}
