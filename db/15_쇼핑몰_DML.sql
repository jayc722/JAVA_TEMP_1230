# 회원이 다음 정보로 회원가입 했을때 필요한 쿼리
# 아이디 : abc123 비번 : abc123 이메일 : abc123@db.com 전화번호 111-1234-5678 

INSERT INTO MEMBER(ME_ID, ME_PW, ME_EMAIL, ME_NUMBER)
VALUES("abc123", "abc123", "abc123@db.com", "111-1234-5678");

# 관리자가 다음 정보로 회원가입을 했을때 필요한 쿼리
# 아이디 : admin123 비번 : admin123 이메일 : admin123@db.com 전화번호 111-1111-2222 

INSERT INTO MEMBER(ME_ID, ME_PW, ME_EMAIL, ME_NUMBER, ME_AUTHORITY)
VALUES("admin123", "admin123", "admin123@db.com", "111-1111-2222", "ADMIN");

# 카테고리 등록 시 필요한 쿼리 
# 상의 : TOP 하의 : PAN 악세사리 : ACC 모자 : CAP 신발 : SHO 

INSERT INTO CATEGORY(CA_NAME, CA_CODE) VALUES
("상의", "TOP"), ("하의", "PAN"), ("악세사리", "ACC"), ("모자", "CAP"), ("신발", "SHO");



#제품을 등록하기 위한 프로시저를 만드시오

DROP PROCEDURE IF EXISTS INSERT_PRODUCT;
DELIMITER //

CREATE PROCEDURE INSERT_PRODUCT(
	# 5개의 변수를 선언
	IN _CA_CODE CHAR(3),
    IN _TITLE VARCHAR(100),
    IN _CONTENT LONGTEXT,
    IN _PRICE INT,
    IN _THUMB VARCHAR(200)
    )
BEGIN
	# 구현 
    DECLARE _COUNT INT DEFAULT 0;
    DECLARE _COUNT_STR VARCHAR(3);
    DECLARE _PR_CODE CHAR(6);
    DECLARE _CA_NUM INT;
    
    # COUNT = (PR_CODE가 _CA_CODE로 시작하는 제품의 개수) + 1
	SET _COUNT = (SELECT COUNT(*) FROM PRODUCT WHERE PR_CODE LIKE CONCAT(_CA_CODE, '%')) + 1;
    # LIKE로 CA CODE로 시작하는 프로덕트 선택. '%'(그냥 0글자 이상) 혹은 "___"(문자 3개)
    # 제품의 개수를 이용하여 3자리 문자열을 만듦. 빈 자리는 앞에 0으로 채움.
    SET _COUNT_STR = LPAD(_COUNT, 3, "0");		-- 내장함수.SQL 참고 
    # 제품 코드는 _CA_CODE와 위에서 구한 3자리 문자열을 합해서 구함   -> 위에거랑 한줄로 합치면 변수선언 따로 안해도 되지만
    SET _PR_CODE = CONCAT(_CA_CODE, _COUNT_STR);
    # _CA_CODE를 이용해서 PR_CA_NUM을 구함 
    SET _CA_NUM = (SELECT CA_NUM FROM CATEGORY WHERE CA_CODE = _CA_CODE);
    
    # 위에서 구한 값들을 이용하여 INSERT문 작성 
    INSERT PRODUCT(PR_CODE, PR_TITLE, PR_CONTENT, PR_PRICE, PR_THUMB, PR_CA_NUM)
    VALUES(_PR_CODE, _TITLE, _CONTENT, _PRICE, _THUMB, _CA_NUM);
END // 
DELIMITER ;

# 워크벤치가 오타를 잘 못잡아주니 잘 확인해주는게 좋음 -> 변수이름 앞에 언더바 해서 구분하는
/*
SELECT COUNT(*) + 1 FROM PRODUCT WHERE PR_CODE LIKE CONCAT("TOP", '%');
-- 선언한 부분 시험 코드 
SELECT LPAD(1, 3, "0");	
SELECT CONCAT(1, 3);
SELECT CA_NUM FROM CATEGORY WHERE CA_CODE = "TOP";
*/

# 카테고리 ("상의", "TOP"), ("하의", "PAN"), ("악세사리", "ACC"), ("모자", "CAP"), ("신발", "SHO"); 

CALL INSERT_PRODUCT("TOP", "셔츠입니다.", "셔츠를 싸게 팝니다.", 10000, "/IMG/TOP_01.JPG");
CALL INSERT_PRODUCT("TOP", "반팔", "반팔입니다.", 5000, "/IMG/TOP_02.JPG");
CALL INSERT_PRODUCT("TOP", "긴팔", "긴팔입니다.", 15000, "/IMG/TOP_03.JPG");

CALL INSERT_PRODUCT("PAN", "반바지", "시원한 반바지입니다.", 7000, "/IMG/PAN_01.JPG");
CALL INSERT_PRODUCT("PAN", "청바지", "스타일한 반바지입니다.", 30000, "/IMG/PAN_02.JPG");
CALL INSERT_PRODUCT("PAN", "면바지", "편한 반바지입니다.", 40000, "/IMG/PAN_03.JPG");

CALL INSERT_PRODUCT("ACC", "반지", "14K 커플링", 500000, "/IMG/ACC_01.JPG");
CALL INSERT_PRODUCT("ACC", "목걸이", "14K 목걸이", 1000000, "/IMG/ACC_02.JPG");
CALL INSERT_PRODUCT("ACC", "순금반지", "1돈 돌반지", 4000000, "/IMG/ACC_03.JPG");

CALL INSERT_PRODUCT("CAP", "빈티지 모자", "빈티지한 모자", 50000, "/IMG/CAP_01.JPG");
CALL INSERT_PRODUCT("CAP", "마술모자", "마술스러운 모자", 10000, "/IMG/CAP_02.JPG");
CALL INSERT_PRODUCT("CAP", "빵모자", "빵빵한 모자", 40000, "/IMG/CAP_03.JPG");

CALL INSERT_PRODUCT("SHO", "장화", "방수 장화", 5000, "/IMG/SHO_01.JPG");
CALL INSERT_PRODUCT("SHO", "운동화", "운동용 런닝화", 100000, "/IMG/SHO_02.JPG");
CALL INSERT_PRODUCT("SHO", "캐쥬얼화", "스타일 좋은 캐주얼화", 40000, "/IMG/SHO_03.JPG");
-- -------------------------------------------------------------------------------------------------------------------


# abc123 회원이 TOP001 제품을 장바구니에 3개 담았을 때 쿼리
INSERT INTO CART(CT_AMOUNT, CT_ME_ID, CT_PR_CODE) VALUES (3, "abc123", "TOP001");

# abc123 회원이 SHO001 제품을 장바구니에 1개 담았을 때 쿼리
INSERT INTO CART(CT_AMOUNT, CT_ME_ID, CT_PR_CODE) VALUES (1, "abc123", "SHO001");
-- -------------------------------------------------------------------------------------------------------------------
#abc123 회원이 장바구니에 담긴 모든 제품을 구매할 때 쿼리

#구매테이블에 총 가격과 구매자를 추가하는 쿼리
INSERT INTO BUY(BU_TOTAL_PRICE, BU_ME_ID) -- DATE는 DEFAULT CURRENT_TIMESTAMP, STATE 도 DEFAAULT고 FINAL DATE는 여기선 필요없으니 이 둘만 넣으면 됨. 
VALUES("50000","abc123");		-- 프로시저로 금액 더해줄수 있지만 여기선 우선 INSERT만

#구매 리스트에 장바구니에 담김 제품들을 추가하는 쿼리
-- SELECT MAX(BU_NUM) FROM BUY; -- 확인용
INSERT INTO BUY_LIST(BL_AMOUNT, BL_PRICE, BL_BU_NUM, BL_PR_CODE) SELECT 3, 30000, MAX(BU_NUM), "TOP001" FROM BUY;
INSERT INTO BUY_LIST(BL_AMOUNT, BL_PRICE, BL_BU_NUM, BL_PR_CODE) SELECT 1, 20000, MAX(BU_NUM), "SHO001" FROM BUY;

#장바구니에 있는 목록들을 제거하는 쿼리
DELETE FROM CART WHERE CT_ME_ID = 'abc123' AND CT_PR_CODE = 'TOP001';
DELETE FROM CART WHERE CT_ME_ID = 'abc123' AND CT_PR_CODE = 'SHO001';


-- -------------------------------------------------------------------------------------------------------------------
# abc123 회원이 구매한 제품들을 "구매 확정"했을 때의 쿼리

UPDATE BUY
SET BU_STATE = "구매확정", BU_FINAL_DATE = NOW() WHERE BU_ME_ID = "abc123" 	# 원래는 BU NUM을 이용하는게 맞음
;



