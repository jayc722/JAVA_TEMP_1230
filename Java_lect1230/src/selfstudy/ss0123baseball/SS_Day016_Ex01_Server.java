package selfstudy.ss0123baseball;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Stream;


public class SS_Day016_Ex01_Server {

	static List<BaseBall> list = new ArrayList<BaseBall>();
	public static void main(String[] args) {
		// 숫자야구게임 구현
		// 단, 기록은 서버에 통신을 이용하여 저장
		// 기록은 영문 3자와 횟수를 기록
		// 기록이 같은 경우 먼저 등록된 순으로 순위를 출력

		//기록은 상위 5명만 출력

		int port = 5001;
		try {
			ServerSocket serverSocket;
			serverSocket = new ServerSocket(port);
			//while문
			while(true) {
				//트라이캐치(연결 종료용)
				try {

					Socket socket = serverSocket.accept();

					System.out.println("[연결 성공!]");

					ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
					ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());


					//runmenu

					while(true) {
						//메뉴를 입력 받음
						int menu = ois.readInt();
						//입력받은 메뉴에 맞는 기능을 실행
						runMenu(menu, oos, ois);
					}
				}catch(Exception e) {
					System.out.println("연결 종료");
				}
			}
		} catch (Exception e) {
			System.out.println("에러 발생");
			e.printStackTrace();
		}
		////////////////////baseBall 클래스


		////////////////////client
		//프로그램 구현


		//runmenu

		//1. 숫자야구게임
		//서버에서 숫자를 받음

		//서버에서 받은 숫자(3자리)로 숫자야구게임을 실행
		//숫자 세자리 입력받음(string num > index123 > int)
		//중복체크 -> 문제없으면 실행횟수+1
		//스트라이크 개수 판별
		//볼 개수 판별 - 스트라이크 개수
		//출력 -> 스트라이크 ==0&&볼==0 ? 3o : ns nb

		//승리 시 -> 성적 등록
		//3자리 string 입력
		//string과 점수 전송
		//순위 받아서 
		//2. 기록 조회
		// 서버에게 상위 5개의 기록을 받아 조회
		//3. 종료



	}

	private static void runMenu(int menu, ObjectOutputStream oos, ObjectInputStream ois) {

		switch(menu) {
		case 1:
			play(oos, ois);
			break;
		case 2:
			rank(oos, ois);
			break;
		case 3:
			break;
		default:
			System.out.println("[잘못된 메뉴를 클라이언트가 전송했습니다.]");
		}

	}

	private static void rank(ObjectOutputStream oos, ObjectInputStream ois) {
		// TODO Auto-generated method stub
		
	}

	private static void play(ObjectOutputStream oos, ObjectInputStream ois) {
		List<Integer> intList = new ArrayList<Integer>();
		Set<Integer> set = new HashSet<Integer>();

		while(set.size() < 3) {
			set.add((int)(Math.random()*(9) + 1));
		}
		
		intList.addAll(set);
		Collections.shuffle(intList);
		System.out.println(intList);

		try {
			oos.writeObject(intList);
			oos.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


			try {
				BaseBall bb = (BaseBall) ois.readObject();
				boolean res = list.add(bb);
				Collections.sort(list, (o1, o2) -> {
					BaseBall bb1 = (BaseBall)o1;
					BaseBall bb2 = (BaseBall)o2;
					
					if(bb1.getCount() != bb2.getCount()) {
						return bb1.getCount() - bb2.getCount();
					}
					if(bb1.getDate().equals(bb2.getDate())) {
						return bb1.getDate().compareTo(bb2.getDate());
					}
					return bb1.getNickName().compareTo(bb2.getNickName());					
				});
				
				oos.writeBoolean(res);
				oos.flush();
				System.out.println(list);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			



	}




	//runmenu

	//1. 숫자야구게임
	//서버에서 숫자를 전송
	//승리 시 -> 성적 등록
	//받은 string과 점수를 list에 등록 > 점수순으로 들어가게(기록순,점수순)
	//
	//
	//2. 기록 조회
	//요청 받을 시 list 상위 5 항목(0번지~5번지)을 전송

	//3. 종료

	//
	private static void print(List<BaseBall> list, Predicate<BaseBall> p) {		//삭제기능에서 사용하기 위해 수정(전체범위 이외에)
		Stream<BaseBall> stream = list.stream();
		stream.filter(p).forEach(s -> System.out.println(s));
}
}
