package homework.ex2.v1;
///////////////////////////////숙제////////////////////////////////////////

import lombok.Data;

//getter setter toString equals 등을 제공
@Data
public class Student {

	
	
	private int grd, clssNum, chrNum;			//다 private 로 하는게 맞음. 일단





	private String stdName;
	
	
	
	

	public Subject [] list;			//학생 인스턴스 하나가 과목들을 각각 갖고 있음
									//private로 하는게 원래는 맞음. 게터세터 각각 입력해야
	
	//생성자 1 학년 반 번호 이름
	public Student(int grd, int clssNum, int chrNum, String stdName) {
		super();
		this.grd = grd;
		this.clssNum = clssNum;
		this.chrNum = chrNum;
		this.stdName = stdName;
	}
	
}
