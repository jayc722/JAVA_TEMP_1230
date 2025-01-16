package day013;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;

public class Ex01_Transient {

	public static void main(String[] args) {
		/* transient
		 * 	-직렬화, 역직렬화 되는 과정에서 직렬화, 역직렬화 하고 싶지 않은 객체에 사용
		 *  (필드, 파일에 필요 없다고 생각하는 경우)
		 * 
		 */

		Point p = new Point(1, 2, 3);

		String fileName = "src/day013/point.txt";

		//인풋
		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))){ //한줄로도 가능

			p = (Point)ois.readObject();


		} catch (FileNotFoundException e) {
			System.out.println("파일을 찾을 수 없습니다.");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("IO 예외 발생");
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			System.out.println("클래스를 찾을 수 없습니다.");
			e.printStackTrace();
		}
		//인풋
		

		System.out.println(p);


		//아웃풋	
		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))){ 

			oos.writeObject(p);


		} catch (FileNotFoundException e) {
			System.out.println("파일을 찾을 수 없습니다.");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("IO 예외 발생");
			e.printStackTrace();
		} 
		//아웃풋

	}

}



@Data
@AllArgsConstructor
class Point implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 461744938472379459L;

	private int x, y;
	
	private transient int z;				//활용은 하지만 저장/불러오기에서는 제외하고 싶은 변수
	
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	
}