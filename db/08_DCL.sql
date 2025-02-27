# 사용자 추가하는 쿼리

# CREATE USER '아이디'@'호스트명' IDENTIFIED BY '비밀번호'; # -> 계정에 해당 DB에의 권한을 부여
# '아이디' : 사용자 계정명
# '호스트명' : 접근 권한 (localhost : 내부에서만 가능(다른PC에서 해당DB에 접근X).  % : 외부에서도 접근 o)
CREATE USER 'community_admin'@'%' IDENTIFIED BY 'admin';		-- 아이디는 임의. 외부에서도 접근 가능. 비밀번호 admin

# 사용자 조회
SELECT USER, HOST FROM MYSQL.USER;

# 사용자 비번 변경
# SET PASSWORD FOR '아이디'@'호스트명' = '새비밀번호';
SET PASSWORD FOR 'community_admin'@'%' = 'admin123';

# 사용자 삭제
# DROP USER '아이디'@'호스트명';
DROP USER 'community_admin'@'%';

CREATE USER 'community_admin'@'%' IDENTIFIED BY 'admin';	

# 권한 부여
# 사용자에게 특정DB에 대한 권한을 부여. 테이블 추가/수정/삭제, 데이터 추가/수정/삭제/조회 등 
# 권한 : SELECT/INSERT/UPDATE/DELETE/CREATE/ALTER/DROP/REFERENCES/ALL PRIVILEGES(모든 권한)
# GRANT 권한 ON DB명.테이블명 TO '아이디'@'호스트명';			-- 아이디 에게 권한을 부여
GRANT SELECT,INSERT,UPDATE,DELETE ON COMMUNITY.* TO 'community_admin'@'%'; -- COMMUNITY DB의 모든 테이블에 열람 권한 -> COMMUNITY에 마우스 호버해서 i버튼 클릭해서 GRANT 확인하면 권한 바껴있는거 볼수있음 -> 클릭 안하고 권한 확인으로도 확인 가능
-- GRANT SELECT,INSERT,UPDATE,DELETE ON *.* TO 'community_admin'@'%'; -- 모든 DB에 대한 접근 권한 부여도 가능(비추천 - 다른 사람의 DB에도 접근할수 있기 때문)
GRANT ALL ON COMMUNITY.* TO 'community_admin'@'%'; -- GRANT(계정 권한 부여) 제외하고는 권한들 다 넣어줄수있음 -> 가서 실행하면 쿼리로 할수있는 INSERT DELETE 다 클릭으로 실행가능

# 권한 제거
# REVOKE 권한 ON DB명.테이블명 FROM '아이디'@'호스트명';		-- 아이디 에게서 권한을 빼앗겠다
REVOKE INSERT ON COMMUNITY.* FROM 'community_admin'@'%';
 
# 권한 확인
SHOW GRANTS FOR 'community_admin'@'%';
