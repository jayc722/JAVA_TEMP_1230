package kr.kh.spring2.service;

import kr.kh.spring2.model.vo.MemberVO;

public interface MemberService {

	boolean checkId(String id);

	boolean insertMember(MemberVO member);

	MemberVO login(MemberVO member);

	boolean updateMemberCookie(MemberVO user);


}
