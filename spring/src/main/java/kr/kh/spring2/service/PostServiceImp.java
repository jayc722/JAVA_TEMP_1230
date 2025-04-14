package kr.kh.spring2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.kh.spring2.dao.PostDao;

@Service
public class PostServiceImp implements PostService{

	@Autowired
	private PostDao postDao;
	
	
}
