/*
다음을 만족하는 쿼리를 작성해서 데이터베이스와 테이블을 생성하시오.
데이터베이스명 : COMMUNITY
테이블명 : BOARD
- 게시글을 제목, 내용, 작성자를 입력하여 등록
- 제목은 최대 50자, 내용은 긴 문자열, 작성자는 최대 15자
- 게시글은 게시글 목록에서 번호, 제목, 작성자, 작성일, 조회수를 확인할 수 있다.
- 작성일은 년,월,일,시,분,초를 확인할 수 있다.

*/


CREATE DATABASE IF NOT EXISTS COMMUNITY;
CREATE TABLE IF NOT EXISTS BOARD(
	BD_KEY INT PRIMARY KEY AUTO_INCREMENT,
    BD_TITLE VARCHAR(50) NOT NULL,						
    BD_CONTENT LONGTEXT NOT NULL,
    BD_USER VARCHAR(15) NOT NULL,	
    BD_DATE DATETIME NOT NULL,
    BD_VIEW INT NOT NULL DEFAULT 1
);


INSERT INTO STUDENT(BD_TITLE,BD_CONTENT,BD_USER) VALUES("제목1","내용1","작성자1"), ("제목2","내용2","작성자2");

SELECT * FROM BOARD;
