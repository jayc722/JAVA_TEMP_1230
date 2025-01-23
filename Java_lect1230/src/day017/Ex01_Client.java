package day017;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;


public class Ex01_Client {

	static private Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {
		
		/*ArrayList<Integer> list = (ArrayList<Integer>) Arrays.asList(4,5,6); //초기값 부여
		Record r = playGame(list);
		System.out.println(r);
		*/
		
		
		//서버와 연결
		
		String ip = "127.0.0.1";
		//String ip = "192.168.40.3";
		
		int port = 5002;
		Socket socket = null;
		ObjectOutputStream oos;
		ObjectInputStream ois; 

		try {
			socket = new Socket(ip, port);
			System.out.println("[연결 성공!]");
			//IO스트림 생성
			oos = new ObjectOutputStream(socket.getOutputStream());
			ois = new ObjectInputStream(socket.getInputStream());
			
		}catch (Exception e) {
			System.out.println("[서버 연결 x]");
			return;
		}
		
		int menu;
		do {
			printMenu();
			
			menu = scan.nextInt();
			//생성한 IO스트림을 넘겨줌
			
			/*try {
				oos.writeInt(menu);
				oos.flush();
			} catch (IOException e) {
				e.printStackTrace();
			}
			*/
			runMenu(menu, ois, oos);
			
		}while(menu != 3);
		
		

	}

	private static void printMenu() {
		
		System.out.println("--------------------");
		System.out.println("1. 숫자야구게임 플레이");
		System.out.println("2. 기록 조회");
		System.out.println("3. 종료");
		System.out.println("--------------------");
		System.out.print("메뉴 선택 : ");

	}

	private static void runMenu(int menu, ObjectInputStream ois, ObjectOutputStream oos) {
		switch(menu) {
		case 1 :
			//IO스트림을 넘겨줌
			play(ois, oos);
			break;
		case 2 :
			//IO스트림을 넘겨줌
			recordView(ois, oos);
			break;
		case 3 : 
			System.out.println("프로그램 종료");
			break;
		default :
			System.out.println("올바른 메뉴가 아닙니다.");
		}

	}

	private static void play(ObjectInputStream ois, ObjectOutputStream oos) {
		//랜덤 리스트 생성
		List<Integer> nums = randomList(1, 9, 3);
		
		Record r = playGame(nums);
		//서버에 전송
		
		/*try {
			oos.writeObject(r);
			oos.flush();
			
			boolean res = ois.readBoolean();
		} catch (Exception e) {
			System.out.println("예외 발생!");
			e.printStackTrace();
		}
		*/
		sendRecord(r, ois, oos);
		
	}

	private static void sendRecord(Record r, ObjectInputStream ois, ObjectOutputStream oos) {
		try {
		
		// 메뉴 전송
		oos.writeInt(1);
		// 기록 전송
		oos.writeObject(r);
		oos.flush();
		//서버에게 결과를 확인받아 실패한 경우 알림
		boolean res = ois.readBoolean();
		if(!res)System.out.println("전송실패");
		
		
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void recordView(ObjectInputStream ois, ObjectOutputStream oos) {
		
				
		
		
		try {
			//메뉴를 서버에 전송
			oos.writeInt(2);
			oos.flush();
			
			//전송받은 기록 리스트 받아옴
			List<Record> list = (List<Record>)ois.readObject();
			//받아온 기록 리스트를 출력
			printRecords(list);
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private static boolean printRecords(List<Record> list) {
		if(list == null || list.isEmpty()) {
			System.out.println("등록된 점수가 없습니다.");
			System.out.println("지금 플레이하면 1등");
			return false;
		}
		for(int i = 0; i < list.size(); i++) {
			System.out.println(i+1 + ". " + list.get(i));	//toString 오버라이딩해서 예쁘게 출력
		}
		return true;
	}

	private static Record playGame(List<Integer> nums) {
		int strike=0, ball=0;
		List<Integer> user = new ArrayList<Integer>();
		int count = 0;
		do {
			user.clear();
			System.out.print("입력 : ");
			while(user.size()<3) {
				user.add(scan.nextInt());
			}
			++count;
			strike = getStrike(nums, user);
			ball = getBall(nums, user);
			printResult(strike, ball);
			
			
			
		}while(strike < 3);
		
		//닉네임 입력
		System.out.print("이니셜(최대 세자리) 입력 : ");
		String nickName = scan.next();
		return new Record(count,nickName);
	}
	
	private static void printResult(int strike, int ball) {
		if(strike != 0) {
			System.out.print(strike + "S");
		}
		if(ball != 0) {
			System.out.print(ball + "B");
		}
		if(strike == 0 && ball == 0) {
			System.out.print("O");
		}

		System.out.println();
		
	}

	private static int getBall(List<Integer> nums, List<Integer> user) {
		int count = 0;
		for(int num : nums) {
			if(user.contains(num))count++;
		}
		return count - getStrike(nums, user);
	}

	private static int getStrike(List<Integer> nums, List<Integer> user) {
		int count = 0;
		for(int i = 0; i < nums.size(); i++) {
			if(nums.get(i) == user.get(i))count++;
		}
		return count;
	}

	private static List<Integer> randomList(int min, int max, int size) {
		List<Integer> list = new ArrayList<Integer>();
		Set<Integer> set = new HashSet<Integer>();

		while(set.size() < size) {
			set.add(random(min,max));
		}
		
		list.addAll(set);
		Collections.shuffle(list);
		System.out.println(list);
		return list;
			
			
			
	}
	private static int random(int min, int max) {
		if(max < min) {
			int tmp = min;
			min = max;
			max = tmp;
		}

		return (int)(Math.random()*(max - min + 1) + min);

	}

}
