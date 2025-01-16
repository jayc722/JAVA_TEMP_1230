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

public class My_1 {

	public static void main(String[] args) {
		/* ObjectStream은 보조 스트림
		 * => 기반 스트림이 필요
		 * */
		String fileName = "src/day12/object_stream.txt";
		
		try(FileOutputStream fos = new FileOutputStream(fileName);
			ObjectOutputStream oos = new ObjectOutputStream(fos)){
			Point p = new Point(1,1);
			oos.writeObject(p);
		} catch (FileNotFoundException e) {
			System.out.println("파일을 찾을 수 없습니다.");
		} catch (IOException e) {
			System.out.println("IO 예외 발생");
			e.printStackTrace();
		}

		try( FileInputStream fis = new FileInputStream(fileName);
			ObjectInputStream ois = new ObjectInputStream(fis)){
			Point p = (Point)ois.readObject();
			System.out.println(p);
		} catch (FileNotFoundException e) {
			System.out.println("파일을 찾을 수 없습니다.");
		} catch (IOException e) {
			System.out.println("IO 예외 발생");
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			System.out.println("클래스를 찾을 수 없습니다.");
		}
	}

}

