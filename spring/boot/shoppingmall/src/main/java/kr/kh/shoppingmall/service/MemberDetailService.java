package kr.kh.shoppingmall.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import kr.kh.shoppingmall.dao.MemberDAO;
import kr.kh.shoppingmall.utils.CustomUser;
import kr.kh.shoppingmall.model.vo.MemberVO;

@Service
public class MemberDetailService implements UserDetailsService{

	@Autowired
	MemberDAO memberDao;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
			MemberVO member = memberDao.selectMember(username);
	
			if (member == null) {
					throw new UsernameNotFoundException("존재하지 않는 사용자입니다: " + username);
			}
			if ("Y".equals(member.getMe_del())) {
					throw new UsernameNotFoundException("탈퇴 처리된 사용자입니다: " + username);
			}
	
			return new CustomUser(member);
	}
	
	

}