package db.ex1.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import db.ex1.dao.StudentDAO;
import db.ex1.model.vo.StudentVO;

public class StudentServiceImp implements StudentService{	//서비스 implements

	
	private StudentDAO studentDAO;
	
	
	
	public StudentServiceImp() {
		
		String resource = "db/ex1/config/mybatis-config.xml";
		InputStream inputStream;
		SqlSession session;
		try {
			inputStream = Resources.getResourceAsStream(resource);
			SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			session = sessionFactory.openSession(true);			//내가 가져온 쿼리가 바로바로 적용
			studentDAO = session.getMapper(StudentDAO.class);			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public List<StudentVO> getStudentList(){
		return studentDAO.selectStudentList();
	}

	@Override
	public StudentVO getStudent(int grade, int classNum, int num) {
		
		return studentDAO.selectStudent(grade, classNum, num);
	}

	@Override
	public StudentVO getStudent(StudentVO studentVO) {
		if(studentVO == null) return null;		//null 체크
		return studentDAO.selectStudent2(studentVO);
	}

	
	@Override
	public boolean addStudent(StudentVO std) {
		StudentVO dbStd = studentDAO.selectStudent2(std); //->여기선 null insert하면 안되니까		
		if(dbStd == null) return false;		//null체크
		
		return studentDAO.insertStudent(std);
	}

	@Override
	public boolean updateStudentName(StudentVO std) {
		//StudentVO dbStd = studentDAO.selectStudent2(std); -> 어차피 null이면 수정 안되기때문에		
		if(std == null) return false;		//null체크
		
		return studentDAO.updateStudentName(std);
	}

	@Override
	public boolean deleteStudent(StudentVO std) {
		if(std == null) return false;		//null체크
		
		return studentDAO.deleteStudent(std);
	}

	
	
}
