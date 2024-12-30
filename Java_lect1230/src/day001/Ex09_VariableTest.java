package day001;

public class Ex09_VariableTest {

	public static void main(String[] args) {
		
		/*
		 학생의 국어 영어 수학 성적을 저장하기 위한 변수를 선언하세요.
		 		 */
		
		int korScore = 0, engScore = 0, matScore = 0;
		
		final int MaxScore = 100;
		
		
		/*
		 학생의 국어 영어 수학 성적의 평균을 저장하기 위한 변수를 선언하세요.
		 		 */
		
		double avaScore	= 0;
		
		korScore = 100;
		engScore = 100;
		
		avaScore = (korScore + engScore + matScore) / (double)3;
		
		System.out.printf("%.2f\n", avaScore);
				
		/*
		 학생의 학점을 저장하기 위한 변수를 선언하세요. A B C D F 만 저장
		 		 */
		
		char testScore = '0';
		String testScore2 = "0";
		
		testScore = 'A';
		testScore2 = "A";
		
		
		System.out.println(testScore+testScore2);
		
		
		
				
		
		
		
		
	}

}
