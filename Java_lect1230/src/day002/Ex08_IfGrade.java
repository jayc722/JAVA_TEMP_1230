package day002;

public class Ex08_IfGrade {

	public static void main(String[] args) {
		/* 주어진 정수 성적에 맞는 학점을 출력 
		 * A : 90 ~ 100 B : 80 ~ 89 C : 70 ~ 79 D 60 ~ 69 F : 0 ~ 59 잘못된 점수 : 0보다 작거나 100보다 큰 경우
		 * */
		
		
		int grade = 200;
		
		
		if (grade <= 100 && grade >= 90) {
			System.out.println("A 학점 입니다.");
		}else if (grade < 90 && grade >= 80) {
			System.out.println("B 학점 입니다.");
		}else if (grade < 80 && grade >= 70) {
			System.out.println("C 학점 입니다.");
		}else if (grade < 70 && grade >= 60) {
			System.out.println("D 학점 입니다.");
		}else if (grade < 60 && grade >= 0) {
			System.out.println("F 학점 입니다.");
		}else {
			System.out.println("점수는 0보다 작거나 100을 넘을 수 없습니다.");
		}
		
		
		// 순서에 의해 조건식이 간결해 질 수 있음
		
		 int score = 100;
		
		if (grade < 0 || score > 100) {
			System.out.println("잘못된 점수");
		}else if(score >= 90) {
			System.out.println("A 학점 입니다");
		}else if(score >= 80) {
			System.out.println("B 학점 입니다");
		}else if(score >= 70) {
			System.out.println("C 학점 입니다");
		}else if(score >= 60) {
			System.out.println("D 학점 입니다");
		}else {
			System.out.println("F 학점 입니다");
				}
		
		

	}

}
