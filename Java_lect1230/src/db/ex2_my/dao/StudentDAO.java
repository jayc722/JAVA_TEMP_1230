package db.ex2_my.dao;

import org.apache.ibatis.annotations.Param;

import db.ex2_my.model.vo.Student;

public interface StudentDAO {

	Student selectStudent(@Param("std")Student std);

	boolean insertStudent(@Param("std")Student std);

	boolean updateStudent(@Param("old")Student oldStd, @Param("new")Student newStd);

	boolean deleteStudent(@Param("std")Student std);
}
