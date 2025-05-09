# 컴퓨터공학과를 등록. 학과코드 COM, 학과코드 번호 160, 사무실 KH 1관 401호를 등록하는 쿼리 
# 디자인학과를 등록. 학과코드 DEG, 학과코드 번호 123, 사무실 KH 3관 101호를 등록하는 쿼리 
# 기계공학과를 등록. 학과코드 MEC, 학과코드 번호 456, 사무실 KH 4관 201호를 등록하는 쿼리 

INSERT INTO DEPARTMENT(DE_NAME, DE_NUM, DE_NAME_NUM, DE_OFFICE,DE_PR_NUM)    VALUES ("컴퓨터공학과","COM",160,"KH 1관 401호",NULL), ("디자인학과","DEG",123,"KH 3관 101호",NULL), ("기계공학과","MEC",456,"KH 4관 201호",NULL);
																							 -- 학과넘버 문자열 3자가 들어가야 하지만 MYSQL은 융통성이 있는 편이라 숫자3자도 문자3자로 변환해서 넣어줌


# 교수를 등록. 이름 홍교수 연락처 012-1234-5678 주민번호 601111-1000000 취임연도 2000 컴공과 
# 교수를 등록. 이름 김교수 연락처 012-1111-5555 주민번호 630101-2000000 취임연도 2000 컴공과                                                                                               
# 교수를 등록. 이름 박교수 연락처 012-7788-4455 주민번호 671111-1000000 취임연도 2005 디자인과 
# 교수를 등록. 이름 이교수 연락처 012-5678-9101 주민번호 701231-2000000 취임연도 2010 디자인과 
# 교수를 등록. 이름 최교수 연락처 012-4567-5677 주민번호 651001-1000000 취임연도 2005 기계과 
# 교수를 등록. 이름 문교수 연락처 012-3333-4444 주민번호 750401-1000000 취임연도 2020 기계과
-- 연도가 같은 경우엔 위에서부터 등록 

/*
INSERT INTO PROFESSOR VALUES 
("홍교수", "012-1234-5678", "601111-1000000", 2000, "COM"),
("김교수", "012-1111-5555", "630101-2000000", 2000, "COM"),
("박교수", "012-7788-4455", "671111-1000000", 2005, "DEG"),
("최교수", "012-4567-5677", "651001-1000000", 2005, "MEC"),
("이교수", "012-5678-9101", "701231-2000000", 2010, "DEG"),
("문교수", "012-3333-4444", "750401-1000000", 2020, "MEC");
*/

-- SET GLOBAL sql_mode = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION';	-- 해줘야 작동함 
INSERT INTO PROFESSOR 
SELECT CONCAT("P", 2000, DE_NAME_NUM, LPAD(COUNT(PR_NUM) + 1, 3, "0")), "홍교수" , "012-1234-5678", "601111-1", 2000, DE_NUM
FROM 
	(SELECT * FROM PROFESSOR WHERE PR_YEAR = 2000) P
RIGHT JOIN 
	DEPARTMENT ON DE_NUM = PR_DE_NUM
WHERE 
	DE_NAME = "컴퓨터공학과";
    
-- 컴공과 160 안다고 가정하고 다음교수 --("김교수", "012-1111-5555", "630101-2000000", 2000, "COM")
INSERT INTO PROFESSOR 
SELECT CONCAT("P", 2000, 160, LPAD(COUNT(PR_NUM) + 1, 3, "0")), "김교수" , "012-1111-5555", "630101-2", 2000, "COM"
FROM 
	PROFESSOR
WHERE 
	PR_YEAR ;
-- ("박교수", "012-7788-4455", "671111-1000000", 2005, "DEG"),
INSERT INTO PROFESSOR 
SELECT CONCAT("P", 2005, 123, LPAD(COUNT(PR_NUM) + 1, 3, "0")), "박교수" , "012-7788-4455", "671111-1", 2005, DE_NUM
FROM 
	(SELECT * FROM PROFESSOR WHERE PR_YEAR = 2005) P
RIGHT JOIN 
	DEPARTMENT ON DE_NUM = PR_DE_NUM
WHERE 
	DE_NAME = "디자인학과";

-- ("이교수", "012-5678-9101", "701231-2000000", 2010, "DEG"),
INSERT INTO PROFESSOR 
SELECT CONCAT("P", 2010, 123, LPAD(COUNT(PR_NUM) + 1, 3, "0")), "이교수" , "012-5678-9101", "701231-2", 2010, DE_NUM
FROM 
	(SELECT * FROM PROFESSOR WHERE PR_YEAR = 2010) P
RIGHT JOIN 
	DEPARTMENT ON DE_NUM = PR_DE_NUM
WHERE 
	DE_NAME = "디자인학과";


-- ("최교수", "012-4567-5677", "651001-1000000", 2005, "MEC"),
INSERT INTO PROFESSOR 
SELECT CONCAT("P", 2005, DE_NAME_NUM, LPAD(COUNT(PR_NUM) + 1, 3, "0")), "최교수" , "012-4567-5677", "651001-1", 2005, DE_NUM
FROM 
	(SELECT * FROM PROFESSOR WHERE PR_YEAR = 2005) P
RIGHT JOIN 
	DEPARTMENT ON DE_NUM = PR_DE_NUM
WHERE 
	DE_NAME = "기계공학과";

-- ("문교수", "012-3333-4444", "750401-1000000", 2020, "MEC");
INSERT INTO PROFESSOR 
SELECT CONCAT("P", 2020, DE_NAME_NUM, LPAD(COUNT(PR_NUM) + 1, 3, "0")), "문교수" , "012-3333-4444", "750401-1", 2020, DE_NUM
FROM 
	(SELECT * FROM PROFESSOR WHERE PR_YEAR = 2020) P
RIGHT JOIN 
	DEPARTMENT ON DE_NUM = PR_DE_NUM
WHERE 
	DE_NAME = "기계공학과";
    
-- 김교수 제외하고 교수번호 전부 1로 끝나야 함. 
-- 입력할건 많지만 학과 코드 같은거 일일히 몰라도 됨.
    
# 최종 합격 명단 
# 이름 홍길동 연락처 013-1234-5678 입학연도 2025 주민번호 060303-3 컴퓨터공학과
# 이름 고길동 연락처 013-1111-1111 입학연도 2025 주민번호 060401-3 컴퓨터공학과
# 이름 김길동 연락처 013-1111-2222 입학연도 2025 주민번호 060505-3 컴퓨터공학과
# 이름 하니 연락처 013-1234-3333 입학연도 2025 주민번호 060606-4 컴퓨터공학과

# 이름 나애리 연락처 013-1234-4444 입학연도 2025 주민번호 060625-4 디자인학과
# 이름 오영심 연락처 013-1234-5555 입학연도 2025 주민번호 060717-4 디자인학과
# 이름 오두리 연락처 013-1234-6666 입학연도 2025 주민번호 060815-4 디자인학과
# 이름 전지현 연락처 013-1234-7777 입학연도 2025 주민번호 051003-4 디자인학과

# 이름 김둘리 연락처 013-1234-8888 입학연도 2025 주민번호 061224-3 기계공학과
# 이름 김군 연락처 013-1234-9999 입학연도 2025 주민번호 070101-3 기계공학과
# 이름 박명수 연락처 013-1234-0000 입학연도 2025 주민번호 060405-3 기계공학과
# 이름 유재석 연락처 013-1234-1234 입학연도 2025 주민번호 061009-3 기계공학과

INSERT INTO FINAL_PASS(FP_NAME,FP_PHONE,FP_YEAR,FP_RES_NUM,FP_DE_NUM) VALUES 
("홍길동", "013-1234-5678", 2025, "060303-3", "COM"),
("고길동", "013-1111-1111", 2025, "060401-3", "COM"),
("김길동", "013-1111-2222", 2025, "060505-3", "COM"),
("하니", "013-1234-3333", 2025, "060606-4", "COM"),

("나애리", "013-1234-4444", 2025, "060625-4", "DEG"),
("오영심", "013-1234-5555", 2025, "060717-4", "DEG"),
("오두리", "013-1234-6666", 2025, "060815-4", "DEG"),
("전지현", "013-1234-7777", 2025, "051003-4", "DEG"),

("김둘리", "013-1234-8888", 2025, "061224-3", "MEC"),
("김군", "013-1234-9999", 2025, "070101-3", "MEC"),
("박명수", "013-1234-0000", 2025, "060405-3", "MEC"),
("유재석", "013-1234-1234", 2025, "061009-3", "MEC");


# 최종 합격한 컴공과 학생들을 학생으로 등록하는 쿼리 
/*
INSERT INTO STUDENT
SELECT CONCAT(2025, DE_NAME_NUM, LPAD(COUNT(ST_NUM) + 1, 3, "0")), "홍길동", "060303-3", "013-1234-5678", 2025, DE_NUM, NULL
FROM
	(SELECT * FROM STUDENT WHERE ST_YEAR = 2025) S
RIGHT JOIN 
	DEPARTMENT ON DE_NUM = ST_DE_NUM
WHERE 
	DE_NAME = "컴퓨터공학과";
    
INSERT INTO STUDENT
SELECT CONCAT(2025, DE_NAME_NUM, LPAD(COUNT(ST_NUM) + 1, 3, "0")), "고길동", "060401-3", "013-1111-1111", 2025, DE_NUM, NULL
FROM
	(SELECT * FROM STUDENT WHERE ST_YEAR = 2025) S
RIGHT JOIN 
	DEPARTMENT ON DE_NUM = ST_DE_NUM
WHERE 
	DE_NAME = "컴퓨터공학과";
       
INSERT INTO STUDENT
SELECT CONCAT(2025, DE_NAME_NUM, LPAD(COUNT(ST_NUM) + 1, 3, "0")), "김길동", "060505-3", "013-1111-2222", 2025, DE_NUM, NULL
FROM
	(SELECT * FROM STUDENT WHERE ST_YEAR = 2025) S
RIGHT JOIN 
	DEPARTMENT ON DE_NUM = ST_DE_NUM
WHERE 
	DE_NAME = "컴퓨터공학과";

INSERT INTO STUDENT
SELECT CONCAT(2025, DE_NAME_NUM, LPAD(COUNT(ST_NUM) + 1, 3, "0")), "하니", "013-1234-3333", "060606-4", 2025, DE_NUM, NULL
FROM
	(SELECT * FROM STUDENT WHERE ST_YEAR = 2025) S
RIGHT JOIN 
	DEPARTMENT ON DE_NUM = ST_DE_NUM
WHERE 
	DE_NAME = "컴퓨터공학과";
*/

/*
SELECT LPAD(RANK() OVER(ORDER BY FP_NAME, FP_RES_NUM), 3, "0") AS ST_NUM, FP_NAME, FP_RES_NUM, FP_PHONE, FP_YEAR FROM FINAL_PASS WHERE FP_DE_NUM = "COM" AND FP_YEAR = YEAR(NOW());
-- RANK DENSERANK ROWNUM 뭘 써도 상관없음 (이름,주민번호는 안 겹치기 때문)
SELECT LPAD(RANK() OVER(ORDER BY FP_NAME, FP_RES_NUM), 3, "0") AS ST_NUM, FP_NAME, FP_RES_NUM, FP_PHONE, FP_YEAR FROM FINAL_PASS WHERE FP_DE_NUM = "DEG" AND FP_YEAR = YEAR(NOW());
SELECT LPAD(RANK() OVER(ORDER BY FP_NAME, FP_RES_NUM), 3, "0") AS ST_NUM, FP_NAME, FP_RES_NUM, FP_PHONE, FP_YEAR FROM FINAL_PASS WHERE FP_DE_NUM = "MEC" AND FP_YEAR = YEAR(NOW());
*/
# 최종합격 컴공과 등록 쿼리
INSERT INTO STUDENT
SELECT 
	CONCAT(FP_YEAR, DE_NAME_NUM, LPAD(RANK() OVER(ORDER BY FP_NAME, FP_RES_NUM), 3, "0")) AS ST_NUM, FP_NAME, FP_RES_NUM, FP_PHONE, FP_YEAR, DE_NUM, NULL 
FROM 
	FINAL_PASS JOIN DEPARTMENT ON FP_DE_NUM = DE_NUM 
WHERE 
	FP_DE_NUM = "COM" AND FP_YEAR = YEAR(NOW());
# 최종합격 디자인과 등록 쿼리
INSERT INTO STUDENT
SELECT 
	CONCAT(FP_YEAR, DE_NAME_NUM, LPAD(RANK() OVER(ORDER BY FP_NAME, FP_RES_NUM), 3, "0")) AS ST_NUM, FP_NAME, FP_RES_NUM, FP_PHONE, FP_YEAR, DE_NUM, NULL 
FROM 
	FINAL_PASS JOIN DEPARTMENT ON FP_DE_NUM = DE_NUM 
WHERE 
	FP_DE_NUM = "DEG" AND FP_YEAR = YEAR(NOW());
# 최종합격 기계과 등록 쿼리    
INSERT INTO STUDENT
SELECT 
	CONCAT(FP_YEAR, DE_NAME_NUM, LPAD(RANK() OVER(ORDER BY FP_NAME, FP_RES_NUM), 3, "0")) AS ST_NUM, FP_NAME, FP_RES_NUM, FP_PHONE, FP_YEAR, DE_NUM, NULL 
FROM 
	FINAL_PASS JOIN DEPARTMENT ON FP_DE_NUM = DE_NUM 
WHERE 
	FP_DE_NUM = "MEC" AND FP_YEAR = YEAR(NOW());
    
    
# 과목을 등록하는 쿼리
# 학과코드 등록 

# 교직(TEA), 교양(CUL), 기본(MSC) 등록 
-- INSERT INTO DEPARTMENT(DE_NAME, DE_NUM, DE_NAME_NUM, DE_OFFICE, DE_PR_NUM)    VALUES ("교직","TEA","TEA",NULL,NULL), ("교양","CUL","CUL",NULL,NULL), ("기본","MSC","MSC",NULL,NULL); -- 이거 아님;
INSERT INTO SUBJECT_CATEGORY SELECT DE_NUM FROM DEPARTMENT;
INSERT INTO SUBJECT_CATEGORY VALUES("TEA"), ("CUL"), ("MSC");


# 과목명 : 컴퓨터개론, 학점 : 2, 시간 : 2, 분류 : COM, 과목코드 : COM001 
# 과목명 : 프로그래밍언어, 학점 : 3, 시간 : 3, 분류 : COM, 과목코드 : COM002 
# 과목명 : 알고리즘, 학점 : 3, 시간 : 3, 분류 : COM, 과목코드 : COM003
 
# 과목명 : 확률과통계, 학점 : 3, 시간 : 3, 분류 : MSC, 과목코드 : MSC001 
# 과목명 : 미분과적분, 학점 : 4, 시간 : 4, 분류 : MSC, 과목코드 : MSC002 

# 과목명 : 영어1, 학점 : 3, 시간 : 3, 분류 : CUL, 과목코드 : CUL001 
# 과목명 : 음악과감상, 학점 : 4, 시간 : 4, 분류 : CUL, 과목코드 : CUL002 

# 과목명 : 교육학개론, 학점 : 2, 시간 : 3, 분류 : TEA, 과목코드 : TEA001 
# 과목명 : 교육방법론, 학점 : 3, 시간 : 3, 분류 : TEA, 과목코드 : TEA002 

# 과목명 : 디자인의이해, 학점 : 2, 시간 : 2, 분류 : DEG, 과목코드 : DEG001 
# 과목명 : 시각디자인, 학점 : 3, 시간 : 3, 분류 : DEG, 과목코드 : DEG002 
# 과목명 : 제품디자인, 학점 : 3, 시간 : 3, 분류 : DEG, 과목코드 : DEG003

# 과목명 : 프로그래밍언어, 학점 : 3, 시간 : 3, 분류 : MEC, 과목코드 : MEC001 
# 과목명 : 동역학, 학점 : 3, 시간 : 3, 분류 : MEC, 과목코드 : MEC002 
# 과목명 : 기계의이해, 학점 : 2, 시간 : 2, 분류 : MEC, 과목코드 : MEC003

/*
INSERT INTO SUBJECT(SJ_TITLE, SJ_POINT, SJ_TIME, SJ_SC_CODE, SJ_CODE) VALUES
("컴퓨터개론", 2, 2, "COM", "COM001"),
("프로그래밍언어", 3, 3, "COM", "COM002"),
("알고리즘", 3, 3, "COM", "COM003");
*/

INSERT INTO SUBJECT(SJ_TITLE, SJ_POINT, SJ_TIME, SJ_SC_CODE, SJ_CODE)
SELECT "컴퓨터개론", 2, 2, "COM", CONCAT("COM", LPAD(COUNT(*) + 1, 3, "0")) FROM SUBJECT WHERE SJ_SC_CODE = "COM";

INSERT INTO SUBJECT(SJ_TITLE, SJ_POINT, SJ_TIME, SJ_SC_CODE, SJ_CODE)
SELECT "프로그래밍언어", 3, 3, "COM", CONCAT("COM", LPAD(COUNT(*) + 1, 3, "0")) FROM SUBJECT WHERE SJ_SC_CODE = "COM";

INSERT INTO SUBJECT(SJ_TITLE, SJ_POINT, SJ_TIME, SJ_SC_CODE, SJ_CODE)
SELECT "알고리즘", 3, 3, "COM", CONCAT("COM", LPAD(COUNT(*) + 1, 3, "0")) FROM SUBJECT WHERE SJ_SC_CODE = "COM";


INSERT INTO SUBJECT(SJ_TITLE, SJ_POINT, SJ_TIME, SJ_SC_CODE, SJ_CODE)
SELECT "확률과통계", 3, 3, "MSC", CONCAT("MSC", LPAD(COUNT(*) + 1, 3, "0")) FROM SUBJECT WHERE SJ_SC_CODE = "MSC";

INSERT INTO SUBJECT(SJ_TITLE, SJ_POINT, SJ_TIME, SJ_SC_CODE, SJ_CODE)
SELECT "미분과적분", 4, 4, "MSC", CONCAT("MSC", LPAD(COUNT(*) + 1, 3, "0")) FROM SUBJECT WHERE SJ_SC_CODE = "MSC";



INSERT INTO SUBJECT(SJ_TITLE, SJ_POINT, SJ_TIME, SJ_SC_CODE, SJ_CODE)
SELECT "영어1", 3, 3, "CUL", CONCAT("CUL", LPAD(COUNT(*) + 1, 3, "0")) FROM SUBJECT WHERE SJ_SC_CODE = "CUL";

INSERT INTO SUBJECT(SJ_TITLE, SJ_POINT, SJ_TIME, SJ_SC_CODE, SJ_CODE)
SELECT "음악과감상", 4, 4, "CUL", CONCAT("CUL", LPAD(COUNT(*) + 1, 3, "0")) FROM SUBJECT WHERE SJ_SC_CODE = "CUL";



INSERT INTO SUBJECT(SJ_TITLE, SJ_POINT, SJ_TIME, SJ_SC_CODE, SJ_CODE)
SELECT "교육학개론", 2, 3, "TEA", CONCAT("TEA", LPAD(COUNT(*) + 1, 3, "0")) FROM SUBJECT WHERE SJ_SC_CODE = "TEA";

INSERT INTO SUBJECT(SJ_TITLE, SJ_POINT, SJ_TIME, SJ_SC_CODE, SJ_CODE)
SELECT "교육방법론", 3, 3, "TEA", CONCAT("TEA", LPAD(COUNT(*) + 1, 3, "0")) FROM SUBJECT WHERE SJ_SC_CODE = "TEA";



INSERT INTO SUBJECT(SJ_TITLE, SJ_POINT, SJ_TIME, SJ_SC_CODE, SJ_CODE)
SELECT "디자인의이해", 2, 2, "DEG", CONCAT("DEG", LPAD(COUNT(*) + 1, 3, "0")) FROM SUBJECT WHERE SJ_SC_CODE = "DEG";

INSERT INTO SUBJECT(SJ_TITLE, SJ_POINT, SJ_TIME, SJ_SC_CODE, SJ_CODE)
SELECT "시각디자인", 3, 3, "DEG", CONCAT("DEG", LPAD(COUNT(*) + 1, 3, "0")) FROM SUBJECT WHERE SJ_SC_CODE = "DEG";

INSERT INTO SUBJECT(SJ_TITLE, SJ_POINT, SJ_TIME, SJ_SC_CODE, SJ_CODE)
SELECT "제품디자인", 3, 3, "DEG", CONCAT("DEG", LPAD(COUNT(*) + 1, 3, "0")) FROM SUBJECT WHERE SJ_SC_CODE = "DEG";


INSERT INTO SUBJECT(SJ_TITLE, SJ_POINT, SJ_TIME, SJ_SC_CODE, SJ_CODE)
SELECT "프로그래밍언어", 3, 3, "MEC", CONCAT("MEC", LPAD(COUNT(*) + 1, 3, "0")) FROM SUBJECT WHERE SJ_SC_CODE = "MEC";

INSERT INTO SUBJECT(SJ_TITLE, SJ_POINT, SJ_TIME, SJ_SC_CODE, SJ_CODE)
SELECT "동역학", 3, 3, "MEC", CONCAT("MEC", LPAD(COUNT(*) + 1, 3, "0")) FROM SUBJECT WHERE SJ_SC_CODE = "MEC";

INSERT INTO SUBJECT(SJ_TITLE, SJ_POINT, SJ_TIME, SJ_SC_CODE, SJ_CODE)
SELECT "기계의이해", 2, 2, "MEC", CONCAT("MEC", LPAD(COUNT(*) + 1, 3, "0")) FROM SUBJECT WHERE SJ_SC_CODE = "MEC";

# 강의명 : 컴퓨터 개론(1), 2025,학기 : 1,강의실 : KH 1관 501호, 분반 : 1, 정원 : 30,강의계획서 : 없음,교수 : 홍교수(P2000160001)
# 시간 : 월1A, 월1B, 월2A, 월2B

# 강의명 : 프로그래밍 언어(2), 2025,학기 : 1,강의실 : KH 1관 501호, 분반 : 1, 정원 : 30,강의계획서 : 없음,교수 : 홍교수(P2000160001)
# 시간 : 월4A, 월4B, 월5A, 수4A, 수4B, 수5A

# 강의명 : 프로그래밍 언어(2), 2025,학기 : 1,강의실 : KH 1관 502호, 분반 : 2, 정원 : 30,강의계획서 : 없음,교수 : 김교수(P2000160002)
# 시간 : 월4A, 월4B, 월5A, 수4A, 수4B, 수5A

# 강의명 : 알고리즘(3), 2025,학기 : 1,강의실 : KH 1관 502호, 분반 : 1, 정원 : 30,강의계획서 : 없음,교수 : 김교수(P2000160002)
# 시간 : 목1A, 목1B, 목2A, 목2B, 목3A, 목3B

# 강의명 : 확률과 통계(4), 2025,학기 : 1,강의실 : KH 3관 501호, 분반 : 1, 정원 : 30,강의계획서 : 없음,교수 : 김교수(P2000160002)
# 시간 : 화1A, 화1B, 화2A, 금1A,금1B,금2A

# 강의명 : 미분과 적분(5), 2025,학기 : 1,강의실 : KH 3관 502호, 분반 : 1, 정원 : 30,강의계획서 : 없음,교수 : 홍교수(P2000160001)
# 시간 : 화1A, 화1B, 화2A, 금1A,금1B,금2A

# 강의명 : 영어1(6), 2025,학기 : 1,강의실 : KH 2관 501호, 분반 : 1, 정원 : 30,강의계획서 : 없음,교수 : 이교수(P2010123001)
# 시간 : 화1A, 화1B, 화2A, 금1A,금1B,금2A

# 강의명 : 음악감상(7), 2025,학기 : 1,강의실 : KH 2관 502호, 분반 : 1, 정원 : 30,강의계획서 : 없음,교수 : 최교수(P2020456001)
# 시간 : 월6A,월6B,월7A,월7B,월8A,월8B

# 강의명 : 교육학 개론(8), 2025,학기 : 1,강의실 : KH 4관 501호, 분반 : 1, 정원 : 30,강의계획서 : 없음,교수 : 최교수(P2005456001)
# 시간 : 화1A,화1B,화2A,화2B,화3A,화3B

# 강의명 : 교육 방법론(9), 2025,학기 : 1,강의실 : KH 4관 502호, 분반 : 1, 정원 : 30,강의계획서 : 없음,교수 : 박교수(P2005123001)
# 시간 : 화1A,화1B,화2A,화2B,화3A,화3B

-- SELECT * FROM PROFESSOR;
INSERT INTO LECTURE(LE_SJ_NUM, LE_YEAR, LE_SEMESTER, LE_CLASS_ROOM, LE_CLASS, LE_MAX, LE_PLAN, LE_PR_NUM) VALUES
(1,2025,"1","KH 1관 501호",1,30,"없음","P2000160001"),
(2,2025,"1","KH 1관 501호",1,30,"없음","P2000160001"),
(2,2025,"1","KH 1관 502호",2,30,"없음","P2000160002"),
(3,2025,"1","KH 1관 502호",1,30,"없음","P2000160002"),
(4,2025,"1","KH 3관 501호",1,30,"없음","P2000160002"),
(5,2025,"1","KH 3관 502호",1,30,"없음","P2000160001"),
(6,2025,"1","KH 2관 501호",1,30,"없음","P2010123001"),
(7,2025,"1","KH 2관 502호",1,30,"없음","P2020456001"),
(8,2025,"1","KH 4관 501호",1,30,"없음","P2020456001"),
(9,2025,"1","KH 4관 502호",1,30,"없음","P2005123001");


INSERT INTO LECTURE_SCHEDULE(LC_LE_NUM,LC_DAY, LC_TIME, LC_MINUTE) VALUES 
(1,"월",1,"A"),(1,"월",1,"B"),(1,"월",2,"A"),(1,"월",2,"B"),
(2,"월",4,"A"),(2,"월",4,"B"),(2,"월",5,"A"),(2,"수",4,"A"),(2,"수",4,"B"),(2,"수",5,"A"),
(3,"월",4,"A"),(3,"월",4,"B"),(3,"월",5,"A"),(3,"수",4,"A"),(3,"수",4,"B"),(3,"수",5,"A"),
(4,"목",1,"A"),(4,"목",1,"B"),(4,"목",2,"A"),(4,"목",2,"B"),(4,"목",3,"A"),(4,"목",3,"B"),
(5,"화",1,"A"),(5,"화",1,"B"),(5,"화",2,"A"),(5,"금",1,"A"),(5,"금",1,"B"),(5,"금",2,"A"),
(6,"화",1,"A"),(6,"화",1,"B"),(6,"화",2,"A"),(6,"금",1,"A"),(6,"금",1,"B"),(6,"금",3,"A"),
(7,"월",6,"A"),(7,"월",6,"B"),(7,"월",7,"A"),(7,"월",7,"B"),(7,"월",8,"A"),(7,"월",8,"B"),
(8,"화",1,"A"),(8,"화",1,"B"),(8,"화",2,"A"),(8,"화",2,"B"),(8,"화",3,"A"),(8,"화",3,"B"),
(9,"화",1,"A"),(9,"화",1,"B"),(9,"화",2,"A"),(9,"화",2,"B"),(9,"화",3,"A"),(9,"화",3,"B");



# 고길동(2025160001) 학생 컴퓨터개론(1), 프로그래밍언어(2), 확률과통계(5), 음악과감상(8) 을 수강신청할때 쿼리

INSERT INTO COURSE(CO_ST_NUM,CO_LE_NUM) VALUES 
("2025160001",1),("2025160001",2),("2025160001",5),("2025160001",8);


# 교수님이 성적 비율을 수정했을 때 쿼리 
# 모든 강이의 성적 비율을 기본으로 적용하는 쿼리 
INSERT INTO LECTURE_STANDARD(LS_LE_NUM)
SELECT LE_NUM FROM LECTURE; 

# 컴퓨터개론(1) 성적 비율 : 중간 45 기말 45 출석 10 과제 0 
# 프로그래밍언어(2) 성적 비율 : 중간 40 기말 40 출석 10 과제 10 
UPDATE LECTURE_STANDARD 
SET 
	LS_MID = 45, 
	LS_FINAL = 45, 
    LS_ATT = 10, 
    LS_HOME = 0 
WHERE 
	LS_LE_NUM = 1;
    
UPDATE LECTURE_STANDARD 
SET 
	LS_MID = 40, 
	LS_FINAL = 40, 
    LS_ATT = 10, 
    LS_HOME = 10 
WHERE 
	LS_LE_NUM = 2;

# 고길동(2025160001) 학생 컴퓨터개론(1) 성적이 중간 100 기말 100 과제 80 출석 100일 때 성적을 계산하는 프로시저 작성. A+ : 95 이상 A : 90 이상 ...  
/*
DROP PROCEDURE IF EXISTS INSERT_SCORE; 
DELIMITER //
CREATE PROCEDURE INSERT_SCORE(
	IN _ST_KEY INT,					
    IN _LE_NUM INT,
    IN _LS_MID INT, 
	IN _LS_FINAL INT, 
    IN _LS_ATT INT, 
    IN _LS_HOME INT
    )
BEGIN
	DECLARE _SCORE INT;
    DECLARE _GRADE CHAR(2);
    DECLARE _LS_MID2 INT;
    DECLARE _LS_FINAL2 INT;
    DECLARE _LS_ATT2 INT;
    DECLARE _LS_HOME2 INT;
    
	IF _LS_MID BETWEEN 0 AND 100 AND _LS_FINAL BETWEEN 0 AND 100 AND _LS_ATT BETWEEN 0 AND 100 AND _LS_HOME BETWEEN 0 AND 100 THEN
		SET _LS_MID2 = _LS_MID * (SELECT LS_MID FROM LECTURE_STANDARD WHERE LS_LE_NUM = _LE_NUM) * 0.01;
        SET _LS_FINAL2 = _LS_FINAL * (SELECT LS_FINAL FROM LECTURE_STANDARD WHERE LS_LE_NUM = _LE_NUM) * 0.01;
        SET _LS_ATT2 = _LS_ATT * (SELECT LS_ATT FROM LECTURE_STANDARD WHERE LS_LE_NUM = _LE_NUM) * 0.01;
        SET _LS_HOME2 = _LS_HOME * (SELECT LS_HOME FROM LECTURE_STANDARD WHERE LS_LE_NUM = _LE_NUM) * 0.01;
        SET _SCORE = _LS_MID2 + _LS_FINAL2 + _LS_ATT2 + _LS_HOME2;
        IF _SCORE >= 95 THEN
				SET _GRADE = "A+";
			ELSEIF _SCORE >= 90 THEN
				SET _GRADE = "A";
			ELSEIF _SCORE >= 85 THEN
				SET _GRADE = "B+";
			ELSEIF _SCORE >= 80 THEN
				SET _GRADE = "B";
			ELSEIF _SCORE >= 75 THEN
				SET _GRADE = "C+";
			ELSEIF _SCORE >= 70 THEN
				SET _GRADE = "C";
			ELSEIF _SCORE >= 60 THEN
				SET _GRADE = "D"; 
			ELSE 
				SET _GRADE = "F";
		END IF;
		INSERT INTO COURSE(CO_ATT,CO_HOME,CO_MID,CO_FINAL,CO_TOTAL,CO_ST_NUM,CO_LE_NUM) VALUES
        (_LS_ATT,_LS_HOME,_LS_MID,_LS_FINAL,_GRADE,_ST_KEY,_LE_NUM);        
    END IF;
END // 
DELIMITER ;
*/

DROP PROCEDURE IF EXISTS INSERT_SCORE; 
DELIMITER //
CREATE PROCEDURE INSERT_SCORE(
	IN _ST_NUM CHAR(10),					
    IN _LE_NUM INT,
    IN _MID INT, 
	IN _FINAL INT, 
    IN _ATT INT, 
    IN _HOME INT
    )
BEGIN
	DECLARE _TOTAL INT DEFAULT 0;
    DECLARE _RES VARCHAR(4) DEFAULT "FAIL";
	
    SET _TOTAL = (
		SELECT 
			(_MID * LS_MID + 
            _FINAL * LS_FINAL + 
            _ATT * LS_ATT + 
            _HOME * LS_HOME) / 100 
            FROM LECTURE_STANDARD WHERE LS_LE_NUM = _LE_NUM);

	IF _TOTAL >= 95 THEN SET _RES = "A+";
		ELSEIF _TOTAL >= 90 THEN SET _RES = "A";
		ELSEIF _TOTAL >= 85 THEN SET _RES = "B+";
		ELSEIF _TOTAL >= 80 THEN SET _RES = "B";
		ELSEIF _TOTAL >= 75 THEN SET _RES = "C+";
		ELSEIF _TOTAL >= 70 THEN SET _RES = "C";
		ELSEIF _TOTAL >= 65 THEN SET _RES = "D+";
		ELSEIF _TOTAL >= 60 THEN SET _RES = "D"; 
		ELSE SET _RES = "F";
	END IF;
        
	UPDATE COURSE
    SET
		CO_MID = _MID,
        CO_FINAL = _FINAL,
        CO_ATT = _ATT,
        CO_HOME = _HOME,
        CO_TOTAL = _RES
	WHERE 
		CO_ST_NUM = _ST_NUM AND CO_LE_NUM = _LE_NUM;
END // 
DELIMITER ;

		SELECT 
			(100 * LS_MID + 
            90 * LS_FINAL + 
            10 * LS_ATT + 
            100 * LS_HOME) / 100 
            FROM LECTURE_STANDARD WHERE LS_LE_NUM = 1;
# 고길동(2025160001) 학생 컴퓨터개론(1) 성적이 중간 100 기말 100 과제 80 출석 100일 때 성적
CALL INSERT_SCORE("2025160001", 1, 100, 100, 80, 100);

# 고길동(2025160001) 학생 프로그래밍언어(2) 성적이 중간 90 기말 90 과제 50 출석 100일 때 성적
CALL INSERT_SCORE("2025160001", 2, 90, 90, 50, 100);



