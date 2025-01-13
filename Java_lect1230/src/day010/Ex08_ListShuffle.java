package day010;

import java.util.ArrayList;
import java.util.Collections;

public class Ex08_ListShuffle {

	public static void main(String[] args) {

		
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		for(int i = 1; i <= 10; i++)list.add(i);
		
		System.out.println(list);
		
		Collections.shuffle(list);		//list 값을 임의로 섞음
				
		System.out.println(list);
		
	}

}
