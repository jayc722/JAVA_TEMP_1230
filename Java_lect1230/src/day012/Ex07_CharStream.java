package day012;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Ex07_CharStream {

	public static void main(String[] args) {
		
		
		//문자 단위 데이터
		//char_stream.txt에는 "가나다123"이 있음
		
		
		String fileName = "src/day012/char_stream.txt";
		try(FileReader fr = new FileReader(fileName)){
			while(fr.ready()) {
				char ch = (char)fr.read();
				System.out.print(ch);
			}
			
		} catch (FileNotFoundException e) {
		System.out.println("파일을 찾을 수 없습니다.");
		} catch (IOException e) {
			System.out.println("IO 예외 발생");
		}
		
		System.out.println();
		System.out.println("----------------------");
		
		try(FileWriter fw = new FileWriter(fileName)){
			String str = "가나다123";
			fw.write(str);
			fw.flush(); 	//충분히 안 차면 버퍼에 채우기만 함 -> 빨리 전송하게 ->이거 추가 안하면 서버 전송 안되는경우가
			System.out.println(str + " 을 파일에 기록했습니다.");
		} catch (IOException e) {
			System.out.println("IO 예외 발생");
		}

	}

}
