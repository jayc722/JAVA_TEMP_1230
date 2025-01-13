package day010;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;

public class Ex09_BaseballGame {

	public static void main(String[] args) {
		// 숫자야구게임
		
		/////////////////////////////////////////////////////////////////
		//set의 값들을 list로 넘기기
		HashSet<Integer> set = new HashSet<Integer>();
		set.add(1);
		set.add(2);
		set.add(3);
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.addAll(set);
		System.out.println(list);
		
		/////////////////////////////////////////////////////////////
		
		
		ArrayList<Integer> com = new ArrayList<Integer>();
		ArrayList<Integer> user = new ArrayList<Integer>();
		Scanner scan = new Scanner(System.in);
		
		int min = 1, max = 9;
		createRandomList(min, max ,3, com);	//랜덤으로 1~9사이 중복되지 않은 수 생성
		System.out.println(com);
		int strike = 0, ball = 0;
		
		
		
		do {
			
			user.clear();//clear()를 통해 리스트의 값 초기화
			
			//입력
			System.out.print("입력 : ");
			for(int i = 0; i < 3; i++) {
				user.add(scan.nextInt());
			}
			
			
			strike = getStrike(com, user);//스트라이크 개수 판별
			
			
			ball = getBall(com,user);//볼의 개수 판별
			
			
			
			printResult(strike,ball);//결과 출력
			
			
		}while(strike<3);
		
		

	}

	private static void printResult(int strike, int ball) {
		
		if(strike != 0) System.out.print(strike + "S");
		if(ball != 0) System.out.print(ball + "B");
		if(strike == 0 && ball == 0) System.out.println("3O");
		System.out.println();
	}

	private static int getBall(ArrayList<Integer> com, ArrayList<Integer> user) {
		//일치하는 숫자 개수(위치 상관x) - 스트라이크 개수
		int count = 0;
		for(int tmp : com) if(user.contains(tmp)) count++;
		
		return count - getStrike(com,user);
	}

	private static int getStrike(ArrayList<Integer> com, ArrayList<Integer> user) {
		//get(번지)
		int strike = 0;
		for(int i = 0; i<com.size(); i++)if(com.get(i)==user.get(i))strike++;
		return strike;
	}

	private static void createRandomList(int min, int max, int size, ArrayList<Integer> com) {
		//set에 1~9 사이 랜덤 수 3개 될 때까지 저장
		HashSet<Integer> set = new HashSet<Integer>();
		
		while(set.size() < size) {
			int r = (int)(Math.random() * (max - min + 1) + min);
			set.add(r);
		}
		System.out.println(set);
		// set에 있는 값 list에 옮김
		com.addAll(set);
		//list에 잇는 값들 섞어줌
		Collections.shuffle(com);
		
	}

}
