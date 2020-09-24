--//question

--요구사항.001
--모든 행과 모든 컬럼을 가져오시오.
select * from tblCountry;

--테이블
--tblCountry
--요구사항.002
--국가명과 수도명을 가져오시오.
select name,capital from tblCountry;

--테이블
--tblCountry
--요구사항.003

select name as "[국가명]", capital as "[수도명]", population as "[인구수]", area as "[면적]", continent as "[대륙]" from tblCountry;

--테이블
--tblCountry

--[국가명]       [수도명]       [인구수]       [면적]        [대륙]
--대한민국        서울          4405          10           AS
--.. 14개
--도움
--
--별칭(Alias) 사용
--요구사항.004
--아래와 같이 가져오시오


select '국가명:' || name || ', ' ||
        '수도명:' || capital || ', ' ||
        '인구수:' || population as "[국가정보]" from tblCountry;
        
        
--tblCountry
--출력

--[국가정보]
--국가명:대한민국, 수도명:서울, 인구수:4405
--국가명:중국, 수도명:베이징, 인구수: 120660
--.. 14개
--도움

--별칭(Alias) 사용
--문자열 더하기 연산(||) 사용
--요구사항.005
--아래와 같이 가져오시오

select * from employees;
select first_name || last_name as "[이름]", email as "[이메일]", phone_number as "[연락처]", '$' || salary as "[급여]" from employees;  
--employees
--출력

--[이름]            [이메일]               [연락처]           [급여]
--Steven King      SKING@GMAIL.COM       515.123.4567      $24000
--..100여명
--도움

--별칭(Alias) 사용
--문자열 더하기 연산(||) 사용
--요구사항.006
--면적(area)이 100이하인 국가의 이름과 면적을 가져오시오.

select * from tblCountry;
select name,area from tblCountry where area<=100;

--tblCountry
--도움

--조건절(where) 사용
--요구사항.007
--아시아와 유럽 대륙에 속한 나라를 가져오시오.
select * from tblCountry;
select * from tblCountry where continent in('AS','EU');

--tblCountry
--도움

--조건절(where) 사용
--in 사용
--요구사항.008
--직업(job_id)이 프로그래머(it_prog)인 직원의 이름(풀네임)과 연락처 가져오시오.
select * from employees;
select first_name || last_name , phone_number from employees where job_id = 'IT_PROG';

--employees
--도움

--조건절(where) 사용
--요구사항.009
--last_name이 'Grant'인 직원의 이름, 연락처, 고용날짜를 가져오시오.
select first_name || last_name, phone_number, hire_date from employees where last_name='Grant';

--employees
--도움

--조건절(where) 사용
--요구사항.010
--특정 매니저(120)이 관리하는 직원의 이름, 급여, 연락처를 가져오시오.
select first_name || last_name,salary,phone_number from employees where manager_id = 120;

--employees
--도움
--
--조건절(where) 사용
--요구사항.011
--특정 부서(60, 80, 100)에 속한 직원들의 이름, 연락처, 이메일, 부서ID 가져오시오.
select first_name || last_name,phone_number,email,job_id from employees where department_id in(60,80,100);


--employees
--도움
--
--조건절(where) 사용
--in 사용
--요구사항.012
--기획부 직원들 가져오시오.
select * from tblinsa;
select * from tblinsa where buseo = '기획부';

--tblinsa
--도움

--조건절(where) 사용
--요구사항.013
--서울에 있는 직원들 중 직위가 부장인 사람의 이름, 직위, 전화번호 가져오시오.

select name,jikwi,tel from tblinsa where city = '서울' and jikwi = '부장';

--테이블

--tblinsa
--도움

--조건절(where) 사용
--요구사항.014
--기본급여 + 수당 합쳐서 150만원 이상인 직원 중 서울에 직원만 가져오시오.

select * from tblinsa where basicpay+sudang >=1500000 and city = '서울';

--테이블

--tblinsa
--도움

--조건절(where) 사용
--요구사항.015
--수당이 15만원 이하인 직원 중 직위가 사원, 대리만 가져오시오.

select * from tblinsa where sudang <= 150000 and jikwi in ('사원','대리');
--테이블

--tblinsa
--도움

--조건절(where) 사용
--in 사용
--요구사항.016
--수당을 제외한 기본 연봉이 2천만원 이상, 서울, 직위 과장(부장)만 가져오시오.
select * from tblinsa;
select * from tblinsa where basicpay * 12 >= 20000000 and city = '서울' and jikwi in ('과장','부장');
--테이블

--tblinsa
--도움

--조건절(where) 사용
--in 사용
--요구사항.017
--국가명 'O국'인 나라를 가져오시오.
select * from tblCountry;
select * from tblCountry where name like '_국';
--테이블

--tblCountry
--조건

--국가명 2글자
--추가조건

--국가명 글자수 상관없이
--도움

--조건절(where) 사용
--like 사용
--요구사항.018
--연락처가 515로 시작하는 직원들 가져오시오.

select * from employees;
select * from employees where phone_number like '515%';
--employees
--도움

--조건절(where) 사용
--like 사용
--요구사항.019
--직업 ID가 SA로 시작하는 직원들 가져오시오.
select * from employees;
select * from employees where job_id like 'SA%';
--테이블

--employees
--도움

--조건절(where) 사용
--like 사용
--요구사항.020
--first_name에 'de'가 들어간 직원들 가져오시오.
select * from employees where first_name like '%de%' or first_name like '%DE%' or first_name like '%dE%' or first_name like '%De%';
--테이블

--employees
--조건

--대소문자 상관없이
--도움

--조건절(where) 사용
--like 사용
--요구사항.021
--남자 직원만 가져오시오.
select * from tblinsa;
select * from tblinsa where ssn like '______-1______';
--테이블

--tblinsa
--도움

--조건절(where) 사용
--like 사용
--요구사항.022
--여자 직원만 가져오시오.
select * from tblinsa where ssn like '______-2______';
--테이블

--tblinsa
--도움

--조건절(where) 사용
--like 사용
--요구사항.023
--여름에 태어난 직원들 가져오시오.
select * from tblinsa;
select * from tblinsa where ssn like '__07__%' or  ssn like '__08__%' or  ssn like '__09__%' ; 
--테이블

--tblinsa
--조건

--7~9월생
--도움

--조건절(where) 사용
--like 사용
--요구사항.024
--서울, 인천에 사는 김씨만 가져오시오.
select * from tblinsa where city in ('서울','인천') and name like '김%';
--테이블

--tblinsa
--도움

--조건절(where) 사용
--like 사용
--요구사항.025
--영업부/총무부/개발부 직원 중 사원급(사원/대리) 중에 010을 사용하는 직원들을 가져오시오.
--테이블
select * from tblinsa where buseo in('영업부','총무부','개발부') and jikwi in ('사원','대리') and tel like '010%';
--tblinsa
--도움

--조건절(where) 사용
--like 사용
--요구사항.026
--서울/인천/경기에 살고 입사일이 2008~2010년 사이인 직원들을 가져오시오.
select * from tblinsa;
select * from tblinsa where city in ('서울','인천','경기') and ibsadate between '2008-01-01' and '2010-12-31';
--테이블

--tblinsa
--도움

--조건절(where) 사용
--between 사용
--요구사항.027
--부서가 아직 배정 안된 직원들을 가져오시오.
select * from employees;
select * from employees where department_id is null;
--테이블

--employees
--도움

--조건절(where) 사용
--is null 사용
--요구사항.028
--직업이 어떤것들이 있는지 가져오시오.
select * from employees;
select distinct job_id from employees;
--테이블

--employees
--도움

--distinct 사용
--요구사항.029
--고용일이 2002~2004년 사이인 직원들은 어느 부서에 근무합니까?
select * from employees;
select distinct department_id from employees where hire_date between '2002-01-01' and '2004-12-31'; 
--테이블

--employees
--도움

--조건절(where) 사용
--between 사용
--distinct 사용
--요구사항.030
--급여가 5000불 이상인 직원들은 담당 매니저가 누구?
select * from employees;
select distinct manager_id from employees where salary >= 5000;
--테이블

--employees
--도움

--조건절(where) 사용
--요구사항.031
--남자 직원 + 80년대생들의 직급은 뭡니까?
select * from tblinsa;
select distinct jikwi from tblinsa where ssn like '8%' and ssn like '______-1______';
--테이블

--tblinsa
--도움

--조건절(where) 사용
--distinct 사용
--요구사항.032
--수당 20만원 넘는 직원들은 어디 삽니까?
select distinct city from tblinsa where sudang >= 200000;
--테이블

--tblinsa
--도움

--조건절(where) 사용
--distinct 사용
--요구사항.033
--연락처가 아직 없는 직원은 어느 부서입니까?

--테이블
select distinct buseo from tblinsa where tel is null;
--tblinsa
--도움

--조건절(where) 사용
--is null 사용