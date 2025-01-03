package day004;

public class Ex07_Class {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}


/* 자동차 클래스
 *  - 정보 : 회사 종류 색상 연식
 *  - 기능 : 시동켜기/끄기 기어변속 액셀누름 브레이크누름 핸들조작
 * 
 */


class 클래스명{
	
	//멤버변수, 필드
	String company;
	String type;
	String color;
	int year;
	String oilType;
	boolean power = true; 	//전원
	char gear; 		//기어
	int speed;		//속력
	int deg;		//방향 각도
	
	//메소드
	/*시동을 켜는 메소드
	 * 매개변수 : power
	 * 리턴타입 : true false
	 * 메소드명 : turnOn
	 */
	static void turnOn (boolean power) {
		if(power) {
			power = false;
		}else {
			power = true;
		}
		return;
	}
	
	
}
