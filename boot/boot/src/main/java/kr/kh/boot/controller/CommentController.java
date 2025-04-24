package kr.kh.boot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.kh.boot.model.vo.CommentVO;
import kr.kh.boot.model.vo.CustomUser;
import kr.kh.boot.service.CommentService;
import kr.kh.boot.utils.CommentCriteria;
import kr.kh.boot.utils.PageMaker;


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

	@PostMapping("/list")
	public String insert(Model model, @RequestBody CommentCriteria cri) {
		cri.setPerPageNum(3);		
		
		List<CommentVO> list = commentService.getCommentList(cri);

		PageMaker pm = commentService.getPageMaker(cri);
		//System.out.println("댓글 개수 : " + list.size());
		model.addAttribute("commentList", list);
		model.addAttribute("page", pm);
		return "post/comment";
	}
	
	
	@PostMapping("/delete")
	@ResponseBody			//이거 없으면 삭제는 되는데 리턴값을 못 받음
	public boolean delete(@RequestParam int co_num) {

		return commentService.deleteComment(co_num);
	}

}
