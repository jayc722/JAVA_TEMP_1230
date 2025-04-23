package kr.kh.boot.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import kr.kh.boot.model.vo.MemberVO;



@Controller
public class HomeController {
	
	@GetMapping("/")
	public String Home(Model model){
		model.addAttribute("name", "홍길동");
		model.addAttribute("url", "/");
		return "index";
	}
	@GetMapping("/test")
	public String test(Model model) {
		int num = (int)(Math.random()*10);		//num에 0에서 9 사이 값 랜덤으로 넣기
		String role = "";
		switch (num) {
			case 4,6,8:
				role = "ADMIN";
				break;
		
			case 3,5,7,9:
				role = "USER";
				break;
		}//짝수는 관리자 홀수는 유저, 012는 게스트

		List<Integer> list = Arrays.asList(10,20,30,40);

		MemberVO user = new MemberVO();
		user.setMe_id("abc");
		user.setMe_pw("456");
		user.setMe_authority("USER");




		model.addAttribute("num", num);
		model.addAttribute("role", role);
		model.addAttribute("items", list);
		model.addAttribute("user", user);
		return "test";
	}
	@GetMapping("/test/{num}")			//pathvariable에 없어서 에러 뜸
	//@GetMapping("/test/{num}")
	public String testNum(@PathVariable("num") int num) {	//pathvariable에 들어갈 변수명 // 중괄호 안에서 사용할 변수명
		System.out.println(num);
		return "test";	//화면은 test.html 그대로 활용
	}
	
	
	@GetMapping("/login")
	public String login() {
		return "member/login";
	}
	

}
