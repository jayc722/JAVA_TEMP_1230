package day013;

import java.util.Scanner;

public class Ex06_Enum {

	public static void main(String[] args) {
		/* 열거형
			-상수 데이터들의 집합
			-enum을 이용하여 선언
			-사용하는 값 제한 가능
		
		enum 열거형명{
			값1, 값2, 값3, ..., 값n
			}
		
		 */
		Season season = Season.SPRING;
		
		System.out.print("계절 입력(SPRING SUMMER FALL WINTER) : ");
		Scanner scan = new Scanner(System.in);
		String str = scan.next();
		Season season2 = Season.valueOf(str);		//valueOf : 입력한 문자열과 이름이 같은 열거형 값이 있으면 해당 객체로 리턴, 없으면 예외 발생
		
		switch(season2) {
		case SPRING :
			System.out.println("봄");
			break;
		case SUMMER :
			System.out.println("여름");
			break;
		case FALL :
		case AUTUMN : 
			System.out.println("가을");
			break;
		case WINTER :
			System.out.println("겨울");
			break;
		}
		
		
		System.out.print("계절 입력(1 2 3 4) : ");
		int num = scan.nextInt();
		
		/* 열거형.values() : 열거형 객체 안에 있는 모든 상수 배열로 반환
		 * 열거형객체.ordinal() : 열거형 객체의 순서 알려줌. 0부터.
		 * 
		 */
		for(Season tmp : Season.values()) if( num == tmp.ordinal() + 1) season = tmp;
		
		
		
		switch(season) {
		case SPRING :
			System.out.println("봄");
			break;
		case SUMMER :
			System.out.println("여름");
			break;
		case FALL :
		case AUTUMN : 
			System.out.println("가을");
			break;
		case WINTER :
			System.out.println("겨울");
			break;
		}
		
		
		
	}

}


enum Season{
	SPRING, SUMMER, FALL, AUTUMN, WINTER				//상수 - 대문자
												//값을 봄여름가을겨울만 가질 수 있음
}
