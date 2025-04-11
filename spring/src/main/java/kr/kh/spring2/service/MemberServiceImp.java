package kr.kh.spring2.service;

import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import kr.kh.spring2.dao.MemberDao;
import kr.kh.spring2.model.vo.MemberVO;

@Service
public class MemberServiceImp implements MemberService{

	@Autowired
	MemberDao memberDao;
	
	@Autowired
	PasswordEncoder passwordEncoder1;
	
	
	@Override
	public boolean checkId(String id) {
		
		System.out.println(id);
		
		MemberVO member =(MemberVO)memberDao.selectMemberById(id); 
		
		if(member == null) {
			System.out.println("없는 아이디");
			return true;
		}
		System.out.println(member);
		System.out.println("이미 존재하는 아이디");
		
		return false;
	}



	@Override
	public boolean insertMember(MemberVO member) {
		// TODO Auto-generated method stub
		if(member == null) {
			System.out.println("멤버가 null");
			return false;
		}
		
		if(member.getMe_id() == null || !Pattern.matches("^[a-zA-Z0-9]{3,13}$", member.getMe_id())) {
			System.out.println("아이디 패턴 불일치");
			return false;
		}
		if(member.getMe_pw() == null || !Pattern.matches("^[a-zA-Z0-9!@#$]{3,20}$", member.getMe_pw())) {
			System.out.println("비밀번호 패턴 불일치");
			return false;
		}
		
		System.out.println(member.getMe_id());
		
		try {
			String encPw = passwordEncoder1.encode(member.getMe_pw());
			member.setMe_pw(encPw);
			return memberDao.insertMember(member);
		}catch(Exception e) {
			e.printStackTrace();
			//중복검사 안했을 경우... 중복돼도 false로 나오게
			return false;
		}
	}



	@Override
	public MemberVO selectMember(MemberVO member) {

		if(member==null) return null;
		String encPw = passwordEncoder1.encode(member.getMe_pw());
		member.setMe_pw(encPw);
		
		MemberVO user = (MemberVO)memberDao.selectMemberById(member.getMe_id());
		if(passwordEncoder1.matches(user.getMe_pw(), member.getMe_pw()))return null;
		
		
		
		
		return user;
	}

}
