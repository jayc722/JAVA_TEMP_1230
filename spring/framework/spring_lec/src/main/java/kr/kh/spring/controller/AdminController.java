package kr.kh.spring.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.kh.spring.model.vo.BoardVO;
import kr.kh.spring.service.MessageService;
import kr.kh.spring.service.PostService;

@Controller
@RequestMapping("/admin")			// admin 밑에 있는 모든 메소드들의 url에 /admin을 넣겠다
public class AdminController {
	
	@Autowired
	PostService postService;
	
	@Autowired
	MessageService messageService;
	
	@GetMapping("/board")			//requestmapping 없으면 그냥 /admin/board이라 쓰면 됨
	public String board(Model model) {
			// 모든 게시판을 가져와 화면에 전송 -> vo추가
		List<BoardVO> list = postService.getBoardList();
		
		model.addAttribute("list", list);
		return "/admin/board";
	}
	/*
	@PostMapping("/board/insert")
	public String boardInsert(String bo_name, HttpServletResponse response) throws IOException {		//BoardVO board로 받아도 됨(nullcheck넣어야하지만)
		response.setContentType("text/html;charset=UTF-8");		//응답 객체
		PrintWriter out = response.getWriter();
		if(postService.insertBoard(bo_name)) {
			out.println("<script>alert('게시판을 등록했습니다.')</script>");
		}else {
			out.println("<script>alert('게시판을 등록 못 했습니다.')</script>");
		}
		out.flush();
		return "redirect:/admin/board";
	}
	*/
	@PostMapping("/board/insert")
	public String boardInsert(String bo_name, HttpServletResponse response, HttpServletRequest request) {

		if(postService.insertBoard(bo_name)) {
			messageService.sendMessage(response, request, "게시판을 등록했습니다.", "/admin/board");
		}else {
			messageService.sendMessage(response, request, "게시판을 등록하지 못했습니다.", "/admin/board");
		}

		return "/admin/board";			//경로 다시 지정해주기 때문에 굳이 return 안해도 됨(빈문자열도)
	}
	
}
