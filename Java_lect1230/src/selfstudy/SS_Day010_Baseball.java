package selfstudy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;

public class SS_Day010_Baseball {

	
	public static void main(String[] args) {
		// 숫자야구게임
		
				int min = 1, max = 9;
				
				HashSet<Integer> set = new HashSet<Integer>();
				ArrayList<Integer> list = new ArrayList<Integer>();
				
				Scanner scan = new Scanner(System.in);
				Integer [] nums = new Integer[3];
				
				while(set.size() < 3) {
					Integer ran = (int)(Math.random()*(max - min + 1) + min);	
						set.add(ran);
				}
				System.out.println(set);
				list.addAll(set);
				Collections.shuffle(list);
				System.out.println(list);
				
				int strike, ball, out;
				int count = 0;
				
				
				do {
					strike = 0; ball = 0;
					System.out.print("세 자리 숫자 입력 : ");
					for(int i = 0; i<3;i++) nums[i] = scan.nextInt();
					for(int i=0;i<3;i++) if(nums[i] == list.get(i))strike++;
					for(int i=0;i<3;i++) if(list.contains(nums[i]))ball++;
					if(ball>0)ball-=strike;
					if(ball>0||strike>0)System.out.println(ball + " ball " + strike + " strike ");
					else System.out.println("3o");	
					count++;
				}while(strike<3);
				System.out.println(count + "clear");

	}

}
