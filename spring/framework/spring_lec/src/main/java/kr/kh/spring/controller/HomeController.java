package kr.kh.spring.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.kh.spring.model.dto.PersonDTO;

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
	@RequestMapping(value = "/") 
	public String home(Model model, String name, Integer age) {				//안에 보내는 타입과 이름 맞춰주면 됨
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

	//에러404
	
	//url 추가 : 리퀘스트매핑, 겟매핑, 포스트매핑		-> url노출o -> 겟매핑/리퀘스트매핑 사용 
	
	/* 메소드의 매개변수에 객체를 넣어주면, 맵핑이 되든 안되든 기본 생성자를 이용하여 객체를 만듬
	 * => 화면에서 보낸 변수의 이름과 같은 필드가 있으면 자동으로 맵핑이 되어 값이 변경됨. 
	 *    이때 setter를 호출
	 * */
	
	//@GetMapping과 @PostMapping에서 처리하는 내용이 같은 경우 @RequestMapping으로 묶을 수 있다
	@GetMapping("/send")		// 빼고 그대로 적으면 됨
	public String send(String name, Integer age) {
		
		System.out.println("화면에서 보낸 이름 : " + name);
		System.out.println("화면에서 보낸 나이 : " + age);
		//return "";			// 얘만 적으면 리턴이 없다고 error
		return "/sample/send";					// 뷰리졸버가 컨트롤러에서 받아서 뷰로 보냄(servlet-context의 beans 부분 - 여기에 /../.../views 있어서 앞에 부분 안써도 나오는것)
	}
	/*
	@GetMapping("/send")
	public String send(Model model, PersonDTO person) {
		System.out.println("화면에서 보낸 이름과 나이 : " + person);
		//서버에서 화면으로 객체를 전송
		model.addAttribute("person", person);
		return "sample/send";
	}
	
	@PostMapping("/send")
	public String sendPost(Model model, PersonDTO person) {
		System.out.println("화면에서 보낸 이름과 나이 : " + person);
		//서버에서 화면으로 객체를 전송
		model.addAttribute("person", person);
		return "sample/send";
	}
	*/
	@GetMapping("/{name}/{age}")
	public String nameAge(@PathVariable("name")String name1, @PathVariable("age")int age1) {
		System.out.println("화면에서 전송한 이름 : " + name1);
		System.out.println("화면에서 전송한 이름 : " + age1);
		return "/sample/send";
	}
	@GetMapping("/redirect")
	public String redirect( PersonDTO person) {
		System.out.println(person);
		/* redirect 방식
		 * - URL 변경
		 * - 해당 URL를 처리하는 메소드를 호출
		 * - 기존 request 정보는 전송하지 않음.
		 * */
		return "redirect:/send";
	}
	@GetMapping("/forward")
	public String forward( PersonDTO person) {
		System.out.println(person);
		/* forward 방식
		 * - URL 변경되지 않음
		 * - 해당 URL를 처리하는 메소드를 호출
		 * - 기존 request 정보도 같이 전송 => 매개변수로 받은 데이터들도 함께 전송
		 * 
		 * */
		return "forward:/send";
	}
}
