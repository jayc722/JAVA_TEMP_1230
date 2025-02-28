# CREATE : 생성 ALTER : 수정 DROP : 삭제 TRUNCATE : 테이블 초기화

# []는 생략 가능이라는 의미


# 데이터베이스 생성
# CREATE DATABASE [IF NOT EXISTS] DB명
# CREATE SCHEMA [IF NOT EXISTS] DB명

DROP DATABASE IF EXISTS STUDENT;		-- 전체코드 실행시 에러방지
-- CREATE DATABASE STUDENT; -- 이미 존재하면 에러코드 발생 -> 정지
CREATE DATABASE IF NOT EXISTS STUDENT;                                                                                                                                                                                                                                                                                                                                                                                                                                                       

-- CREATE DATABASE STUDENT; -- IF NOT EXISTS가 없으면 DB 생성하려는 경우 쿼리에 에러 발생
-- CREATE DATABASE STUDENT2; -- -> 이후 쿼리 실행X


# 데이터 베이스 삭제
# DROP DATABASE [IF EXISTS] DB명
# DROP SCHEMA [IF EXISTS] DB명
# DROP DATABASE IF EXISTS STUDENT; 

# 데이터 베이스 문자 집합을 설정할 때
# ALTER SCHEMA DB명 DEFAULT CHARACTER SET 새 SCHARSET DEFAULT COLLATE 새COLLATE;

# 테이블 생성
/*
CREATE TABLE [IF NOT EXISTS] 테이블명(
	컬럼명(속성이름) 타입 [ZEROFILL] [UNIQUE] [NOT NULL] [DEFAULT값] [PRIMARY KEY] [AUTO_INCREMENT],(여기까지는 띄어쓰기로 구분하고)
    ...,(여러 타입들이 나올수있음)
    [ CONSTRAINT 제약조건명 PRIMARYKEY(컬럼명),](여기부터는 콤마로 구분)
	-- [ CONSTRAINT생략하고 PRIMARYKEY(컬럼명)만 쓸수도,] -> 저 위 애들중에 그냥 PRIMARY KEY쪽이 더 간편
    [ CONSTRAINT 제약조건명 FOREIGN KEY(컬럼명) REFERENCES 참조테이블명(기본키명),]
    -- [ 제약조건 생략해서 FOREIGN KEY(컬럼명) REFERENCES 참조테이블명(기본키명),]
    [ CONSTRAINT 제약조건명 CHECK(논리식)]
    -- [ 얘도 생략가능 CHECK(논리식)] -- 제약조건 있어야 삭제시 검색가능
);

ZEROFILL
	- 앞에 0으로 채울 때 사용
    - 5자리 숫자로 정하고, 1을 저장했을 때 앞의 4자리를 0으로 채움
UNIQUE
	- 컬럼의 값들이 중복되면 안되는 경우 지정.(보통 대체키에)
NOT NULL
	- 컬럼이 NULL값을 가지면 안될때 사용(EX 나이, 성적,... 기본값이 필요한 애들)
PRIMARY KEY
	- 기본키
    - 제약조건으로 설정할 수도 있지만 컬럼명 옆에 지정할수 있음
    - NOT NULL + UNIQUE
AUTO_INCREMENT
	- 기본키에만 가능. 정수형 속성에 지정가능
    - 데이터를 추가할때 기본키에 값을 지정하지 않으면 자동으로 1 증가되어서 추가됨
    
*/

-- 논리적 설계로 구상된 학생테이블 구성

USE STUDENT;	-- STUDENT 선언
DROP TABLE IF EXISTS STUDENT; -- 전체코드 실행시 에러방지
CREATE TABLE IF NOT EXISTS STUDENT( 						-- 테이블 속성 무조건 하나는 있어야...없어서 오타뜨는
	ST_KEY INT PRIMARY KEY AUTO_INCREMENT, 				-- 학생번호(대리키) -- 개발자 성향인데 속성이름 안겹치게 하려고 테이블 이름 앞에 붙여서 쓰는
	ST_GRADE INT NOT NULL DEFAULT 1,						-- 학년, NULL허용 안함, 기본값 1
    ST_CLASS INT NOT NULL DEFAULT 1,
    ST_NUM INT NOT NULL DEFAULT 1,	
    ST_NAME VARCHAR(20) NOT NULL,							-- 이름. 글자수 달라질수 있으니 VARCHAR로. 최대 20글자. NULL허용X. 기본값은 X
    CHECK(ST_GRADE >= 1),
    CHECK(ST_CLASS >= 1),
    CHECK(ST_NUM >= 1)
);

# 테이블 삭제
# DROP TABLE [IF EXISTS] 테이블명;
# DROP TABLE STUDENT;

# 테이블 수정 - 컬럼 추가
# ALTER TABLE 테이블명 ADD 컬럼명 데이터타입 [...]->아까 위에서 한 애들;
ALTER TABLE STUDENT ADD ST_TEST DATETIME DEFAULT CURRENT_TIMESTAMP;

# 테이블 수정 - 컬럼 수정
# ALTER TABLE 테이블명 CHANGE 기존컬럼명 새컬럼명 타입 [...];
ALTER TABLE STUDENT CHANGE ST_TEST TEST CHAR(3) NOT NULL;

# 테이블 수정 - 컬럼 삭제
# ALTER TABLE 테이블명 DROP 컬럼명;
ALTER TABLE STUDENT DROP TEST;

# 등록된 모든 제약 조건 확인
SELECT * FROM INFORMATION_SCHEMA.CHECK_CONSTRAINTS;

# 테이블 수정 - 제약 조건 추가
# ALTER  TABLE ADD CONSTRAINT 제약조건명 제약조건
ALTER TABLE STUDENT ADD CONSTRAINT STUDENT_CHK4 CHECK(ST_NAME != '');		-- 빈 문자열이 아닌 경우 (!= 과 <> 같은 의미)

# 테이블 수정 - 제약 조건 삭제
# ALTER TABLE 테이블명 DROP CONSTRAINT 제약조건명;
# ALTER TABLE SUDENT DROP CONSTRAINT STUDENT_CHK4;

# 테이블 초기화 : AUTO_INCREMENT 값을 1로 초기화 및 데이터 제거
# TRUNCATE TABLE 테이블명;


/*
INSERT INTO STUDENT.STUDENT(ST_GRADE, ST_CLASS, ST_NUM, ST_NAME)
VALUES(1,1,1, "홍길동"), (1,1,2,"임꺽정");
SELECT * FROM STUDENT.STUDENT;
-- 원래 중복체크 해야하는데 일단은 그냥
INSERT INTO STUDENT.STUDENT(ST_GRADE, ST_CLASS, ST_NUM, ST_NAME)
VALUES(1,1,3, "홍길동2"), (1,1,4,"임꺽정2");			
SELECT * FROM STUDENT.STUDENT;

TRUNCATE TABLE STUDENT.STUDENT;
# DELETE TABLE STUDENT.STUDENT;

*/ 
-- 얘는 TRUNCATE DELETE 차이 보려는거고 DML 파트기때문에 주석처리

DROP TABLE IF EXISTS SUBJECT;

CREATE TABLE STUDENT.SUBJECT(
	SJ_NUM INT PRIMARY KEY AUTO_INCREMENT,
    SJ_GRADE INT NOT NULL DEFAULT 1,
    SJ_SEMESTER ENUM("1","2") NOT NULL DEFAULT "1",				-- 열거형(문자열, 숫자를 못넣음) -> 굳이 숫자로 표현하고 싶으면 ENUM이 아니라 INT로 1 2 만든다음에 CHECK 이용해야
    SJ_NAME VARCHAR(10) NOT NULL,				-- 얘는 기본값이 X
    CHECK(SJ_GRADE IN(1,2,3)) 
);

DROP TABLE IF EXISTS STUDENT.SCORE;

CREATE TABLE STUDENT.SCORE(
	SC_NUM INT PRIMARY KEY AUTO_INCREMENT,
	SC_ST_KEY INT NOT NULL,									-- 외래키는 외래키인거 바로 알수있게 테이블 이름 쓰고 키 이름( 이건 강사님 취향 )  -- 외래키는 상대 테이블 타입과 맞춰야 함
    SC_SJ_NUM INT NOT NULL,
    SC_SCORE INT NOT NULL DEFAULT 0,
    CHECK(SC_SCORE BETWEEN 0 AND 100),
    FOREIGN KEY(SC_ST_KEY) REFERENCES STUDENT.STUDENT(ST_KEY),
	FOREIGN KEY(SC_SJ_NUM) REFERENCES STUDENT.SUBJECT(SJ_NUM)
);


-- 10.프로시저에서 넘어옴
DROP TABLE IF EXISTS STUDENT.AVERAGE;

CREATE TABLE STUDENT.AVERAGE(
	AV_NUM INT PRIMARY KEY AUTO_INCREMENT,
    AV_ST_KEY INT NOT NULL,
    AV_GRADE INT NOT NULL,
    AV_SEMESTER INT NOT NULL,
    AV_SUM INT NOT NULL,			-- 평균을 하려는데 평균치를 저장하면 추가 등에서 귀찮으니 SUM과 전체개수 COUNT 를 각각 지정해서 평균치로 이용함 
    AV_COUNT INT NOT NULL,
    FOREIGN KEY(AV_ST_KEY) REFERENCES STUDENT.STUDENT(ST_KEY)
);
-- 학생 성적은 1학년 1학기 2학년 1학기... 고정


-- ALTER TABLE STUDENT DROP CONSTRAINT STUDENT_CHK4
