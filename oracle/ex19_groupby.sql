--ex19_groupby.sql

/*


group by 절
- 레코드를 특정 컬럼값(1개 or 그 이상)에 맞춰서 그룹을 나누는 역할 
- 그룹을 왜 나누는지> -> 각각의 나눠진 그룹을 대상 -> 집계 함수를 적용하기 위해서(***)
- group by 컬럼명 

select 컬럼리스트 
from 테이블 
where 조건
group by 절
order by 컬럼

1. from 테이블 
2. where 조건
3. group by 절
4. select 컬럼리스트 
5. order by 컬럼

*/

-- 공통적인 성격의 데이터를 여러 개체가 가지고 있으면 그룹을 나눌 수 있어
-- 부서별 그룹
select count(*) from tblInsa group by buseo; -- 개개인의 값이 못와, 집계함수가 올 수 있어

-- 부서별로 평균 급여? 
select * from tblInsa;

select round(avg(basicpay)) from tblInsa; --155만원

select distinct buseo from tblInsa;

select round(avg(basicpay)) from tblInsa where buseo = '총무부'; --171
select round(avg(basicpay)) from tblInsa where buseo = '개발부'; --138
select round(avg(basicpay)) from tblInsa where buseo = '영업부'; --160
select round(avg(basicpay)) from tblInsa where buseo = '기획부'; --185
select round(avg(basicpay)) from tblInsa where buseo = '인사부'; --153
select round(avg(basicpay)) from tblInsa where buseo = '자재부'; --141
select round(avg(basicpay)) from tblInsa where buseo = '홍보부'; --145

select round(avg(basicpay)), count(*), buseo from tblInsa group by buseo; -- group by에 쓰여 있는 건 단독으로 사용 가능 그 외에는 집계 함수로 
-- 단일 컬럼과 집합을 같이 쓸 수 없어 

select * from tblComedian;

--행
select 
    count(decode(gender,'m',1)) as 남자,
    count(decode(gender,'f',1)) as 여자
from tblComedian;

--종
select
    count(*), gender
from tblComedian
group by gender;

select  
    job,count(*)
from tblAddressBook
group by job 
order by count(*) desc;

-- 다중 그룹
select 
    buseo,city,jikwi,count(*) 
from tblInsa 
group by buseo,city,jikwi
order by buseo,city,jikwi; -- 그룹안에서 지역별로 그룹, 그룹을 세분화 한 것 

-- group by + 집계 함수
select 
    hometown as "지역",
    count(*) as "지역별 인구수",
    round(avg(weight),1) as "지역별 평균 몸무게",
    max(weight) as "지역별 최고 몸무게",
    min(weight) as "지역별 최저 몸무게",
    sum(weight) as "지역별 몸무게 총합"
from tblAddressBook
group by hometown;
        
select 
    nvl2(completedate,'o','x'),
    count(*)
from tblTodo
group by  nvl2(completedate,'o','x'); --가공된 결과값도 그룹으로 삼을 수 있어 

select 
     substr(ssn,8,1),
     count(*)
from tblInsa
group by substr(ssn,8,1); -- 공통점을 만들어서라도 묶어

/*
having 절 
- 조건절 

select 컬럼리스트 
from 테이블 
where 조건
group by 절
having 절
order by 컬럼

1. from 테이블 
2. where 조건 
3. group by 절
4. having 절
5. select 컬럼리스트 
6. order by 컬럼

from 절 -> where절 : 개인에 대한 질문(조건)
group by절 -> having절 : 그룹(집계 함수 결과)에 대한 질문(조건)


*/

select 
    buseo,count(*)
from tblInsa
--where count(*)>10 개인에 대한 질문
group by buseo
having count(*) > 10; --집합에 대한 질문

select
    buseo,round(avg(basicpay))
from tblInsa
--where basicpay >= 1550000 -- 60명을 대상으로 155만원 이상 사람을 가져와 그룹을 이뤄 그 사람들의 평균, 단일 컬럼
group by buseo
having avg(basicpay) >= 1550000; -- 60명을 그룹을 묶어 그룹의 결과가 having을 만족하면 가져와, 그룹을 요소로 생각해서 걸러내, 집계함수, 일반 컬럼이 못와


-- 날짜 
select 
    to_char(buydate,'dd'),
    count(*) as 날짜별구매횟수,
    sum(qty) as 날짜별구매개수,
    max(price) as 날짜별최대단가,
    max(qty*price) as 날짜별최대구매비용
from tblhousekeeping
group by to_char(buydate,'dd')
order by to_char(buydate,'dd') asc;

select 
    case
        when price >=0 and price < 3000 then '저가'
        when price >=3000 and price < 10000 then '중가'
        when price >=10000 then '고가'
    end as price, 
    count(*)
from tblhousekeeping
group by case
        when price >=0 and price < 3000 then '저가'
        when price >=3000 and price < 10000 then '중가'
        when price >=10000 then '고가'
    end;
-- 그룹으로 묶기 위해서 

-- tblInsa. 부서별 직급의 인원수 가져오기
-- [부서] [인원]    [부장]    [과장]    [대리]    [사원]
-- 총무부 7            1       2           3       1
-- 개발부 14           2       2           4       6
-- 영업부 16           1       1           2       12

select 
    buseo as "부서",
    count(*) as "인원", 
    count(decode(jikwi,'부장',1)) as "부장",
    count(decode(jikwi,'과장',1)) as "과장",
    count(decode(jikwi,'대리',1)) as "대리",
    count(decode(jikwi,'사원',1)) as "사원"
from tblInsa
group by buseo;
-- 부서별로 총 인원수와 직급별로 가져온것

-- group by 대상 컬럼 or 집계함수
select 
    buseo, count(*) 
from tblInsa
group by buseo;

select 
    buseo,jikwi, count(*) -- 부서,직위로 그룹을 나눠
from tblInsa
group by buseo, jikwi
order by buseo asc, jikwi asc
;

select 
    buseo, count(*) 
from tblInsa
group by buseo
--having avg(basicpay) > 1500000; -- 각 부서의 평균 급여 각 그룹에 질문 7개의 부서 중 
having count(*) > 10;

-- group by 결과를 좀 더 자세하게 출력하는 함수 
-- rollup(), cube() : summary 직계 함수를 또 집계 해주는 것
select 
    buseo,
    count(*)
from tblInsa
group by rollup(buseo); -- 총 합을 보여줘 

select 
    buseo,
    count(*),
    sum(basicpay),
    avg(basicpay),
    max(basicpay),
    min(basicpay)
from tblInsa
group by rollup(buseo); -- avg는 전체 평균

select 
    buseo,
    jikwi,
    city,
    count(*)
from tblInsa
group by rollup(buseo, jikwi,city) --중간 집계를 반환해줘
order by buseo,jikwi,city; 

select 
    buseo,
    count(*)
from tblInsa
group by cube(buseo)
order by buseo;


select 
    buseo,
    jikwi,
    count(*)
from tblInsa
group by cube(buseo,jikwi)
order by buseo,jikwi;
-- 큐브는 롤업보다 detail 함, 1차에 대해서 집계 

select 
    buseo,
    jikwi,
    city,
    count(*)
from tblInsa
group by cube(buseo,jikwi,city)
order by buseo,jikwi,city;

-- listagg
-- 11g 이후
select 
    buseo,
    count(*),
    listagg(name,', ') within group(order by name asc) as name -- 속해 있는 리스트를 만들어 
from tblInsa
group by buseo
order by buseo;

select 
    buydate,
    count(*),
    listagg(item,', ') within group(order by item) as item,
    sum(qty*price) as totalprice
from tblhousekeeping
group by buydate
order by buydate;















