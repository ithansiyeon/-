
-- 설문조사
create table tblResearch(
    seq number primary key,     --PK
    question varchar2(300) not null,    --질문
    item1 varchar2(300) not null,   --항목1
    item2 varchar2(300) not null,   --항목2
    item3 varchar2(300) not null,   --항목3
    item4 varchar2(300) not null,   --항목4
    cnt1 number default 0 not null, --선택1
    cnt2 number default 0 not null, --선택2
    cnt3 number default 0 not null, --선택3
    cnt4 number default 0 not null  --선택4
);

insert into tblResearch values (1, '사용 가능한 프로그래밍 언어는?','JAVA','Python','Visual C++','C#',default,default,default,default);

update tblResearch set 
    cnt1 = 9,   -- JAVA
    cnt2 = 10,   -- Pthyon
    cnt3 = 4,   -- VC++
    cnt4 = 1    -- JavaScript
        where seq = 1;
commit;
select * from tblresearch;

create table zipcode  (
   seq                  NUMBER(10)                        not null,
   zipcode              VARCHAR2(50),
   sido                 VARCHAR2(50),
   gugun                VARCHAR2(50),
   dong                 VARCHAR2(50),
   bunji                VARCHAR2(50),
   constraint PK_ZIPCODE primary key (seq)
)

select * from zipcode;
select count(*) from zipcode;

-- 고양이 위치
create table tblCat(
    seq number primary key,         --PK
    catid varchar2(30) not null,    --<img id = "cat1">
    x number not null,              --left
    y number not null               --top
    
);
select * from tblCat;
insert into tblCat values(1,'cat1',0,0);
insert into tblCat values(2,'cat2',220,110);
insert into tblCat values(3,'cat3',150,280);
select * from 
(select a.*,rownum as rnum from 
    (select seq,subject,name,regdate from vwBoard order by seq desc) a)
        where rnum >=1 and rnum <= 10;
commit;


-- 추천 검색어
create table tblSearch(
    seq number primary key,
    word varchar2(100) not null
);

insert into tblSearch values(1,'가위');
insert into tblSearch values(2,'가나');
insert into tblSearch values(3,'가리비');
insert into tblSearch values(4,'가나 초콜렛');
insert into tblSearch values(5,'가위손');
insert into tblSearch values(6,'가방');
insert into tblSearch values(7,'가방 손잡이');
insert into tblSearch values(8,'가방끈');
insert into tblSearch values(9,'나비');
insert into tblSearch values(10,'나비잠');

commit;

select * from tblInsa;

-- 부서 조건 > 통계 > 지역별 or 직급별
select jikwi,count(*) as cnt from tblInsa where buseo = '영업부' group by jikwi; 

--대리	3
--부장	2
--사원	2

--과장	1
--대리	6
--부장	2
--사원	8


select * from tblmessage;












