package kr.kh.spring.service;

import kr.kh.spring.model.vo.CommentVO;
import kr.kh.spring.model.vo.MemberVO;

public interface CommentService {

	boolean insertComment(CommentVO comment, MemberVO user);

}
