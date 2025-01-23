package day017;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ex01_Server {

	static List<Record> list = new ArrayList<Record>();

	public static void main(String[] args) {
		// 숫자야구게임 구현
		// 단, 기록은 서버에 통신을 이용하여 저장
		// 기록은 영문 3자와 횟수를 기록
		// 기록이 같은 경우 먼저 등록된 순으로 순위를 출력

		//기록은 상위 5명만 출력

		int port = 5002;

		try {
			ServerSocket serverSocket = new ServerSocket(port);

			while(true) {			//여러번 접속해도 되게 
				Socket socket = serverSocket.accept();
				Thread t = new Thread(()->{
					try {
						ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
						ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());			
						System.out.println("[연결 성공!]");



						while(true) {

							//메뉴를 입력받음(클라이언트에게) -> 
							int menu = ois.readInt();
							//메뉴에 따라 기능을 실행
							runMenu(menu, ois, oos);
						}
					}catch (Exception e) {
						System.out.println("[연결 해제]");
					}
				});
				t.start();
			}
		}catch (Exception e) {
			e.printStackTrace();		
		}

	}

	private static void runMenu(int menu, ObjectInputStream ois, ObjectOutputStream oos) {
		switch(menu) {
		case 1 :
			insertRecord(ois, oos);
			break;
		case 2 :
			recordView(ois, oos);
			break;
		}

	}

	private static void recordView(ObjectInputStream ois, ObjectOutputStream oos) {
		//클라이언트에게 기록 리스트를 전송
		try {

			//List<Record> tmp = new ArrayList<Record>();
			List<Record> tmpList = list.subList(0, Math.min(5, list.size()));	//복사 - 최솟값이 5에서 list.size개까지
											//subList(from,to) to->min(list항목수)
			List<Record> sendList = new ArrayList<Record>();		//tmpList가 직렬화 안된 애를 전달해서 -> 새로 array만들어서
			sendList.addAll(tmpList);
			/*for(int i = 0; i < 5; i++) {
				
				if(list.get(i)==null)break;			
				tmp.add(list.get(i));
				}
				oos.writeObject(tmp);

			}*/
			oos.writeObject(sendList);
			oos.flush();


		}catch (Exception e) {
			System.out.println("[기록 조회 예외 발생]");
			e.printStackTrace();
		}

	}

	private static void insertRecord(ObjectInputStream ois, ObjectOutputStream oos) {
		try {

			// 기록 수신(클라)
			Record r = (Record) ois.readObject();
			// 기록 추가
			boolean res = list.add(r);
		//기록 정렬
		Collections.sort(list, (o1, o2) -> {			//integer랑 다르게 직접 만들어야(아니면 comparator 만들어주든지)
			Record r1 = (Record)o1;		//object라 형변환 필요
			Record r2 = (Record)o2;
			if(r1.getCount() != r2.getCount()) return r1.getCount() - r2.getCount();
			if(!r1.getDate().equals(r2.getDate())) return r1.getDate().compareTo(r2.getDate()); //date에서 날짜순정렬 compareto 지원해줌
			return r1.getNickName().compareTo(r2.getNickName());
		});
		
		//클라이언트에게 결과 전달
		
		oos.writeBoolean(res);
		oos.flush();
		System.out.println(list);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}



}
