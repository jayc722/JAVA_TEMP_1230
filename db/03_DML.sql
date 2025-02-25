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
FROM WHEN 






