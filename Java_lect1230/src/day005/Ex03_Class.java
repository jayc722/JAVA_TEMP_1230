package day005;

public class Ex03_Class {

	public static void main(String[] args) {
		
		String name = "임꺽정";
		int count = 100;
		
		System.out.println("이름 : " + name + " - " + count + " 회");
		record1(name, count);
		System.out.println("이름 : " + name + " - " + count + " 회");
		Record r1 = new Record(name, count);
		r1.print();
		record2(r1);
		r1.print();
		System.out.println("이름 : " + name + " - " + count + " 회");
		

		
		
	}

	
	public static void record1(String name, int count) {
		name = "홍길동";
		count = 2;
	}
	
	public static void record2(Record r1) {
		r1.setName("홍길동");
		r1.setCount(2);
		
	}
}

class Record{
	
	//멤버변수 , 필드
	private int count;						//멤버변수 ->클래스 전체에서 사용하는 변수	지역변수보다 더 넓은 범위
	private String name;			//private 는 외부에서 접근 x
	
	
	
	
	//메소드 : 기능
	
	
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	
	public void print() {
		System.out.println("이름 : " + name + " - " + count + " 회");
	}
	
	//생성자
	
	//public Record() {							//기본생성자
	
	public Record(String name, int count) {
		this.name = name;
		this.count = count;
		
		}
		
	public Record() {
		this("홍길동", 100);
		//name = "홍길동";
		//count = 100;
		
	}
	
	
	
}
