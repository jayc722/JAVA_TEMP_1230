# INSERT : 데이터 추가
# SELECT : 데이터 조회
# UPDATE : 데이터 수정
# DELETE : 데이터 삭제

# 데이터 추가
# INDSET INTO 테이블명 VALUE(값1, ..., 값N)
# 						-> 값 순서는 속성 순서에 맞게
INSERT INTO STUDENT.STUDENT VALUE(1,1,1,1, "홍길동");			-- SUDENT : 스튜던트 데이터베이스의 스튜던트 테이블
															-- 테이블명 대신 DB명.테이블명으로 해도 됨(선택된 DB와 상관없이 해당 DB 실행)
                                                            -- 테이블명만 쓰려면 USE DB명으로 DB를 선택한 후에 사용 (그냥 테이블명만 쓰면 선택된 DB에 따라 동작되지 않을수 있음.)
                                                            -- INSERT INTO STUDENT.STUDENT VALUE(1,1,1,1, "홍길동");	 -- > 그냥은 에러(STUDENT DB 선택하지 않아서). 위에 USE STUDENT; 추가해야
	-- AUTO INCREMENT의 경우는 이렇게 안하고 밑의 방법을 주로 이용(중복)
USE STUDENT;
    
-- 데이터 확인하려면 해당 DB에 마우스 호버해서 제일 오른쪽 아이콘 하거나 아래 코드
SELECT * from student.student;

# INSERT INTO 테이블명(속성1, ..., 속성N) VALUE(값1,..., 값N)
# - 일부 속성 값을 생략할 때 사용
# - 생략 가능 속성 :	1. NULL 허용인 속성들
#					2. NOT NULL이지만 DEFAULT를 이용하여 기본값을 지정한 속성들

INSERT INTO STUDENT(ST_GRADE, ST_CLASS, ST_NUM, ST_NAME) VALUE(1,1,2, "임꺽정");	-- 생략x
INSERT INTO STUDENT(ST_NUM, ST_NAME) VALUE(3, "고길동");		-- 학년 반 생략

# INSERT INTO 테이블명(속성1, ..., 속성N) VALUES(값1, ..., 값N), (값1, ..., 값N), ...;		-- VALUES로 여려개의 값 한번에 넣을수o. 그냥 하나 넣을때도 VALUES 쓰는게 맘편함
INSERT INTO STUDENT(ST_NUM, ST_NAME) VALUES(4, "둘리"), (5, "하니");

# INSERT INTO 테이블명(속성1, ..., 속성N) SELECT 속성1, ..., 속성N FROM 테이블명 WHERE 조건		-- SELECT는 너무 길어서 다음 파일로 설명
#											값1, 값2, ..., 속성A FROM 테이블명 WHERE 조건		-- 값1 값2들은 지정된 값, 속성A는 검색 결과 값
# 	- 테이블에서 검색된 값을 이용하여 추가할 때 사용 --> 지금까지는 바로 넣어줬는데 이건 외부 자료를 넣어주는거

# 데이터 수정
# UPDATE 테이블명 SET 속성1 = 값1, ..., 속성N = 값N WHERE 조건
# 조건에서 같다(자바에서의 ==)는 = , 같지 않다는 != 또는 <>		-- 대입연산자 = 는 앞에 SET이 들어가서 구분됨
# NULL과 같다는 IS NULL, NULL과 같지 않다는 IS NOT NULL

# 1학년 1반 1번 학생의 이름을 홍길동A로 수정하는 쿼리
UPDATE STUDENT SET ST_NAME = "홍길동A" WHERE ST_GRADE = 1 AND ST_CLASS = 1 AND ST_NUM = 1; 

# 데이터 삭제
# DELETE FROM 테이블명 FROM 조건;
# 1학년 1반 2번 학생의 데이터를 삭제하는 쿼리
DELETE FROM STUDENT
WHERE
    ST_GRADE = 1 AND ST_CLASS = 1 AND ST_NUM = 2;
    
#학생들 샘플 데이터 추가(SELECT 확인 위해)
INSERT INTO STUDENT(ST_GRADE, ST_CLASS, ST_NUM, ST_NAME) VALUES
(2, 1, 1, "김길동"), (2, 1, 2, "가길동"), (2, 1, 3, "나길동"),
(2, 2, 1, "이길동"), (2, 2, 2, "박길동"), (2, 2, 3, "하길동"),
(2, 3, 1, "하니"), (2, 3, 2, "가니"), (2, 3, 3, "김둘리"),

(3, 1, 1, "김길동"), (3, 1, 2, "가길동"), (3, 1, 3, "나길동"),
(3, 2, 1, "이길동"), (3, 2, 2, "박길동"), (3, 2, 3, "하길동"),
(3, 3, 1, "하니"), (3, 3, 2, "가니"), (3, 3, 3, "김둘리");


#과목 샘플 데이터 추가
INSERT INTO STUDENT.SUBJECT(SJ_GRADE, SJ_SEMESTER, SJ_NAME) VALUES
(1, 1, "국어"), (1, 1, "수학"), (1, 1, "영어"),
(2, 1, "국어"), (2, 1, "수학"), (2, 1, "영어"),
(3, 1, "국어"), (3, 1, "수학"), (3, 1, "영어"),
(1, 2, "국어"), (1, 2, "수학"), (1, 2, "영어"),
(2, 2, "국어"), (2, 2, "수학"), (2, 2, "영어"),
(3, 2, "국어"), (3, 2, "수학"), (3, 2, "영어");


#성적 샘플 데이터 추가
INSERT INTO STUDENT.SCORE(SC_ST_KEY, SC_SJ_NUM, SC_SCORE) VALUES
(1, 1, 100), (1, 2, 100), (1, 3, 100),	# 1학년 1반 1번 학생 1학년 1학기 국영수 성적
(3, 1, 90), (3, 2, 80), (3, 3, 70),		# 1학년 1반 3번 학생 1학년 1학기 국영수 성적
(4, 1, 90), (4, 2, 30), (4, 3, 100),
(5, 1, 80), (5, 2, 70), (5, 3, 90),
(6, 4, 90), (6, 5, 30), (6, 6, 100),	# 2학년 1빈 1번 학생 1학년 2학기 국영수 성적
(7, 4, 50), (7, 5, 40), (7, 6, 80),
(8, 4, 50), (8, 5, 40), (8, 6, 80),
(9, 4, 50), (9, 5, 40), (9, 6, 80),
(10, 4, 50), (10, 5, 40), (10, 6, 80),
(11, 4, 50), (11, 5, 40), (11, 6, 80),
(12, 4, 50), (12, 5, 40), (12, 6, 80),
(13, 7, 50), (13, 8, 40), (13, 9, 80),	# 2학년 3반 2번 학생 2학년 1학기 국영수 성적
(14, 7, 50), (14, 8, 40), (14, 9, 80),
(15, 7, 50), (15, 8, 40), (15, 9, 80);

#1학년 1반 1번의 1학년 2학기 국어 성적을 100점으로 추가 -> 학생 기본키와 과목번호 알아야하는데 학생 기본키 일일히 찾기 힘듦...
SELECT ST_KEY FROM STUDENT WHERE ST_GRADE = 1 AND ST_CLASS = 1 AND ST_NUM = 1;		-- 1학년 1반 1번의 ST_KEY 찾기
SELECT SJ_NUM FROM SUBJECT WHERE SJ_GRADE = 1 AND SJ_SEMESTER = 2 AND SJ_NAME = "국어"; -- 1학년 2학기 국어 과목 번호 찾기

SELECT ST_KEY,SJ_NUM
FROM STUDENT
JOIN SUBJECT
WHERE 
	ST_GRADE = 1 AND ST_CLASS = 1 AND ST_NUM = 1
    AND SJ_GRADE = 1 AND SJ_SEMESTER = 2 AND SJ_NAME = "국어";	-- 되는데 복잡함
-- ->
-- 서브쿼리(테이블 위치에 쿼리가 들어가는 형태)를 이용해서 가상의 테이블 만들기
SELECT ST_KEY,SJ_NUM
	FROM (SELECT ST_KEY FROM STUDENT WHERE ST_GRADE = 1 AND ST_CLASS = 1 AND ST_NUM = 1) AS T1
	JOIN (SELECT SJ_NUM FROM SUBJECT WHERE SJ_GRADE = 1 AND SJ_SEMESTER = 2 AND SJ_NAME = "국어") AS T2;
#1학년 1반 1번의 1학년 2학기 국어 성적을 100으로 추가할 때 쿼리
INSERT INTO SCORE(SC_ST_KEY, SC_SJ_NUM, SC_SCORE)
SELECT ST_KEY,SJ_NUM, 100
	FROM (SELECT ST_KEY FROM STUDENT WHERE ST_GRADE = 1 AND ST_CLASS = 1 AND ST_NUM = 1) AS T1
	JOIN (SELECT SJ_NUM FROM SUBJECT WHERE SJ_GRADE = 1 AND SJ_SEMESTER = 2 AND SJ_NAME = "국어") AS T2;


