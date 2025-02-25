/*
SELECT	
	*
FROM
	테이블명;
# 테이블에 있는 모든 속성들의 데이터를 '조회'하는 쿼리  ->특정 데이터 골라서(혹은 전부) 조회 
*/
USE STUDENT;

SELECT * FROM STUDENT;		-- * 은 ALL
							-- 위에처럼 여러줄로 가독성있게 해도 되지만 너무 짧아서 한줄로 해도 됨
                            
# SELECT 속성1, ..., 속성N FROM 테이블명;
# 테이블에 있는 속성1, ..., 속성N 의 데이터를 조회하는 쿼리
# 속성명 옆에 AS "새속성명" 입력하면 결과창에 속성 이름을 변경할 수 있음  -- AS 뒤에 오는 출력할 속성명에 공백이 없으면 따옴표 생략해도 됨. AS도 생략해도 되는데 문법상 헷갈리지 말라고 써주는게... 

# 학생들의 학년, 반, 번호, 이름을 조회하는 쿼리? 
SELECT ST_GRADE AS 학년, ST_CLASS AS 반, ST_NUM 번호, ST_NAME AS "학생 이름" FROM STUDENT;



# SELECT [DISTINCT] 속성1, ..., 속성N FROM 테이블명 [WHERE 조건식];
# 조건식을 만족하는 속성들을 조회하는 쿼리. 중복된 행(기본키인 속성을 포함하지 않는 경우)은 제외 
# 등록된 학생들의 학년을 조회하는 쿼리?
-- SELECT * FROM STUDENT; -- 전체
-- SELECT ST_GRADE 학년 FROM STUDENT; -- 학년만 조회
SELECT DISTINCT ST_GRADE 학년 FROM STUDENT; -- 학년만 조회(중복된 값들은 하나만 표시)

# 1학년 학생들을 조회하는 쿼리?
SELECT * FROM STUDENT WHERE ST_GRADE = 1;

# 논리 연산자
# - AND, OR, NOT
# - AND의 우선순위가 보다 높음(괄호 잘 쳐야 함)
# 비교 연산자
# - =, <>, !=, <, <=, >= 
# - 속성 BETWEEN A AND B : A이상 B이하  ( 속성 >= A AND 속성 <=B 와 같음 ) -- 속성 NOT BETWEEN A AND B : A미만 또는 B 초과 ( 속성 < A OR 속성 > B )
# - 속성 IN(값1, ..., 값N) : 속성의 값이 값1, ..., 값N 중에 있을 때 참 ( 속성 = 값1 OR ... OR 속성 = 값N ) -- 속성 NOT INT(값1, ..., 값N) : 속성이 값이 " 중에 없을 때 참 ( 속성 != 값1 AND ... AND 속성 != 값N ) 
# - LIKE "패턴" : 패턴과 일치하는 값을 조회할 때 사용 ( 문자열 같다는 완전히 똑같은 애들만 )
#			패턴 : _(한글자) %(0글자 이상)		EX) 홍%(홍으로 시작하는 문자열) ___(3글자)
# - NULL 확인 : IS NULL(NULL이면 참) IS NOT NULL(NULL이 아니면 참)
   

# 1학년 1반의 번호가 1~3인 학생들을 조회하는 쿼리
SELECT * FROM STUDENT WHERE ST_NUM BETWEEN 1 AND 3;
SELECT * FROM STUDENT WHERE ST_NUM IN(1,2,3);

# 성이 홍씨인 학생들을 조회하는 쿼리
SELECT * FROM STUDENT WHERE ST_NAME LIKE "홍%";
# 이름에 길이 들어가는 학생들을 조회하는 쿼리
SELECT * FROM STUDENT WHERE ST_NAME LIKE "%길%";
# 성이 홍씨이고 이름이 3글자인 학생들을 조회하는 쿼리
SELECT * FROM STUDENT WHERE ST_NAME LIKE "홍__";
# 성이 홍씨가 아닌 학생들을 조회하는 쿼리
SELECT * FROM STUDENT WHERE ST_NAME NOT LIKE "홍%";




