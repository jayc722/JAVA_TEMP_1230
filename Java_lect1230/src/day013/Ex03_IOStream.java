package day013;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

public class Ex03_IOStream {

	public static void main(String[] args) {

		
		
		List<String> list = new ArrayList<String>();
		
		//불러오기
		//try(FileReader fr = new FileReader("src/day013/string.txt")){
		try(FileReader fr = new FileReader("src/day013/string.txt");
				BufferedReader br = new BufferedReader(fr)){				//한줄씩 읽어오기
			String line;
			while( (line = br.readLine()) != null )System.out.println(line);
			
			
		}catch (FileNotFoundException e) {
			System.out.println("파일을 찾을 수 없습니다.");
		} catch (IOException e) {
			System.out.println("IO 예외 발생");
		} 
		
		
		
		//저장하기
		//filewriter에서 이이쓰기 하려면 생성자에 파일명과 true를 순서대로 넣어주면 됨
		try(FileWriter fw = new FileWriter("src/day013/string.txt",true)) { //간략화 //콤마 트루 하면 이어쓰기(없으면 덮어쓰기)
			fw.write("안녕하세요.\n");
			fw.write("제이름은 홍길동입니다.\n");
				
				
			
		} catch (FileNotFoundException e) {
			System.out.println("파일을 찾을 수 없습니다.");
		} catch (IOException e) {
			System.out.println("IO 예외 발생");
		} 
		
		
		list.add("안녕");
		list.add("이름");
		
		
		
	}

}
