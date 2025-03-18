package kr.kh.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import kr.kh.spring.model.vo.PostVO;
import kr.kh.spring.service.PostService;

@Controller
public class PostController {

	//postService postService = new postServiceImp() {};		//자바와 db연동할때 했던 방식 
	
	@Autowired
	private PostService postService;		// 스프링 연동방식. (의존성 주입)
	
	@GetMapping("/post/list")
	public String postList(Model model) {
		// 게시글 목록 전체를 가져옴
		List<PostVO> list = postService.selectPostList();
		// 화면에 게시글 목록을 전송(->화면에 뿌리는건 화면 jsp에서)
		// 매퍼의 resultType=kr.kh.spring.vo.model.vo.postVO
		model.addAllAttributes(list);
		
		return "/post/list";
	}
	
}
