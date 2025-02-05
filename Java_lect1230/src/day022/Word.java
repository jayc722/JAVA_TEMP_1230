package day022;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Word implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private String word;
	private String partOfSpeech;
	private String meaning;
	
	
	
	@Override
	public String toString() {
		return word + " [" + partOfSpeech + "] " + meaning;
	}



	public void update(Word word) {

		this.word = word.word;
		this.partOfSpeech = word.partOfSpeech;
		this.meaning = word.meaning;
		
	}
	
	
	
}
