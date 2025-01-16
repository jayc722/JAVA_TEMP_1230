package day012;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;

public class Ex08_ObjectStream {

	public static void main(String[] args) {

		//ObjectStream은 보조 스트림
		// 	->기반 스트림 필요

		String fileName = "src/day012/object_stream.txt";

		try(FileOutputStream fos = new FileOutputStream(fileName);
				ObjectOutputStream oos = new ObjectOutputStream(fos)){
			Point p = new Point(1,1);
			oos.writeObject(p);


		} catch (FileNotFoundException e) {
			System.out.println("파일을 찾을 수 없습니다.");
		} catch (IOException e) {
			System.out.println("IO 예외 발생");

		}
		try(FileInputStream fis = new FileInputStream(fileName);
				ObjectInputStream ois = new ObjectInputStream(fis)){
			Point p = (Point)ois.readObject();				//클래스 형변환 필요 -> 클래스 형변환 예외 설정
			System.out.println(p);
		} catch (FileNotFoundException e) {
			System.out.println("파일을 찾을 수 없습니다.");
		} catch (IOException e) {
			System.out.println("IO 예외 발생");
		} catch (ClassNotFoundException e) {
			System.out.println("클래스를 찾을 수 없습니다.");
		}


	}

}

@Data
@AllArgsConstructor 
class Point implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -196972164490478060L;	// 클래스 상수(저장된 값 읽어올때 사용)
																		// 클래스 이름이 같더라도 serialversionUID값이 다르면
																		// 파일에서 읽어와서 저장하지 못함
	private int x, y;
	
	@Override
	public String toString() {
		return "(" + x + " , " + y + ")";
	}
	
	
	
}