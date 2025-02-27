# 내장함수(자체적으로 갖고있는 함수)

# 조건
# IF(식, 식1, 식2) : 식이 참이면 식1을, 거짓이면 식2를 반환
# IFNULL(식1, 식2) : 식1이 NULL이면 식2를, NULL이 아니면 식1을 반환
# NULLIF(식1, 식2) : 식1과 식2가 같으면 NULL, 다르면 식1을 반환
# CASE 속성 WHEN 값 THEN 결과 ELSE 결과 END	-- >이렇게 한줄로 해도 되지만
# CASE 속성	
#	WHEN 값1
# 	THEN 결과1
#	WHEN 값2
# 	THEN 결과2
# 	ELSE 결과3 	-->없어도됨
# END		-- > 이렇게 보기편하게 보통

# 성적이 60이상이면 O, 미만이면 X라고 출력하도록
SELECT *, IF(SC_SCORE >= 60, "O", "X") AS 통과 FROM SCORE;

# IFNULL은 JOIN 해야하니 넘어가자...

# -> 똑같은 걸 CASE WHEN으로 작업
SELECT *, CASE WHEN SC_SCORE >= 60 THEN "O" ELSE "X" END AS 통과 FROM SCORE; 

# 성적이 90이상이면 A, 80이상이면 B, 70이상이면 C, 60이상이면 D, 60미만이면 F로 출력하는 쿼리
SELECT *, IF(SC_SCORE >= 90, "A", IF(SC_SCORE >= 70, "B",  IF(SC_SCORE >= 80, "C",  IF(SC_SCORE >= 60, "D", "F")))) AS 학점 FROM SCORE;
SELECT *, CASE WHEN SC_SCORE >= 90 THEN "A" WHEN SC_SCORE >= 80 THEN "B" WHEN SC_SCORE >= 70 THEN "C" WHEN SC_SCORE >= 60 THEN "D" ELSE "F" END AS 학점 FROM SCORE; 

# 성적이 최고성적과 같으면 NULL, 다르면 성적을 출력하는 쿼리
SELECT *, NULLIF(SC_SCORE, (SELECT MAX(SC_SCORE) FROM SCORE)) AS 결과 FROM SCORE;		-- 서브쿼리로
--------------------------------------------------------------------------------------------------------------------
# 내장함수 - 문자열
# CHAR_LENGTH(문자열) : 문자열 개수
# LENGTH(문자열) : 바이트 수
# CONCAT(문자열1, ...) : 문자열을 이어붙임(CONCATENATE)
# FIELD(찾을문자열, 문자열1, ...) : 찾을 문자열의 위치를 찾아 반환
# INSTR(부분문자열, 기준문자열) : 기준 문자열에서 부분 문자열의 위치를 찾아 반환 ->1번지부터 시작
# LOCATE(부분문자열, 기준문자열) : 기준 문자열에서 부분 문자열의 위치를 찾아 반환 ->1번지부터 시작
# FORMAT(숫자, 소수점자리) : 숫자를 소수점이하 자리까지 표현. 1000단위마다 ,를 추가
# BIN(숫자) OCT(숫자) HEX(숫자) : 2,8,16진수로 변환
# INSERT(기준문자열, 위치, 길이, 삽입할문자열) : 기준문자열의 위치부터 길이만큼 지우고 삽입할 문자열을 끼워 반환 (길이가 전체보다 길어도 O)
# LEFT(문자열, 길이) / RIGHT(문자열, 길이) : 좌/우 에서 문자열의 길이만큼 반환 
# LOWER(문자열), UPPER(문자열) : 소문자/대문자로 
# LPAD(문자열, 길이, 채울문자열)/RPAD(동일) : 문자열을 길이만큼 늘리고 빈곳을 채울문자열로 채움	(숫자도 가능)
# REPEAT(문자열, 횟수) : 문자열 횟수만큼 반복
# REPLACE(문자열, 문자열A, 문자열B) : 문자열에서 문자열A를 찾아 문자열B로 바꿈
# REVERSE(문자열) : 문자열 순서를 역순으로 반환
# SUBSTRING(문자열, 시작위치, 길이) : 문자열에서 시작위치부터 길이만큼 부분문자열을 반환

--------------------------------------------------------------------------------------------------------------------

# 내장함수 - 날짜/시간함수
# ADDATE/SUBDATE(날짜, 차이) : 날짜를 기준으로 차이만큼 일(DATE)를 더한/뺀 날짜 반환
SELECT ADDDATE("2025-02-27 20:20:20","2:00:00");
SELECT ADDDATE(NOW(),2);	-- NOW는 지금 시각
# ADDTIME/SUBTIME(날짜/시간, 차이) : 날짜/시간 기준으로 차이만큼 더한/뺀
SELECT NOW(), ADDTIME("2025-02-27 20:20:20","2:00:00");
# YEAR/MONTH/DAY(날짜) : 날짜에서 년/월/일 구함
SELECT YEAR(NOW()) AS YEAR, MONTH(NOW()) AS MONTH, DAY(NOW()) AS DAY;
# HOUR/MINUTE/SECOND/MICROSECOND(시간) : 시간에서 시/분/초/마이크로초 반환
SELECT MICROSECOND(NOW()); -- 마이크로초는 안 나옴
SELECT MICROSECOND(NOW(6)); -- 마이크로초 6자리(NOW()안에 숫자 0~6 넣을수있음)
SELECT MICROSECOND("2025-02-27 20:20:20.123456");
SELECT MICROSECOND("2025-02-27 20:20:20.123456"+0.01);
# DATE/TIME(날짜) : 날짜에서 년-월-일/시:분:초 반환
SELECT DATE(NOW()) DATE;
# DATEDIFF(날짜1, 날짜2) : 날짜1에서 날짜2의 차이를 일로 반환. 날짜1 - 날짜2
SELECT DATEDIFF(NOW(),"2025-02-25 20:20:20") DATEDIFF;
# TIMEDIFF(날짜1/시간1, 날짜2/시간2) : 날짜1/시간1에서 날짜2/시간2의 차이를 시간:분:초로 반환.
SELECT TIMEDIFF(NOW(),"2025-02-25 20:20:20") TIMEDIFF;
# NOW()/SYSDATE() : 현재 날짜와 시간을 반환
SELECT NOW(), SYSDATE();
# DATE_ADD/DATE_SUB(기준날짜, INTERVAL 간격 종류) : 기준 날짜에서 INTERVAL만큼 더한/뺀 날짜
# INTEVAL 종류
# YEAR MONTH DAY HOUR MINUTE SECOND MICROSECOND QUARTER WEEK
# YEAR_MONTH(년부터 월까지) DAY_HOUR(일~시) DAY_MICROSECOND
SELECT DATE_ADD("2025-02-25 20:20:20.123456", INTERVAL 1 QUARTER);
SELECT DATE_ADD("2025-02-25 20:20:20", INTERVAL "1 1" YEAR_MONTH);  -- 숫자보다 큰 범위 입력하면 작은쪽부터 채우긴 하는데...
--------------------------------------------------------------------------------------------------------------------
# 수학함수
# ABS() 절대값
# CEIL() 소수점 첫째자리에서 올림 FLOOR() 내림 ROUND() 반올림
SELECT CEIL(2.49), ROUND(2.49), ROUND(2.4967,2); -- ROUND는 자릿수 지정 가능
