package kr.kh.spring2.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import kr.kh.spring2.model.vo.MemberVO;

public class AutoLoginInterceptor extends HandlerInterceptorAdapter{
	
	
	@Override
	public void postHandle(
	    HttpServletRequest request, 
	    HttpServletResponse response, 
	    Object handler, 
	    ModelAndView modelAndView)
	    throws Exception {
		 //구현   
	
	}
	
	//자동 로그인 기능.
	
	@Override
	public boolean preHandle(HttpServletRequest request, 
			HttpServletResponse response, 
			Object handler)
			throws Exception {
			
			//구현
			
			//로그인 했으면 true 리턴
		
			//LC 쿠키를 가져옴
		
			//LC 쿠키가 없으면 true를 리턴
		
			//쿠키 값을 가져옴
		
			//쿠키값을 이용하여 회원정보를 요청
		
			//회원정보가 있으면 세션에 회원정보를 추가
		
			return true;
	}
}