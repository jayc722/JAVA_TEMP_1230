package day004;

public class Ex08_Class2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		Point1 p1 = new Point1(10,10);
		p1.print();
		p1.move(20,20);
		p1.print();
		
	}

}



/* 화면에 점을 나타내기 위한 클래스
 * 필드		
 * -점 개수
 * -x좌표 y좌표
 *
 * 
 * 메소드		
 * -점의 x좌표 y좌표
 * -좌표 이등 기능
 * 
 * 생성자
 * -기본생성자(0,0으로)
 * -원하는 위치로 이동
 * 
 * 화면 초기화
 * 		
 */


class Point1{
	//필드
	int dotCount;
	int fieldX=20;
	int fieldY=20;
	
	private int dotX;
	private int dotY;
	
	
	//메소드
	
	public void print() {
		System.out.println("(" + dotX + "," + dotY + ")");
	}
	
	//put a dot
	public void move(int dotX1, int dotY1) {
		dotX=dotX1;
		dotY=dotY1;
		
		
		
	}
	
	
	//생성자
	
	public Point1() {}
	
	public Point1(int dotX1, int dotY1) {
		//for(int i=1; i <= fieldY; i++) for(int j=1; j<= fieldX; j++) System.out.println(" ");
		move(dotX1,dotY1);
	}
	
	
	
}