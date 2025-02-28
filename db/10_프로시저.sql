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
	프로시저 구현;			-->비긴하고 델리미터 사이에 세미콜론 만나도 프로시저의 종료시점으로서 사용되지 않기 위해 ; 재정의
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



/*
프로시저에서 사용하는 문법
1. 변수 선언(세션변수는 SET @변수명 초기값) - 변수는 프로시저 시작 위치(BEGIN 바로 밑)에 모아놔야 함.(중간에 선언 불가)
프로시저 구현부에서의 변수 선언 방법은
DECLARE 변수명 자료형 [DEFAULT 초기값];

2. 검색 결과를 변수에 저장(그냥 변수 = 값; 하면 비교연산 SET 변수 = 값; 해야 대입연산)
SET 변수 = (SELECT 속성 FROM 테이블명 [WHERE ...]);		-- SELECT문에서는 원하는걸 찾은 뒤에 꼭 전체를 괄호로 묶어야 함

3. 조건문 - IF
IF 조건식 THEN 
	실행문;
ELSEIF 조건식 THEN		-- ELSE IF 아님 유의 
	실행문;
ELSE
	실행문;
END IF;

4. 조건문 - CASE 	
CASE 변수 
	WHEN 값 THEN 
		실행문;
	WHEN 값 THEN 
		실행문;
	ELSE
		실행문;
END CASE;

5. 반복문 - WHILE
WHILE 조건식 DO
	실행문; 
END WHILE;

6. 반복문 - REPEAT 
REPEAT 
	실행문;
UNTIL 조건식
END REPEAT;

7. 반복문 - CURSOR 
	- 검색 결과를 한행씩 가져와서 반복문으로 활용
DECLARE 변수명 BOOLEAN DEFAULT FALSE;
DECLARE 커서명 CURSOR FOR SELECT 속성들 FROM 테이블명; -- SELECT에서 나온 검색 결과들을 반복문에 사용
DECLARE CONTINUE HANDLER FOR NOT FOUND SET 변수명 = TRUE;
OPEN 커서명;
루프명 : LOOP
FETCH 커서명 INTO 변수명1, ...;
IF 변수명A THEN 
	LEAVE 루프명;
END IF; 
반복문의실행문; 
END LOOP; 
CLOSE 커서명; 

*/

-- 프로시저 만들어서 확인  -> 02 DDL에 AVERAGE 테이블 추가

# AVERAGE 테이블에 등록된 학생만큼 1학년 1학기~ 3학년 2학기 평균 초기 데이터를 추가하는 프로시저 작성 

DROP PROCEDURE IF EXISTS INIT_AVERAGE;
DELIMITER //
CREATE PROCEDURE INIT_AVERAGE()
BEGIN
	DECLARE _COUNT INT;	-- 초기값 선언할 필요는 x
    DECLARE _DONE BOOLEAN DEFAULT FALSE;
    DECLARE _ST_KEY INT;
    
    DECLARE _GRADE INT DEFAULT 1;
    DECLARE _SEMESTER INT DEFAULT 1;
														-- DECLARE 된 변수를 사용하기 때문에 얘네 둘을 제일 밑으로
	DECLARE _CURSOR CURSOR FOR SELECT ST_KEY FROM STUDENT; -- 학생 기본키를 속성으로 가져와서 외래키로 넣으려고
    DECLARE CONTINUE HANDLER FOR NOT FOUND SET _DONE = TRUE;
    
    SET _COUNT = (SELECT COUNT(*) FROM AVERAGE);
	IF _COUNT = 0 THEN  -- 0 일때 초기화 
		OPEN _CURSOR;
        CURSOR_LOOP : LOOP
			FETCH _CURSOR INTO _ST_KEY;
            SET _GRADE = 1;-- 초기화
	
            IF _DONE THEN
				LEAVE CURSOR_LOOP;
			END IF;
            
            WHILE _GRADE <= 3 DO
				REPEAT
					INSERT AVERAGE(AV_ST_KEY, AV_GRADE, AV_SEMESTER, AV_SUM, AV_COUNT)
                    VALUES(_ST_KEY, _GRADE, _SEMESTER, 0, 0);								-- DEFAULT값을 안넣어줘서 여기서 값 넣어줌... 
                    SET _SEMESTER = _SEMESTER + 1;
                UNTIL _SEMESTER > 2  -- 얘가 참이 되면 종료하는
                END REPEAT;
                SET _SEMESTER = 1;					-- 한사람당 성적 6개(1학년 1,2학기 2학년 1,2학기 3학년 1,2학기) ->22명 X 6개... 실행시 132개의 결과가 나오면 됨 						
                SET _GRADE = _GRADE + 1;
			END WHILE;
            
		END LOOP;
        CLOSE _CURSOR;
    END IF;
		
END // 
DELIMITER ;
CALL INIT_AVERAGE();

-- 프로그램의 맨 뒤에는 세미콜론 안 붙여도 괜찮음.
# AVERAGE 테이블에 SUM과 COUNT를 모두 0으로 초기화
DROP PROCEDURE IF EXISTS ZERO_SUM_COUNT;

DELIMITER //
CREATE PROCEDURE ZERO_SUM_COUNT() 
BEGIN 
	UPDATE AVERAGE SET AV_SUM = 0, AV_COUNT = 0;
END // 
DELIMITER ;
CALL ZERO_SUM_COUNT(); 





DROP PROCEDURE IF EXISTS CALC_AVERAGE; -- 위에 학생 평균 그대로 가져와 제로썸 넣어줌
DELIMITER //
CREATE PROCEDURE CALC_AVERAGE()
BEGIN
	-- DECLARE _COUNT INT;	-- 초기값 선언할 필요는 x
    DECLARE _DONE BOOLEAN DEFAULT FALSE;
    DECLARE _SC_ST_KEY INT;
    DECLARE _SC_SCORE INT;
    
    DECLARE _SC_GRADE INT;	-- 여기서는 검색할 값 넣을 거기 때문에 DEFAULT초기값 안 넣어줘도 됨 
    DECLARE _SC_SEMESTER INT;
														
	-- DECLARE _CURSOR CURSOR FOR SELECT ST_KEY FROM STUDENT;
    DECLARE _CURSOR CURSOR FOR SELECT SC_ST_KEY, SC_SCORE, SJ_GRADE AS SC_GRADE, SJ_SEMESTER AS SC_SEMESTER FROM SCORE JOIN SUBJECT ON SC_SJ_NUM = SJ_NUM; -- SELECT 문이 따로 없으니 JOIN -- AS로 밑에 이름 그대로 쓰려고
    DECLARE CONTINUE HANDLER FOR NOT FOUND SET _DONE = TRUE;
    
    CALL ZERO_SUM_COUNT(); 		-- 데이터가 많으면 전에 한거 다 날리고 또 해야하니 좋은 작업은 아님
    
	
		OPEN _CURSOR;
        CURSOR_LOOP : LOOP
        
			FETCH _CURSOR INTO _SC_ST_KEY, _SC_SCORE, _SC_GRADE, _SC_SEMESTER;		-- 커서에 넣은거랑 맞추면 됨
                        			
            IF _DONE THEN
				LEAVE CURSOR_LOOP;
			END IF;
            
            UPDATE AVERAGE SET AV_SUM = AV_SUM + _SC_SCORE, AV_COUNT = AV_COUNT + 1 WHERE AV_GRADE = _SC_GRADE AND AV_SEMESTER = _SC_SEMESTER AND AV_ST_KEY = _SC_ST_KEY;
            
		END LOOP;
        CLOSE _CURSOR;
    
		
END // 
DELIMITER ;
CALL CALC_AVERAGE();
