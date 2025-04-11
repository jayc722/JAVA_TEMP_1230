package kr.kh.spring2.interceptor;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import kr.kh.spring2.model.vo.MemberVO;

public class LoginInterceptor extends HandlerInterceptorAdapter{
	@Override
	public void postHandle(
	    HttpServletRequest request, 
	    HttpServletResponse response, 
	    Object handler, 
	    ModelAndView modelAndView)
	    throws Exception {
		 //구현   
		System.out.println("인터셉터 : 컨트롤러 포스트핸드");
		MemberVO user = (MemberVO)modelAndView.getModel().get("user");
		//System.out.println("interceptor : "+user);
		HttpSession session = request.getSession();
		if(user==null) return;
		session.setAttribute("user", user);
		//자동로그인 체크x -> 종료
		if(!user.isAuto()) return;
		
		//쿠키 생성. 유지시간 7일. 쿠키 이름을 LC로. 값은 세션ID
		int second = 24 * 7 * 60 * 60;
		int ms = second * 1000;
		long nowMS = System.currentTimeMillis();
		Date limitDate = new Date(nowMS + ms);
		
		
		//생성된 쿠키를 클라이언트에 저장.
		
		//회원정보에 쿠키값과 만료시간을 업데이트.
	}
	@Override
	public boolean preHandle(HttpServletRequest request, 
			HttpServletResponse response, 
			Object handler)
			throws Exception {
			
			//구현
			System.out.println("인터셉터 : 컨트롤러 프리핸드");
			return true;
	}
}