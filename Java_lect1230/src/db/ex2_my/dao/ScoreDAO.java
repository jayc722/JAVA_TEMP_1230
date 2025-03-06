package db.ex2_my.dao;

import org.apache.ibatis.annotations.Param;

import db.ex2_my.model.vo.SubjectScore;

public interface ScoreDAO {
	SubjectScore selectScore(@Param("score")SubjectScore subjectScore);

	boolean insertScore(@Param("score")SubjectScore subjectScore);

	boolean updateScore(@Param("score")SubjectScore subjectScore);

	boolean deleteScore(@Param("key")int key, @Param("num")int num);

}
