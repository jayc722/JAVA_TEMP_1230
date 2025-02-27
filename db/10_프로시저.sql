# 프로시저 : 일련의 쿼리를 하나의 함수처럼 실행하기 위한 쿼리의 집합 ( 함수랑은 약간 다름 )

/*
프로시저 목록 확인
SHOW PROCEDURE STATUS;
프로시저 스크립트 확인 방법
SHOW CREATE PROCEDURE 프로시저명;
*/

# 프로시저 목록 확인
SHOW PROCEDURE STATUS;
# 프로시저 스크립트 확인
USE SAKILA; 		-- SAKILA DB에 있는 FILM_IN_STOCK 프로시저 확인
SHOW CREATE PROCEDURE FILM_IN_STOCK;		-- CREATE PROCEDURE 란에 있는 내용이 실제 만들게 될 내용


/*
프로시저 삭제
DROP PROCEDURE IF EXISTST 프로시저명;


프로시저 정의 : 
DELIMETER 기호
CREATE PROCEDURE 프로시저명(
	[IN|OUT|INOUT 변수명1,]		-- 함수의 매개변수에 해당 IN : 가져오는것(매개변수) OUT : 리턴 INOUT : 가져오기도 보내기도
    [...]
)
BEGIN
	프로시저 구현;			-->비긴하고 델리미터 사이에 세미콜론 만나도 사용되지 않기 위해 ; 재정의
END 기호 
DELIMETER; 			

-설명--------------
DELIMETER : 문장의 끝을 나타내는 기호를 새로 정할 때 사용(프로시저 안에 사용되는 세미콜론;이 프로시저를 정의하는 동안 실행되면 안되기 떄문. -->프로시저 정의하는 중에는 ;를 문장 끝 나타내는 기호처럼 사용X) --> 잘 안쓰는 기호로 정의할 것 
IN : 매개변수처럼 해당 값을 프로시저 안에서 사용 
OUT : 프로시저 안에서 나온 결과를 넘겨줄 때 사용 
INOUT : 매개변수처럼 값을 가져와서 프로시저에서 사용하고 결과를 받아서 밖에서 활용 

프로시저 호출
CALL 프로시저명(매개변수 또는 값듯);		-- >프로시저 호출한 개수만큼 넣어줘야 


*/


# 학생 성적을 추가할 때 성적이 0 미만 100 초과면 추가하지 않는 프로시저 (CHECK 제약조건으로도 해결 가능하긴 함)
USE STUDENT;
DROP PROCEDURE IF EXISTS INSERT_SCORE; 


DELIMITER //
CREATE PROCEDURE INSERT_SCORE(
	IN _ST_KEY INT,					-- PROCEDURE 내부에서 검색기능 사용 가능한데 속성이름과 겹치면 안될수가 있어서 변수앞에 언더바 붙여놓은 것 
    IN _SJ_NUM INT,
    IN _SCORE INT
    )
BEGIN
	IF _SCORE BETWEEN 0 AND 100 THEN
		INSERT INTO SCORE(SC_ST_KEY, SC_SJ_NUM, SC_SCORE) VALUES(_ST_KEY, _SJ_NUM, _SCORE);
    END IF;
END // 
DELIMITER ;

CALL INSERT_SCORE(16, 7, 90);	-- > 들어가짐(제일 하단에)
CALL INSERT_SCORE(16, 8, 150);	-- > 안들어가짐(점수가 100 초과)


# 프로시저 예제 
DROP PROCEDURE IF EXISTS P_TEST1;
DELIMITER //
CREATE PROCEDURE P_TEST1(
	IN _NUM INT,
    OUT _RES INT
    )
BEGIN
	SET _RES = _NUM * 2;
END // 
DELIMITER ;

# 세션 변수 VALUE 선언  -- > 세션 변수 : 세션이 유지되는 동안(세션과 DB가 연결돼있는) 유지되는 변수
SET @VALUE =  3;		-- 변수 생성, 초기값 설정(사용은 안함)
CALL P_TEST1(10, @VALUE);
SELECT @VALUE;



DROP PROCEDURE IF EXISTS P_TEST2;
DELIMITER //
CREATE PROCEDURE P_TEST2(
	INOUT _NUM INT
    )
BEGIN
	SET _NUM = _NUM * 2;
END // 
DELIMITER ;
		
CALL P_TEST2(@VALUE);
SELECT @VALUE;