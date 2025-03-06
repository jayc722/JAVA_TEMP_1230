package db.ex1.service;

import java.util.List;

import db.ex1.model.vo.StudentVO;

public interface StudentService {

	List<StudentVO> getStudentList();

	StudentVO getStudent(int grade, int classNum, int num);			//변수명 수정(i,j,k->학년반번호)

	StudentVO getStudent(StudentVO studentVO);

	boolean addStudent(StudentVO std);

	boolean updateStudentName(StudentVO std);

	boolean deleteStudent(StudentVO std);

	
	

	
}
