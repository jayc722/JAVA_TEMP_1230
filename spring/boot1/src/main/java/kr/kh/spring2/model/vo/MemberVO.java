package kr.kh.spring2.model.vo;

import java.util.Date;

import lombok.Data;

@Data
public class MemberVO {

	private String me_id;
	private String me_pw;
	private String me_email;
	private String me_authority;
	private String me_cookie;			//자동로그인 : 쿠키를 체크해서 쿠키를 생성하는 작업
	private Date me_limit;				//자동로그인 되는 과정
	private boolean auto;		//자동로그인을 위한 필드
	
}
