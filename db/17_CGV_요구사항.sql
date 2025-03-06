/*
영화 예매 사이트(CGV)
조회(무비 차트)
	- 사용자는 등록된 현재 상영 중이거나 상영 예정인 영화를 조회.
	- 영화는 예매 내역이 많은 순으로 조회. 
조회(상영 시간) - 예매하기 전 단계 
	- 사용자는 영화, 극장, 날짜를 선택해서 상영 시간을 확인. 
    - 사용자는 현재 상영중이거나 상영 예정은 영화를 선택. 
    - 사용자는 현재 운영중인 극장 선택. 
    - 사용자는 상영시간이 등록된 날짜 선택. 
    - 사용자는 영화, 극장, 날짜를 선택하여 상영 시간, 관, 전체 좌석수/예매 가능 좌석 수를 확인.
조회(영화 상세 조회)
	- 사용자는 영화를 선택하여 상세 조회를 한다.
    - 상세 정보는 감독, 배우, 장르, 기본정보, 개봉일, 영화 설명, 트레일러, 스틸컷이 있다. 
    - 감독은 영화를 연출한 감독으로 등록된 감독 모두를 조회.
    - 배우는 영화에 참여한 배우로,영화에 등록할때 참여한 배우를 등록된 순으로 조회.
    - 장르는 영화 장르로, 등록된 장르 모두를 조회.
    - 기본 정보는 관람 나이, 런닝시간(분), 제작 국가 조회.
    - 여러 나라에서 제작한 경우 제작 국가가 여러 나라가 된다. 
검색 
	- 사용자는 검색어를 입력하여 검색. 
    - 검색어를 포함하는 영화와 인물을 조회.
    - 영화는 개봉일 순으로 조회. 
    - 인물은 이름 순으로 조회.
예매
	- 예매는 회원만 가능. 
    - 예매를 위해서 상영시간을 선택하면 인원을 선택 후, 인원 수에 맞게 좌석을 선택하여 예매. 
    - 인원은 성인과 청소년으로 나누어 선택. 
	- 좌석은 예매되지 않은 좌석들을 선택.  
    - 예매 시 할인은 고려X 
    - 12시 이전 상영되는 영화는 조조 할인 금액으로 예매  
영화 관리 
	- 관리자는 상영 예정/상영된 영화를 등록. 
    - 영화 정보는 영화에 참여한 감독, 배우, 장르, 제목, 기본 정보, 개봉일, 내용, 스틸컷, 트레일러, 영화 상세 정보를 입력하여 등록. 
    - 감독/배우는 등록된 감독/배우 중에서 선택하여 입력하고, 여려명 입력이 가능.
    - 장르는 등록된 장르를 선택, 여러 장르 선택 가능.
    - 기본 정보에서 연령은 등록된 연령 중 하나를 선택. 
    - 기본 정보에서 런닝 시간은 분 단위 정수로 입력. 
    - 기본 정보에서 제작 국가는 등록된 국가 중 선택하며 여러 국가 선택 가능. 
    - 트레일러는 영상이며 여러 트레일러 등록 가능.
    - 스틸컷은 이미지이며 여러 스틸컷 등록 가능. 
감독/배우 관리
	- 관리자는 감독/배우를 등록, 수정, 삭제 
    - 감독/배우는 등록된 인물과 역할, 대표 사진을 선택하여 등록. 
    - 한 영화인이 감독과 배우를 겸하면 각각 등록. 
인물 관리 
	- 관리자는 인물을 등록, 수정, 삭제.
    - 인물은 영화인의 정보로, 이름, 생년월일, 내용, 국가를 입력. 
    - 국가는 대표국가 하나만 선택. 
극장 관리 
	- 관리자는 극장을 등록, 수정, 삭제. 
    - 극장은 지역, 이름, 상영관 정보, 주소, 총 관수 지정. 
    - 지역은 등록된 지역 중 하나를 선택. 
	- 상영관 정보는 극장 등록과 함께 등록하거나 극장 등록 후 나주에 등록. 
상영관 관리 
	- 관리자는 상영관을 등록, 수정, 삭제. 
    - 극장을 선택하고 상영관 번호, 총 좌석수, 좌석 정보를 입력하여 동록. 
    - 상영관 번호는 해당 극장의 총 상영관 수보다 작거나 같아야 함. 
    - 좌석 정보는 행은 영어 대문자로, 열은 숫자로 표현. 해당 상영관의 모든 좌석수를 등록. -- 좌석 배치 모양 등은 고려 X 
    - 등록된 좌석 정보에 맞게 총 좌석수를 저장. 
    - 좌석은 상황에 따라 예매가 불가능한 경우가 있음.
상영시간 관리 
	- 관리자는 상영시간을 등록, 수정, 삭제. 
    - 상영시간은 상영관 정보, 영화, 날짜, 상영시간을 입력하여 등록. 
    - 상영관 정보는 극장 선택 시 상영관이 조회되어, 조회된 상영관 중 하나를 선택. 
    - 영화는 등록된 영화 중에서 하나를 선택. 
    - 상영시간(시작시간)은 10분 단위로 등록. 
요금 관리 
	- 관리자는 요금을 수정. 
    - 요금은 성인, 청소년, 조조할인으로 구분. 
    - 청소년은 성인요금의 80%. 
    
	

*/