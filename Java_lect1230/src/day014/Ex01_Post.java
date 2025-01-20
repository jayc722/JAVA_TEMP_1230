package day014;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Stream;

import lombok.AllArgsConstructor;
import lombok.Data;


public class Ex01_Post {

	static List<Post> list = new ArrayList<Post>();
	static Scanner scan = new Scanner(System.in);
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
		
		Post p1 = new Post("제목1", "내용1", "abc123");
		System.out.println(p1);

		p1.print();
		list.add(p1);
		
		int menu = 0;
		final int EXIT = 5;
		
		do {
			printMenu("게시글 등록", "게시글 수정", "게시글 삭제", "게시글 조회", "종료");
		try {
			menu = scan.nextInt();
			removeBuffer();
			runMenu(menu);
		}
		//잘못된 타입의 메뉴를 입력한 경우
		catch(InputMismatchException e) {
			System.out.println("올바른 입력이 아닙니다.");
			removeBuffer();
		}
		}while( menu != EXIT);
	
		
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
			//delContent();
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






	private static void modContent() {
		int index = searchContent();
		
		
	}






	private static int searchContent() {
		printBar();
		if(list.size() == 0) {
			System.out.println("등록된 할일이 없습니다");
			return -1;
		}
		System.out.print("검색할 게시글 번호를 입력 : ");
		int num1 = scan.nextInt();
		
		print(list, s->s.getPostNum() == num1);
		
		Post tmp = new Post(num1);
		return list.indexOf(tmp);
		
				
	}




	public static Post inputContent() {
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
		
		return new Post(title, name, content, true);
		
		
		
	}

	private static void insContent() {

		
		
		Post post = inputContent();
		
		list.add(new Post(post.getPostTitle(),post.getWriter(),post.getPostContent()));
		
		System.out.println(post.getPostNum()+ "번째 게시글 입니다.");
		
		
		list.add(post);
		
		
		
	}
	
	
	private static void print(List<Post> list, Predicate<Post> p) {		
		Stream<Post> stream = list.stream();
		stream.filter(p).forEach(s->System.out.println(s));
		
}
}

@Data
@AllArgsConstructor
class Post{
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
		System.out.println("----------------------");
		viewCount++;
	}
	
	
	private String getDateStr() {
		// Date -> String
		// yyyy-MM-dd HH:mm:ss
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		return format.format(this.date);
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