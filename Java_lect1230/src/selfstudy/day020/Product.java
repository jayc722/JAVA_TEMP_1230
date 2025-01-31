package selfstudy.day020;

import java.text.DecimalFormat;
import java.util.Objects;

import lombok.AllArgsConstructor;
import lombok.Data;

/* 쇼핑몰 구현
	 * -제품 관리
	 * 	-관리자가 관리
	 * 	-관리자는 admin/admin 고정
	 * 	-제품 추가, 수정, 삭제, 제품 입고
	 * 		-제품 추가
	 * 			-제품 코드(6자리. ABC001), 분류, 제품명, 옵션, 가격을 등록
	 * 			-ABC001, 문구, 볼펜, 빨강, 1000
	 * 			-DEF001, 의류, 셔츠, XL, 30000 
	 * 			-XYZ001, 식품, 우유 1L, 딸기, 2000
	 * 			-XYZ002, 식품, 딸기우유, 1L, 2000 
	 * 			-XYZ003, 식품, 딸기우유, 2L, 3000
	 * 			-분류는 문구 의류 식품 가전 기타로 고정
	 * 			-각 분류마다 분류코드가 지정
	 * 				-문구 : ABC, 의류 : DEF, 식품 : XYZ, 가전 : ELC, 기타 : ETC
	 * 			-제품 코드는 분류 코드에 등록된 순서 3자리를 만들어서 총 6자리로 고정
	 * -제품 입고
	 * 	-제품 코드, 수량을 입력해서 제품을 입고(제품이 있어야 구매 가능)
	 * -제품 구매
	 * 	-등록된 제품을 선택해서 구매
	 * 	-로그인한 사용자가 제품을 구매할 수 있음
	 * 	-로그인 하지 않으면 제품 조회 및 구매x
	 * 	-수량이 있는 제품만 구매 가능(남은 수량보다 큰 수 입력 시 구매x)
	 * 	-제품 코드와 수량을 선택해서 구매
	 * 	-결제 과정은 없음(생략)
	 * -제품 조회
	 * 	-분류를 이용하여 주회
	 * 		-문구 의류 식품 가전 기타 전체
	 * 	-제품 코드, 제품명, 옵션, 수량, 가격 조회
	 * -회원가입
	 * 	-아이디, 비번, 비번확인은 입력해서 회원가입
	 * -로그인
	 * 	-아이디, 비번을 입력하여 회원이면 제품 조회로, 아니면 메인으로 돌아감
	 * 	-관리자이면 관리자 메뉴로 이동
	 */
	
@Data	
@AllArgsConstructor
public class Product {
	ProductNum sbj;
	String name, opt;
	int codeInput, price, amount;
	String code;
	
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		return Objects.equals(code, other.code);
	}


	public Product(ProductNum sbj, int code) {
		super();
		this.sbj = sbj;
		this.codeInput = code;
		DecimalFormat df = new DecimalFormat("000");
		
		switch(this.sbj) {
		case 문구 :
			this.code = "ABC" + df.format(this.codeInput);
			this.codeInput = 1;
			break;
		case 의류 :
			this.code = "DEF" + df.format(this.codeInput);
			this.codeInput = 2;
			break;
		case 식품 :
			this.code = "XYZ" + df.format(this.codeInput);
			this.codeInput = 3;
			break;
		case 가전 :
			this.code = "ELC" + df.format(this.codeInput);
			this.codeInput = 4;
			break;
		case 기타 :
			this.code = "ETC" + df.format(this.codeInput);
			this.codeInput = 5;
			break;
			
		default :
			System.out.println("코드 작성 오류");
		
		}

	}


	public Product(String code) {
		super();
		this.code = code;
	}

	
	
	
	
}
enum ProductNum{
	
	문구, 의류, 식품, 가전, 기타;


	
	
	public static boolean check(String str) {		//문자열을 열거형 값으로 바꿀수 있는지
		try {
			return ProductNum.valueOf(str) != null;	//이값이 null이 아니면 true
		}catch (Exception e) {
			return false;
		}
	}
	
	
	
	
	
	
}

@Data
@AllArgsConstructor
class Id{
	String id;
	String password;
	boolean athority;
	
	//id 확인용
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Id other = (Id) obj;
		return Objects.equals(id, other.id);
	}

	public boolean getAthority() {
		if (this.athority == true) return true;
		return false;
	}

	
	
}