package db.ex1.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import db.ex1.dao.SubjectDAO;
import db.ex1.model.vo.SubjectVO;

public class SubjectServiceImp implements SubjectService{

	private SubjectDAO subjectDAO;
	
	public SubjectServiceImp() {
		
		String resource = "db/ex1/config/mybatis-config.xml";
		InputStream inputStream;
		SqlSession session;
		try {
			inputStream = Resources.getResourceAsStream(resource);
			SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			session = sessionFactory.openSession(true);			//내가 가져온 쿼리가 바로바로 적용
			subjectDAO = session.getMapper(SubjectDAO.class);			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	@Override
	public List<SubjectVO> getSubjectList() {
		return subjectDAO.selectSubjectList();
	}	//서비스 implements

	
	

}
