package db.ex2_my.service;


import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import db.ex2_my.dao.SubjectDAO;
import db.ex2_my.model.vo.Subject;
import lombok.Data;

@Data
public class SubjectManager {

	private List<Subject> list;
	
	private SubjectDAO subjectDao;
	
	public SubjectManager() {
		String resource = "db/ex2_my/config/mybatis-config.xml";
		InputStream inputStream;
		SqlSession session;
		try {
			inputStream = Resources.getResourceAsStream(resource);
			SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			session = sessionFactory.openSession(true);
			subjectDao = session.getMapper(SubjectDAO.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public boolean contains(Subject sub) {
		Subject dbSub = subjectDao.selectSubject(sub);
		return dbSub != null;
	}
	
	public boolean insertSubject(Subject subject) {
		if(subject == null) {
			return false;
		}
		if(contains(subject)) {
			return false;
		}
		return subjectDao.insertSubject(subject);
	}

	public boolean updateSubject(Subject subject, Subject newSubject) {
		if(subject == null || newSubject == null) {
			return false;
		}
		//등록 안된 과목을 수정하려고 함
		if(!contains(subject)) {
			return false;
		}
		//수정할 과목이 등록되지 않으면 수정
		if(!contains(newSubject)) {
			return subjectDao.updateSubject(subject, newSubject);
		}
		return false;
	}

	public boolean deleteSubject(Subject subject) {
		if(subject == null) {
			return false;
		}
		return subjectDao.deleteSubject(subject);
	}

	public void print() {
		List<Subject> list = subjectDao.selectSubjectList();
		
		if(list == null || list.size() == 0) {
			System.out.println("등록된 과목이 없습니다.");
			return;
		}
		for(Subject tmp : list) {
			System.out.println(tmp);
		}
		
	}
}