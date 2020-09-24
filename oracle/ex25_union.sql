--ex25_union.sql

/*

조인, join
- 테이블을 합치는 기술 
- 횡(가로) 합치기

유니온,union 
- 테이블을 합치는 기술
- 종(세로) 합치기
- union, union all, intersect, minus

*/

select * from tblMen;
select * from tblWomen;

-- 커플인 남녀 정보 
select * from tblMen m
    inner join tblWomen w
        on m.name = w.couple;

-- 커플 + 남자 모두 
select * from tblMen m
    left outer join tblWomen w
        on m.name = w.couple; -- 여자친구 정보가 없는 얘들이 나옴
        
-- 커플 + 여자 모두 
select * from tblMen m
    right outer join tblWomen w
        on m.name = w.couple;

-- 커플 + 남자 + 여자
select * from tblMen m
    full outer join tblWomen w
        on m.name = w.couple;

select * from tblMen 
union
select * from tblWomen; --세로로 합친것 

-- union 주의점
-- 1. 컬럼 개수
-- 2. 컬럼 타입 
-- 3. 컬럼 성격(***)

-- 각 순서에 맞는 타입 
select name,age,height from tblMen 
union
select name,age,height from tblWomen; --세로로 합친것 

select age from tblMen
union 
select population from tblCountry;

select name,tel from tblInsa
union
select name,tel from tblAddressbook;

create table tblUnionA
(
    name varchar2(30) not null
);

create table tblUnionB
(
    name varchar2(30) not null
);

insert into tblUnionA values('사과');
insert into tblUnionA values('바나나');
insert into tblUnionA values('파인애플');
insert into tblUnionA values('망고');
insert into tblUnionA values('귤');

insert into tblUnionB values('자두');
insert into tblUnionB values('복숭아');
insert into tblUnionB values('포도');
insert into tblUnionB values('딸기');
insert into tblUnionB values('파인애플');

-- 합집합: 중복값이 존재하면 distinct 처리(자동제거)
select * from tblUnionA
union
select * from tblUnionB;

-- 중복값을 그대로 보관
select * from tblUnionA
union all
select * from tblUnionB;

-- 교집합
select * from tblUnionA
intersect
select * from tblUnionB;

-- 차집합(A - B)
select * from tblUnionA
minus
select * from tblUnionB;

-- (B - A)
select * from tblUnionB
minus
select * from tblUnionA;









