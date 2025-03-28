package kr.kh.spring.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.kh.spring.model.vo.CommentVO;
import kr.kh.spring.model.vo.MemberVO;
import kr.kh.spring.pagination.Criteria;
import kr.kh.spring.pagination.PageMaker;
import kr.kh.spring.service.CommentService;

@Controller		// (이젠 아님)컨트롤렁 안의 모든 메소드에 @ResponseBody가 분은 경우에 사용(요 안에 있는 애들 전부 비동기통신 한다는 말)
				// detail.jsp 너무 복잡해서 단순한게 만들기 위해 commentList.jsp 만들기 위함
@RequestMapping("/comment")	//comment 다 붙일거니까...
public class ComentController {

	@Autowired
	private CommentService commentService;

	@PostMapping("/insert")
	@ResponseBody
	public boolean insert(@RequestBody CommentVO comment, HttpSession session) {
		//System.out.println(comment);
		MemberVO user = (MemberVO)session.getAttribute("user");

		
		return (commentService.insertComment(comment, user));
	}
	
	
	@GetMapping("/list2")		//나중에 또 post로 바꿀거지만 우선은 get으로 변경	(확인용)
	// 여기는 responsebody 추가 x
	public String list2(Model model, Criteria cri){
		
		List<CommentVO> list = commentService.getCommentList(cri);
		
		PageMaker pm = commentService.getPageMaker(cri);
		model.addAttribute("list", list);
		model.addAttribute("pm", pm);
		return "/comment/list";		//comment폴더의 list.jsp 연결
	}
	//http://localhost:8080/spring/comment/list?search=29 해서 나오면 성공
	
	
	@PostMapping("/list")		//나중에 또 post로 바꿀거지만 우선은 get으로 변경	
	// 여기는 responsebody 추가 x
	public String list(Model model, @RequestBody Criteria cri){
		
		List<CommentVO> list = commentService.getCommentList(cri);
		PageMaker pm = commentService.getPageMaker(cri);
		model.addAttribute("list", list);
		model.addAttribute("pm", pm);
		return "comment/list";		//앞에 / 제거 -> 기본 뷰 리졸버 말고 인터널 뷰 리졸버가 detail-jsp한테 보냄 -> 문자열을 html 코드로 보냄
	}

	@PostMapping("/delete")
	@ResponseBody
	public boolean delete(@RequestParam int co_num, HttpSession session) {		//받는거에 따라 requestbody가 될수도있고 param이 될수도있음
		MemberVO user = (MemberVO)session.getAttribute("user");
		return commentService.deleteComment(co_num, user);	//개발자 건드려서 delete 못하게 하려고
	}
	
	
}
