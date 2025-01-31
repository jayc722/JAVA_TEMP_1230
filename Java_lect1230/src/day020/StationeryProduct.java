package day020;

import lombok.Data;

@Data
public class StationeryProduct extends Product1{
	
	
	//분류마다 제품코드 할당할 때 등록된 제품 수 활용하기 때문에
	//클래스 변수 이용    -> day16 게시글때 참고
	//단점)클래스가 제품 개수만큼 나옴
	private static int count = 0;

}
