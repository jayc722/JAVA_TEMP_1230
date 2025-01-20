package homework.ex2.v1;
///////////////////////////////숙제////////////////////////////////////////

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

//getter setter toString equals 등을 제공
@Data
//@AllArgsConstructor
@RequiredArgsConstructor		//(final붙은) 상수나 non null 가진 필드들만으로 생성자 만들어주는 애. (이런 방법도 있음)
public class Student implements Serializable{				//불러오기위해

	private static final long serialVersionUID = 1328042168303275018L;
	
	
	@NonNull		//null 값 가지지 않도록하는
	private int /*Integer로해도 상관x*/ grd, clssNum, chrNum;			//다 private 로 하는게 맞음. 일단
	@NonNull
	private String stdName;
	
	
	
	

	public List<SubjectScore> list = new ArrayList<SubjectScore>();		//학생 인스턴스 하나가 과목들을 각각 갖고 있음
									//private로 하는게 원래는 맞음. 게터세터 각각 입력해야
	
	//생성자 1 학년 반 번호 이름
	/*public Student(int grd, int clssNum, int chrNum, String stdName) {
		super();
		this.grd = grd;
		this.clssNum = clssNum;
		this.chrNum = chrNum;
		this.stdName = stdName;
	}*/
	//equals 오버라이딩
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		return chrNum == other.chrNum && clssNum == other.clssNum && grd == other.grd;
	}
	/* 			//없어도 상관없음(해시알고리즘 사용 안한다면)
	@Override
	public int hashCode() {
		return Objects.hash(chrNum, clssNum, grd);
	}
	*/
	
	public void print() {
		System.out.println("----------------------");
		System.out.println(grd + "학년 " + clssNum + " 반  "+chrNum + " 번 "  + stdName);
		System.out.println("----------------------");
		if(list.size() == 0) {
			System.out.println("등록된 성적이 없습니다.");
			return;
		}
		for(SubjectScore score : list) {
			System.out.println(score);
		}
		
		
	}

	public void update(Student newStd) {
		if(newStd == null)return;
		grd = newStd.grd;
		clssNum = newStd.clssNum;
		chrNum = newStd.chrNum;
		stdName = newStd.stdName;
		//성적은 복사 x 
		
	}

	public boolean insertScore(SubjectScore subjectScore) {
		if(list.contains(subjectScore))	return false;
		list.add(subjectScore);
		return true;
	}

	public void printScore(Subject subject) {
		int index = list.indexOf(new SubjectScore(subject, 0)); //objects.equals는 클래스가 다르면 무조건 false
		if(index < 0) {
			System.out.println("일치하는 성적이 없습니다.");
			return;
		}
		System.out.println(list.get(index));
	}

	public boolean updateScore(Subject subject, SubjectScore subjectScore) {
		if(subject == null || subjectScore == null)return false;//확신 못하니까...
		
		if(!list.contains(new SubjectScore(subject, 0)))return false;//등록돼있는 성적x
		//같은 과목 수정
		if(subject.equals(subjectScore.getSubject())) {
			list.remove(subjectScore);
			list.add(subjectScore);
			return true;
		}
		//다른 과목 수정
		//새 성적이 등록된 성적인지 확인
		if(list.contains(subjectScore))return false;
		
		list.remove(new SubjectScore(subject, 0));
		list.add(subjectScore);
		
		return true;
		
	}

	public boolean deleteScore(Subject subject) {
		// TODO Auto-generated method stub
		return list.remove(new SubjectScore(subject, 0));
		
		
	}
	
}
