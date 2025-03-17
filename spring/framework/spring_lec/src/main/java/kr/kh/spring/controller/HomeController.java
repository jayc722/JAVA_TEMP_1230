package kr.kh.spring.controller;

import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
	public String home(Locale locale, Model model) {		
	

		/* 컨트롤러가 Dispatcher Servlet(디스패쳐)에게 home이라는 문자열 반환 
		 * 	=> 디스패쳐가 View Resolver(뷰 리졸버)에게 home이라는 문자열 전단
		 * 	=> 뷰 리졸버는 설정된 방법에 따라 home을 가공. 
		 * 		=> view resolver 설정은 servlet-context.xml에 있음(src/main/webapp/resources/WEB-INF/spring/appServlet/servlet-context.xml)
		 * 		=> 기본 뷰 리졸버에 의해 /WEB-INF/view/home.jsp가 완성되어 최종적으로 해당 jsp의 결과 화면을 클라이언트에 전송.
		 * */
		
		model.addAttribute("name", "홍길동"); 	// 화면에 데이터 전송하는 방법 : Model 객체를 이용하여 전송.	
												// 							-addAttribute("화면에서 쓸 이름", 데이터); 
		
		
		return "home";
	}
	
}
