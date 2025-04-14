package kr.kh.spring2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.kh.spring2.service.PostService;

@Controller
@RequestMapping("/post")
public class PostController {

	@Autowired
	private PostService postService;
	
	@GetMapping("/list")
	public String list() {
		
		//게시판 목록을 서비스에게 요청하여 가져온 후 화면에 전송
		
		return "/post/list";		//"post/list" 처럼 슬래시 빼먹을 경우 타일즈 적용 안됨...
	}
	
	
	
}
