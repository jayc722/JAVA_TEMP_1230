package kr.kh.spring.controller;


import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.kh.spring.dao.PostDAO;
import kr.kh.spring.model.dto.PersonDTO;
import kr.kh.spring.model.vo.MemberVO;
import kr.kh.spring.service.MemberService;

/*	@Controller
 * 		=> HandlerMapping에 url을 등록하기 위한 어노테이션(얘가 없으면 안에 코드 있어도 인식 잘 못함)
 */
@Controller
public class HomeController {	// 불필요한 부분 (logger 같은 애들 제거 - 보기 편하게)

	/*	@RequestMapping
	 * 		=> 처리할 URL 정보를 지정하는 어노테이션으로 해당 정보와 일치하는 경우 메소드 호출하여 실행함
	 * 		=> value : 처리할 URL을 지정.
	 * 		=> method : 리퀘스트 메소드 처리 방식을 지정. GET, POST, PUT, DELETE 등.
	 * 
	 * 
	 * 	@GetMaping 
	 * 		=> @RequestMapping(method = RequestMethod.GET)인 경우 대체할 수 있는 어노테이션
	 * 
	 * 	@PostMaping 
	 * 		=> @RequestMapping(method = RequestMethod.POST)인 경우 대체할 수 있는 어노테이션
	 * */
	
	//@RequestMapping(value = "/", method = RequestMethod.GET)				//method = RequestMethod.GET -> home태그의 get 방식/post 방식 중 get 방식으로 오는 애를 처리하겠다 지정. 얘를 생략하면 get방식 post 방식 둘다 처리 
	@GetMapping(value = "/example")
	public String example(Model model, String name, Integer age) {				//안에 보내는 타입과 이름 맞춰주면 됨
		System.out.println("화면에서 보낸 이름 : " + name);
		System.out.println("화면에서 보낸 나이 : " + age);

		/* 컨트롤러가 Dispatcher Servlet(디스패쳐)에게 home이라는 문자열 반환 
		 * 	=> 디스패쳐가 View Resolver(뷰 리졸버)에게 home이라는 문자열 전단
		 * 	=> 뷰 리졸버는 설정된 방법에 따라 home을 가공. 
		 * 		=> view resolver 설정은 servlet-context.xml에 있음(src/main/webapp/resources/WEB-INF/spring/appServlet/servlet-context.xml)
		 * 		=> 기본 뷰 리졸버에 의해 /WEB-INF/view/home.jsp가 완성되어 최종적으로 해당 jsp의 결과 화면을 클라이언트에 전송.
		 * */
		
		model.addAttribute("name", "홍길동"); 	// 화면에 데이터 전송하는 방법 : Model 객체를 이용하여 전송.	
												// 							-addAttribute("화면에서 쓸 이름", 데이터); 

		
		return "home";				//return이 home -> /*/* 형식이 아니라 폼 적용 x
	}
	@GetMapping("/")
	public String home() {				//home.jsp sample로 옮기기 위한
		return "home";				
	}
	
	
	//에러404
	
	//url 추가 : 리퀘스트매핑, 겟매핑, 포스트매핑		-> url노출o -> 겟매핑/리퀘스트매핑 사용 
	
	/* 메소드의 매개변수에 객체를 넣어주면, 맵핑이 되든 안되든 기본 생성자를 이용하여 객체를 만듬
	 * => 화면에서 보낸 변수의 이름과 같은 필드가 있으면 자동으로 맵핑이 되어 값이 변경됨. 
	 *    이때 setter를 호출
	 * */
	
	//@GetMapping과 @PostMapping에서 처리하는 내용이 같은 경우 @RequestMapping으로 묶을 수 있다
	@RequestMapping("/send")		// 빼고 그대로 적으면 됨
	//public String send(String name, Integer age) {
	public String send(Model model, PersonDTO person) {
		System.out.println("화면에서 보낸 이름과 나이 : " + person);
		//서버에서 화면으로 객체를 전송
		model.addAttribute("person", person);
		//return "";			// 얘만 적으면 리턴이 없다고 error
		return "/sample/send";					// 뷰리졸버가 컨트롤러에서 받아서 뷰로 보냄(servlet-context의 beans 부분 - 여기에 /../.../views 있어서 앞에 부분 안써도 나오는것)
	}
	/*
	@GetMapping("/send")
	public String send(Model model, PersonDTO person) {
		System.out.println("화면에서 보낸 이름과 나이 : " + person);
		//서버에서 화면으로 객체를 전송
		model.addAttribute("person", person);
		return "/sample/send";
	}
	
	@PostMapping("/send")
	public String sendPost(Model model, PersonDTO person) {
		System.out.println("화면에서 보낸 이름과 나이 : " + person);
		//서버에서 화면으로 객체를 전송
		model.addAttribute("person", person);
		return "/sample/send";
	}
	*/
	@GetMapping("/sample/{name}/{age}")		// /{name}/{age}에서 수정
	public String nameAge(@PathVariable("name")String name1, @PathVariable("age")int age1) {
		System.out.println("화면에서 전송한 이름 : " + name1);
		System.out.println("화면에서 전송한 이름 : " + age1);
		return "/sample/send";
	}
	@GetMapping("/redirect")
	public String redirect( PostDAO person) {
		System.out.println(person);
		/* redirect 방식
		 * - URL 변경
		 * - 해당 URL를 처리하는 메소드를 호출
		 * - 기존 request 정보는 전송하지 않음.
		 * */
		return "redirect:/send";
	}
	@GetMapping("/forward")
	public String forward( PostDAO person) {
		System.out.println(person);
		/* forward 방식
		 * - URL 변경되지 않음
		 * - 해당 URL를 처리하는 메소드를 호출
		 * - 기존 request 정보도 같이 전송 => 매개변수로 받은 데이터들도 함께 전송
		 * 
		 * */
		return "forward:/send";
	}
	@GetMapping("/jstl")
	public String jstl(Model model) {
		List<String> list = Arrays.asList("사과","바나나","딸기","포도");
		model.addAttribute("str","<h1>서버에서 보낸 메세지입니다.</h1>");
		model.addAttribute("age",20);
		model.addAttribute("list",list);
		model.addAttribute("date",new Date());
		
		return "/sample/jstl";
	}
	
	@GetMapping("/signup")
	public String signup() {
		return "/member/signup";				//회원가입 창 생성(a태그) 위한 getmapping
	}
	//보내기 위해 post로 수정
	@Autowired
	private MemberService memberService;		//멤버서비스 객체 가져오고
		
	@PostMapping("/signup")						//회원가입 정보 보내기 위한 postmapping
	public String signupPost(Model model, MemberVO member) {					//컨트롤러는 보통 리다이렉트에게 건네는 역할
		if(memberService.signup(member)) {				//성공시
			model.addAttribute("msg", "회원 가입을 했습니다.");
			model.addAttribute("url", "/");
			return "msg/msg";					//메인페이지
		}
		return "redirect:/signup";				//실패시 다시 회원가입 
	}
	
	@GetMapping("/login")
	public String login() {
		return "/member/login";				
	}
	//405에러- 포스트방식 처리할 애가 없어서
	@PostMapping("/login")
	public String loginPost(Model model, MemberVO member) {
		//화면에서 보낸 회원정보와 일치하는 회원정보를 DB에서 가져옴
		MemberVO user = memberService.login(member);
		if(user==null) {
		return "redirect:/login";		//실패시 다시 로그인창		
		}
		
		user.setAuto(member.isAuto());		//boolean은 get이 아니라 is로 받아옴.	//자동로그인을 인터셉터에서 처리
		//가져온 회원정보를 인터셉터에게 전달
		model.addAttribute("user", user);
		return "redirect:/";			//성공시 메인페이지
	}
	@GetMapping("/logout")
	public String logout(HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		MemberVO user = (MemberVO)session.getAttribute("user");
		//세션에 있는 유저 삭제
		session.removeAttribute("user");
		if(user != null) {
			user.setMe_cookie(null);
			memberService.updateCookie(user);
		}
		return "redirect:/";			//메인페이지로	
	}
	
	@ResponseBody // 뷰 리졸버가 분석하지 않고 그대로 서버로 보내는 역할
	@PostMapping("/check/id")
	//리턴타입 꼭 Object일 필요는 없음. List로 보내고 싶으면 List로 수정해도 상관없음 
	public boolean checkId(@RequestParam("id") String id){
		return memberService.checkId(id);
	}
	
	

}
