package day002;

public class Ex15_SwitchGrade {

	public static void main(String[] args) {
		// 주어진 성적에 맞는 학점 출력 ABCDF
		
		
		int score = -1 ;
		
		switch (score / 10) {
		case 10, 9 :
			System.out.println(score + " 는 A 학점 입니다. ");
			break;
		case 8 :
			System.out.println(score + " 는 B 학점 입니다. ");
			break;
		case 7 :
			System.out.println(score + " 는 C 학점 입니다. ");
			break;
		case 6 :
			System.out.println(score + " 는 D 학점 입니다. ");
			break;
		case 5, 4, 3, 2, 1 :
			System.out.println(score + " 는 F 학점 입니다. ");
			break;
		case 0 :
			switch (score) {
			case 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 :
				System.out.println(score + " 는 F 학점 입니다. ");
				break;
			}
		default :
			System.out.println(score + " 는 110이상 0 미만 입니다. ");
			
			
		}
		
		
		

	}

}
