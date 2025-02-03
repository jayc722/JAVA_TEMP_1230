package selfstudy.day021.Ex02;

import java.util.Date;

import lombok.Data;

@Data
public class Word {

	private String wordName, wordClass, wordMean;
	
	private Date date;
	
	
	
	public void print() {
		
		System.out.println(wordName);
		System.out.println("품사 : " + wordClass);
		System.out.println("의미 : " + wordMean);
		
	}

	public void printShort(int i) {
		
		
		String shortMean;
		if(wordMean.length()>7)shortMean = wordMean.substring(0, 5) +"...";
		else shortMean = wordMean;
		
		System.out.println((i+1) + ". " + wordName + " : " + wordClass + ", " + shortMean);
	}


	public Word(String wordName,String wordClass,String wordMean) {
		super();
		this.wordName = wordName;
		this.wordClass = wordClass;
		this.wordMean = wordMean;
		this.date = new Date();
	}
	
	
	
	
}
