package homework.ex2.v2;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;


@Data
public class StudentManager {

	
	private List<Student> list;
	
	public StudentManager(List<Student> list) {
		
		if(list == null) this.list = new ArrayList<Student>(); //load시 아무것도 없으면 새로 만들기
		else this.list = list;
		
	}
	
	public StudentManager() {
		list = new ArrayList<Student>();
	}

	public boolean insertStudent(Student std) {
		if(std == null || list == null)	return false;
		if(list.contains(std))return false;
		return list.add(std);			//->리스트(중복허용) : 추가하면 무조건 true
		
	}

	public boolean updateStudent(Student selStd, Student newStd) {
		if(selStd == null || newStd == null || list == null) return false;		//널체크 잊지말것
		if(!list.contains(selStd)) return false;
		Student tmp = getStudent(newStd);		//학년반번호 같은 학생 찾기
		//수정될 정보가 없거나 이전 학생 정보이면 수정이 이뤄짐(1학년1반1번에서 없는 자리로 가거나 1학년1반1번으로 갈때)
		if(tmp==null||tmp==getStudent(selStd)){  //주소비교...eqauls가 아니라==사용
			getStudent(selStd).update(newStd);	
			return true;
		}
		
		
		return false;
	}

	public Student getStudent(Student std) {
		int index = list.indexOf(std);
		
		return index < 0 ? null : list.get(index);
	}

	public boolean deleteStudent(Student std) {
		if (std == null || list == null)return false;		//얘는 굳이 체크할필요 없긴한데...
		return list.remove(std);
		
		
	}

	public void printStudent(Student std) {
		if(std == null) {
			System.out.println("학생 정보가 없습니다.");
			return;
		}
		if(list == null) {
			System.out.println("학생 리스트가 없습니다.");
			return;
		}
		Student tmp = getStudent(std);
		if(tmp == null) {
			System.out.println("일치하는 학생이 없습니다.");
			return;
		}
		tmp.print();
		
		
	}

	public boolean insertScore(Student std, SubjectScore subjectScore) {
		if (std == null || list == null || subjectScore == null)return false;
		std = getStudent(std);
		if (std == null)	return false;
		return std.insertScore(subjectScore);
		
	}

	public boolean updateScore(Student std, Subject subject, SubjectScore subjectScore) {
		if (std == null || list == null || subject == null ||subjectScore == null)return false;
		std = getStudent(std);
		if (std == null)	return false;
		return std.updateScore(subject, subjectScore);
	}

	public boolean deleteScore(Student std, Subject subject) {
		if (std == null || list == null || subject == null)return false;
		std = getStudent(std);
		if (std == null)	return false;
		return std.deleteScore(subject);
	}

	public void printScore(Student std, Subject subject) {
		if (std == null || list == null || subject == null) {
			System.out.println("출력할 수 없습니다.");
			return;
		}
		std = getStudent(std);
		if (std == null) {
			System.out.println("일치하는 학생이 없습니다.");
			return;
		}
		std.printScore(subject);
		
	}
}
