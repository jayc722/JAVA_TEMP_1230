package day006.score;

public class Student {
	private String name;
	private int score;
	
	
	
	

	public int getScore() {
		return score;
	}



	public void print() {
		System.out.println(name + " : " + score);
		
	}
	
	
	// 생성자
	public Student(String name, int count) {
		this.name = name;
		this.score = count;
	}
}
