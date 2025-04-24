package kr.kh.boot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.kh.boot.model.vo.CommentVO;
import kr.kh.boot.model.vo.CustomUser;
import kr.kh.boot.service.CommentService;


//@RestController			//모든 처리를 비동기로 할때
@Controller
@RequestMapping("/comment")
public class CommentController {
	
	@Autowired
	CommentService commentService;

	@ResponseBody	//이게 없으면 해당 문자열을 화면에서 찾아와서 받아옴. 있으면 해당 문자열 자체를 전송.
	@PostMapping("/insert")
	public boolean insert(@RequestBody CommentVO comment, @AuthenticationPrincipal CustomUser customUser ) {
		//System.out.println(comment);
		
		return commentService.insertComment(comment, customUser);
	}
	

}
