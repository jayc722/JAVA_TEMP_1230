# 카테고리 상의를 클릭했을 때 조회하는 쿼리


# CA_NUM을 안다면 그냥 찾으면 되는데
SELECT * FROM PRODUCT WHERE PR_CA_NUM = 1;

#만약 모르면... 서브쿼리 사용해서
SELECT * FROM PRODUCT 
WHERE PR_CA_NUM = (SELECT CA_NUM FROM CATEGORY WHERE CA_NAME = '상의');

#JOIN 이용해서?
SELECT * FROM PRODUCT 
JOIN CATEGORY ON CA_NUM = PR_CA_NUM
WHERE CA_NAME = '상의';

#CA CODE 이용해서
SELECT * FROM PRODUCT 
WHERE PR_CA_NUM = (SELECT CA_NUM FROM CATEGORY WHERE CA_CODE = 'TOP');
#CA CODE 이용해서 CONCAT으로
SELECT * FROM PRODUCT 
WHERE PR_CODE LIKE CONCAT('TOP', '%');


-- ---------------------------------------------------------------------------------

# abc123 회원이 구매한 제품들 목록을 조회하는 쿼리(동일제품 여러개 구매하면 하나만 나오도록)
-- SELECT * FROM BUY_LIST WHERE BL_BU_NUM =(SELECT BU_NUM FROM BUY WHERE BU_ME_ID = "abc123");
-- 내가한거 안되네... #SELECT * FROM PRODUCT WHERE PR_CODE = (SELECT BL_PR_CODE FROM BUY_LIST WHERE BL_BU_NUM =(SELECT BU_NUM FROM BUY WHERE BU_ME_ID = "abc123"));
SELECT * FROM BUY
JOIN BUY_LIST ON BU_NUM = BL_BU_NUM
JOIN PRODUCT ON PR_CODE = BL_PR_CODE
WHERE BU_ME_ID = 'abc123';

-- 이렇게 하면 되긴 하는데 같은품목 여러번 사면 그 횟수만큼 나옴... -> 이걸 한품목당 하나만 나오게 하고 싶다면

SELECT DISTINCT PRODUCT.* FROM BUY
JOIN BUY_LIST ON BU_NUM = BL_BU_NUM
JOIN PRODUCT ON PR_CODE = BL_PR_CODE
WHERE BU_ME_ID = 'abc123';

-- ---------------------------------------------------------------------------------

# 제품 가격이 만원 이상인 제품들만 조회하는 쿼리
SELECT * FROM PRODUCT WHERE PR_PRICE >= 10000;
# 제품을 높은 금액 순으로 조회하는 쿼리
SELECT * FROM PRODUCT ORDER BY PR_PRICE DESC;

# 제품별 판매 개수를 조회하는 쿼리	=> OUTER JOIN, SUM()  / BUY_LIST와 PRODUCT만 JOIN 하면 됨... 누가 했는지는 관심 없으니 BUY는 필요X. SUM은 GROUP BY로 
							-- INNER JOIN 하면 판매 안된 제품은 조회X

SELECT * FROM PRODUCT		-- PRODUCT가 왼쪽에 있으니 PRODUCT 기준으로 LEFT JOIN
LEFT JOIN BUY_LIST ON PR_CODE = BL_PR_CODE		
-- GROUP BY PR_CODE			-- 중복되지 않은 데이터들이 있어서 그냥 이렇게만 하면 ERROR
;	-- 이렇게 하면 판매량이 0인 제품이 0으로 뜨니 아래 코드로

SELECT PRODUCT.*, IFNULL(SUM(BL_AMOUNT),0) AS 판매수 FROM PRODUCT
LEFT JOIN BUY_LIST ON PR_CODE = BL_PR_CODE		
GROUP BY PR_CODE;


# 판매량이 제일 많은 제품을 조회하는 쿼리


SELECT PRODUCT.*, IFNULL(SUM(BL_AMOUNT),0) AS 판매수 FROM PRODUCT
LEFT JOIN BUY_LIST ON PR_CODE = BL_PR_CODE		
GROUP BY PR_CODE
ORDER BY 판매수 DESC
LIMIT 1; -- 판매량이 같은 경우 가나다순으로 1개만 선택하기때문에 RANK 사용 (1등만 뽑을거면 RANK()나 DENSE_RANK()나 차이없긴 한데)


SELECT DENSE_RANK() OVER(ORDER BY 판매수 DESC) RNK, BUY_PRODUCT.* FROM ( 
SELECT PRODUCT.*, IFNULL(SUM(BL_AMOUNT),0) AS 판매수 FROM PRODUCT
LEFT JOIN BUY_LIST ON PR_CODE = BL_PR_CODE		
GROUP BY PR_CODE) BUY_PRODUCT
-- WHERE RNK=1 -- 랭크를 띄울 수는 있지만 띄운 랭크로 바로 검색에 사용할수는 X
;

SELECT * FROM (
SELECT DENSE_RANK() OVER(ORDER BY 판매수 DESC) RNK, BUY_PRODUCT.* FROM (
SELECT PRODUCT.*, IFNULL(SUM(BL_AMOUNT),0) AS 판매수 FROM PRODUCT
LEFT JOIN BUY_LIST ON PR_CODE = BL_PR_CODE		
GROUP BY PR_CODE) BUY_PRODUCT) T
WHERE RNK=1 -- 이렇게 하면 중복 허용 랭크
;



#카테고리 별 최고 금액의 제품들을 조회하는 쿼리

#먼저 카테고리별 최고 금액 조회
SELECT PR_CA_NUM 카테고리, MAX(PR_PRICE) 최고금액 FROM PRODUCT GROUP BY PR_CA_NUM;

SELECT * FROM PRODUCT 
JOIN (SELECT PR_CA_NUM 카테고리, MAX(PR_PRICE) 최고금액 FROM PRODUCT GROUP BY PR_CA_NUM) T		-- 위에서 한 카테고리별 최고금액과 JOIN
ON PR_CA_NUM = 카테고리 
WHERE PR_PRICE = 최고금액
ORDER BY 카테고리;



# 사용자 별 누적 구매액 조회  
# OUTER JOIN => 구매 내역이 없는 사용자도 조회
# GROUP BY , SUM(내장함수) : 사용자별 구매액을 계산 
SELECT * FROM USER 
JOIN (SELECT SUM(BU_ME_ID) FROM BUY)		
ON ME_ID;

/* -- 내가한거... 안되네
SELECT BUY.*, IFNULL(SUM(BU_TOTAL_PRICE),0) AS 구매액 FROM BUY
LEFT JOIN BUY ON ME_ID = BU_ME_ID		
GROUP BY ME_ID;
*/

-- 구매액만
SELECT BU_ME_ID, SUM(BU_TOTAL_PRICE) AS 누적구매액 FROM BUY
GROUP BY BU_ME_ID;

-- JOIN 해서 --> 구매내역 NULL 인 사용자도 표시되게
SELECT ME_ID, IFNULL(SUM(BU_TOTAL_PRICE),0) AS 누적구매액 FROM BUY
RIGHT JOIN MEMBER ON ME_ID = BU_ME_ID
GROUP BY ME_ID;


# 반으로 제품을 검색했을 때 조회하는 쿼리 
SELECT * FROM PRODUCT
WHERE PR_CONTENT LIKE CONCAT('%', '반', '%') OR PR_TITLE LIKE CONCAT('%', '반', '%');			-- 여기선 CONCAT 안붙여도 되지만 MYBATIS 연결하려면 붙이는게 좋음








