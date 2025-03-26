package kr.kh.spring.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import kr.kh.spring.model.vo.BoardVO;
import kr.kh.spring.model.vo.FileVO;
import kr.kh.spring.model.vo.MemberVO;
import kr.kh.spring.model.vo.PostVO;
import kr.kh.spring.service.PostService;

@Controller
public class PostController {

	//postService postService = new postServiceImp() {};		//자바와 db연동할때 했던 방식 
	
	@Autowired
	private PostService postService;		// 스프링 연동방식. (의존성 주입)
	
	@GetMapping("/post/list")
	public String postList(Model model, Integer po_bo_num) {
		// 게시글 목록 전체를 가져옴
		//List<PostVO> list = postService.getPostList();
		
		po_bo_num = po_bo_num == null ? 0 : po_bo_num;			//없으면 0
		
		List<PostVO> list = postService.getPostList(po_bo_num);
		List<BoardVO> boardList = postService.getBoardList();
		model.addAttribute("boardList", boardList);					//추가(게시판 종류 띄우기 위해)
		
		// 화면에 게시글 목록을 전송(->화면에 뿌리는건 화면 jsp에서)
		// 매퍼의 resultType=kr.kh.spring.vo.model.vo.postVO
		model.addAttribute("list", list);
		model.addAttribute("po_bo_num", po_bo_num);			//게시판 outline 설정 위해
		return "/post/list";
	}
	
	@GetMapping("/post/insert")
	public String postInsert(Model model) {
		// 등록된 게시판 리스트를 가져와서 화면에 전송
		List<BoardVO> list = postService.getBoardList();
		model.addAttribute("list", list);
		
		return "/post/insert";
	}
	/*
	@PostMapping("/post/insert")
	public String postInsertPost(PostVO post) {	//이름 겹치니까 postmapping은 post 붙이기	//messageservice 이용하는 방법은 어제 했으니 다른 방식으로 //입력된 텍스트 받는 방식은 많지만 한꺼번에 받기위해 postVO로
		//추후 삭제 예정
		MemberVO user = new MemberVO();
		user.setMe_id("admin");
		if(postService.insertPost(post, user)) {

		}else {
			
		}
		return "redirect:/post/list";
	}*/
	
	@PostMapping("/post/insert")
	public String postInsertPost(Model model, PostVO post, HttpSession session, MultipartFile[] fileList) {
		//httpsession 은 session만 가져와짐	//첨부파일 name이랑 매개변수명 맞춰야 자동으로 가져와짐
		
		MemberVO user = (MemberVO)session.getAttribute("user");
		
		if(postService.insertPost(post, user, fileList)) {
			model.addAttribute("url", "/post/list");
			model.addAttribute("msg", "등록했습니다.");

		}else {
			model.addAttribute("url", "/post/insert");
			model.addAttribute("msg", "등록하지 못했습니다.");
			
		}
		return "/msg/msg";
	}


	
	@GetMapping("/post/detail/{po_num}")
	public String postDetail(Model model, @PathVariable("po_num")int po_num) {

		//게시글을 가져오기 전에 게시글 조회수를 증가
		postService.updateView(po_num);
		
		// 게시글을 가져옴
		PostVO post = postService.getPost(po_num);
		
		// 첨부파일 가져옴
		List<FileVO> list = postService.getFileList(po_num);
		
		// 화면에 전송
		model.addAttribute("post", post);
		model.addAttribute("list", list);
		
		
		return "/post/detail";
	}
	
	@GetMapping("/post/delete/{po_num}")
	public String postDelete(Model model, @PathVariable("po_num")int po_num, HttpSession session) {

		MemberVO user = (MemberVO)session.getAttribute("user");
		
		if(postService.deletePost(po_num, user)) {
			model.addAttribute("url", "/post/list");
			model.addAttribute("msg", "삭제했습니다.");

		}else {
			model.addAttribute("url", "/post/detail/" + po_num);
			model.addAttribute("msg", "삭제하지 못했습니다.");
			
		}

		
		return "/msg/msg";
	}

		@GetMapping("/post/update/{po_num}")
		public String postUpdate(Model model, @PathVariable("po_num")int po_num, HttpSession session) {
			 
			List<BoardVO> list = postService.getBoardList();
			model.addAttribute("list", list);
			
			// 게시글을 가져옴
			PostVO post = postService.getPost(po_num);
			// 작성자 본인인지 확인
			
			MemberVO user = (MemberVO)session.getAttribute("user");
			// 로그인되어있지 않거나 없는 게시글이거나 작성자가 아니면
			if(user == null || post == null || !post.getPo_me_id().equals(user.getMe_id())) {
				model.addAttribute("url", "/post/list");
				model.addAttribute("msg", "작성자가 아니거나 없는 게시글 입니다.");
				return "/msg/msg";
				
			}else {
				// 화면에 전송
				model.addAttribute("post", post);
				return "/post/update";
			}
		}	
		
		@PostMapping("/post/update")
		public String postUpdatePost(Model model, PostVO post, HttpSession session) {	

			MemberVO user = (MemberVO)session.getAttribute("user");

			if(postService.updatePost(post, user)) {
				model.addAttribute("msg", "수정했습니다.");

			}else {
				model.addAttribute("msg", "수정하지 못했습니다.");
				
			}
			model.addAttribute("url", "/post/detail/" + post.getPo_num());
			return "/msg/msg";
		}


}

