package kr.kh.boot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import kr.kh.boot.model.vo.BoardVO;
import kr.kh.boot.model.vo.PostVO;
import kr.kh.boot.service.PostService;


@Controller
public class PostController {
	
	@Autowired
	PostService postService;

	@GetMapping("/post/list/{bo_num}")
	public String postList(Model model, @PathVariable int bo_num){
		//System.out.println(bo_num);
		List<PostVO> list = postService.getPostList(bo_num);
		//System.out.println(list);
		List<BoardVO> boardList = postService.getBoardList();
		System.out.println(boardList);
		model.addAttribute("postList", list);
		model.addAttribute("boardList", boardList);
		model.addAttribute("url", "/post/list");	//url 문자열로 보내기
		//model.addAttribute("bo_num", bo_num);			//이렇게 안 넘겨줘도 화면에서 url에서 넘겨주는 bo_num으로 받아옴.
		return "post/list";
	}

}
