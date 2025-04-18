package kr.kh.spring2.pagination;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Criteria {
	
	protected int page = 1;//현재 페이지 : 기본값 - 1
	protected int perPageNum = 3;//한 페이지에서 컨텐츠 개수 : 기본값 - 3
	
	protected String search = ""; //검색어 : 기본값 - 빈문자열=> 전체 검색
	protected String type = "0"; //검색 타입
								//기본값 0으로 수정(전체검색을 0으로 하기 위해)
	
	public Criteria(int page, int perPageNum) {
		this.page = page;
		this.perPageNum = perPageNum;
	}
	public int getPageStart() {					//게터처럼 사용하려고 일부러 pageStart의 게터인 getPageStart로 이름 맞춤
		return (page - 1) * perPageNum;
	}
}