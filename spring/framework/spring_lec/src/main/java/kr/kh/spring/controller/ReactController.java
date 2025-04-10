package kr.kh.spring.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.kh.spring.model.vo.BoardVO;
import kr.kh.spring.model.vo.PostVO;
import kr.kh.spring.pagination.PageMaker;
import kr.kh.spring.pagination.PostCriteria;
import kr.kh.spring.service.PostService;

@RestController
public class ReactController {
	//리액트와 연결하기 위한 컨트롤러 클래스

	
	@Autowired
	private PostService postService;		
	
	
	@GetMapping("/react/post/list")
	public Map<String,Object> postList( PostCriteria cri) {
		
		List<PostVO> list = postService.getPostList(cri);
		List<BoardVO> boardList = postService.getBoardList();
		PageMaker pm = postService.getPageMaker(cri);
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("list", list);
		map.put("pm", pm);
		map.put("boardList", boardList);
		return map;
	}
	
	@GetMapping("/test")
	public String test() {
		return "Hello";
	}
}