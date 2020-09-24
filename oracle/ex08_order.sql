-- ex08_order.sql

/*

정렬, Sort 
- order by 절 
- select문과 같이 사용
- 원본 테이블 정렬(x) -> 결과 테이블 정렬(O)
- 정렬의 기준으로 컬럼을 지정한다.
- 오름차순, 내림차순 

1. select 절
2. from 절
3. where절 
4. order by절 



*/

select * from tblInsa order by name; -- 생략하면 오름차순
select * from tblInsa order by name asc;
select * from tblInsa order by name desc;

-- 정렬 대상으로 가능한 자료형
select * from tblInsa order by basicpay desc; --숫자
select * from tblInsa order by name; --문자
select * from tblInsa order by ibsadate desc; --날짜시간
select * from tblInsa order by basicpay desc; --허경운
select * from tblInsa order by basicpay + sudang desc; --홍길동

--부장(4) > 과장(3) > 대리(2) > 사원(1)
select * from tblInsa order by jikwi desc;

select 
    name, jikwi
    from tblInsa 
    order by 
    case
        when jikwi = '부장' then 4
        when jikwi = '과장' then 3
        when jikwi = '대리' then 2
        when jikwi = '사원' then 1
    end desc;
    
select name,jikwi from tblInsa where jikwi in ('과장', '부장');

select name, jikwi
from tblInsa
where case
        when jikwi = '부장' then 4
        when jikwi = '과장' then 3
        when jikwi = '대리' then 2
        when jikwi = '사원' then 1
       end >= 3;

-- 다중정렬
select * from tblInsa order by city asc; -- 1차정렬
select * from tblInsa order by city asc, buseo desc; -- 2차정렬
select * from tblInsa order by city asc, buseo desc, name asc; -- 3차정렬