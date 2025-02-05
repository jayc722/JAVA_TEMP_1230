package day022;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MyWordManager {

	private Map<String, List<Word>> myWords;
	
	
	
	
	public MyWordManager(Map<String, List<Word>> myWords) {
		this.myWords = myWords;
	
	}




	public void add(String id, Word word) {
		// TODO Auto-generated method stub
		
		List<Word> list = myWords.get(id);
		
		if(list == null) {	//검색기록이 x ->단어 검색어를 처음 등록할 때
			list = new ArrayList<Word>();
			list.add(word);
			myWords.put(id, list);
			return;
		}
		
		//검색어가 이미 있는 경우
//		if(list.contains(word)) {
			list.remove(word);		//어차피 없는애면 false로 나옴 ->혹시 기존에 일치하는 애가 있으면 삭제
			list.add(word);
//		}
		
		
		
	}

	public void print(String id) {
		List<Word> list = myWords.get(id);
		//단어 겁색어가 없는 경우
		if(list == null) {
			System.out.println("[검색 기록이 없습니다.]");
			return;
		}
		list.stream().forEach(w->System.out.println(w));
		
	}
	
	
}
