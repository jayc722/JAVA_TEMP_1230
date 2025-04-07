package kr.kh.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import kr.kh.spring.dao.MemberDAO;
import kr.kh.spring.model.vo.MemberVO;

@Service
public class MemberServiceImp implements MemberService{

	@Autowired
	private MemberDAO memberDAO; 
	
	@Autowired
	BCryptPasswordEncoder passwordEncoder;		//bean 등록했을때 autowised로 등록돼서 암호화에 사용
	
	@Override
	public boolean signup(MemberVO member) {

		if(member==null) {				//null체크
			return false;
		}
		
		
		
		//(원래는) 아이디 정규 표현식 체크
		
		//(원래는) 비번 정규 표현식 체크
		
		//(원래는) 이메일 정규 표현식 체크
		
		
		// 아이디 중복체크
		MemberVO user = memberDAO.selectMember(member.getMe_id());
		if(user != null) {
			return false;
		}
		
		// 암호화 코드
		String encodedPw = passwordEncoder.encode(member.getMe_pw());
		member.setMe_pw(encodedPw);	//회원의 비번을 암호화된 비번으로 수정해줌
		
		
		return memberDAO.insertMember(member);
	}

	@Override
	public MemberVO login(MemberVO member) {
		
		if(member==null) {				//null체크
			return null;
		}
		MemberVO user = memberDAO.selectMember(member.getMe_id());
		// 아이디 일치하지 않을때
		if(user==null) {	
			return null;
		}
		//비번 일치하지 않을때		--> db에선 암호화해서 가져오기때문에...member.getMe_pw().equals(user.getMe_pw()) 하면 안됨;
		if(!passwordEncoder.matches(member.getMe_pw(),user.getMe_pw())) {			//!not 잊으면 안됨		
			return null;
		}
		
		//아이디 비번 전부 일치
		return user;
	}

	@Override
	public boolean checkId(String id) {
		MemberVO user = memberDAO.selectMember(id);
		return user == null;	// true면 null(없는 아이디->사용 가능)
	}

	@Override
	public void updateCookie(MemberVO user) {
		memberDAO.updateCookie(user);
		
		
		
		
	}

	@Override
	public MemberVO getMemberByCookie(String cookieId) {			//갖고올때 null이면 그냥 못갖고오고 끝이니 null체크도 필요없음
		return memberDAO.selectMemberByCookie(cookieId);			//selectMember로 가져오지 말고 쿠키만 가져오기
	}

	@Override
	public boolean findPw(String id) {
		MemberVO user = memberDAO.selectMember(id);
		if(user == null) return false;
		
		try {
			//새 비번을 생성
			String newPw = createPw(16);
			//System.out.println(newPw);
			//새 비번을 이메일로 전송
			
			//새 비번으로 db의 회원정보 업데이트
			
			
			
			return true;
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	private String createPw(int size) {
		if(size<8) return null;		//비번 정규표현식보다는 커야함
		String pw = "";
		while(pw.length() < size) {
			//랜덤 정수 생성(0~61)
			//int r = (int)(Math.random()*(61 - 0 + 1) + 0);
			int r = (int)(Math.random()*(62));
			
			//0~9면 문자 0~9로 맵핑 후 이어붙임
			if(r < 10) pw += r;
			
			//10~35면 a~z로 맵핑 후 이어붙임
			else if (r < 36) pw += (char)(r - 10 + 'a');	//a부터 z까지의 문자
			//36~61이면 A~Z로 맵핑 후 이어붙임
			else pw += (char)(r - 36 + 'A');	//A부터 Z까지의 문자
		}
		return pw;
	}

}
