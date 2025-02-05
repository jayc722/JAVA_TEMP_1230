package day023;

import java.io.FileReader;
import java.io.FileWriter;

public class EX16_IOStream {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		
		String fileName =  "src/day023/ex16.txt";
		
		//filewriter(파일명) : 기존 파일을 지우고 새로 만듦
		//filewriter(파일명, boolean) : true 이면 이어쓰기 false 이면 덮어쓰기
		
		try(FileWriter fw = new FileWriter(fileName)){
			fw.write("안녕하세요\n");
			fw.write("제 이름은 홍길동 입니다.\n");
			fw.flush();
			
			
		}catch (Exception e) {
			// TODO: handle exception
		}
		
		try(FileReader fr = new FileReader(fileName)){
			while(fr.ready()) {
				char ch = (char)fr.read();
				System.out.print(ch);
			}
			
		}catch (Exception e) {
			// TODO: handle exception
		}

	}

}
