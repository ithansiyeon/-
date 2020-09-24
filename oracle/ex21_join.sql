--ex21_join.sql

/*

테이블의 관계

ERD, Entity Relational Diagram
- 엔티티 관계도 
- 테이블의 관계를 표시해놓은 도식(설계도)

조인, join

- 직원 테이블 
- 담당 프로젝트 


*/
drop table tblStaff;

create table tblStaff
(
    seq number primary key,          --직원번호(PK)
    name varchar2(30) not null,      --직원명
    salary number not null,          --급여
    address varchar2(300) not null,  --거주지
    project varchar2(300) null       --담당 프로젝트명
);

insert into tblStaff (seq,name,salary,address,project)
    values (1,'홍길동',300,'서울시','홍콩 수출');
insert into tblStaff (seq,name,salary,address,project)
    values (2,'아무개',250,'인천시','TV 광고');
insert into tblStaff (seq,name,salary,address,project)
    values (3,'하하하',350,'대전시','매출 분석');

-- 홍길동에게 프로젝트 1건 추가하기
insert into tblStaff (seq,name,salary,address,project)
    values (4,'홍길동',300,'서울시','고객 관리');
insert into tblStaff (seq,name,salary,address,project)
    values (5,'홍길동',300,'서울시','자재 관리');

select * from tblStaff;


drop table tblStaff;
drop table tblProject;

create table tblStaff --부모 테이블
(
    seq number primary key,          --직원번호(PK)
    name varchar2(30) not null,      --직원명
    salary number not null,          --급여
    address varchar2(300) not null  --거주지
);

create table tblProject( --자식 테이블(부모 테이블 PK를 FK와 엮어서 참조 관계를 만든다.)
    seq number primary key,             --프로젝트번호(PK)
    project varchar2(300) not null,     --프로젝트명
    staff number not null references tblStaff(seq) --직원번호(FK) foreign key, 외래키 관계를 맺을 때만 
);

insert into tblStaff (seq,name,salary,address) values (1,'홍길동',300,'서울시');
insert into tblStaff (seq,name,salary,address) values (2,'아무개',250,'인천시');
insert into tblStaff (seq,name,salary,address) values (3,'하하하',350,'대전시');

insert into tblProject (seq,project,staff) values (1, '홍콩 수출',1);
insert into tblProject (seq,project,staff) values (2, 'TV 광고',2);
insert into tblProject (seq,project,staff) values (3, '매출 분석',3);
insert into tblProject (seq,project,staff) values (4, '자재 관리',1);
insert into tblProject (seq,project,staff) values (5, '대리점 분양',2);

select * from tblStaff;
select * from tblProject;

select seq,project, (select name from tblStaff where seq = tblProject.staff) from tblProject;

-- 상황 A.
-- 신입 사원 입사 -> 신규 프로젝트 담당 
-- A.1 신입 사원 추가하기(O) 
insert into tblStaff (seq,name,salary,address) values (4,'호호호',250,'서울시'
);

-- A.2 신규 프로젝트 추가하기(O)
insert into tblProject (seq,project,staff) values (6, '고객 유치',4);

-- A.3 신규 프로젝트 추가하기(O)
--ORA-02291: integrity constraint (HR.SYS_C007165) violated - parent key not found, 5가 없는 직원 번호, 참조하는 키가 실존하는 키가 아니면 안넣어줌
insert into tblProject (seq,project,staff) values (7, '해외 수출',5); 

select * from tblProject;

commit;
rollback;

-- 상황 B.
-- '홍길동' 퇴사

-- B.1 '홍길동' 삭제(O)
--ORA-02292: integrity constraint (HR.SYS_C007165) violated - child record found
delete from tblStaff where name = '홍길동';

-- B.2 '홍길동'의 모든 업무 -> 위임(O) 
update tblProject set staff = 2 where staff = 1;

-- B.3 '홍길동' 삭제
delete from tblStaff where name = '홍길동';

/*

관계를 맺고 있는 2개의 테이블을 조작할 때 발생하는 일 
- 이 관계 규칙이 깨지면 데이터 무결성(유효성)이 깨진다. -> 데이터 가치 상실
- 반드시 지켜야할 상황 

1. 부모 테이블 조작(tblStaff)
    a. 행을 추가(insert): 아무 영향 없음 
    b. 행을 수정(update): 아무 영향 없음 
    c. 행을 삭제(delete): 자식 테이블에 자신을 참조하는 행이 존재하는지 반드시 사전 체크 > FK
    
2. 자식 테이블 조작(tblProject)
    a. 행을 추가(insert): 자신이 참조하는 대상이 실제로 존재하는지 반드시 사전 체크 > FK
    b. 행 수정(update): 자신이 참조하는 대상이 실제로 존재하는지 반드시 사전 체크 > FK
    c. 행을 삭제(delete): 아무 영향 없음 
    
*/
-- F키가 있는게 자식

-- 고객 테이블
create table tblCustomer
(
    seq number primary key, --고객번호(PK)
    name varchar2(30) not null, --고객명
    tel varchar2(15) not null, --전화
    address varchar2(100) not null --주소
    

);

-- 판매 테이블
create table tblSales
(
    seq number primary key,     --판매번호
    item varchar2(50) not null, --제품명
    qty number not null,         -- 수량
    regdate date default sysdate not null, -- 판매날짜
    cseq number not null references tblCustomer(seq) --고객번호(FK) 누가 샀는지 모르면 안돼서 
);



select * from tblcustomer;
select * from tblsales;


--장르 테이블
create table tblGenre(

    seq number primary key,  --장르번호(PK)
    name varchar2(30) not null,--장르명
    price number not null,   --대여 가격(원)
    period number not null --대여 기간(일)
);


-- 장르 데이터
INSERT INTO tblGenre VALUES (genreSeq.NEXTVAL, '액션',1500,2);
INSERT INTO tblGenre VALUES (genreSeq.NEXTVAL, '에로',1000,1);
INSERT INTO tblGenre VALUES (genreSeq.NEXTVAL, '어린이',1000,3);
INSERT INTO tblGenre VALUES (genreSeq.NEXTVAL, '코미디',2000,2);
INSERT INTO tblGenre VALUES (genreSeq.NEXTVAL, '멜로',2000,1);
INSERT INTO tblGenre VALUES (genreSeq.NEXTVAL, '기타',1800,2);

create sequence genreSeq;


--비디오 테이블
create table tblVideo(
    
    seq number primary key,         --비디오 번호
    name varchar2(30) not null,     --제목
    qty number not null,            --보유 수량
    company varchar2(50) null,      --제작사
    director varchar2(50) null,     --감독
    major varchar2(50) null,        --주연배우
    genre number not null references tblGenre(seq) --장르번호(FK)

);

create sequence videoSeq;

-- 비디오 데이터
INSERT INTO tblVideo (seq, Name, qty, Company, Director, Major, Genre) VALUES (videoSeq.NEXTVAL, '영구와 땡칠이',5,'영구필름','심영래','땡칠이',3);
INSERT INTO tblVideo (seq, Name, qty, Company, Director, Major, Genre) VALUES (videoSeq.NEXTVAL, '어쭈구리',5,'에로 프로덕션','김감독','박에로',2);
INSERT INTO tblVideo (seq, Name, qty, Company, Director, Major, Genre) VALUES (videoSeq.NEXTVAL, '털미네이터',3,'파라마운트','James','John',1);
INSERT INTO tblVideo (seq, Name, qty, Company, Director, Major, Genre) VALUES (videoSeq.NEXTVAL, '육복성',3,'대만영화사','홍군보','생룡',4);
INSERT INTO tblVideo (seq, Name, qty, Company, Director, Major, Genre) VALUES (videoSeq.NEXTVAL, '뽀뽀할까요',6,'뽀뽀사','박감독','최지후',5);
INSERT INTO tblVideo (seq, Name, qty, Company, Director, Major, Genre) VALUES (videoSeq.NEXTVAL, '우정과 영혼',2,'파라마운트','James','Mike',5);
INSERT INTO tblVideo (seq, Name, qty, Company, Director, Major, Genre) VALUES (videoSeq.NEXTVAL, '주라기 유원지',1,NULL,NULL,NULL,1);
INSERT INTO tblVideo (seq, Name, qty, Company, Director, Major, Genre) VALUES (videoSeq.NEXTVAL, '타이거 킹',4,'Walt','Kebin','Tiger',3);
INSERT INTO tblVideo (seq, Name, qty, Company, Director, Major, Genre) VALUES (videoSeq.NEXTVAL, '텔미 에브리 딩',10,'영구필름','강감독','심으나',5);
INSERT INTO tblVideo (seq, Name, qty, Company, Director, Major, Genre) VALUES (videoSeq.NEXTVAL, '동무',7,'부산필름','박감독','장동근',1);
INSERT INTO tblVideo (seq, Name, qty, Company, Director, Major, Genre) VALUES (videoSeq.NEXTVAL, '공동경쟁구역',2,'뽀뽀사','박감독','이병흔',1);

drop table tblMember;

--회원 테이블
create table tblMember(
        seq number primary key,         --회원번호(PK)
        name varchar2(30) not null,     --회원명
        grade number(1) not null,       --회원등급(1,2,3)
        byear number(4) not null,   -- 생년
        tel varchar2(15) not null,      --연락처
        address varchar2(300) null,     --주소
        money number not null           --예치금

);

create sequence memberSeq;


-- 회원 데이터
INSERT INTO tblMember (seq, Name,Grade,Byear,Tel,address,Money) VALUES (memberSeq.NEXTVAL, '김유신',1,1970,'123-4567','12-3번지 301호',10000);
INSERT INTO tblMember (seq, Name,Grade,Byear,Tel,address,Money) VALUES (memberSeq.NEXTVAL, '강감찬',1,1978,'111-1111','777-2번지 101호',0);
INSERT INTO tblMember (seq, Name,Grade,Byear,Tel,address,Money) VALUES (memberSeq.NEXTVAL, '유관순',1,1978,'222-2222','86-9번지',20000);
INSERT INTO tblMember (seq, Name,Grade,Byear,Tel,address,Money) VALUES (memberSeq.NEXTVAL, '이율곡',1,1982,'333-3333',NULL,15000);
INSERT INTO tblMember (seq, Name,Grade,Byear,Tel,address,Money) VALUES (memberSeq.NEXTVAL, '신숙주',1,1988,'444-4444','조선 APT 1012호',0);
INSERT INTO tblMember (seq, Name,Grade,Byear,Tel,address,Money) VALUES (memberSeq.NEXTVAL, '안중근',1,1981,'555-5555','대한빌라 102호',1000);
INSERT INTO tblMember (seq, Name,Grade,Byear,Tel,address,Money) VALUES (memberSeq.NEXTVAL, '윤봉길',1,1981,'666-6666','12-1번지',0);
INSERT INTO tblMember (seq, Name,Grade,Byear,Tel,address,Money) VALUES (memberSeq.NEXTVAL, '이순신',1,1981,'777-7777',NULL,1500);
INSERT INTO tblMember (seq, Name,Grade,Byear,Tel,address,Money) VALUES (memberSeq.NEXTVAL, '김부식',1,1981,'888-8888','73-6번지',-1000);
INSERT INTO tblMember (seq, Name,Grade,Byear,Tel,address,Money) VALUES (memberSeq.NEXTVAL, '박지원',1,1981,'999-9999','조선 APT 902호',1200);

drop table tblRent;

delete from tblrent where seq=44;

--대여 테이블
create table tblRent(
    seq number primary key,     --대여번호(PK)
    member number not null references tblMember(seq), --회원번호(FK)
    video number not null references tblVideo(seq),   --비디오번호(FK)
    rentdate date default sysdate not null,             --대여시각
    retdate date null,                                 --반납시각
    remark varchar2(500) null                           --비고
    
);

drop sequence rentseq;
create sequence rentSeq;

-- 대여 데이터

INSERT INTO tblRent (seq, member, video, Rentdate, Retdate) VALUES (rentSeq.NEXTVAL, 1,1,'2007-01-01',NULL);
INSERT INTO tblRent (seq, member, video, Rentdate, Retdate) VALUES (rentSeq.NEXTVAL, 2,2,'2007-02-02','2001-02-03');
INSERT INTO tblRent (seq, member, video, Rentdate, Retdate) VALUES (rentSeq.NEXTVAL, 3,3,'2007-02-03',NULL);
INSERT INTO tblRent (seq, member, video, Rentdate, Retdate) VALUES (rentSeq.NEXTVAL, 4,3,'2007-02-04','2001-02-08');
INSERT INTO tblRent (seq, member, video, Rentdate, Retdate) VALUES (rentSeq.NEXTVAL, 5,5,'2007-02-05',NULL);
INSERT INTO tblRent (seq, member, video, Rentdate, Retdate) VALUES (rentSeq.NEXTVAL, 1,2,'2007-02-10',NULL);



select * from tblGenre; --6
select * from tblMember; --11
select * from tblVideo; --10
select * from tblrent; --6

조인, join
/*
- (서로 관계를 맺은) 2개(1개) 이상의 테이블의 내용을 가져와서 1개의 결과셋으로 만드는 작업

조인의 종류(ANSI) 
1. 단순 조인, cross join
2. 내부 조인, inner join(***)
3. 외부 조인, outer join(***)
4. 셀프 조인, self join
5.  전체 외부 조인, full outer join


*/

-- 1. 단순 조인
select * from tblCustomer; --3명
select * from tblSales;    --9건

select * from tblCustomer cross join tblSales; --3명 x 9건 = 27 대용량의 데이터를 만들때 데이터의 유효성 따위는 필요 없는 테스트용 데이터 1:1 ANSI SQL
select * from tblCustomer, tblSales; -- Oracle

-- 2. 내부 조인, inner join(교집합)
-- 단순 조인에서 유효한 레코드만 추출하는 조인 

select * from tblCustomer inner join tblSales on tblCustomer.seq = cseq;

select * from tblCustomer c 
    inner join tblSales s 
    on c.seq = s.cseq; -- 부모테이블(PK) = 자식테이블(FK)
    
select * from tblGenre; --부모   
select * from tblVideo; --자식

-- ORA-00918: column ambiguously defined 
select v.name, g.price, g.period from tblGenre g
    inner join tblVideo v
        on g.seq = v.genre;
        
select s.name,s.salary,p.project from tblStaff s 
    inner join tblProject p
        on s.seq = p.staff -- project가 여러개라서 그래서 이름이 겹치는 것??
        order by s.name;
        
select * from tbltodo;
select * from tblsales;

select * from tbltodo t
    inner join tblsales s
        on t.seq = s.seq; -- 두 테이블간의 관계가 없으면 의미가 없어
        
-- tblGenre + tblVideo
select * from tblGenre g
    inner join tblVideo v
        on g.seq = v.genre;
        
-- tblGenre + tblVideo + tblRent 
select * from tblGenre g
    inner join tblVideo v
        on g.seq = v.genre
        inner join tblRent r
            on r.video = v.seq;
        

-- tblGenre + tblVideo + tblRent + tblMember
select m.name,v.name, r.rentdate , g.period from tblGenre g
    inner join tblVideo v
        on g.seq = v.genre
        inner join tblRent r
            on r.video = v.seq 
               -- on  v.seq = r.video 
            inner join tblMember m 
                on m.seq = r.member; 
                
-- 3. 외부 조인, outer join(교집합 + 여집합)
-- 내부 조인 기반 + 부모 테이블(나머지)

select * from tblCustomer;
select * from tblSales;

insert into tblCustomer values(4,'호호호','010-1234-5678','서울시');

-- 내부 조인:: (구매 이력이 1건 이상인) 고객의 정보와 함께 구매 정보를 가져오시오.
select * from tblCustomer c
    inner join tblSales s
        on c.seq = s.cseq -- 고객의 번호가 판매자 번호에 등록이 되어야 돼서 호호호가 없는게 당연하거임
        order by c.seq asc;

-- 외부 조인:: (구매 이력과 상관없이) 고객의 정보와 함께 구매 정보를 가져오시오.
select * from tblCustomer c 
    left outer join tblSales s
        on c.seq = s.cseq
            order by c.seq asc;

-- tblStaff + tblProject 
-- 내부조인 : 프로젝트를 1건이상 담당한 직원의 정보 + 프로젝트 정보 
-- 외부조인 : 프로젝트 담당 유무와 상관없이 모든 직원 정보 + 프로젝트 정보 

select * from tblMember; --10명
select * from tblrent; --6건

select * from tblMember m
    inner join tblRent r
         on m.seq = r.member; --6개가 나옴, 무조건 자식 테이블 갯수만큼 나옴, 자식 테이블 레코드 수 == 내부 조인 결과
        
-- right: inner 조인
-- 부모 테이블을 가리키면 돼 outer join 
select * from tblMember m
    left outer join tblRent r
         on m.seq = r.member;
         
-- 4. 셀프 조인, self join
-- 1개의 테이블을 사용해서 조인
-- 단순 조인, 내부 조인, 외부 조인 <> 셀프 조인
-- 단순 조인 + 셀프 조인, 내부 조인 + 셀프 조인, 외부 조인 + 셀프 조인 

-- 직원 테이블
create table tblSelf
(
    seq number primary key,     --직원 번호(PK)
    name varchar2(30) not null, --직원명
    department varchar2(50) null, --부서명
    super number null references tblSelf(seq) --상사번호(FK) 자기참조
);
         
insert into tblSelf values(1,'홍사장',null,null);

insert into tblSelf values(2,'김부장','영업부',1);
insert into tblSelf values(3,'이과장','영업부',2);
insert into tblSelf values(4,'정대리','영업부',3);
insert into tblSelf values(5,'최사원','영업부',4);

insert into tblSelf values(6,'박부장','개발부',1);
insert into tblSelf values(7,'하과장','개발부',6);

-- 상사가 존재하는 직원들을 가져오세요
-- s1은 직원, s2는 상사
select 
    s1.name as 직원명,
    s1.department as 부서명,
    s2.name as 상사명
from tblSelf s1 
    inner join tblSelf s2 
        on s1.super = s2.seq;

select 
    s1.name as 직원명,
    s1.department as 부서명,
    s2.name as 상사명
from tblSelf s1 
    left outer join tblSelf s2 
        on s1.super = s2.seq; 

-- s2의 seq를 상사명으로 하는게 1~7까지 상사라고 치고 그 중에 s1.super하고 같으면 이지만 s1의 직원이 전체를 포함해서 출력하는 거니까
        

create table tblSelf2
(
    seq number primary key,     --직원 번호(PK)
    name varchar2(30) not null, --직원명
    department varchar2(50) null
);

insert into tblSelf2 values(1,'홍사장',null);

insert into tblSelf2 values(2,'김부장','영업부');
insert into tblSelf2 values(3,'이과장','영업부');
insert into tblSelf2 values(4,'정대리','영업부');
insert into tblSelf2 values(5,'최사원','영업부');

insert into tblSelf2 values(6,'박부장','개발부');
insert into tblSelf2 values(7,'하과장','개발부');



-- 부하직원이 없는 최사원과 하과장 까지 출력이 돼
select * from tblSelf s1
    right outer join tblSelf2 s2
        on s1.super = s2.seq;

-- 상사가 없는 홍사장이 출력이 됨
select * from tblSelf s1
    left outer join tblSelf2 s2
        on s1.super = s2.seq;
        



