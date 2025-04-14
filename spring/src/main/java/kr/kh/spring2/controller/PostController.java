package kr.kh.spring2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.kh.spring2.model.vo.BoardVO;
import kr.kh.spring2.model.vo.PostVO;
import kr.kh.spring2.pagination.PageMaker;
import kr.kh.spring2.pagination.PostCriteria;
import kr.kh.spring2.service.PostService;

@Controller
@RequestMapping("/post")
public class PostController {

	@Autowired
	private PostService postService;
	
	@GetMapping("/list")
	public String list(Model model) {
		
		//게시판 목록을 서비스에게 요청하여 가져온 후 화면에 전송
		List<BoardVO> boardList = postService.getBoardList();
		model.addAttribute("boardList", boardList);
		
		return "/post/list";		//"post/list" 처럼 슬래시 빼먹을 경우 타일즈 적용 안됨...
	}
	
	@PostMapping("/list")
	//@ResponseBody					//비동기통신		//responsebody는리턴한 값 그대로 보내줌 //없으면 뷰리졸버한테 전송
	public Object PostList(Model model, @RequestBody PostCriteria cri) {			//화면에 전송하려면 model
		//System.out.println(bo_num);
		
		cri.setPerPageNum(2);
		//num을 서비스에게 주면 서 게시판 번호에 맞는 게시글 목록 전체를 가져오라고 요청. -> 게시글 목록 중 2개를 가져오라고 요청(cri 이용)
		List<PostVO> postList = postService.getPostList(cri);
		
		//서비스에게 현재페이지 정보 주고 PageMaker 객체 요청
		//PageMaker pm = new PageMaker(1, cri, 3);			//일단 테스트
		PageMaker pm = postService.getPageMaker(cri);
		
		
		
		//가져온 게시글 목록을 화면에 전송
		model.addAttribute("postList", postList);
		model.addAttribute("pm",pm);
		
		
		//return postList;
		return"post/sub";					//앞에 / 붙어있으면 기본뷰리졸버로 가서 헤더푸터 붙어서 나옴
	}
	
	
}
