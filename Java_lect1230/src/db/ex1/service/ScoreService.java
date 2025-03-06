package db.ex1.service;

import java.util.List;


import db.ex1.model.vo.ScoreVO;
import db.ex1.model.vo.StudentVO;

public interface ScoreService {

	

	List<ScoreVO> getScoreList();

	//ScoreVO getScore(int grade, int classNum, int num);

	//List<ScoreVO> getScoreList(StudentVO studentVO, int st_key);

	List<ScoreVO> getScoreList(int st_key);
	
	

	
}
