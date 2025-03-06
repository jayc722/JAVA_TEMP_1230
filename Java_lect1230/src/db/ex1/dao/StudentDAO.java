package db.ex1.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import db.ex1.model.vo.StudentVO;

public interface StudentDAO {

	List<StudentVO> selectStudentList();	// DAO랑 Mapper는 세트

	StudentVO selectStudent(@Param("grade")int grade, @Param("classNum")int classNum, @Param("num")int num);			// 매개변수가 있으면 param 어노테이션 추가해줘야 함. pram 안에 있는 문자열이 mapper에서 쓸 문자열

	StudentVO selectStudent2(@Param("std")StudentVO studentVO);

	boolean insertStudent(@Param("std")StudentVO std);	//insert update delete는 boolean int(적용된 행의 개수) 으로 보낼 수 있음

	boolean updateStudentName(@Param("std")StudentVO std);

	boolean deleteStudent(@Param("std")StudentVO std);
	
	//param 매개변수 하나일땐 생략 가능하나 이왕이면 붙이는게 나음
	

}
