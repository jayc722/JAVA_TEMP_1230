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