package day006;

public class Ex04_ArrayCopy2 {

	public static void main(String[] args) {
		// 깊은 복사 얕은 복사 비교
		
		
		Point [] points = new Point[5];		//참조형 -> 초기화 : null
		//points[0].print();				//못씀{null)
		
		for(int i = 0; i < points.length; i++) {
			points[i] = new Point(i, i);
		}
		
		
		print(points);
		
		Point [] points2 = new Point[points.length];
		System.arraycopy(points, 0, points2, 0, points.length);
		
		System.out.println("---------------");
		points[0].x = 10;								//얕은 복사
		print(points2);							
		
		
		System.out.println("---------------");
		points[0] =  new Point(10,10);								//
		points[0].x = 100;								//이때는 아예 객체를 새로 만들기 때문에 되는거처럼 보임(주의)
		print(points2);
		
		
		points2[0].x = 1;								
		Point [] points3 = new Point[points2.length];	//깊은 복사
		for(int i = 0; i < points2.length; i++) {
			points3[i] = new Point(points2[i]);
		}
		points2[0].x = 100;
		
		System.out.println("--------------");
		print(points);
		
		
		
	}

	public static void print(Point[] points) {
		for(int i = 0; i < points.length; i++) {
			points[i].print();
		}
	}
	
}
	
	class Point{
		int x, y;
		
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
		
		public Point(Point p) {				//복사 생성자 - 자기자신 복사하는 생성자
			this(p.x,p.y);					//위아래 같은 것
			//x=p.x;
			//y=p.y;		
			
		}
		
		public void print() {
			System.out.println("(" + x + ", " + y + ")");
		}
		
		
		
	}
	

