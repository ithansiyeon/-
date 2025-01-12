-- ex13_casting.sql

-- 형변환 함수 
-- 1. to_char()     : 숫자 -> 문자
-- 2. to_char()     : 날짜 -> 문자 ******
-- 3. to_number()   : 문자 -> 숫자
-- 4. to_date()     : 문자 -> 날짜 ******

-- 1. to_char() : 숫자 -> 문자
-- char to_char(대상 컬럼, 형식문자열)

-- 형식문자열 구성요소 
-- a. 9 
-- b. 0
-- c. $
-- d. L
-- e. .
-- f. ,

-- 숫자 우측, 문자 좌측
select 
    100 as 컬럼입니다컬럼입니다,
    '100'as 컬럼입니다컬럼입니다,
    to_char(100) as 컬럼입니다컬럼입니다,
    to_char(100,'999') as 컬럼입니다컬럼입니다, -- 문자 3자리로 표현, 빈공간을 공백으로 채움 
    to_char(-100,'999') as 컬럼입니다컬럼입니다,
    trim(to_char(10,'999')) as 컬럼입니다컬럼입니다,
    to_char(1,'999') as 컬럼입니다컬럼입니다,
    to_char(100,'000') as 컬럼입니다컬럼입니다, -- 빈공간을 0으로 채움, 실인자 값이 형식 문자보다 크면 에러가 발생
    to_char(10,'000') as 컬럼입니다컬럼입니다,
    to_char(1,'000') as 컬럼입니다컬럼입니다

    
from dual;

select 
100,
    to_char(100,'$999'), --통화(Currency)
    '$' || to_char(100,'999'),
    '$' || to_char(-100,'999'),
    to_char(100,'999') || '원',
    to_char(100,'L999') -- Locale(지역 설정)
from dual;

-- 숫자 우측 정렬


select 
    1234567,
    to_char(1234567,'9,999,999'), -- %,d 
    to_char(123.456,'999.999'), 
    to_char(123.456,'99999.9') -- 소수 이하 자릿수 반올림이 됨
from dual;




-- 2. to_char() : 날짜 -> 문자
-- char to_char(대상 컬럼,'형식 문자열')

-- 형식 문자열 구성 요소
-- a. yyyy (**)
-- b. yy
-- c. month
-- d. mon
-- e. mm (**)
-- f. day
-- g. dy
-- h. ddd,dd(**),d
-- i. hh,hh24(**)
-- j. mi(**)
-- k. ss(**)
-- l. am(pm)

select sysdate from dual;
select to_char(sysdate,'yyyy') from dual; -- 2020(4자리) **
select to_char(sysdate,'yy') from dual;    -- 20(2자리)
select to_char(sysdate,'month') from dual; -- 5월 (풀네임)
select to_char(sysdate,'mon') from dual; -- 5월 (약어)
select to_char(sysdate,'mm') from dual; -- 05 (2자리 숫자) **
select to_char(sysdate,'day') from dual; -- 월요일(풀네임) 
select to_char(sysdate,'dy') from dual; -- 월 (약어)
select to_char(sysdate,'ddd') from dual; -- 146 (올해의 며칠)
select to_char(sysdate,'dd') from dual; -- 25 (이번달의 며칠) **
select to_char(sysdate,'d') from dual; -- 2 (이번주의 며칠 == 요일)
select to_char(sysdate,'hh') from dual; -- 04(12시)
select to_char(sysdate,'hh24') from dual; -- 16(24시) **
select to_char(sysdate,'mi') from dual;  -- 10분
select to_char(sysdate,'ss') from dual; -- 53초
select to_char(sysdate,'am') from dual; -- 오후 
select to_char(sysdate,'pm') from dual; -- 오후 am,pm은 차이가 없어 

select 
    sysdate, --20/05/25
    to_char(sysdate,'yyyy--mm--dd'), --2020--05--25
    to_char(sysdate,'hh24:mi:ss'), --16:13:37
    to_char(sysdate,'day am hh:mi:ss')
        
from dual;

-- 컬럼 리스트에서 사용
select to_char(sysdate,'yyyy-mm-dd hh24:mi:ss') from dual; -- **꼭 기억!!!

-- 조건절에서 사용 
select name, to_char(ibsadate,'day') from tblInsa
--where ibsadate between '2010-01-01' and '2011-01-01'; --0시 0분 0초 생각해 
--where to_char (ibsadate,'yyyy') = '2010'; --O
where to_char(ibsadate,'d') in (1,7); --주말

-- 정렬에서 사용
select name, to_char(ibsadate,'day') from tblInsa
order by to_char(ibsadate,'d') asc;

select distinct to_char(ibsadate,'day') from tblInsa;

-- 요일별 입사 사원수?
select 
    count(decode(to_char(ibsadate,'dy'),'일',1)) as 일, 
    count(decode(to_char(ibsadate,'dy'),'월',1)) as 월, 
    count(decode(to_char(ibsadate,'dy'),'화',1)) as 화, 
    count(decode(to_char(ibsadate,'dy'),'수',1)) as 수, 
    count(decode(to_char(ibsadate,'dy'),'목',1)) as 목, 
    count(decode(to_char(ibsadate,'dy'),'금',1)) as 금, 
    count(decode(to_char(ibsadate,'dy'),'토',1)) as 토 
from tblInsa; -- 레코드가 하나라서 정렬의미가 없음



-- 3. to_number() : 문자 -> 숫자
-- number to_number(대상 컬럼) 
-- 잘 사용 안함 -> 암시적 형변환 발생 
select '123', to_number('123') from dual;
select 123 * 2, '123' * 2, to_number('123') * 2 from dual; -- 숫자 format을 갖는 문자선에서만 해줌


-- 4. to_date() : 문자 -> 날짜 
-- date to_date(대상 컬럼, '형식 문자열')
-- 형식 문자열은 to_char()와 동일하게 사용 

select sysdate, '2010-01-01' from dual; --20/05/25, 10/01/01 날짜로 인식하면

select sysdate, to_date('2010-01-01','yyyy-mm-dd') from dual; 

select sysdate, to_date('20100101','yyyymmdd') from dual; -- 대쉬를 지워주는게 올바른 형태

select * from tblInsa where ibsadate > '2010-01-01'; -- 암시적 형변환 발생 -> to_date() 호출

select * from tblInsa where ibsadate > to_date('2010-01-01','yyyy-mm-dd'); --정석

select * from tblInsa where ibsadate > '2010-01-01 12:00:00';

select * from tblInsa 
            where ibsadate > to_date('2010-01-01 12:00:00','yyyy-mm-dd hh24:mi:ss');
            
select '14:23:45', to_date('14:23:45','hh24:mi:ss') from dual; --20/05/01



-- null 함수
-- 1. nvl() -> null value
-- object nvl(대상 컬럼,object)
-- 2. nvl2() (가공할때 쓰여)
-- object nvl2(대상 컬럼,object,object)

select name, nvl(couple, '여차친구 없음'), nvl2(couple,'O','X') as 여자친구유무 from tblMen;

-- 6장 + 7-1절
-- 12장










