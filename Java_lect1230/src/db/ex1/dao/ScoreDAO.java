package db.ex1.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import db.ex1.model.vo.ScoreVO;
import db.ex1.model.vo.StudentVO;

public interface ScoreDAO {
	


	List<ScoreVO> selectScoreList();
	/*
	ScoreVO selectScore1(int grade, int classNum, int num);		
	
	StudentVO selectScore(@Param("grade")int grade, @Param("classNum")int classNum, @Param("num")int num);			// 매개변수가 있으면 param 어노테이션 추가해줘야 함. pram 안에 있는 문자열이 mapper에서 쓸 문자열

	List<ScoreVO> selectScore2(@Param("std")StudentVO studentVO);
	*/
	List<ScoreVO> selectScoreListBySt_key(@Param("st_key")int st_key);


}
