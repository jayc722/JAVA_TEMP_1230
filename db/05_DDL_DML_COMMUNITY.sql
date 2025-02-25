/*
다음을 만족하는 쿼리를 작성해서 데이터베이스와 테이블을 생성하시오.
데이터베이스명 : COMMUNITY
테이블명 : BOARD
- 게시글을 제목, 내용, 작성자를 입력하여 등록
- 제목은 최대 50자, 내용은 긴 문자열, 작성자는 최대 15자
- 게시글은 게시글 목록에서 번호, 제목, 작성자, 작성일, 조회수를 확인할 수 있다.
- 작성일은 년,월,일,시,분,초를 확인할 수 있다.

*/
DROP DATABASE IF EXISTS COMMUNITY; -- 초기데이터 꼬였을 때 전체실행 한번 딸깍 하면 초기화되게 순서 바꿈

CREATE DATABASE COMMUNITY; -- IFNOTEXISTS 빼도 되는게 앞에 제거가 붙어서
USE COMMUNITY;

DROP TABLE IF EXISTS BOARD;
CREATE TABLE BOARD(
	BO_NUM INT PRIMARY KEY AUTO_INCREMENT,
    BO_TITLE VARCHAR(50) NOT NULL,						-- 제목 UNIQUE 넣을 필요 X
    BO_CONTENT LONGTEXT NOT NULL,
    BO_WRITER VARCHAR(15) NOT NULL,	
    BO_DATE DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,	-- CURRENT_TIMESTAMP 현재시간을 넣어줌
    BO_VIEW INT NOT NULL DEFAULT 0
);

# abc123 회원이 "인사"라는 제목으로 "안녕하세요"라는 내용을 작성했을 때 필요한 쿼리

INSERT INTO BOARD(BO_TITLE,BO_CONTENT,BO_WRITER) VALUES("제목1","내용1","작성자1"), ("제목2","내용2","작성자2");
INSERT INTO BOARD(BO_TITLE,BO_CONTENT,BO_WRITER) VALUES("인사","안녕하세요","abc123");

# 1번 게시글을 클릭해서 게시글 내용을 조회할 때 필요한 쿼리
-- SELECT BO_TITLE AS 제목, BO_WRITER AS 작성자, BO_CONTENT 내용, BO_DATE AS 날짜, BO_VIEW AS 조회수 FROM BOARD WHERE BO_NUM = 1;  -- 내가한거...

UPDATE BOARD SET BO_VIEW = BO_VIEW + 1 WHERE BO_NUM = 1;
SELECT * FROM BOARD WHERE BO_NUM = 1;		-- 얘가 조회수증가 위에 있으면 조회수 증가 안하고 출력됨

# abc123 회원이 1번 게시글을 삭제할 때 쿼리(아직은 작성자만 삭제가능한 기능은 도입X)
# DELETE FROM BOARD WHERE BO_NUM = 3;

# 2025S년 2월 25일에 작성한 게시글을 조회하는 쿼리
SELECT * FROM BOARD WHERE BO_DATE BETWEEN "2025-02-25" AND "2025-02-25 23:59:59";		-- 문자열이라도 DATE면 크기비교 가능

SELECT * FROM BOARD;
