package kr.kh.spring.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.kh.spring.model.vo.PostVO;

@Mapper
public interface PostDAO {


	List<PostVO> selectPostList();

}
