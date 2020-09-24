-- ex24_pseudo.sql

/*

의사 컬럼, Pseudo Column
- 실제 컬럼이 아닌데 컬럼처럼 행동하는 객체 
- 오라클 전용. MS_SQL(top),MySQL(limit)
- rownum 
- rownum은 from절이 실행된 직후 호출(+계산)이 된다. > 하나의 select from에서 단 한번만 실행


*/

select name,buseo,jikwi,rownum from tblInsa; --rownum 행번호

--질문의 조건에 1행이 포함이 되면 O, 포함이 안되면 X
select name,buseo,jikwi,rownum from tblInsa where rownum = 1;
select name,buseo,jikwi,rownum from tblInsa where rownum <= 5;
select name,buseo,jikwi,rownum from tblInsa where rownum = 10;
select name,buseo,jikwi,rownum from tblInsa where rownum >= 5 and rownum <= 10;


select name,buseo,jikwi,rownum from tblInsa order by name; -- from에서 rownum이 매개져지고 그 다음 order by로 정렬됨

-- tblInsa. 급여를 가장 많이 받는 직원. Top 5
select name,buseo,jikwi,basicpay from tblInsa order by basicpay desc;

-- 원하는 정렬을 한 후 -> 제대로된 rownum을 얻는 방법 -> 서브 쿼리 사용 
select name,buseo,jikwi,basicpay, rownum
    from (select name,buseo,jikwi,basicpay from tblInsa order by basicpay desc)
        where rownum<=5;
-- from절 하나당 rownum이 새로 할당됨


-- tblInsa. 급여를 가장 많이 받는 직원. Top 6 ~ 10
-- 특정 테이블 -> 내가 원하는 정렬 + 내가 원하는 범위 추출 -> 최소 서브쿼리 2개 이상 
select name,buseo,jikwi,basicpay,rnum, rownum from  -- rnum은 정적인 데이터, rownum 계산된 값
(select name,buseo,jikwi,basicpay, rownum as rnum
    from (select name,buseo,jikwi,basicpay from tblInsa order by basicpay desc))
    where rnum between 6 and 10; -- 1~6사이가 포함이 되야 돼 

create or replace view vwBasicpay
as 
select name,buseo,jikwi,basicpay, rownum as rnum
    from (select name,buseo,jikwi,basicpay from tblInsa order by basicpay desc);

select * from vwBasicpay where rnum = 3;


select * from tblAddressbook;

--지역별(hometown) 거주자가 가장 많은 순서 Top 3
select a.*,rownum from (select 
                  hometown,count(*) as cnt
                   from tblAddressbook
                      group by hometown
                         order by count(*) desc) a
                         where rownum<=3;
-- 1. 정렬 2. 서브쿼리 정렬된 순서의 rownum 
-- 1이 포함된건 그 상태에서 해결 1이 포함되지 않으면 서브쿼리를 또 만들어서 해결함 

--지역별(hometown) 거주자가 가장 많은 순서 Top 4 ~ 6
select b.* from (select a.*,rownum as rnum from (select 
                  hometown,count(*) as cnt
                   from tblAddressbook
                      group by hometown
                         order by count(*) desc) a
                       ) b where rnum between 4 and 6
                         ;


select * from (select a.*,rownum as rnum from (select 
                  hometown,count(*) as cnt
                   from tblAddressbook
                      group by hometown
                         order by count(*) desc) a
                       ) where rnum between 4 and 6
                         ;
                         
-- tblInsa. 부서별 인원수가 가장 많은 두번째 부서?

select * from(select a.*,rownum as rnum from(select buseo,count(*) as cnt
    from tblInsa group by buseo order by count(*) desc) a)
    where rnum=2;
    
    
    





            

    











