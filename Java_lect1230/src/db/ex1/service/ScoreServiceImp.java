package db.ex1.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import db.ex1.dao.ScoreDAO;
import db.ex1.model.vo.ScoreVO;
import db.ex1.model.vo.StudentVO;

public class ScoreServiceImp implements ScoreService{

	private ScoreDAO scoreDAO;
	
	public ScoreServiceImp() {
		
		String resource = "db/ex1/config/mybatis-config.xml";
		InputStream inputStream;
		SqlSession session;
		try {
			inputStream = Resources.getResourceAsStream(resource);
			SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			session = sessionFactory.openSession(true);			//내가 가져온 쿼리가 바로바로 적용
			scoreDAO = session.getMapper(ScoreDAO.class);			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<ScoreVO> getScoreList() {
		return scoreDAO.selectScoreList();
	}

	/*
	@Override
	public ScoreVO getScore(int grade, int classNum, int num) {
		
		return scoreDAO.selectScore1(grade, classNum, num);
	}
	*/

	@Override
	public List<ScoreVO> getScoreList(int st_key) {
			
		return scoreDAO.selectScoreListBySt_key(st_key);
	}
	
	
	
	

}
