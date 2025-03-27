package kr.kh.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import kr.kh.spring.service.CommentService;

@RestController		// 컨트롤렁 안의 모든 메소드에 @ResponseBody가 분은 경우에 사용(요 안에 있는 애들 전부 비동기통신 한다는 말)
public class ComentController {

	@Autowired
	private CommentService commentService;
	
}
