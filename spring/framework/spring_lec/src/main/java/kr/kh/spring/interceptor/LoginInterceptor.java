package kr.kh.spring.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import kr.kh.spring.model.vo.MemberVO;

public class LoginInterceptor extends HandlerInterceptorAdapter{
	@Override
	public void postHandle(	//PostHadle은 컨트롤러에서 나올 때 가로채는 경우 호출
	    HttpServletRequest request, 
	    HttpServletResponse response, 
	    Object handler, 
	    ModelAndView modelAndView)
	    throws Exception {
		 //구현   
		//System.out.println("인터셉터 실행");
		//컨트롤러가 보내준 회원정보를 가져와서
		MemberVO user = (MemberVO)modelAndView.getModel().get("user");				//homecontroller에서 addAttribute가 보낸 이름과 일치하면 잡아옴
		//System.out.println(user);
		
		//가져온 회원정보로 세션에 회원정보 저장
		HttpSession session = request.getSession();
		if(user != null) {
			session.setAttribute("user", user);
		}
		
	}
	
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)	//preHandler 컨트롤러로 들어가기 전 가로채는 경우 호출
			throws Exception {																			//리턴 true이면 가던 url로 그대로 가서 실행. false이면 가던 url로 안감.(보통 이경우는 redirect로 다른 url로 보냄)(로그인 된 회원만 들어갈수 있는 페이지 같은 경우)
			
			//구현
			return true;
	}
}