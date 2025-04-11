package kr.kh.spring2.dao;

import org.apache.ibatis.annotations.Param;

import kr.kh.spring2.model.vo.MemberVO;

public interface MemberDao {

	MemberVO selectMemberById(@Param("me_id") String id);

	boolean insertMember(@Param("member")MemberVO member);		//param 안붙여도 되긴 하는데 헷갈릴거같으면 무조건 붙이는게

	boolean updateMemberCookie(@Param("member")MemberVO member);

	MemberVO selectMemberByCookie(@Param("me_cookie")String me_cookie);

}
