package kr.kh.spring.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import kr.kh.spring.model.vo.CommentVO;
import kr.kh.spring.model.vo.MemberVO;
import kr.kh.spring.pagination.Criteria;
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
	
	
	@GetMapping("/list")		//나중에 또 post로 바꿀거지만 우선은 get으로 변경	
	// 여기는 responsebody 추가 x
	public String list(Criteria cri){
		HashMap<String, Object> map = new HashMap<String, Object>();
		
		//System.out.println(cri);	//검색어가 넘어오면 성공
		List<CommentVO> list = commentService.getCommentList(cri);
		
		map.put("list", list);
		return "/comment/list";		//comment폴더의 list.jsp 연결
	}
	//http://localhost:8080/spring/comment/list?search=29 해서 나오면 성공
}
