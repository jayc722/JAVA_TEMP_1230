package selfstudy.ss0123baseball;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Pattern;

public class Test {
	public static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {

		List<Integer> intList = new ArrayList<Integer>();
		Set<Integer> set = new HashSet<Integer>();

		while(set.size() < 3) {
			set.add((int)(Math.random()*(9) + 1));
		}

		intList.addAll(set);
		Collections.shuffle(intList);
		System.out.println(intList);



		int count = 0;
		int strike = 0;
		int ball = 0;
		List<Integer> inputList = new ArrayList<Integer>();
		do {
			for(int i = 0; i < 3;) {
				System.out.print("세자리 숫자 입력");
				inputList.add(i, scan.nextInt());
				if(inputList.get(i)>9||inputList.get(i)<1) {
					System.out.println("1에서9사이 숫자 입력");
				}
			}
				count++;
				System.out.println(count);




				/*				for(int i = 0; i < 3; i++) if(baseballNum[i] == num[i])strike++;

		for(int tmp : baseballNum) {
			for(int tmp2 : num) {
				if (tmp2 == tmp) ball++;
			}
		}
		ball -= strike;
				 */			
				for(int i = 0; i < 3; i++) {
					for (int tmp0 : inputList) {
						if(tmp0 == intList.get(i)) if(inputList.get(i)==intList.get(i))strike++;else ball++;
					}
				}

				if(strike != 0) {
					System.out.print(strike + "S");
				}
				if(ball != 0) {
					System.out.print(ball + "B");
				}
				if(strike == 0 && ball == 0) {
					System.out.print("3O");
				}

				System.out.println();

			}while(strike<3);
		}

}
