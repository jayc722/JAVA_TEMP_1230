package kr.kh.spring2.controller;

import java.util.Locale;

import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.kh.spring2.model.vo.MemberVO;
import kr.kh.spring2.service.MemberService;


@Controller
public class HomeController {
	
	@Autowired
	MemberService memberService;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private JavaMailSender mailSender;

	
	@GetMapping("/")
	public String home(Locale locale, Model model) {
		/*
		String str = "abcd";
		String encStr = passwordEncoder.encode(str);
		System.out.println(str);
		System.out.println(encStr);
		System.out.println(passwordEncoder.matches(str, encStr));
		mailSend("jaewon8469@gmail.com", "샘플", "샘플 내용입니다");				//메일 보내기
		*/					
		
		return "home";
	}
	
	@GetMapping("/signup")
	public String signup() {
		return "/member/signup";
	}
	
	@GetMapping("/login")
	public String login() {
		return "/member/login";
	}
	
	@ResponseBody
	@PostMapping("/check/id")
	public boolean checkId(@RequestParam String id) {
		
		
		
		return memberService.checkId(id);
		
	}
	
	
	@PostMapping("/signup")
	public String signupPost(MemberVO member) {					//meberVO의 필드명과 signup.jsp의 name의 속성명을 일치시켜 놨기 때문에 맞는 이름에 들어가는것.
		
		boolean res = memberService.insertMember(member);
		
		System.out.println(res);
		
		if(res) {
			return "redirect:/";
		}
		
		
		return "redirect:/signup";
	}
	
	@PostMapping("/login")
	public String loginPost(MemberVO member, Model model) {					//회원정보를 인터셉터 같은 애들한테 넘기기 위해서
		//public String loginPost(MemberVO member, ModelAndView mv) {					//이걸로 해도 됨 선언해서		
		MemberVO user = (MemberVO)memberService.login(member);
		if(user==null)return "redirect:/login";
		System.out.println(user);
		
		//화면에서 자동로그인 여부를 로그인한 회원 정보에 저장
		user.setAuto(member.isAuto());			// 멤버의 auto 정보를 유저로 넘기기 -> 인터셉터에서 활용할수 있고록
		
		model.addAttribute("user",user);	
		return "redirect:/";			//로그인 url 통해서 들어갈때 나올때 전부=> 홈으로(이때 인터셉터가 가로챔)
		
		
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		//회원정보에서 쿠키값을 null로 수정.
		MemberVO user = (MemberVO)session.getAttribute("user");
		if(user==null) return "redirect:/"; 
		user.setMe_cookie(null);
		user.setMe_limit(null);
		memberService.updateMemberCookie(user);
		
		session.removeAttribute("user");
		
		
		
		
		
		return "redirect:/";
	}
	
	
	public boolean mailSend(String to, String title, String content) {
		
		String setfrom = "woodjoon98@gmail.com";
		try{
			MimeMessage message = mailSender.createMimeMessage();
			MimeMessageHelper messageHelper
			= new MimeMessageHelper(message, true, "UTF-8");
			
			messageHelper.setFrom(setfrom);// 보내는사람 생략하거나 하면 정상작동을 안함
			messageHelper.setTo(to);// 받는사람 이메일
			messageHelper.setSubject(title);// 메일제목은 생략이 가능하다
			messageHelper.setText(content, true);// 메일 내용
			
			mailSender.send(message);
			return true;
		} catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}
	
}
