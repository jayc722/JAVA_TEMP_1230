package day003;
import java.util.Scanner;

public class Ex11_ForLCM {

	public static void main(String[] args) {
		/* 정수 num1과 num2를 입력받고 두 정수의 최소 공배수를 구하는 코드를 작성
		 * 2의 배수 : 2 4 6 8 10
		 * 3의 배수 : 3 6 9 12
		 * 2와 3의 공배수 : 6 12 18 24
		 * 2와 3의 최소공배수 : 6
		 * A의 배수 : 어떤 수를 A로 나누었을 때 0이 되는 수
		 * 공배수 : 공통으로 있는 배수
		 * 최소공배수 : 공배수 중 가장 작은 공배수
		 * 반복횟수 i는1부터 1씩증가
		 * 규칙성 i가 num1 num2 의 배수이면 i 출력하고 종료
		 * =>i를 num1로 나누었을때 나머지가 0과 같고 i를 num2로 나누었을때 나머지가 0과 같다면 i를 출력하고 반복문을 종료
		 * 반복문 종료후 : 없음
		 */
		Scanner scan = new Scanner(System.in);
		System.out.println("두 수를 입력해 주세요");
		int num1 = scan.nextInt(), num2 =scan.nextInt();
		int gcd=1;
		int lcm=0;
		for(int i=1; i<=num1||i<=num2; i++) if(num1%i==0) if(num2%i==0) gcd = i;		
		System.out.println(num1 + " 과 " + num2 + " 의 최대 공약수는 : " + gcd );
		System.out.println(num1 + " 과 " + num2 + " 의 최소 공배수는 : " + num1*(num2/gcd));
			
		for(int i=1; ;i++) if(i%num1==0) if(i%num2==0) {lcm=i; break;}
		System.out.println(num1 + " 과 " + num2 + " 의 최소 공배수는 : " + lcm);
		
		/*반복횟수 i를 num1부터 =>num1의 배수를 활용
		 * 
		 */
		for(int i=num1; ;i+= num1) if(i%num2==0) {lcm=i; break;}
		System.out.println(num1 + " 과 " + num2 + " 의 최소 공배수는 : " + lcm);
		
		
	}
	
}
