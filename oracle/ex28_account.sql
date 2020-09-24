--ex28_account.sql

/*

계정 
- DCL
- 계정 생성, 수정, 삭제 
- 리소스 접근 권한 제어 

사용자 계정 생성하기
- 시스템 권한을 가지고 있는 계정만 가능하다.
    - 관리자만 가능(system, 관리자 권한 부여받은 계정)
    - 계정 생성 권한을 가지는 일반 계정 
    
create user 계정명 identified by 암호;

alter user 계정명 identified by 암호; -- 비밀번호 변경하는 방법
alter user 계정명 account unlock; -- 계정 푸는 것
alter user 계정명 acoount lock;

drop user 계정명; --계정 삭제 


*/

-- system
create user test identified by java1234;

-- 계정 생성 O -> 접속 권한 X -> 로그인 실패 
-- 계정에게 권한 제어 
-- 1. grant 권한 to 계정명
-- 2. revoke 권한 to 계정명 (뺏는 것)
grant create session to test; --로그인 

grant connect, resource to test; --집합인 roll의 이름(로그인,테이블,조회 권한)

-- 프로젝트 진행
--1. 프로젝트 전용 계정 생성 
create user project identified by java1234;

--2. 권한 부여
grant connect, resource to project;

--3. 권한 뺏기
revoke connect from project;

drop user project1;


