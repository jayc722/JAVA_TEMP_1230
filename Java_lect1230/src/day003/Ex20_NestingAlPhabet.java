package day003;

public class Ex20_NestingAlPhabet {

	public static void main(String[] args) {
		
		
		int num = 0;
		char alp = 0;
		
		do {
			num++;
			alp = 'a';
			for(int i = 0; i < num; i++) {
				alp = (char) ('a' + i);
				System.out.print(alp);		
			}
			System.out.println();
		}while(alp != 'z');
		
			
		//////////////////////////////////////////
		
		char ch, lastCh = 'a';	
		
		for(lastCh = 'a'; lastCh <= 'z'; lastCh++) {
			for(ch = 'a'; ch <= lastCh; ch++) {
				System.out.print(ch);
			}
			System.out.println();
		}
		
	}

}
