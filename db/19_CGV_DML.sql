USE CGV;
# CGV 사이트를 참고하여 미키17영화를 등록할 때 필요한 쿼리를 작성

# 1. 관람등급, 장르, 국가, 지역, 요금 추가

INSERT INTO MOVIE_RATINGS VALUES ("12세 이상 관람가"),("15세 이상 관람가"),("청소년 관람 불가"),("전체관람가"),("제한 상영가");
INSERT INTO GENRE VALUES ("어드벤처"),("SF"),("드라마"),("액션"),("애니메이션"),("코미디"),("공포"),("로맨스"),("판타지"),("스릴러"),("범죄"),("전쟁"); 
INSERT INTO COUNTRY VALUES ("한국"),("미국"),("영국"),("오스트레일리아"),("일본");
INSERT INTO REGION VALUES ("서울"),("경기"),("인천"),("강원"),("대전/충청"),("대구"),("부산/울산"),("경상"),("광주/전라/제주");
-- 요금 : 성인15000 청소년 12000 조조 11000
INSERT INTO FEE(FE_TYPE, FE_PRICE, FE_DATE) VALUES 
("성인", 15000, "2025-03-01"),
("청소년", 12000, "2025-03-01"),
("조조", 11000, "2025-03-01");


# 2. 미키 영화정보를 추가. 제목/상영시간/개봉일/내용/상태/관람등급
INSERT INTO MOVIE(MV_TITLE, MV_TIME, MV_DATE, MV_CONTENT, MV_STATE, MV_MR_AGE)
VALUES
("미키17","140","2025-02-28","당신은 몇 번째 미키입니까?","상영중","15세 이상 관람가")
;

# 3. 인물 추가 : 봉준호, 로버트 패틴슨, 나오미 애키, 스티븐 연, 토니 콜렛, 마크 러팔로 
INSERT INTO PERSON(PR_NAME, PR_BIRTH, PR_DETAIL, PR_CT_NAME) VALUES ("봉준호", "1969-09-14", "", "한국"),
("로버트 패틴슨", "1986-05-13", "국내에서는 [해리포터와 불의잔]에서 캐드릭 디고리 역을 맡아 가장 눈에 띄는 연기를 보였던 ‘로버트 패틴슨’은 1986년 생 영국 출신 배우이다.
못하는 스포츠가 없을 정도로 만능 스포츠맨인 그는 풋볼, 스키, 스노우보드 등 각종 스포츠 경기에 참가하여 취미 활동이라고는 생각할 수 없을 정도로 완벽한 실력을 선보여 주변인을 깜짝 놀라게 했다.
[트와일라잇]의 절대매력 뱀파이어 ‘에드워드’ 역으로 전세계 소녀 팬들의 사랑을 한 몸에 받은 그는19살때 [해리포터와 불의 잔]의 출연으로 영화 관계자들의 관심을 끌었다. 또한 음악적으로도 남다른 재능을 갖고 있어, 기타와 키보드 연주를 통해 음악에 대한 열정을 드러냈으며 영화 [트와일라잇]의 O.S.T.에도 참여하여 큰 이슈가 되기도 하였다. [트와일라잇] 단 한편으로 전세계 하이틴 스타로 군림한 그는 최근에는 연극 무대에 참여하는 등 다양한 방면으로 자신의 경력을 쌓고 있는 욕심 많은 연기자이다.

", "영국"),
("나오미 애키", "1922-11-02", "", NULL),
("스티븐 연", "1983-12-21", "", "미국"),
("토니 콜렛", "1972-11-01", "", "오스트레일리아"),
("마크 러팔로", "1967-11-22","1968년 위스콘신 출생.
제2의 말론 브란도로 불리 우며, 브로드웨이를 사로잡은 마크 러팔로는 영화와, TV, 연극무대에서 활동하며 다방면의 재능을 보이고 있다. 어눌해 보이는 듯한 말투나, 삶을 체념한 듯한 행동의 이면에 악마적인 카리스마와 음울한 고독의 그림자를 드리우는 그는 <유 캔 카운트 온 미>를 통해 비뚫어진 삶, 고독한 방랑 인생의 이면에 존재하는 따뜻한 열정과 온기를 보여주며, 방랑자의 영혼을 읊조리는 듯한 음유시인의 모습으로 관객들을 사로잡고, 몬트리올 영화제 남우주연상을 수상의 영광을 안았다.

","미국"); 


# 영화인 등록	- > 원래는 GENERATOR USE PROPER~로 등록할수있는데 여기선 그냥 외래키 직접 입력해서 입력
INSERT INTO ACTOR(AT_POSITION, AT_PR_NUM) VALUES ("감독", 1),("배우", 2),("배우", 3),("배우", 4), ("배우", 5), ("배우", 6); 

# 영화 참여 등록 
INSERT INTO MOVIE_ACTOR(MA_ROLE, MA_MV_NUM, MA_AT_NUM) VALUES 
("감독", 1, 1),("미키반스", 1, 2),("나샤배릿지", 1, 3),("티모", 1, 4),("일파 마샬", 1, 5),("케네스 마샬", 1, 6); 

# 영화 장르 등록
INSERT INTO MOVIE_GENRE(MG_MV_NUM, MG_GR_NAME) VALUES (1,"어드벤처"),(1,"SF"),(1,"드라마"); 

# 제작 국가 등록 
INSERT INTO MOVIE_COUNTRY(MC_CT_NAME, MC_MV_NUM) VALUES ("미국", 1); 

# 트레일러와 스틸컷 등록
INSERT INTO FILE(FI_NAME, FI_TYPE, FI_MV_NUM) VALUES
("미키17_1.JPG", "S", 1),
("미키17_2.JPG", "S", 1),
("미키17_3.JPG", "S", 1),
("미키17_1.MP4", "T", 1),
("미키17_1.MP4", "T", 1),
("미키17_3.MP4", "T", 1); 


# 미키17 강남 3/11 상영시간을 등록할 때 필요한 쿼리들을 작성 
# 4관 13:50, 19:10 
# 1관 16:20 
# 3관 09:00, 11:50 
# 5관 10:00 

# 극장
INSERT INTO THEATER(TT_NAME, TT_ADDR, TT_COUNT, TT_RG_NAME) VALUES
-- ("CGV강남", "서울특별시 강남구 역삼동 814-6 스타플렉스", 6, "서울"),
("CGV강남", "서울특별시 강남구 역삼동 814-6 스타플렉스", 5, "서울"),
("CGV강릉", "강원특별자치도 강릉시 옥천동 189 씨네몰 6~8층 CGV강릉", 8, "강원");


# 상영관 
INSERT INTO SCREEN(SC_NAME, SC_SEAT, SC_TT_NUM) VALUES -- SC_POS는 DEFAULT Y라 굳이 안쳐도
-- ("1관", 144, 1),("2관", 123, 1),("3관", 172, 1),("4관", 123, 1),("5관", 172, 1),("6관", 123, 1); -- 하나하나 넣어볼꺼라 좌석수 일부러 좀 작게 넣음
("1관", 12, 1),("2관", 10, 1),("3관", 15, 1),("4관", 16, 1),("5관", 20, 1);

# 상영관 좌석 등록
INSERT INTO SEAT(SE_NAME, SE_SC_NUM) VALUES
("A1", 1),("A2", 1),("A3", 1),("A4", 1),
("B1", 1),("B2", 1),("B3", 1),("B4", 1),
("C1", 1),("C2", 1),("C3", 1),("C4", 1),

("A1", 2),("A2", 2),("A3", 2),("A4", 2),("A5", 2),
("B1", 2),("B2", 2),("B3", 2),("B4", 2),("B5", 2),

("A1", 3),("A2", 3),("A3", 3),
("B1", 3),("B2", 3),("B3", 3),
("C1", 3),("C2", 3),("C3", 3),
("D1", 3),("D2", 3),("D3", 3),
("E1", 3),("E2", 3),("E3", 3),

("A1", 4),("A2", 4),("A3", 4),("A4", 4),
("B1", 4),("B2", 4),("B3", 4),("B4", 4),
("C1", 4),("C2", 4),("C3", 4),("C4", 4), 
("D1", 4),("D2", 4),("D3", 4),("D4", 4),

("A1", 5),("A2", 5),("A3", 5),("A4", 5),("A5", 5), 
("B1", 5),("B2", 5),("B3", 5),("B4", 5),("B5", 5),
("C1", 5),("C2", 5),("C3", 5),("C4", 5),("C5", 5),
("D1", 5),("D2", 5),("D3", 5),("D4", 5),("D5", 5);

# 상영시간 
INSERT INTO SCHEDULE(SD_DATE, SD_TIME, SD_POS_SEAT, SD_EARLY, SD_MV_NUM, SD_SC_NUM) VALUES
("2025-03-11", "13:50", 16, "N", 1, 4),
("2025-03-11", "19:10", 16, "N", 1, 4),
("2025-03-11", "16:20", 12, "N", 1, 1),
("2025-03-11", "09:00", 15, "Y", 1, 3),
("2025-03-11", "11:50", 15, "N", 1, 3),
("2025-03-11", "10:00", 20, "Y", 1, 5);


# 회원가입하는 쿼리. 아이디 : abc123, 비번 : abc123, 사용자 

INSERT INTO MEMBER(ME_ID,ME_PW) VALUES ("abc123","abc123");			-- 권한 기본값 USER 로 설정해서 따로 안 부여해도 됨

# abc123 회원이 3번 스케쥴(미키17, 1관 3월 11일 16:20)의 예약 가능한 좌석 A1, A2를 예매했을 때 필요한 쿼리 (성인1, 청소년1) 
# 1. 예매 테이블(TICKET)에 추가하는 쿼리
INSERT INTO TICKET(TI_ADULT, TI_TEEN, TI_PRICE,TI_ME_NUM, TI_SD_NUM) 	-- TI_STATE는 DEFAULT가 결제라 생략해도 ㅇ 
VALUES 																	-- TI_PRICE는 프로시저 사용해서 넣어도 되지만 여기선 그냥 입력해서 넣어주기... 조조인지도
(1,1,27000,1,3);

# 2. 예매 리스트 테이블(TICKET_LIST)에 추가하는 쿼리
INSERT INTO TICKET_LIST(TL_TI_NUM, TL_SE_NUM)
VALUES
(1,1),
(1,2);
# 3. SCHEDULE의 예매 가능 좌석수를 변경
UPDATE SCHEDULE SET SD_POS_SEAT = SD_POS_SEAT - 2 WHERE SD_NUM = 3;

# abc123 회원이 1번 스케쥴(미키17, 4관 3월 11일 13:50)의 예약 가능한 좌석 A1, A2를 예매했을 때 필요한 쿼리 (성인1, 청소년1) 
INSERT INTO TICKET(TI_ADULT, TI_TEEN, TI_PRICE,TI_ME_NUM, TI_SD_NUM) VALUES (1,1,27000,1,1);
INSERT INTO TICKET_LIST(TL_TI_NUM, TL_SE_NUM) VALUES (2,38), (2,39);

UPDATE SCHEDULE SET SD_POS_SEAT = SD_POS_SEAT - 2 WHERE SD_NUM = 1;

# abc123 회원이 2번 스케쥴(미키17, 4관 3월 11일 19:10)의 예약 가능한 좌석 A1, A2를 예매했을 때 필요한 쿼리 (성인1, 청소년1) 
INSERT INTO TICKET(TI_ADULT, TI_TEEN, TI_PRICE,TI_ME_NUM, TI_SD_NUM) VALUES (1,1,27000,1,2);
INSERT INTO TICKET_LIST(TL_TI_NUM, TL_SE_NUM) VALUES (3,38), (3,39);

UPDATE SCHEDULE SET SD_POS_SEAT = SD_POS_SEAT - 2 WHERE SD_NUM = 2;

# abc123 회원이 2번 스케쥴(미키17, 4관 3월 11일 19:10)의 예약 가능한 좌석 A3, A4를 예매했을 때 필요한 쿼리 (성인1, 청소년1) 
INSERT INTO TICKET(TI_ADULT, TI_TEEN, TI_PRICE,TI_ME_NUM, TI_SD_NUM) VALUES (1,1,27000,1,2);
INSERT INTO TICKET_LIST(TL_TI_NUM, TL_SE_NUM) VALUES (4,40), (4,41);

UPDATE SCHEDULE SET SD_POS_SEAT = SD_POS_SEAT - 2 WHERE SD_NUM = 2;

# abc123 회원이 2번 스케줄에 예약했던 좌석 A3, A4를 취소했을 때 필요한 쿼리 
UPDATE TICKET SET TI_STATE = '취소' WHERE TI_NUM = 4;
-- DELETE FROM TICKET_LIST WHERE TL_TI_NUM = '3'; -- 이거 안지워도 되나보네

UPDATE SCHEDULE SET SD_POS_SEAT = SD_POS_SEAT + 2 WHERE SD_NUM = 2;



