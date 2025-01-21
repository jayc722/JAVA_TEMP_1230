package day014;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Stream;

import lombok.AllArgsConstructor;
import lombok.Data;


public class Ex01_Post {

	static List<Post> list = new ArrayList<Post>();
	static Scanner scan = new Scanner(System.in); 	//static인 메소드(메인) 안에서 필드 사용하려면 static 붙이거나
													// Ex01_Post p = new Ex01_Post(); p.scan.next();
	public static void main(String[] args) {
		/* 게시글 프로그램을 위한 클래스 선언
		 * 게시글 등록
		 * -제목 내용 작성자 입력
		 * 게시글 수정
		 * -게시글 번호 선택
		 * -제목 내용 수정
		 * 게시글 삭제 
		 * -게시글 번호를 선택해서 삭제
		 * 게시글 조회
		 * -게시글 번호를 이용하여 조회하고 조회수 +1
		 * +@ 저장불러오기
		 */
		
		
		int menu = 0;
		final int EXIT = 5;
		
		String fileName = "src/day014/post.txt";
		
		list = (ArrayList<Post>)load(fileName);				//저장 불러오기 -> static 파일변수(num)가 저장이 안됨
		
		if(list == null || list.size() == 0) {				//게시글이 없으면 가져올 필요 없으니...
			list = new ArrayList<Post>();					//불러오기 시 nullpointexception 방지
		}
		else {					//   여기서 번호 초기화
			int lastIndex = list.size()-1;
			Post lastPost = list.get(lastIndex);
			int lastNum = lastPost.getPostNum();				//static변수에 대한 getter setter 는 자동으로 안 만들어짐 ->직접 만들어야
			Post.setPostCount(lastNum + 1);
			
		}
		
		do {
			printMenu("게시글 등록", "게시글 수정", "게시글 삭제", "게시글 조회", "종료");
		
			
			menu = scan.nextInt();
			removeBuffer();
			runMenu(menu);
		

		}while( menu != EXIT);
		
		save(fileName,list);
	
		
	}
	
	
	
	
	

	private static Object load(String fileName) {		//->리턴타입 오브젝트로(복붙하려고...)

		try(FileInputStream fis = new FileInputStream(fileName);
			ObjectInputStream ois = new ObjectInputStream(fis)){
		
			
			return ois.readObject();	//try문 코드가 return으로
			
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





	private static void removeBuffer() {
		scan.nextLine();
	}


	public static void printMenu(String ... menus ) {
		printBar();
		//메뉴가 없는 경우
		if(menus.length == 0) {
			System.out.println("메뉴 없음");
			return;
		}
		//메뉴들을 숫자를 붙여서 출력
		for(int i = 0; i < menus.length; i++) {
			String menu = menus[i];
			if(i<9)System.out.println(i+1 + ".  " + menu);
			if(i>8)System.out.println(i+1 + ". " + menu);
		}
		printBar();
		System.out.print("메뉴 선택 : ");
	}
	
	public static void printBar(char bar, int count) {
		for(int i = 1; i <= count; i++) {
			System.out.print(bar);
		}
		System.out.println();
	}
	public static void printBar() {
		for(int i = 1; i <= 15; i++) {
			System.out.print("-");
		}
		System.out.println();
	}

	private static void runMenu(int menu) {
		switch(menu) {
		case 5 : 
			System.out.println("종료합니다.");
			break;
		case 1 :
			System.out.println("게시글 등록");
			insContent();
			break;
		case 2 :
			System.out.println("게시글 수정");
			modContent();
			break;
		case 3 :
			System.out.println("게시글 삭제");
			delContent();
			break;
		case 4 : 
			System.out.println("게시글 조회");
			searchContent();
			break;
		default :
			System.out.println("잘못된 입력입니다.");	
		}
		return;
	}






	private static void delContent() {
		// 번호를 입력
		//있으면 삭제
		System.out.println("번호 : ");
		int num = scan.nextInt();
		int index = list.indexOf(new Post(num));
		
		/*
		if(index < 0) {
			System.out.println("등록되지 않았거나 삭제된 게시글입니다.");
			return;
		}
		
		list.remove(index);
		System.out.println("게시글을 삭제 했습니다.");
		
		*/
		if(list.remove(new Post(num))) {
			System.out.println("게시글을 삭제 했습니다.");
			return;
		}
		System.out.println("등록되지 않았거나 삭제된 게시글입니다.");
		
		
	}






	private static void modContent() {
		//번호 입력
		System.out.println("번호 : ");
		//번호와 일치하는 게시글 있는지 확인해서 없으면 알림 후 종료
		//indexOf는 Object's'.equals(o1,o2)호출 -> o1과 o2 다른 클래스이면 무조건false ->클래스를 맞춰줘야함 integer에서 post로 
		//클래스에서 equals 가 클래스 달라도 되게 오버라이딩해도 equals 호출이라 의미가 x
		int num = scan.nextInt();
		//int index = list.indexOf(num);
		int index = list.indexOf(new Post(num));
		
		if(index < 0) {
			System.out.println("등록되지 않았거나 삭제된 게시글입니다.");
			return;
		}
		
		//제목 내용 입력
		removeBuffer();
		System.out.println("제목 : " + list.get(index).getPostTitle());
		System.out.print("제목 : ");
		String title = scan.nextLine();
		printBar();
		System.out.println("작성자 이름 : " + list.get(index).getWriter());
		System.out.print("작성자 이름 : ");
		String name = scan.nextLine();
		printBar();
		System.out.println("내용 : " + list.get(index).getPostContent());
		System.out.print("내용 : ");
		String content = scan.nextLine();
		//목록에서 일치하는 게시글 가져옴
		Post post = list.get(index);
		//가져온 게시글의 제목과 내용을 수정
		post.setPostTitle(title);
		post.setPostContent(content);
		post.setWriter(name);
		
	}






	private static void searchContent() {
		//게시글 번호 입력
		
		//해당 게시글 있으면 출력, 없으면 안내문구
		
		System.out.println("번호 : ");
		int num = scan.nextInt();
		int index = list.indexOf(new Post(num));
		
		if(index < 0) {
			System.out.println("등록되지 않았거나 삭제된 게시글입니다.");
			return;
		}
		
		//해당 게시글이 있으면 조회수 증가 후 출력
		Post post = list.get(index);
		post.view();    //post.setView(post.getViewCount()+1); //라고 해도 되긴 함
		post.print();
		
				
	}






	private static void insContent() {
		
		System.out.println("게시글 입력(엔터까지 입력)");
		printBar();
		System.out.print("제목 : ");
		String title = scan.nextLine();
		printBar();
		System.out.print("작성자 이름 : ");
		String name = scan.nextLine();
		printBar();
		System.out.print("내용 : ");
		String content = scan.nextLine();
		
		//제목 내용 작성자 입력
		Post post = new Post(title, content, name);
		
		//입력받은 내용으로 객체 생성
		
		//목록에 추가	->중복체크 x
		list.add(post);
		
		post.print();
		
		
		
	}
	
	
	private static void print(List<Post> list, Predicate<Post> p) {		
		Stream<Post> stream = list.stream();
		stream.filter(p).forEach(s->System.out.println(s));
		
}
}

@Data
@AllArgsConstructor
class Post implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4972797693257637077L;
	private static int postCount;				// 정적으로 설정해 놔야 클래스 전체에서 메소드로 바꿀수있음
	private int postNum;
	private String postTitle;
	private String postContent;
	private String writer;
	private int viewCount;
	private Date date;
	/*private User user;
	private Comment comment;
	*/
	
	@Override
	public boolean equals(Object obj) {			//언제나 게시글 번호로 찾기때문에 num으로만 입력
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Post other = (Post) obj;
		return postNum == other.postNum;
	}
	
	public void view() {viewCount++;}
	@Override
	public int hashCode() {						//해시알고리즘 안쓰면 필요x
		return Objects.hash(postNum);
	}
	public Post(String postTitle, String postContent, String writer) {			//제목 내용 작성자만 받아서 생성
		this.postTitle = postTitle;
		this.postContent = postContent;
		this.writer = writer;
		date = new Date();
		++postCount;										//static 안하면 생성할때마다 1로 초기화
		postNum = postCount;								//이렇게 안하면 모든 게시글번호가 같아짐  -> num = ++count로 간략화
	}
	
	public Post(String postTitle, String postContent, String writer, boolean a) {			//제목 내용 작성자만 받아서 생성
		
		this.postTitle = postTitle;
		this.postContent = postContent;
		this.writer = writer;
		date = new Date();
		
	}
	public Post(int postNum) {			//검색용
		this.postNum = postNum;
	}
	public void print() {
		System.out.println("번호 : " + postNum);
		System.out.println("제목 : " + postTitle);
		System.out.println("내용 : " + postContent);
		System.out.println("작성자 : " + writer);
		System.out.println("작성일 : " + getDateStr());
		System.out.println("조회수 : " + viewCount);
		System.out.println("---------------");
		//viewCount++;
	}
	
	
	private String getDateStr() {
		// Date -> String
		// yyyy-MM-dd HH:mm:ss
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		return format.format(this.date);
		
		

	}

	public static int getPostCount() {
		return postCount;
	}

	public static void setPostCount(int postCount) {
		Post.postCount = postCount;
	}
	
}

class User{
	String id;
	String passWord;
}

class Comment{
	 User user;
	 String text;
}