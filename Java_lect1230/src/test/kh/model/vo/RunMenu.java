package test.kh.model.vo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class RunMenu {

	public static void main(String[] args) {
		// TODO Auto-generated method stub


		String fileName = "src/test/kh/model/vo/test.txt";
		Food food = new Food("사과", 20);
		fileSave(fileName);
		
	}

	public static void fileSave(String fileName) {
		File file = new File(fileName);	//file 객체 생성
		
		try {
			FileOutputStream fos = new FileOutputStream(file);
				//파일 출력 스트림
			ObjectOutputStream oos = new ObjectOutputStream(fos);
				//객체 출력 스트림
			
			Food obj = new Food("사과", 20);
			
			oos.writeObject(obj);
				//객체 정보 기록
			oos.flush();
			
			oos.close();
			fos.close();
				//스트림 닫음
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		


	}

}
