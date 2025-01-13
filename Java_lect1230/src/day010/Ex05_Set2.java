package day010;

import java.util.HashSet;

public class Ex05_Set2 {

	public static void main(String[] args) {
		// 1에서 9 사이 랜덤한 수를 생성하여 중복되지 않게 3개 만드는 코드
		
		HashSet<Integer> set = new HashSet<Integer>();
		int min = 1, max = 9;
		
		while(set.size() < 3) {
			Integer ran = (int)(Math.random()*(max - min + 1) + min);	
				set.add(ran);
		}
		System.out.println(set);
		

	}

}
