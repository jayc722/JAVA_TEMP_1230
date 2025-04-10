package kr.kh.spring.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import kr.kh.spring.model.vo.BoardVO;
import kr.kh.spring.model.vo.FileVO;
import kr.kh.spring.model.vo.LikeVO;
import kr.kh.spring.model.vo.MemberVO;
import kr.kh.spring.model.vo.PostVO;
import kr.kh.spring.pagination.PageMaker;
import kr.kh.spring.pagination.PostCriteria;
import kr.kh.spring.service.PostService;

@RestController						//react전용 컨트롤러
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
	
	
	@GetMapping("/react/post/detail/{po_num}")								//주소에 react만 추가
	public Map<String,Object> postDetail(@PathVariable("po_num")int po_num, HttpSession session) {			//post컨트롤러에서 그대로 가져옴

		//게시글을 가져오기 전에 게시글 조회수를 증가
		postService.updateView(po_num);
		
		// 게시글을 가져옴
		PostVO post = postService.getPost(po_num);
		
		// 첨부파일 가져옴
		List<FileVO> list = postService.getFileList(po_num);
		
		MemberVO user = (MemberVO)session.getAttribute("user");
		LikeVO like = postService.getLike(po_num, user);
		
		// 화면에 전송
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("post", post);
		map.put("list", list);
		map.put("like", like);
		/*
		model.addAttribute("post", post);
		model.addAttribute("list", list);
		model.addAttribute("like", like);
		*/
		
		return map;
	}
}