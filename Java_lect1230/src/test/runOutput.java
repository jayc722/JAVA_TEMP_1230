package test;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class runOutput {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
	}

	public void output() {
		FileWriter fw = null;
		
		try {
			fw = new FileWriter("test1.txt", true);
			fw.write(97);
			fw.write(65);
			
			
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
	}
}
