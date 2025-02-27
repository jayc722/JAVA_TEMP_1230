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
SELECT * FROM STUDENT WHERE ST_NUM BETWEEN 1 AND 3 AND ST_CLASS = 1 AND ST_GRADE = 1;
SELECT * FROM STUDENT WHERE ST_NUM IN(1,2,3) AND ST_CLASS = 1 AND ST_GRADE = 1;

# 성이 홍씨인 학생들을 조회하는 쿼리
SELECT * FROM STUDENT WHERE ST_NAME LIKE "홍%";
SELECT * FROM STUDENT WHERE ST_NAME LIKE CONCAT("홍","%");	-- 내장함수 - 문자열 이어붙이기
# 이름에 길이 들어가는 학생들을 조회하는 쿼리
SELECT * FROM STUDENT WHERE ST_NAME LIKE "%길%";
# 성이 홍씨이고 이름이 3글자인 학생들을 조회하는 쿼리
SELECT * FROM STUDENT WHERE ST_NAME LIKE "홍__";
# 성이 홍씨가 아닌 학생들을 조회하는 쿼리
SELECT 
    *
FROM
    STUDENT
WHERE
    ST_NAME NOT LIKE '홍%';

/* 
정렬하는 쿼리 ORDER BY

SELECT [DISTINCT]
	속성1, ..., 속성N
FROM 
	테이블명
[WHERE
	조건]
[ORDER BY 속성A [ASC | DESC] [,속성B [ASC | DESC]]]	-- 대괄호는 생략가능 {ASC 오름차순(기본값) DESC 내림차순} {속성A 겹치면 속성B... 로 정렬할 때 콤마로 나열 가능}

->생략은 되는데 순서는 지켜야
->기본값은 번지순으로 정렬
*/


#3학년 2학년 1학년 순으로 조회하고 학년이 같은 경우 1반 2반 순으로 조회하고 반이 같은 경우 1번 2번 순으로 조회하는 쿼리
SELECT * FROM STUDENT ORDER BY ST_GRADE DESC, ST_CLASS ASC, ST_NUM;	-- ASC는 생략가능

# 3학년 학생들을 이름순(사전순)으로 정렬하고 이름이 같으면 반 번호 순으로 오름차순으로 정렬하는 쿼리
SELECT * FROM STUDENT WHERE  ST_GRADE = 3 ORDER BY ST_NAME, ST_CLASS, ST_NUM;

# 3학년 학생들을 번호가 2에 가까운 순으로 정렬
SELECT *, ABS(ST_NUM - 2) AS NUM FROM STUDENT WHERE  ST_GRADE = 3 ORDER BY NUM;  -- 내장함수 이용...아직 배우진 않았지만, NUM을 새로운 속성처럼 만들어서 추가해서 새로운 기준으로 삼음.





/* 
결과에서 원하는 개수를 가져오는 쿼리 LIMIT

SELECT [DISTINCT]
	속성1, ..., 속성N
FROM 
	테이블명
[WHERE
	조건]
[ORDER BY 속성A [ASC | DESC] [,속성B [ASC | DESC]]]
[LIMIT [번지,] 개수]
- 검색 결과에서 번지 부터 개수 만큼 가져옴
- 번지는 생략가능. 생략하면 0번지(번지는 0번지부터)

*/
SELECT * FROM STUDENT LIMIT 3;
SELECT * FROM STUDENT LIMIT 0, 3;
SELECT * FROM STUDENT LIMIT 8, 3; -- 8번지부터 3개

# 한 페이지에 학생 3명의 정보를 조회하는 페이지가 있고 학생 등록 순서대로 조회.
# 2페이지에서 조회 가능한 학생들을 선택하는 쿼리?  -- 한 페이지에 3명씩일때

SELECT * FROM STUDENT LIMIT 3, 3; -- 2페이지 
SELECT * FROM STUDENT LIMIT 6, 3; -- 3페이지 6번지 = 3명 * (3페이지 - 1), 3개 =3명 
SELECT * FROM STUDENT LIMIT 9, 3; -- 4페이지



/* 
그룹화 GROUP BY ~ HAVING

SELECT [DISTINCT]
	속성1, ..., 속성N
FROM 
	테이블명
[WHERE
	조건]
[GROUP BY 속성1 [, 속성2, ...]]		-- WHERE 다음에 들어감
[HAVING 조건]
[ORDER BY 속성A [ASC | DESC] [,속성B [ASC | DESC]]]
[LIMIT [번지,] 개수]

- 결과들을 그룹으로 묶어서 처리할 때
	- 1학년 1반 학생수(1)
    - 각 학년별 반의 학생수(2)
    - 각 학년의 학생수(3)
- 보통 집계함수와 함께 사용

- GROUP BY는 묶는 기준
	- 학년, 반을 기준으로 묶음.(1)
    - 학년, 반을 기준으로 묶음.(2)
    - 학년을 기준으로 묶음.(3)
    
- HAVING절은 집계함수에 조건을 걸때 사용(일반함수에 조건 걸때는 그냥 WHERE 쓰면 됨)

집계함수
	- COUNT(속성) : 결과의 개수를 셈. 결과가 몇행인지를 반환.(속성의 값이 NULL이 아닌 개수를 셈.NULL이면 제외)
    - SUM(속성) : 속성의 합
    - AVG(속성) : 속성의 평균
    - MIN(속성) : 속성의 최소값
    - MAX(속성) : 속성의 최대값

*/
# 1학년 1반의 학생수를 조회
SELECT COUNT(*) AS "1학년 1반 학생 수" FROM STUDENT.STUDENT WHERE ST_GRADE = 1 AND ST_CLASS = 1;

# 각 학년 각 반의 학생수를 조회
SELECT * FROM STUDENT.STUDENT GROUP BY ST_GRADE, ST_CLASS;  -- 서로 다른 속성끼리 합쳐지면 하나는 사라지기에 바로 합쳐지지 않게 에러 남. 설정 바꾸면 되긴 하지만
SELECT ST_GRADE, ST_CLASS FROM STUDENT.STUDENT GROUP BY ST_GRADE, ST_CLASS; -- 이렇게 하면 됨

SELECT ST_GRADE, ST_CLASS, COUNT(*) AS "학생 수" FROM STUDENT.STUDENT GROUP BY ST_GRADE, ST_CLASS;  -- 다 NOT NULL 이기때문에 지금은 COUNT ALL 해도 됨

# 각 학년별 학생수
SELECT ST_GRADE, COUNT(*) AS "학생 수" FROM STUDENT.STUDENT GROUP BY ST_GRADE;  

# 학생수가 6명 이상인 학년들을 조회
SELECT ST_GRADE, COUNT(*) AS "학생 수" FROM STUDENT.STUDENT GROUP BY ST_GRADE HAVING `학생 수` >= 6;	  -- ""쓰면 문자열로 취급되기 때문에 학생수를 HAVING에서 속성으로 취급시키려면 `` 써야함
SELECT ST_GRADE, COUNT(*) AS 학생수 FROM STUDENT.STUDENT GROUP BY ST_GRADE HAVING 학생수  >= 6;	

-- SELECT ST_GRADE, COUNT(*) AS "학생 수" FROM STUDENT.STUDENT GROUP BY ST_GRADE WHERE COUNT(*) >= 6;	 -- 집계함수에서 WHERE는 안됨
# CROUP BY가 있는 쿼리에서 조건은 무조건 HAVING절이라는건 아님 (조건에 집계함수 없으면 WHERE 절 집계함수 있을때는 HAVING 절)


/*
JOIN 
- 여러 테이블을 묶어서 하나의 결과 테이블을 만들 때 사용 

	- 1학년 1반 1번 학생의 성적정보 확인하려면 -> 지금은 스튜던트 테이블에서 학생의 넘버 확인하고 스코어에서 해당넘버 점수 보고 서브젝트에서 해당 과목을 확인해야함
    
INNER JOIN : 두 테이블의 교집합				(등록되지 않은거 안보이게 하기)
	- 성적이 등록된 학생들의 과목 성적을 조회 	=> 성적이 등록되지 않은 학생들은 조회X 
										=> 성적이 등록되지 않은 과목들은 조회X

OUTER JOIN : 두 테이블의 합집합				(등록되지 않은거 보이게 하기)
	- 모든 학생의 과목 성적들을 조회				=> 성적이 등록되지 않은 학생 조회 O
										=> 성적이 등록되지 않은 과목 조회 X
                                        
	- 모든 과목의 성적들을 조회				=> 성적이 등록되지 않은 과목 조회 O
										=> 성적이 등록되지 않은 학생 조회 X
                                        

SELF JOIN : 하나의 테이블로 JOIN 하는 경우 

*/

/*
- 테이블A가 테이블B에 참조되고 있으면(참조관계일 때) 테이블B에는 외래키, 테이블A에는 기본키로 연결이 되어 있었을 때 JOIN 사용 가능
	=> 학생 테이블이 성적 테이블에 참조되고 있으면 성적테이블의 외래키로 SC_ST_KEY, 학생 테이블 ST_KEY로 연결되어있음
    
INNER JOIN 

SELECT 테이블A.속성1, 테이블A.속성2, ..., 테이블B.속성2, 테이블B.속성2
FROM
	테이블A
JOIN
	테이블B ON 테이블A.기본키 = 테이블B.외래키		-- 이너조인은 FROM과 JOIN 순서 중요X, 앞에서 설명한 WHERE ORDER BY같은거 다 쓸수있음
	-> 속성명이 겹치지 않으면 테이블명 굳이 쓰지 않아도 됨
*/

# 등록된 모든 학생들의 성적을 조회하는 쿼리
/*
SELECT 
	* 
    FROM 
		SCORE
	JOIN
		STUDENT ON STUDENT.ST_KEY = SCORE.SC_ST_KEY;			-- 성적 42개 등록했기때문에 성적 42개 잘 나옴 --> 
*/
# 과목정보까지 보여주려면 : 이어서 과목정보 조인하면 됨

SELECT 
	ST_GRADE 학년, ST_CLASS 반, ST_NUM 번호, ST_NAME 이름, 	
	SJ_GRADE 학년, SJ_SEMESTER 학기, SJ_NAME 과목명, SC_SCORE 성적	
    FROM 
		SCORE
	JOIN														-- 이너조인
		-- STUDENT ON STUDENT.ST_KEY = SCORE.SC_ST_KEY		
        STUDENT ON ST_KEY = SC_ST_KEY							-- JOIN 시 속성명이 겹치지 않아 테이블명 생략 가능 -> 겹치면 어느쪽 테이블인지 헷갈리니 써줘야 함(헷갈리니까 써주는게 좋긴함)
	JOIN
		-- SUBJECT ON SCORE.SC_SJ_NUM = SUBJECT.SJ_NUM;
        SUBJECT ON SC_SJ_NUM = SJ_NUM;

# +@ 뷰를 이용한 쿼리 재사용 --> 뷰는 가상의 테이블로 미리 정의된 쿼리를 이용해서 마치 일반 테이블처럼 사용하는 가상의 테이블
# 뷰의 장점 1. 재사용 2. 가독성↑ 3. 쿼리의 단순화 4. 보안 강화(특정 칼럼이나 데이터만 보여줄 수 있음. 굳이 뷰가 아니라 SELECT라도 AS로 이름 바꿔서 보여줄수 있긴한데)
# CREATE VIEW 뷰명 AS SELECT 쿼리문;
DROP VIEW STUDENT_SCORE;		-- 중복 방지용
CREATE VIEW STUDENT_SCORE AS
	SELECT 
		ST_GRADE 학년, ST_CLASS 반, ST_NUM 번호, ST_NAME 이름, 	
		SJ_GRADE 과목학년, SJ_SEMESTER 학기, SJ_NAME 과목명, SC_SCORE 성적		-- 여기서는 칼럼 이름 중복되면 안됨....
    FROM 
		SCORE
	JOIN														
	    STUDENT ON ST_KEY = SC_ST_KEY							
	JOIN
		SUBJECT ON SC_SJ_NUM = SJ_NUM;
SELECT * FROM STUDENT_SCORE;



# 1학년의 1학년 1학기 국어 성적을 조회하는 쿼리
SELECT 
	ST_GRADE 학년, ST_CLASS 반, ST_NUM 번호, ST_NAME 이름, 	
	SJ_GRADE 학년, SJ_SEMESTER 학기, SJ_NAME 과목명, SC_SCORE 성적	
    FROM 
		SCORE
	JOIN								
        STUDENT ON ST_KEY = SC_ST_KEY							
	JOIN
        SUBJECT ON SC_SJ_NUM = SJ_NUM
	WHERE  SC_SJ_NUM = 1;

-- 뷰 이용하면 --
SELECT * FROM STUDENT_SCORE WHERE 학년 = 1 AND 과목학년 = 1 AND 학기 = 1 AND 과목명 = "국어";

# 1학년의 1학년 1학기 국어 성적의 평균을 조회하는 쿼리
SELECT ST_GRADE 학년, SJ_GRADE 학년, SJ_SEMESTER 학기, SJ_NAME 과목명, AVG(SC_SCORE) AS 평균
	FROM 
		SCORE  
	JOIN 
		STUDENT ON ST_KEY = SC_ST_KEY  
	JOIN 
		SUBJECT ON SC_SJ_NUM = SJ_NUM  
	WHERE 
    ST_GRADE = 1 AND SJ_GRADE = 1 AND SJ_SEMESTER = 1 AND SJ_NAME = '국어';

-- 뷰 이용하면 --
SELECT 학년, 과목학년, 학기, 과목명, AVG(성적) 평균 FROM STUDENT_SCORE WHERE 학년 = 1 AND 과목학년 = 1 AND 학기 = 1 AND 과목명 = "국어";	-- GROUP BY 여기선 필요X


# 2학년의 1학년 2학기 국어 성적의 평균을 각 반별로 조회하는 쿼리 (뷰 이용)
SELECT 학년, 반, 과목학년, 학기, 과목명, AVG(성적) 평균 FROM STUDENT_SCORE WHERE 학년 = 2 AND 과목학년 = 1 AND 학기 = 2 AND 과목명 = "국어" GROUP BY 반; -- GROUP BY 필수

# 각 학생별 평균(학년, 학기별)을 조회하는 쿼리
SELECT 학년, 반, 번호, 이름, 과목학년, 학기, AVG(성적) 평균 FROM STUDENT_SCORE GROUP BY 학년, 반, 번호, 이름, 과목학년, 학기; 
-- 너무 많아서 복잡하면 -- > 뷰 새로 만들기

DROP VIEW STUDENT_SCORE;		-- 중복 방지용
CREATE VIEW STUDENT_SCORE AS
	SELECT 
		ST_GRADE 학년, ST_CLASS 반, ST_NUM 번호, ST_NAME 이름, 	
		SJ_GRADE 과목학년, SJ_SEMESTER 학기, SJ_NAME 과목명, SC_SCORE 성적	,
        ST_KEY 학생번호
    FROM 
		SCORE
	JOIN														
	    STUDENT ON ST_KEY = SC_ST_KEY							
	JOIN
		SUBJECT ON SC_SJ_NUM = SJ_NUM;

SELECT 학년, 반, 번호, 이름, 과목학년, 학기, AVG(성적) 평균 FROM STUDENT_SCORE GROUP BY 학생번호, 과목학년, 학기; 


# 각 학생의 학년별 평균을 조회하는 쿼리
SELECT 학년, 반, 번호, 이름, 과목학년, AVG(성적) 학년평균 FROM STUDENT_SCORE GROUP BY 학생번호, 과목학년;  -- 위에서 학기만 빼면


# 각 학생의 1학년 평균이 가장 높은 학생을 조회하는 쿼리
SELECT 학년, 반, 번호, 이름, 과목학년, AVG(성적) 평균 FROM STUDENT_SCORE WHERE 과목학년 = 1 GROUP BY 학생번호, 과목학년
ORDER BY 평균 DESC
LIMIT 1;			-- 그냥 리밋1 하면 순서대로 안나오니 정렬은 먼저 해줘야



/*
SELECT 속성, ...
FROM 테이블A
LEFT | RIGHT JOIN 테이블 B ON 테이블A.속성1 = 테이블B.속성2
	-이너조인이랑 달리 OUTER JOIN은 순서가 중요(왼쪽 테이블을 기준으로 연결-이어붙임-)
*/

# 모든 과목의 평균을 조회하는 쿼리
-- SELECT SUBJECT.* , AVG(SC_SCORE) 평균	-- -> 성적 있는애들은 평균으로, 없는애들은 NULL로 출력됨
SELECT SUBJECT.* , IFNULL(AVG(SC_SCORE), 0) 평균		-- ->NULL이면 0을 넣어주세요
	FROM SUBJECT
LEFT JOIN
	SCORE ON SJ_NUM = SC_SJ_NUM			-- 성적 없는 애들도 이어붙여줌
GROUP BY SJ_NUM;

# 모든 학생의 전체 성적 평균을 조회하는 쿼리. 성적이 없는 경우는 0이 나오도록

SELECT STUDENT.*, IFNULL(AVG(SC_SCORE), 0) 평균
	FROM STUDENT
LEFT JOIN SCORE ON SC_ST_KEY = ST_KEY  -- 학생에 점수를 붙여야 하니 LEFT
GROUP BY ST_KEY;

# 등록된 학생수를 조회하는 쿼리
SELECT COUNT(*) 학생수
	FROM STUDENT;
    
# SELF JOIN
# 회사원의 사수를 관리 ->외래키로 사원번호를 
# 사원번호, 사원이름, ... , 사수 -> 자기 테이블의 사원번호를 이용

# CROSS JOIN
# 모든 경우의 수를 조합하여 합치는 조인
SELECT * FROM STUDENT JOIN SUBJECT;	-- 학생 한명한명에 모든 과목을 넣어놓고 차후에 수정하는 작업에 사용 (학생 22명, 과목18개 -> 296개 나옴 --> 너무 많은 데이터가 사용될 수 있어 조심해야함)

# JOIN USING : 테이블B의 외래키와 테이블A의 외래키의 속성이름이 같은 경우
/*
SELECT * FROM 테이블A JOIN 테이블B ON 테이블B.속성1 = 테이블A.속성1;
-->
SELECT * FROM 테이블A JOIN 테이블B USING(속성1);
*/

# 서브 쿼리 : 쿼리 안에 쿼리가 들어가는 형태 -> 얘도 JOIN임

# 장점 :	1. 쿼리의 구조화
#		2. JOIN 보다 가독성이 좋음
#		3. 속도를 향상시킬 수 있음

# EX) 홍길동이라는 사람이 KH 학원에 다니는 아들을 찾으러 왔음. 일반JOIN(모든 강의장에서 성이 홍씨인 남자를 찾고 그중에 아들 찾고) 서브쿼리(각 강의장에서 성이 홍씨고 남자인 학생을 찾아 /->걸러진데이터끼리JOIN시킴/ 그중에 아들 찾음)

# 서브쿼리 적용위치 		1. SELECT문에서 속성 위치
#					2. SELECT문에서 FROM 다음에 나오는 테이블명 위치
#					3. SELECT문에서 WHERE절에서 특정 값 위치
# 					4. SELECT문에서 HAVING절에서 특정 값 위치
#					5. INSERT SELECT
#					6. UPDATE문에서 수정할 값 위치

# INSERT SELECT문 ->DML



SET GLOBAL sql_mode = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION';

# group by 에러 뜨는 이유?
SELECT * FROM STUDENT GROUP BY ST_GRADE;	-- GROUP BY에 없는 속성 날아가기때문에 에러 발생 -- 기본키로만 GROUPBY 하면 되는데 그러면 하는 이유가...
# GROUP BY 할때 사용하지 않은 속성 조회하는 경우 에러 해결하는 쿼리(실행하고 인스턴스 나갔다 들어와야 적용됨)
SET GLOBAL sql_mode = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION';	
# 원상 복구하는 쿼리
SET GLOBAL sql_mode = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION,ONLY_FULL_GROUP_BY';	



# 각 반 학생별 평균을 조회하는 쿼리 

# 1학년 1반 반 등수를 조회하는 쿼리(평균)
SELECT ST_GRADE 학년, ST_CLASS 반, ST_NUM 번호, ST_NAME 이름, IFNULL(AVG(SC_SCORE),0) 평균
	FROM SCORE
RIGHT JOIN STUDENT ON SC_ST_KEY = ST_KEY  -- 점수 없는 학생도 넣기위해 OUTERJOIN. STUDENT가 오른쪽에 있기때문에
GROUP BY ST_KEY;	-- 기본키라 위에 SQL-MODE 쿼리 안써도 됨




# 평균이 같으면 국 영 수 점수 순으로 비교하여 등수를 결정. 다 같으면 같은등수	-> 같은 등수 나오는 경우 다음 등수는 그만큼 건너뜀
SELECT ST_GRADE 학년, ST_CLASS 반, ST_NUM 번호, ST_NAME 이름, IFNULL(AVG(SC_SCORE),0) 평균
FROM SCORE
RIGHT JOIN STUDENT ON SC_ST_KEY = ST_KEY  -- 점수 없는 학생도 넣기위해 OUTERJOIN. STUDENT가 오른쪽에 있기때문에
WHERE ST_GRADE = 1 AND ST_CLASS = 1
GROUP BY ST_KEY;	-- 기본키라 위에 SQL-MODE 쿼리 안써도 됨

SELECT 
    ST_GRADE AS 학년, 
    ST_CLASS AS 반, 
    ST_NUM AS 번호, 
    ST_NAME AS 이름, 
    IFNULL(AVG(SC_SCORE), 0) AS 평균
FROM STUDENT
LEFT JOIN SCORE ON SC_ST_KEY = ST_KEY  -- 점수 없는 학생도 포함
WHERE ST_GRADE = 1 AND ST_CLASS = 1
GROUP BY ST_KEY
ORDER BY 평균 DESC;

-- SELECT RANK() OVER(ORDER BY 평균 DESC) 순위, T.*
SELECT RANK() OVER(ORDER BY 평균 DESC, 국어평균 DESC, 수학평균 DESC, 영어평균 DESC) 순위, T.*
FROM
	(SELECT 
    ST_GRADE AS 학년, 
    ST_CLASS AS 반, 
    ST_NUM AS 번호, 
    ST_NAME AS 이름, 
    IFNULL(AVG(SC_SCORE), 0) AS 평균,
    AVG(CASE WHEN SJ_NAME = '국어' THEN SC_SCORE END) 국어평균,		-- 어차피 과목 하나씩밖에 안 들어있긴하지만 평균은 제대로 표현됨
    AVG(CASE WHEN SJ_NAME = '수학' THEN SC_SCORE END) 수학평균,
    AVG(CASE WHEN SJ_NAME = '영어' THEN SC_SCORE END) 영어평균
FROM SCORE
JOIN SUBJECT ON SC_SJ_NUM = SJ_NUM	-- 성적 보여줌
LEFT JOIN STUDENT ON SC_ST_KEY = ST_KEY  
WHERE ST_GRADE = 1 AND ST_CLASS = 1
GROUP BY ST_KEY) AS T;

-- ORDERBY 쓰려면 있는 속성이어야하는데 평균은 없는 속성이기에 서브쿼리 이용해야함
SELECT RANK() OVER(ORDER BY 평균 DESC) 순위, T.*
FROM
	(SELECT ST_GRADE 학년, ST_CLASS 반, ST_NUM 번호, ST_NAME 이름, IFNULL(AVG(SC_SCORE),0) 평균
		FROM SCORE
		RIGHT JOIN STUDENT ON SC_ST_KEY = ST_KEY 
		WHERE ST_GRADE = 1 AND ST_CLASS = 1
		GROUP BY ST_KEY) AS T;	
        
        

# 2학년 등수 조회 쿼리(평균)
SELECT RANK() OVER(ORDER BY 평균 DESC) 순위, T.*
FROM
	(SELECT ST_GRADE 학년, ST_CLASS 반, ST_NUM 번호, ST_NAME 이름, IFNULL(AVG(SC_SCORE),0) 평균
		FROM SCORE
		RIGHT JOIN STUDENT ON SC_ST_KEY = ST_KEY 
		WHERE ST_GRADE = 2			-- 여기만 수정하면 됨
		GROUP BY ST_KEY) AS T;	
        

# 성적 평균순 정렬
SELECT * FROM SCORE JOIN STUDENT ON SC_ST_KEY = ST_KEY WHERE ST_GRADE = 2;  -- > 여기다 SCORE 대신 넣기
# NULL인 학생 포함(OUTTER JOIN)
SELECT SC_ST_KEY, AVG(SC_SCORE) 학생평균 FROM SCORE RIGHT JOIN STUDENT ON ST_KEY = SC_ST_KEY GROUP BY SC_ST_KEY;

SELECT * FROM (SELECT ST_GRADE 학년, ST_CLASS 반, ST_KEY, IFNULL(AVG(SC_SCORE),0) 학생평균 FROM SCORE RIGHT JOIN STUDENT ON ST_KEY = SC_ST_KEY GROUP BY ST_KEY) AS T WHERE 학년 = 2;
SELECT RANK() OVER(ORDER BY 반평균 DESC) 반등수, T.* FROM(SELECT 학년, 반, AVG(학생평균) 반평균 FROM (SELECT ST_GRADE 학년, ST_CLASS 반, ST_KEY, IFNULL(AVG(SC_SCORE),0) 학생평균 FROM SCORE RIGHT JOIN STUDENT ON ST_KEY = SC_ST_KEY GROUP BY ST_KEY) AS T WHERE 학년 = 2 GROUP BY 학년, 반) AS T;
-- 줄여쓰면
SELECT RANK() OVER(ORDER BY 반평균 DESC) 반등수, T.* FROM(SELECT ST_GRADE 학년, ST_CLASS 반, IFNULL(AVG(SC_SCORE), 0) 반평균 FROM SCORE RIGHT JOIN STUDENT ON SC_ST_KEY = ST_KEY WHERE ST_GRADE= 2 GROUP BY ST_GRADE, ST_CLASS) AS T;