package kr.kh.spring2.interceptor;

import java.util.Date;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import kr.kh.spring2.dao.MemberDao;
import kr.kh.spring2.model.vo.MemberVO;
import kr.kh.spring2.service.MemberService;

@Component
public class LoginInterceptor extends HandlerInterceptorAdapter{
	
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
		
		String sessionID = session.getId();
		System.out.println(sessionID);
		
		Cookie cookie = new Cookie("LC", sessionID);
		cookie.setPath("/");
		cookie.setMaxAge(second);
		//생성된 쿠키를 클라이언트에 저장.
		//response 객체에 쿠키를 담아서 전송
		response.addCookie(cookie);
		
		
		user.setMe_cookie(sessionID);
		user.setMe_limit(limitDate);
		System.out.println("인터셉터 : " + user);
		
		//회원정보에 쿠키값과 만료시간을 업데이트.
		memberService.updateMemberCookie(user);
		//memberService.updateMemberCookie(user.me_id,sessionID,limitDate);		//취향
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