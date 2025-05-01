package kr.kh.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.kh.spring.dao.MemberDAO;

@Controller
@RequestMapping("/member")
public class MemberController {

	//회원 데이터베이스 모듈 불러오기
	@Autowired
	private MemberDAO memberDao;

	//가입페이지에 대한 매핑

	@GetMapping("/join")
	public String join() {

	//(생략)
		return "/member/login";

	}

	}