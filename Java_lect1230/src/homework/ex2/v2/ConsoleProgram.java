package homework.ex2.v2;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public interface ConsoleProgram {

	void run();
	
	void printMenu();
	
	void runMenu(int menu);
	
	default Object load(String fileName) {		//object 디폴트 메소드로 사용 -> 디폴트 메소드는default 지정해줘야
		
		try(FileInputStream fis = new FileInputStream(fileName);
			ObjectInputStream ois = new ObjectInputStream(fis)){
		
			
			return ois.readObject();	//try문 코드가 return으로
			
		} catch (Exception e) {
			System.out.println("-------------------");
			System.out.println("불러오기 실패");
			System.out.println("-------------------");
			e.printStackTrace();
		}
		
		return null;
		
	}
		
		
	default void save(String fileName, Object obj) {
		try(FileOutputStream fos = new FileOutputStream(fileName);
			ObjectOutputStream oos = new ObjectOutputStream(fos)){
			
			oos.writeObject(obj);
			
		} catch (Exception e) {
			System.out.println("-----------------");
			System.out.println("저장하기 실패");
			System.out.println("-----------------");
			e.printStackTrace();
		}
	}
	
}
