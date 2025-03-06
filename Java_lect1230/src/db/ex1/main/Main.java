package db.ex1.main;

import java.util.List;

import db.ex1.model.vo.ScoreVO;
import db.ex1.model.vo.StudentVO;
import db.ex1.model.vo.SubjectVO;
import db.ex1.service.ScoreService;
import db.ex1.service.ScoreServiceImp;
import db.ex1.service.StudentService;
import db.ex1.service.StudentServiceImp;
import db.ex1.service.SubjectService;
import db.ex1.service.SubjectServiceImp;

public class Main {

	/*
	 mybatis에서 자동으로 매핑을 할때 변수 이름 가져오는 규칙
	 1. 정확히 일치(sc_score) 2. prefix를 생략(느슨한 매핑)(score) 3. 유사한 필드명도 매핑(느슨한 매핑 - 유사 정도에 따라 될수도 안될수도)(score1)
	  - autoMappingBehavior 속성 값에 따라 매핑 강도 조절 가능 
	  	: FULL : 기본값. 1,2,3 다 가능
	 	: PARTIAL : 1만 가능.
	 	: NONE : 자동 매핑을 미활성화(resultMap으로 찾아야함)
	 
	  
	  */
	
	
	static StudentService studentService = new StudentServiceImp();
	
	static SubjectService subjectService = new SubjectServiceImp();
	
	static ScoreService scoreService = new ScoreServiceImp();
	
	public static void main(String[] args) {
		
		
		//dao랑 mapper는 오타 나도 빨간줄 안뜨기때문에 유의해야 함
		//invalid bound statement -> bao 의심 (서비스랑 서비스imp는 실행 전에 빨간줄 뜨기때문에)
		//result maps collection does not contain value for ~ -> map 오타
		
		List<StudentVO> list = studentService.getStudentList();
		//System.out.println(list); 		//확인하기 위해서
		
		/*
		for(StudentVO std : list) {
			System.out.println(std);
		}
		*/
		
		
		
		/*
		StudentVO std = studentService.getStudent(1,1,1);		//매개변수가 없는 경우는 그냥 쓰면 되는데 있는 경우는 조금 고민해야
		
		System.out.println(std);
		
		StudentVO std2 = studentService.getStudent(new StudentVO(0, 1, 1, 1, null));		//객체 이용
		
		System.out.println(std2);
		*/

		
		
			//등록된 모든 과목을 가져와서 콘솔창에 확인하는 코드
		
		List<SubjectVO> subjectList = subjectService.getSubjectList();
		//System.out.println(subjectList); 		
				
		/*
		for(SubjectVO subject : subjectList) {
			System.out.println(subject);
		}
		*/
		
				
		//등록된 모든 성적
		
		List<ScoreVO> scoreList = scoreService.getScoreList();
		//System.out.println(scoreList); 		
				
		/*
		for(ScoreVO score : scoreList) {
			System.out.println(score);
		}
		*/
		
		
		//1학년 1반 1번 학생의 등록된 성적들을 가져오는 코드
	
		
		//1학년 1반 1번 학생의 정보를 가져옴
		StudentVO std3 = studentService.getStudent(1,1,1);
		
		List<ScoreVO> scores = scoreService.getScoreList(std3.getSt_key());
		/*
		//System.out.println(scores);
		System.out.println(std3 + "의 성적 목록");
		for(ScoreVO score : scores) {
			System.out.println(score);
		}
		*/
		//toString -> student로 학생 subject로 과목, score에서 전체
			
		
		
		
		
		
		//INSERT
		
		
		// 1학년 1반 1번 abc 학생을 등록
		
		/*
		StudentVO std4 = new StudentVO(0, 1, 1, 1, "abc");			//기본키는 auto incresement라 생략해서 사용
		//StudentVO std4 = new StudentVO(1, 1, 1, 1, "abc");				//얘도 됨
		
		if(studentService.addStudent(std4)) {						// 얘는 이미 등록돼있는 학생이라 등록 안됨
			System.out.println(std4 + "학생을 등록 했습니다.");
			System.out.println(std4);
		}else {
			System.out.println(std4 + "학생을 등록하지 못했습니다.");	
		}
		*/
				
		StudentVO std4 = new StudentVO(0, 1, 1, 10, "abc");		//또 실행하면 이미 등록돼있어서 등록 안된다고 뜸.	
		
		if(studentService.addStudent(std4)) {				
			System.out.println(std4 + "학생을 등록 했습니다.");
			System.out.println(std4.getSt_key());				//기본키를 0으로 추가해서 0 으로 출력됨 ->mapper 파일에서 useGeneratedKeys 추가하면 추가된 기본키 사용 가능
		}else {														
			System.out.println(std4 + "학생을 등록하지 못했습니다.");	
		}
		
		
		
		// 1학년 1반 1번 학생의 이름을 111로 수정
		
				StudentVO std5 = new StudentVO(0, 1, 1, 1, "111");			
				
				if(studentService.updateStudentName(std5)) {						
					System.out.println(std5 + " 학생을 수정 했습니다.");
					System.out.println(std5.getSt_key());
				}else {
					System.out.println(std5 + " 학생을 수정하지 못했습니다.");	
				}
				
				//std4.setSt_grade(3);	//3학년1반10번 학생이 없기때문에 삭제 안됨
				if(studentService.deleteStudent(std4)) {						
					System.out.println(std4 + " 학생을 삭제 했습니다.");
				}else {
					System.out.println(std4 + " 학생을 삭제하지 못했습니다.");	
				}
		
		
		
	}
	
	

}


