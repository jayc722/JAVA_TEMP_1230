DROP DATABASE IF EXISTS WINDOW_FUNC;

CREATE DATABASE WINDOW_FUNC;
USE WINDOW_FUNC;

CREATE TABLE TEAM_SCORE (
    TS_TEAM CHAR(1) PRIMARY KEY,
    TS_SCORE INT NOT NULL DEFAULT 0
);

INSERT INTO TEAM_SCORE VALUES("A",10),("B",5),("C",10),("D",10),("E",10),("F",9),("G",8);
# 윈도우 함수
# - 테이블의 행과 행 사이의 관계를 정의
# - OVER절이 들어간 함수
# - 순위를 표현


# A:10 B:5 C:10 D:10 E:10 F:9 G:8 점일때 순위 표현
# ROW_NUMBER() OVER(ORDER BY 속성 정렬방법)	: 값이 같더라도 다른 번호를 부여(한 등수에는 한 명만)


