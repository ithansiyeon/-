-- ex09_aggregation_functio.sql

/*

메서드 vs 함수, 서브루틴, 프로시저 등... 


집계함수, Aggregation Function
- 다량의 데이터를 대상으로 통계값을 구하는 함수 


1. count()
2. sum()
3. avg()
4. max()
5. min()

1. count()
- select > 결과셋의 레코드 수를 반환한다.
- number count(대상컬럼)
- 매개변수는 단 1개의 컬럼명을 넣을 수 있다.
- 예외로 *을 넣을 수 있다.
- null은 제외한다.(***) => 존재하지 않아서 세지를 않음 


*/

select name from tblCountry;
select count(name) from tblCountry;

select count(name) from tblInsa where city in ('서울','인천'); --29
select count(name) from tblInsa where ssn like '%-2%';
select count(name) from tblInsa where ssn like '%-1%';

select count(*) from tblCountry; -- 다중컬럼의 개수를 샌것 
select count(name,capital) from tblCountry;

select population from tblCountry;
select count(population) from tblCountry;

select count(name) from tblCountry; -- 14
select count(population) from tblCountry; --null은 빈값, 데이터가 아님  -- 13
select count(*) from tblCountry; --전체를 하나의 데이터로 생각(부분적으로 null값이 있어도 어느 누구도 빠질 수 없어서)

select * from tblTodo;
select count(*) from tblTodo; -- 전체 행수를 센것

-- 한 일 갯수? 안한일 갯수?
select count(*) from tblTodo where completedate is not null; --12
select count(*) from tblTodo where completedate is null; --8

select count(*), count(completedate), count(*)-count(completedate) from tblTodo; --한번에 얻은 것 

-- tblInsa. 총 인원수? 연락처O ?, 연락처X ?
select
    count(*) as 총인원수,
    count(tel) as 연락처있음,
    count(*) - count(tel) as 연락처없음
from tblInsa;

-- tblComedian. 남자 몇명? 여자 몇명?
select * from tblComedian;

-- null이 없어서 위에 방식하고 할 수 없음 
select count(*) from tblComedian where gender = 'm' ; --8
select count(*) from tblComedian where gender = 'f' ; --2

select 
    count(case  
        when gender = 'm' then 1 -- then 뒤에 있는 의미가 없어 null이 아니기만 하면 돼 
    end) as 남자수,
    count(case  
        when gender = 'f' then 1  
    end) as 여자수
from tblComedian; 


-- 모든 집계 함수 사용시 주의점 > 에러 발생 
--1. ORA-00937: not a single-group group function
-- 컬럼 리스트에 집계 함수(집합)와 단일 컬럼은 동시에 사용할 수 없다.
select count(*), name from tblInsa; 

select count(*), name from tblInsa; 
select name from tblInsa;

--2. ORA-00934: group function is not allowed here 
-- where절에는 집계 함수를 사용할 수 없다.
-- where절의 개인에 대한 질문 -> 집합값 사용 불가능 
select avg(basicpay) from tblInsa;
select * from tblInsa where basicpay > avg(basicpay);

select count(100) from tblInsa; -- 상수 컬럼, 눈에 보이면 다 세줘


/*

2. sum() 
- number sum(대상컬럼) 
- 해당 컬럼값의 총합을 구한다.
- 숫자형에만 사용 가능(문자형X,날짜형X)
*/

select sum(weight) from tblComedian; -- 자동 집계를 함 
select sum(first) from tblComedian;  --문자열 ORA-01722: invalid number
select sum(ibsadate) from tblInsa; --날짜시간 ORA-00932: inconsistent datatypes: expected NUMBER got DATE

select 
    sum(basicpay), sum(sudang),
    sum(basicpay) + sum(sudang),
    sum(basicpay + sudang)
from tblInsa;


select 
    count(case 
        when gender = 'm' then 1 -- 의미 없는 값. 존재O
    end),
    sum(case 
        when gender = 'm' then 1 -- 의미 있는 값, sum도 null을 제외 
    end)
from tblComedian;

/*

3. avg() 
- number avg(대상컬럼) 
- 해당 컬럼값의 평균값을 반환한다.
- 숫자형만 가능하다. 
*/

select 
    avg(basicpay),
    sum(basicpay) / count(*)
from tblInsa

select 
    avg(population), --15588
    sum(population) / count(*), -- 14475, 인구수가 없는 얘까지 센것
    sum(population) / count(population) --15588
from tblCountry;

-- 회사 성과급 지급
-- 1. 균등 지급 : 총지급액 / 모든 팀원수 = sum() / count(*)
-- 2. 차등 지급 : 총지급액 / 참여 팀원수 = sum() / count(참여인원) -> avg()


/*
4. max()
5. min()
- object max(대상 컬럼명) : 최댓값 반환
- object min(대상 컬럼) : 최솟값 반환 
- 모든 자료형에 사용 가능 
*/

select max(height), min(weight) from tblComedian; --숫자형
select max(name), min(name) from tblInsa; --문자형 
select max(ibsadate),min(ibsadate) from tblInsa; --날짜시간형 신입, 고참

select
    count(*) as "총 직원 수",
    sum(basicpay) as "총 급여 합",
    avg(basicpay) as "평균 급여",
    max(basicpay) as "최대 급여",
    min(basicpay) as "최소 급여"
from tblInsa
where buseo = '기획부';

-- sum()
-- tblCountry
-- 1. 유럽과 아프리카에 속한 나라의 인구의 총합? 14,198
select * from tblCountry;
select sum(population) from tblCountry where continent in('EU','AF') ;

-- 2. employees. 매니저(108)이 관리하고 있는 직원들의 급여 총합? 39,600
select * from employees;
select sum(salary) from employees where manager_id = 108;

--3. 직업(ST_CLERK,SH_CLERK)을 가지고 있는 직원들의 급여 총합? 120,000
select sum(salary) from employees where job_id in('ST_CLERK','SH_CLERK');

--4. tblInsa. 서울에 있는 직원들의 급여합(basicpay + sudang) 33,812,400
select * from tblInsa;
select sum(basicpay+sudang) from tblInsa where city = '서울';

--5. 장급(부장,과장)들의 급여 총합? 36,289,000
select sum(basicpay) from tblInsa where jikwi in ('부장','과장');

--avg() 얘만 신경쓰면 돼 
--1. tblCountry. 아시아에 속한 국가의 평균 인구수? 39,165
select * from tblCountry;
select avg(population) from tblCountry where continent = 'AS';

--2. 장급(부장,과장)의 평균 급여? 2,419,266
select * from tblInsa;
select avg(basicpay) from tblInsa where jikwi in ('부장','과장');
--3. 장급(부장,과장)의 평균 급여와 사원급(대리,사원)의 평균 급여 차액? 1,150,320 case
select 
    avg(case when jikwi in ('부장','과장') then basicpay end) - avg(case when jikwi in ('대리','사원') then basicpay end)
from tblInsa;
-- max(), min()
-- 1. 면적이 가장 넓은 나라의 면적? 959
select max(area), min(area) from tblCountry;

--2. 급여(basicpay + sudang)가 가장 적은 직원은 얼마를 받는지? 988,000
select min(basicpay + sudang) from tblInsa;

select count(distinct buseo) from tblInsa;

select buseo from tblInsa;
select count(all buseo) from tblInsa;



select 
    buseo as 부서, 
    m as 급여, 
    (select name from tblInsa i where i.basicpay = a.m and rownum = 1) as 직원명 
from (select buseo, max(basicpay) as m from tblInsa
    group by buseo
        order by buseo) a;












