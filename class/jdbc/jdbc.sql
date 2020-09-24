--D:\class\JDBCTest\jdbc.sql

create table tblAddress(
    seq number primary key,          -- 번호(PK)
    name varchar2(30) not null,      -- 이름
    age number(3) not null,          --나이
    tel varchar2(15) null,          --전화
    address varchar2(300) not null, --주소
    regdate date default sysdate not null --등록시간
    
);

create sequence seqAddress;

insert into tblAddress (seq,name,age,tel,address,regdate) 
            values(seqAddress.nextVal,'홍길동',20,'010-1234-5678',
                    '서울시 강남구 역삼동',default);

commit; --이클립스 유저는 몰라서, 정식으로 등록 

select * from tblAddress;

select * from tblAAA;

select name,gender,age,address from tblAddressBook where replace(lower(address),' ','') like '%' || replace(lower('시강'),' ','') || '%'; -- 공백을 무시 

-- 이중 for문 자바에서
select distinct buseo from tblInsa; -- 카테고리 
select * from tblInsa where buseo = '기획부' order by 
case 
    when jikwi = '부장' then 1
    when jikwi = '과장' then 2
    when jikwi = '대리' then 3
    when jikwi = '사원' then 4
end,name; -- 항목

select * from tblAddress;

-- CallableStatement + 프로시저
-- m1()
create or replace procedure procM1(
    pname varchar2,
    page number,
    ptel varchar2,
    paddress varchar2
)
is
begin
    insert into tblAddress values(seqAddress.nextVal,pname,page,ptel,paddress,default);
end;

select * from tblAddress;

-- m2();
-- 반환값(단일 레코드 or 다중 레코드(cursor))
create or replace procedure procM2(
    pnum number, 
    pname out varchar2,
    pbuseo out varchar2,
    pjikwi out varchar2
)
is
begin
    select name,buseo,jikwi into pname,pbuseo,pjikwi from tblInsa where num = pnum;
end;

--m3()
create or replace procedure procM3(
    pname varchar2, --남자이름
    wname out varchar2, --여자이름
    wage out varchar2 --여자 나이
)
is
begin
    select name,age into wname,wage from tblWomen where couple = (select name from tblMen where name = pname);
end;

--m4()
create or replace procedure procM4(
    pbuseo varchar2,
    presult out sys_refcursor
)
is
begin
    open presult for
        select * from tblInsa where buseo = pbuseo;
end;


--m5()
create or replace procedure procM5(
    presult out sys_refcursor
)
is
begin
    open presult for
        select * from tblAddress;
end;

select * from tblBoard;
select * from tblComment;

create or replace procedure procAddComment(
    -- 댓글쓰기 매개변수
)
is
begin
    -- 통재로 인식함, DML 2개 이상을 하나의 트랜잭션으로 처리하고 싶으면 오라클에서 
    --1. 카운트 증가 
    update tblBoard set commentCount = commentCount+1
        where seq = 1;
    --2. 댓글쓰기 
    insert into tblComment(seq,subject,pseq) 
        values(1,'댓글',1);
    
    commit;
    
    exception -- 실패하면 무조건
        when others then 
            rollback;
end;

