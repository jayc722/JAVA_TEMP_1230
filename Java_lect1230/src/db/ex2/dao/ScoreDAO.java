package db.ex2.dao;

import org.apache.ibatis.annotations.Param;

import db.ex2.model.vo.Student;
import db.ex2.model.vo.SubjectScore;

public interface ScoreDAO {

	SubjectScore selectScore(@Param("score")SubjectScore subjectScore); //매개변수 하나일 때는 param 생략 가능 
																//->mapper에서  #{score.score},  #{score.num} 대신 그냥  #{score},  #{num}로 사용

	boolean insertScore(@Param("score")SubjectScore subjectScore);			//객체로 사용

	boolean updateScore(@Param("score")SubjectScore subjectScore);

	boolean deleteScore(@Param("key")int key, @Param("num")int num);


}
