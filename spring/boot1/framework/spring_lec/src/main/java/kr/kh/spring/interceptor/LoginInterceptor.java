package kr.kh.spring.interceptor;

import java.util.Date;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import kr.kh.spring.model.vo.MemberVO;
import kr.kh.spring.service.MemberService;

public class LoginInterceptor extends HandlerInterceptorAdapter{
	
	@Autowired
	private MemberService memberService;
	
	
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
		if(user == null) return;		//if문 안에 if문 안 들어가게 하려고 수정
		session.setAttribute("user", user);
		
		//자동로그인이 체크되어 있지 않으면 종료
		if(!user.isAuto()) return;
		
		//자동로그인이 체크돼있으면 쿠키 생성해서 클라이언트에게 전송
			//현재 로그인 시도 할 때 세선 아이디를 value로 갖는 쿠키를 생성
		Cookie cookie = new Cookie("LC", session.getId());
		cookie.setPath("/");	//특별한 일 없으면 메인경로
		int time = 60 * 60 * 24 * 7;		//단위 : 초 (7일을 초로 환산)
		cookie.setMaxAge(time);		//쿠키 유지기간
			//response 객체에 쿠키를 담아서 전송 => 클라이언트에 쿠키 전송
		response.addCookie(cookie);
		
		//db에 자동 로그인 정보를 저장
		user.setMe_cookie(session.getId());
		//1주일 뒤 밀리초
		Date date = new Date(System.currentTimeMillis() + time * 1000);	//System.currentTimeMillis() : 현재 시간을 밀리초로 반환 -> time *1000 하면 1주일분의 밀리초
		user.setMe_limit(date);
		memberService.updateCookie(user);
			
		
	}

	//컨트롤러로 들어가기전 가로채는 경우 호출이 됨
	//리턴이 true이면 가던 URL로 가서 실행
	//리턴이 false이면 가던 URL로 가지 못함. 보통 이 경우는 redirect로 다른 URL로 가라고 함.
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)	//preHandler 컨트롤러로 들어가기 전 가로채는 경우 호출
			throws Exception {																			//리턴 true이면 가던 url로 그대로 가서 실행. false이면 가던 url로 안감.(보통 이경우는 redirect로 다른 url로 보냄)(로그인 된 회원만 들어갈수 있는 페이지 같은 경우)
			
			//구현
			return true;
	}
}