package kr.kh.spring.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.kh.spring.model.vo.CommentVO;
import kr.kh.spring.model.vo.MemberVO;
import kr.kh.spring.service.CommentService;

@RestController		// 컨트롤렁 안의 모든 메소드에 @ResponseBody가 분은 경우에 사용(요 안에 있는 애들 전부 비동기통신 한다는 말)
@RequestMapping("/comment")	//comment 다 붙일거니까...
public class ComentController {

	@Autowired
	private CommentService commentService;

	@PostMapping("/insert")
	public boolean insert(@RequestBody CommentVO comment, HttpSession session) {
		//System.out.println(comment);
		MemberVO user = (MemberVO)session.getAttribute("user");

		
		return (commentService.insertComment(comment, user));
	}
	
}
