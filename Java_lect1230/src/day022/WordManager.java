package day022;

import java.util.List;
import java.util.stream.Collectors;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class WordManager {

	private List<Word> list;


	boolean insert(Word word) {
		
		
		
		if(word == null || word.getWord() == null || word.getPartOfSpeech() == null || word.getMeaning() == null)return false;
		
		switch(word.getPartOfSpeech()) {
		case "명", "대", "동", "형", "부", "전", "접", "관": break;
		default : return false;
		}
		
		//단어 뜻 체크
		if(word.getWord().trim().isEmpty() || word.getMeaning().trim().isEmpty()) return false;  //trim은 앞뒤 공백 제거하는 코드.

		if(list.contains(word)) return false;	//완벽하게 동일한 단어가 있는 경우
		
		
		list.add(word);
		return true;
		
		
		
		
		
	}


	public List<Word> getWordList(String word) {

		
		return list.stream().filter(w->w.getWord().equals(word)).collect(Collectors.toList());	//스트림 이용하면 짦게 처리 가능
																								//필터에 해당하는애들 toList로 출력
	}


	public void print(List<Word> tmpList) {
		
		if( tmpList == null || tmpList.isEmpty()) {
			System.out.println("[일치하는 단어가 없습니다.]");
			return;
		}
		
		for(int i = 0; i < tmpList.size(); i++)System.out.println(i+1 + ", " + tmpList.get(i));
			
		
		
	}


	public boolean update(Word word, Word wordObj) {
		if(word == null || wordObj == null)return false;
		
		word.update (wordObj);
		return true;
	}


	public boolean delete(Word word) {
		return list.remove(word);
	}
	
	public void print() {
		System.out.println(list);
	}


	public void sort() {
		//abc순 정렬
		list.sort((o1,o2)->{
			//if(o1.getWord().equals(o2.getWord()))
			return o1.getWord().compareTo(o2.getWord());
			});
		
		
	}


	public void print(String word) {

		List<Word> tmpList = list.stream().filter(w->w.getWord().contains(word)).collect(Collectors.toList());
		if(tmpList.isEmpty()) {
			System.out.println("[일치하는 단어가 없습니다.]");
			return;
		}
		tmpList.stream().forEach(w->System.out.println(w));	//향상된 for문도 가능하지만 축약
		
	}
	
	
	
}
