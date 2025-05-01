package kr.kh.spring.pagination;

import lombok.Data;

@Data
public class PageMaker {
	private int totalCount; //전체 컨텐츠 개수 => 마지막 페이지네이션의 마지막 페이지(번호)를 계산하기 위해		// 생성자에
	private int startPage;//페이지네이션 시작 페이지번호
	private int endPage;//페이지네이션 마지막 페이지번호
	private boolean prev;//이전버튼 활성화
	private boolean next;//다음버튼 활성화
	private int displayPageNum;//한 페이지네이션에서 보여준 페이지의 최대 숫자 개수							// 생성자에
	private Criteria cri;//현재페이지 정보															// 생성자에
	
	//totalCount, diplayPageNum, perPageNum(cri)를 이용 -> endPage, startPage, prev, next(이전버튼 활성화 여부, 다음버튼 활성화 여부, 마지막 페이지 번호)를 계산
	//예시 : 전체 게시글이 : 131개, 한페이지에 게시글이 10, 14페이지
	public void calculate() {
		
		//현재 페이지에 대한 최대 페이지번호
		//현재 페이지 : 4, 한페이지에 컨텐츠 개수가 10, 한 페이지네이션의 페이지 개수 : 10 //endPage = (int)(Math.ceilt(0.4) * 10);
		endPage = (int)(Math.ceil(cri.getPage()/(double)displayPageNum)*displayPageNum);
		//컨텐츠 수와 상관없이 현재 페이지의 마지막 페이지를 계산
		
		startPage = endPage - displayPageNum + 1;
		//최대 마지막 페이지를 이용하여 시작 페이지를 계산 //컨텐츠 개수를 이용하여 계산한 최대 페이지 번호 : 14
		
		int tmpEndPage = (int)(Math.ceil(totalCount/(double)cri.getPerPageNum())); // 전체컨텐츠수/한페이지컨텐츠수 해서 올림
		//컨텐츠 개수를 이용하여 계산한 모든 페이지의 최대 페이지 수
		
		//최대 페이지가 현재 페이지에서 가능한 최대 페이지보다 작으면 현재 페이지에서 가능한 최대 페이지를 수정 (endPage와 tmpEndPage 중 작은 값을 endPage로 설정)
		//마지막 페이지네이션, 컨텐츠수가 마지막 페이지까지 못 가는 경우
		if(endPage > tmpEndPage) {
			endPage = tmpEndPage;
		}
		
		prev = startPage == 1 ? false : true;//첫번째 페이지네이션이면 false 아니면 true

		next = endPage == tmpEndPage ? false : true;//마지막 페이지네이션이면 false 아니면 true(구현하는 방식에 따라 다름...다음 버튼 눌렀는데 1칸씩 이동할지 10개씩 이동할지)
	}
	public PageMaker(int displayPageNum, Criteria cri, int totalCount) {
		this.displayPageNum = displayPageNum;
		this.cri = cri;
		this.totalCount = totalCount;
		calculate();
	}
}