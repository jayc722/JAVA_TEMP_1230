# 트리거

# 테이블에 발생한 이벤트에 반응해 자동으로 실행되는 작업 - > 데이터 무결성 확보 가능
													-- EX. 쇼핑몰 데이터 관리 中 재고량 + 판매량 == 입고량  -- > 합이 맞아야하는데 안맞으면 그걸 지켜줘야 (안맞으면 그만큼 재고에서 빼도록 작동) 
# 이벤트 : INSERT, UPDATE, DELETE ( 데이터가 추가, 수정, 삭제되었을 때 작동 ) -- 트리거 발생한 테이블과 수정하려는 테이블이 같으면 에러 발생!!! 


# 트리거 확인하는 쿼리
-- USE SAKILA;			-- STUDENT는 아직 트리거 등록 안해서 SKAKILA에서 확인 
-- SHOW TRIGGERS; 
-- USE STUDENT;


# 트리거 삭제 
-- DROP TRIGGER IF EXISTS 트리거명;

# 트리거 등록 -- 프로시저랑 다르게 호출을 따로 하지는 X
/*
DELIMITER 기호 
CREATE TRIGGER 트리거명 TRIGGER_TIME TRIGGER_EVENT ON 테이블명 
FOR EACH ROW
BEGIN
	실행문; 
END 기호
DELIMITER ;

	- TRIGGER_TIME : 트리거 동작되는 시점. BEFORE | AFTER
    - TRIGGER_EVENT : 트리거가 실행되는 이벤트. INSERT | UPDATE | DELETE 
    - 트리거 안에서 사용되는 키워드 
				- OLD : DELETE,UPDATE 하기전 데이터. OLD.속성을 통해 활용할 수 있음.
				- NEW : INSERT, IPDATE 한 후 데이터. NEW.속성을 통해 활용할 수 있음. 
                
*/


# 학생 성적이 추가되면 학생 평균을 수정하는 트리거 
DROP TRIGGER IF EXISTS INSERT_SCORE; 


DELIMITER //
CREATE TRIGGER INSERT_SCORE AFTER INSERT 
ON SCORE 				-- 스코어 테이블 
FOR EACH ROW 			-- 각 행마다
BEGIN					-- 합계와 최종 스코아 1씩 증가시키려고 
	-- UPDATE AVERAGE SET AV_SUM = AV_SUM + ??, AV_COUNT = AV_COUNT + 1 WHERE AV_GRADE = ?? AND AV_SEMESTER = ?? AND AV_ST_KEY = ??;
    
    DECLARE _AV_GRADE INT;
    DECLARE _AV_SEMESTER INT;

	SET _AV_GRADE = (SELECT SJ_GRADE FROM SUBJECT WHERE SJ_NUM = NEW.SC_SJ_NUM);
    SET _AV_SEMESTER = (SELECT SJ_SEMESTER FROM SUBJECT WHERE SJ_NUM = NEW.SC_SJ_NUM);
    
    UPDATE AVERAGE 
    SET 
		AV_SUM = AV_SUM + NEW.SC_SCORE, 
		AV_COUNT = AV_COUNT + 1 
	WHERE 
		AV_GRADE = _AV_GRADE AND AV_SEMESTER = _AV_SEMESTER AND AV_ST_KEY = NEW.SC_ST_KEY;
END // 
DELIMITER ;				-- DELIMITER 띄고 ; 해야되네... 

# INSERT INTO SCORE(SC_ST_KEY, SC_SJ_NUM, SC_SCORE) VALUES(16,13,100);		-- 추가되면 자동 실행 -> 데이터 무결성 지켜줌
