# TCL 트랜잭션 제어 언어

# 트랜잭션 : DB 상태를 변화(수정추가삭제) 시키기 위해 수행하는 작업단위
# START TRANSACTION / BEGIN / BEGIN WORK : 트랜잭션을 시작

# SVAEPOINT 저장명 : 임시로 지정할 위치를 지정
# ROLLBACK TO 저장명 : 저장명 전 상태로 되돌림
# ROLLBACK : 트랜잭션 시작 전 상태로 되돌림
# COMMIT : 지금까지의 작업을 반영

SELECT * FROM SCORE;                                                                                                                                                                       

START TRANSACTION;			-- 롤백전까진 두번째꺼 열어도 무시됨...

UPDATE SCORE SET SC_SCORE = 90 WHERE SC_NUM = 1;

SAVEPOINT S1;

UPDATE SCORE SET SC_SCORE = 90 WHERE SC_NUM = 2;

SAVEPOINT S2;

ROLLBACK TO S1;
# ROLLBACK TO S2;	-- S1으로 돌아갔기에 이러면 못감
# ROLLBACK;

SELECT * FROM SCORE;


ROLLBACK;
COMMIT;


