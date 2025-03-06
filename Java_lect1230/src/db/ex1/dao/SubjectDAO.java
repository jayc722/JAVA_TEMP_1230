package db.ex1.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import db.ex1.model.vo.StudentVO;
import db.ex1.model.vo.SubjectVO;

public interface SubjectDAO {
	

	List<SubjectVO> selectSubjectList();		
	
	

}
