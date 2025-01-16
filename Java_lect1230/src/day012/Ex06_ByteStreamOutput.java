package day012;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Ex06_ByteStreamOutput {

	public static void main(String[] args) {

		
		//outputstream은 파일이 없어도 폴더만 있으면 파일을 생성해서 작업
		
		try(FileOutputStream fos = new FileOutputStream("src/day012/byte_stream2.txt")){
			for(char ch = 'a'; ch <= 'z'; ch++) {
				fos.write(ch);
			}
			
		} catch (FileNotFoundException e) {
			System.out.println("찾을 수 없습니다.");
		} catch (IOException e) {
			System.out.println("IO 예외 발생");
		}
		
		
	}

}
