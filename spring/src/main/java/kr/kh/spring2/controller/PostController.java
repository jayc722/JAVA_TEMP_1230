package kr.kh.spring2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.kh.spring2.model.vo.BoardVO;
import kr.kh.spring2.model.vo.PostVO;
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
	public Object PostList(@RequestParam int bo_num, Model model) {			//화면에 전송하려면 model
		//System.out.println(bo_num);
		
		//num을 서비스에게 주면 서 게시판 번호에 맞는 게시글 목록 전체를 가져오라고 요청. -> 게시글 목록 중 2개를 가져오라고 요청(cri 이용)
		List<PostVO> postList = postService.getPostList(bo_num, 2);
		
		
		//가져온 게시글 목록을 화면에 전송
		model.addAttribute("postList", postList);
		
		
		
		//return postList;
		return"post/sub";					//앞에 / 붙어있으면 기본뷰리졸버로 가서 헤더푸터 붙어서 나옴
	}
	
	
}
