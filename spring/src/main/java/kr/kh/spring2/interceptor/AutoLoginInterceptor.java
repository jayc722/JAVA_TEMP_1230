package kr.kh.spring2.interceptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.util.WebUtils;

import kr.kh.spring2.model.vo.MemberVO;
import kr.kh.spring2.service.MemberService;

@Component
public class AutoLoginInterceptor extends HandlerInterceptorAdapter{
	
	
	@Autowired		//호출 방식 때문에 의존성 자동으로 주입 x -> @component 어노테이션 추가해 줘야 함 
	private MemberService memberService;
	
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
			
			HttpSession session = request.getSession();
			MemberVO user = (MemberVO)session.getAttribute("user");
		
			//구현
			
			//로그인 했으면 true 리턴
			if(user != null) return true;
		
			//LC 쿠키를 가져옴
			Cookie cookie = WebUtils.getCookie(request, "LC");
			//LC 쿠키가 없으면 true를 리턴
			if(cookie==null)return true;
		
			//쿠키 값을 가져옴
			String me_cookie = cookie.getValue();
			
			//쿠키값을 이용하여 회원정보를 요청
			user = memberService.getMemberByCookie(me_cookie);
			
			//회원정보가 있으면 세션에 회원정보를 추가(만료시간이 지났거나 로그아웃 한 상태면 실패)
			if(user!=null)session.setAttribute("user", user);
			
			return true;
	}
}