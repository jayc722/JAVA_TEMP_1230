package day012;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Ex04_ByteStreamInput {

	public static void main(String[] args) {

		
		
			//경로에는 상대경로, 절대경로
			//inputstream은 해당 폴더에 파일이 없으면 filenotfoundexception 발생
		
		//바이트기반 스트림 -> 한글 표현은 어려움
		FileInputStream fis = null;
		try {
			fis = new FileInputStream("src/day012/byte_stream.txt");
			
			/*int data = fis.read();				//read() -1이면 파일의 끝
			System.out.println((char)data);
			data= fis.read();*/
			
			
			int data;
			do {
				data = fis.read();
				if(data!= -1)System.out.print((char)data);
			}while(data!=-1);
			
			
		} catch (FileNotFoundException e) {
			System.out.println("파일을 찾을 수 없습니다.");
			
			
		} catch (IOException e) {
			System.out.println("읽기에 실패했습니다.");
		} finally {
			if(fis != null) {
				try {
					fis.close();
				} catch (IOException e) {
					System.out.println("IO예외 발생");
				}
			}
		}
		
	}

}
