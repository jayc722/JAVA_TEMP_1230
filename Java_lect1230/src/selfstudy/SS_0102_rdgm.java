package selfstudy;

import java.util.Random;
import java.util.Scanner;

public class SS_0102_rdgm {

	public static void main(String[] args) {

		Random random = new Random();
		final int minAf = 1, maxAf = 3, minDf = 1, maxDf = 3;
		Scanner scan = new Scanner(System.in);
		char input = 0;
		int damage = 0, sword; 
		int minSword = 0, maxSword = 0, minArmor = 0, maxArmor = 0;
		int myHp = 100;
		int potion = 0;
		int mobD = 0;
		
		//공격 1 아이템 2 후퇴 3
		
		
		/////////////////////////////////////////////////////////////////////////////////////////
		
		
		
		System.out.println("적이 나타났다!");
		for (int monHp = 10;monHp>0||myHp>0;){									//몹 등장
						
			System.out.println("적의 남은 체력 : " + monHp + "\n무엇을 할까. 1. 공격 2. 아이템 3. 방어");
			input = scan.next().charAt(0);
						
			if(input == '1') {
				
				
				int minA = minAf + minSword, maxA = maxAf + maxSword; 
				damage = random.nextInt(maxA - minA + 1) + minA;
				monHp -= damage;
				
				System.out.println(damage + "데미지!");
		
				
			}else if(input == '2') {
				
				if(potion<=0)System.out.println("사용가능한 아이템이 없다!");
				else {
					System.out.println("무슨 아이템을 사용할까요? \n 1. 포션 : " + potion + " 2. 뒤로가기");
					input = scan.next().charAt(0);
					
					if(input == '1') {
						if(potion>0) {
						System.out.println("체력을 30 회복");
						myHp += 30;
						potion--;
						System.out.println("현재 체력 : " + myHp);
						continue;
						}else {
							System.out.println("포션이 없습니다.");
							continue;
						}
					}else if(input == '2') {
						continue;
					}else System.out.println("유효하지 않은 조작입니다.");
					
				}
				
			}else if(input == '3') {
				
				System.out.println("무사히 도망쳤다");
				break;
			}else{	
				
			}
			if(monHp<=0) {
				System.out.println("승리!");
				break;
			}
			
			mobD = random.nextInt(20);
			myHp -= mobD;
			System.out.println("적의 공격!" + mobD + "데미지!\n" + "남은 체력 : " + myHp );
			
			if(myHp<=0) {
				System.out.println("패배");
				break;
			}
			
		}
		
		//////////////////////////////////////////////////////////////////

		System.out.println("칼을 획득했다!");
		System.out.println("포션을 3 획득했다!");
		
		minSword = 5; maxSword = 5;
		potion +=3;
		
		/////////////////////////////////////////////////////////////////
		
		System.out.println("끝");
			
			
			
			
		
		
		
		
		
		
		
		
	}

}
