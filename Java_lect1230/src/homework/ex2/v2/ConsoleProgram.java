package homework.ex2.v2;

import java.util.List;

public interface ConsoleProgram {

	void printMenu();
	void runMenu(int menu);
	
	void load(String fileName, List<Object> list);
	
	void save(String fileName, List<Object> list);
	
}
