package selfstudy.ss0123baseball;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;


public class SS_Day016_Ex01_Client {

	private static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) {
		String ip = "127.0.0.1";
		int port = 5001;
		
		int menu = 0;
		
		Socket socket = null;
		ObjectOutputStream oos;
		ObjectInputStream ois; 

		try {
			socket = new Socket(ip, port);
			oos = new ObjectOutputStream(socket.getOutputStream());
			ois = new ObjectInputStream(socket.getInputStream());
			System.out.println("연결 성공");
			
		}catch (Exception e) {
			System.out.println("서버와 연결이 되지 않아 프로그램을 종료합니다.");
			return;
		}
		
		do {
			printMenu();
			
			menu = scan.nextInt();
			scan.nextLine();
			
			try {
				oos.writeInt(menu);
				oos.flush();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			runMenu(menu, ois, oos);
			
		}while(menu != 5);

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
		case 1:
			baseBall(ois, oos);
			break;
		case 2:
			rank(ois, oos);
			break;
		case 3:
			System.out.println("프로그램을 종료합니다.");
			break;
		default:

		}

	}
	private static void rank(ObjectInputStream ois, ObjectOutputStream oos) {

		try {
			List<BaseBall> list = (List<BaseBall>)ois.readObject();
			if(!printRank(list)) return;

		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static boolean printRank(List<BaseBall> list) {
		if(list == null || list.isEmpty()) {
			System.out.println("등록된 랭킹이 없습니다.");
			return false;
		}
		for(BaseBall lank : list) {
			System.out.println(lank);
		}
		return true;
	}

	private static void baseBall(ObjectInputStream ois, ObjectOutputStream oos) {
		try {
			List<Integer> intList = new ArrayList<Integer>();
			
			intList = (List)ois.readObject();
			

			int count = 0;
			int strike = 0;
			int ball = 0;
			do {
				System.out.print("세자리 숫자 입력");
				String inputNum = scan.nextLine();
				if(!Pattern.matches("/(\\d)(?!\\1)(\\d)(?!\\1|\\2)(\\d)/g", inputNum)) {
					System.out.println("중복되지 않는 세자리 숫자를 입력해주세요");
					continue;
				}
				count++;
				int num [] = new int[3];
				
				
				//string을 num1~num3로 분리
				for(int i = 0; i<3; i++) {
					num[i] = (int)inputNum.charAt(i);
				}
				
/*				for(int i = 0; i < 3; i++) if(baseballNum[i] == num[i])strike++;

				for(int tmp : baseballNum) {
					for(int tmp2 : num) {
						if (tmp2 == tmp) ball++;
					}
				}
				ball -= strike;
	*/			
				for(int i = 0; i < 3; i++) {
					for (int tmp0 : num) {
						if(tmp0 == ) if(num[i]==baseballNum[i])strike++;else ball++;
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
			
			boolean res = false;
			
			do {
			
			String name = inputName();
			BaseBall record = new BaseBall(count, name);
			//oos.writeUTF(name);
			//oos.writeInt(count);
			oos.writeObject(record);
			oos.flush();
			res = ois.readBoolean();
			}while (!res);
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}

		}
		
		private static String inputName() {
			String input;
			while(true){
				System.out.print("등록할 이름(세자리) :");
				input = scan.nextLine();
				if(!Pattern.matches("/[\\S]{3}/", input)) {
					System.out.println("세자리를 입력해주세요");
					continue;
				}
				return input;
			}

		}

}
