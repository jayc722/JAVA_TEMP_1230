package day002;

public class Ex09_IfSeason {

	public static void main(String[] args) {
		/*월이 주워졌을 때 이에 맞는 계절을 출력
		 * 봄 : 345 여름 : 678 가을 : 91011 겨울 : 1212 잘못된 월 : 그 외
		 */

		
		
		int month = 12;
		
		if 			(month < 1 || month > 12) 	{
			System.out.println("잘못된 입력입니다.");
		} else if 	(month == 12  || month < 3) {
			System.out.println(month + " 월은 겨울 입니다.");
		} else if 	(month < 6) 				{
			System.out.println(month + " 월은 봄 입니다.");
		} else if 	(month < 9) 				{
			System.out.println(month + " 월은 여름 입니다.");
		} else 									{
			System.out.println(month + " 월은 가을 입니다.");
		}
	
		
		if 			(month == 3 || month == 4 || month == 5) 	{
			System.out.println(month + " 월은 봄 입니다.");
		} else if 	(month == 6 || month == 7 || month == 8) 	{
			System.out.println(month + " 월은 여름 입니다.");
		} else if 	(month == 9 || month == 10 || month == 11) 	{
			System.out.println(month + " 월은 가을 입니다.");
		} else if 	(month == 12 || month == 1 || month == 2) 	{
			System.out.println(month + " 월은 겨울 입니다.");
		} else 													{
			System.out.println("잘못된 입력입니다.");
		}
	
		
		
		
		
	}

}
