package day016;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Ex01_Server {

	private static List<Post> list = new ArrayList<Post>();

	public static void main(String[] args) {

		int port = 5001;
		String fileName = "src/day016/data.txt";
		String fileName2 = "src/day016/count.txt";			//합쳐도 되지만 세이브로드 메소드 고쳐야 하니...
		

		try {
			list = (List<Post>) load(fileName);
			Integer count = (Integer) load(fileName2);
			count = count == null ? 0 : count;		//널체크 안하면 초기 오류...
			Post.setCount(count);
			
			if(list == null) list = new ArrayList<Post>();
			/*else if (!list.isEmpty()) {							//카운트에서 널체크 해줘서 필요 없어짐... post.setcount만...
				//int count = list.get(list.size() -1).getNum(); 	//가장 마지막글 게시글 번호 가져옴 ->이거 안해주면 게시글번호 1번부터 시작
																	//세이브로드용 count 파일 새로 만들어서
				Post.setCount(count);
			}*/														
		
			ServerSocket serverSocket = new ServerSocket(port);

			//서버가 대기하다 연결 요청이 오면 Socket 객체를 생성
			//1. 서버 대기, 2. 연결 요청 수락, 3. Socket 객체 생성
			while(true) {
				try {
				Socket socket = serverSocket.accept();
				System.out.println("[연결 완료]");

				ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
				ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());

				while(true) {
					//메뉴를 입력 받음
					int menu = ois.readInt();
					System.out.println(menu);
					//입력받은 메뉴에 맞는 기능을 실행
					runMenu(menu, oos, ois);

				}
				}catch (Exception e) {
					System.out.println("[연결 종료]");
					//e.printStackTrace();
					save(fileName,list);
					save(fileName2,Post.getCount());
			}

		}

	}catch (Exception e) {
		e.printStackTrace();
	}finally {				//갑작스러운 종료에도 세이브되도록 
		save(fileName,list);
		save(fileName2,Post.getCount());
	}
		
		
		
	}

	private static void runMenu(int menu, ObjectOutputStream oos, ObjectInputStream ois) {
		switch(menu) {
		case 1:
			insert(oos, ois);
			break;
		case 2:
			update(oos, ois);
			break;
		case 3:
			delete(oos, ois);
			break;
		case 4:
			search(oos, ois);
			break;
		case 5:
			break;
		default:
			System.out.println("[잘못된 메뉴를 클라이언트가 전송했습니다.]");
		}

	}
	private static void insert(ObjectOutputStream oos, ObjectInputStream ois) {
		try {
			//게시글 정보를 받음
			Post post = new Post((Post)ois.readObject());

			//게시글을 등록
			//결과를 보냄
			oos.writeBoolean(list.add(post));
			oos.flush();
			System.out.println(list);
		}catch (Exception e) {
			System.out.println("예외 발생");
		}
	}

	private static void update(ObjectOutputStream oos, ObjectInputStream ois) {
		try {
			//수정할 객체를 클라이언트에서 받음
			Post post = (Post) ois.readObject();

			//객체가 없으면 false를 
			int index = list.indexOf(post);
			boolean res = true;
			if(index < 0 ) {
				res = false;
			}
			//있으면 객체를 수정하고 true를 전송
			else {
				Post tmp = (Post)list.get(index).clone();
				tmp.setTitle(post.getTitle());
				tmp.setContent(post.getContent());
				list.set(index, tmp);
			}
			oos.writeBoolean(res);
			oos.flush();
			System.out.println(list);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void delete(ObjectOutputStream oos, ObjectInputStream ois) {
		try {
			//클라이언트가 보내준 게시글 번호를 받아옴
			int num = ois.readInt();
			//받아온 번호로 객체를 생성
			//삭제를 하고 결과를 클라이언트에게 전송
			/*
			Post post = new Post(num);
			boolean res = list.remove(post);
			oos.writeBoolean(res);
			*/
			oos.writeBoolean(list.remove(new Post(num)));
			oos.flush();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void search(ObjectOutputStream oos, ObjectInputStream ois) {
		try {
			//전체 게시글을 클라이언트에게 전송
			List<Post> tmplist = new ArrayList<Post>();		//복사본 생성
			oos.writeObject(list);
			oos.writeObject(tmplist); 	//이게 있어야 동작
			oos.flush();
			
			if(list == null || list.isEmpty()) {
				return;
			}
			
			//게시글 번호를 입력 받음
			int num = ois.readInt();
			
			//게시글을 클라이언트에게 전송
			int index = list.indexOf(new Post(num));
			Post post = null;
			
			if(index >= 0 ) {
				post = list.get(index);
				post.view();
				post = (Post)post.clone();
				list.set(index, post);		//이렇게 해야 조회할때 반영
			}
			oos.writeObject(post);
			oos.flush();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	//세이브로드 day014post에서 그대로 가져옮 -> 탬플릿 만들어둬서 그대로 가져와도됨
	private static Object load(String fileName) {

		try(FileInputStream fis = new FileInputStream(fileName);
			ObjectInputStream ois = new ObjectInputStream(fis)){
			return ois.readObject();
		} catch (Exception e) {
			System.out.println("-------------------");
			System.out.println("불러오기 실패");
			System.out.println("-------------------");
			e.printStackTrace();
		}
		return null;
	}

	
	private static void save(String fileName, Object obj) {
		try(FileOutputStream fos = new FileOutputStream(fileName);
			ObjectOutputStream oos = new ObjectOutputStream(fos)){
			oos.writeObject(obj);
		} catch (Exception e) {
			System.out.println("-----------------");
			System.out.println("저장하기 실패");
			System.out.println("-----------------");
			e.printStackTrace();
		}
	}


	
	
}
