-- 1. tblInsa. 입사년도별 남자와 여자 인원수를 가져오시오.(groupby+decode)

select
    to_char(ibsadate, 'yyyy'),
    count(decode(substr(ssn, 8, 1), '1', '1')) as 남자인원수,
    count(decode(substr(ssn, 8, 1), '2', '1')) as 여자인원수
from tblInsa
    group by to_char(ibsadate, 'yyyy')
        order by to_char(ibsadate, 'yyyy') asc;
			

-- 2. tblInsa. 부서별 남,여 인원수 출력. 여자인원수가 5명 이상인 부서만 가져오시오.(groupby+having+decode)

select
    buseo,
    count(decode(substr(ssn, 8, 1), '1', '1')) as 남자인원수,
    count(decode(substr(ssn, 8, 1), '2', '1')) as 여자인원수
from tblInsa
    group by buseo
        having count(decode(substr(ssn, 8, 1), '2', '1')) >= 5;
			
			
-- 3. tblInsa. 입사월별 인원수 구하기. (월, 인원수)(groupby)
-- 출력결과
-- 월     인원수
-- 1월    10명
-- 2월    25명

select 
    to_number(to_char(ibsadate, 'mm')) || '월' as 월, 
    count(*) || '명' as 인원수 
from tblInsa
    group by to_char(ibsadate, 'mm')
        order by to_char(ibsadate, 'mm') asc;
				

-- 4. tblInsa. 전체인원수, 2000년, 1999년, 1998년도에 입사한 인원을 다음의 형식으로 가져오시오.(decode)
-- 전체 2000 1999 1998
-- 60    x    x    x

select
	count(*) as 전체인원수,
	count(decode(to_char(ibsadate, 'yyyy'), '2000', 1)) as "2000",
	count(decode(to_char(ibsadate, 'yyyy'), '1999', 1)) as "1999",
	count(decode(to_char(ibsadate, 'yyyy'), '1998', 1)) as "1998"
from tblInsa;

-- 5. tblInsa. 아래 형식으로 지역별 인원수를 가져오시오(decode)
-- 전체 서울  인천  경기
-- 60    x     x     x

select
	count(*) as 전체인원수,
	count(decode(city, '서울', 1)) as "서울",
	count(decode(city, '인천', 1)) as "인천",
	count(decode(city, '경기', 1)) as "경기"
from tblInsa;


-- 6. 부서별 기본급이 가장 높은 사람을 출력하시오.(이름, 부서, 기본급) 동급은 첫번째 사람만 출력하시오.(subquery+groupby)

select 
    buseo as 부서, 
    m as 급여, 
    (select name from tblInsa i where i.basicpay = a.m and rownum = 1) as 직원명 
from (select buseo, max(basicpay) as m from tblInsa
    group by buseo
        order by buseo) a;
	
    					
-- 7. 지역(city)별로 급여(기본급+수당) 1순위 직원만 출력하시오.(급여, 직원명,주민번호,입사일,지역,부서,직위)(groupby+subquery)

select
	city, m as 급여,
	(select name from tblInsa i where i.basicpay = a.m and rownum = 1) as 직원명,
	(select ssn from tblInsa i where i.basicpay = a.m and rownum = 1) as 주민번호,
	(select ibsadate from tblInsa i where i.basicpay = a.m and rownum = 1) as 입사일,
	(select city from tblInsa i where i.basicpay = a.m and rownum = 1) as 지역,
	(select buseo from tblInsa i where i.basicpay = a.m and rownum = 1) as 부서,
	(select jikwi from tblInsa i where i.basicpay = a.m and rownum = 1) as 직위
from
	(select city, max(basicpay) as m from tblInsa
        group by city
                order by city) a;


-- 8. tblInsa. 부서별 인원수가 가장 많은 부서 및 인원수를 출력하시오.(groupby+subquery)

select * from
    (select buseo, count(*) from tblInsa
        group by buseo
            order by count(*) desc)
                 where rownum = 1;


-- 9. tblInsa. 여자 인원수가 가장 많은 부서 및 인원수를 출력하시오.(groupby+subquery)
select * from
    (select buseo, count(*) from tblInsa
        where substr(ssn, 8, 1) = '2'
            group by buseo
                order by count(*) desc)
                    where rownum = 1;



-- 10. tblInsa. 지역(city)별 평균 급여(basicpay+sudang)가 가장 높은 지역 및 평균급여를 출력하시오(groupby+subquery)

select * from
    (select city, avg(basicpay + sudang) from tblInsa
        group by city
            order by avg(basicpay + sudang) desc)
                where rownum = 1;



-- 11. tblInsa. 이름, 부서, 출신도, 기본급, 수당, 기본급+수당, 세금, 실수령액 출력하시오.(case)
-- 세금: 총급여가 250만원 이상이면 2%, 200만원 이상이면 1%, 나머지 0.
-- 실수령액: 총급여-세금

select 
    name, buseo, city, basicpay, sudang, basicpay + sudang,
    case
        when (basicpay + sudang) >= 2500000
                then (basicpay + sudang) * 0.02
        when (basicpay + sudang) >= 2000000
                then (basicpay + sudang) * 0.01
        else 0
    end as 세금,
    (basicpay + sudang) - case
        when (basicpay + sudang) >= 2500000
                then (basicpay + sudang) * 0.02
        when (basicpay + sudang) >= 2000000
                then (basicpay + sudang) * 0.01
        else 0
    end as 실수령액
from tblInsa;


-- 12. tblInsa. 부서별 평균 급여를 출력하되, A, B, C 등급으로 나눠서 출력.
-- 200만원 초과 - A등급
-- 150~200만원 - B등급
-- 150만원 미만 - C등급

select buseo, round(avg(basicpay)),
    case
        when avg(basicpay) > 2000000 then 'A'
        when avg(basicpay) >= 1500000 then 'B'
        else 'C'
    end as 등급
from tblInsa
group by buseo;



-- 13. 역대 로또 1등 당첨금(1인 당첨금)이 가장 많은 순으로 5개를 가져오시오.(subquery)
select * from
    (select * from lotto_detail 
        where win_person_no <> 0 order by (win_money / win_person_no) desc)
            where rownum <= 5;



-- 14. 로또 번호(1~45) 중 가장 많이 나온 숫자를 6개 가져오시오.(bonus 숫자 포함)(union+groupby+subquery)

select * from (select num, count(*) as cnt from (select num1 as num from lotto_master
union all
select num2 as num from lotto_master
union all
select num3 as num from lotto_master
union all
select num4 as num from lotto_master
union all
select num5 as num from lotto_master
union all
select num6 as num from lotto_master
union all
select bonus as num from lotto_master)
    group by num
        order by count(*) desc)
            where rownum <= 6;



-- 15. tblSubway. 승차 인원의 합보다 하차 인원의 합이 더 많은 역들을 가져오시오.(groupby+having+case+sum)

select 
    stationname,
    sum(case when gubun = '승차' then passengernumber end) as 승차인원,
    sum(case when gubun = '하차' then passengernumber end) as 하차인원
from tblSubway
    group by stationname
        having sum(case when gubun = '승차' then passengernumber end) < sum(case when gubun = '하차' then passengernumber end);



-- 16. traffic_accident. 년도별(10년단위,1차그룹)+교통수단별(2차그룹) 총 사고 인원수와 사망자수를 가져오시오.(groupby)

select 
    substr(year, 1, 3) || '0', 
    trans_type,
    sum(total_acct_num),
    sum(death_person_num)
from traffic_accident
group by substr(year, 1, 3) || '0', trans_type
order by substr(year, 1, 3) || '0', trans_type;



-- 17. traffic_accident. 발생 년도와 상관없이 사고당 평균 사망자수가 가장 많은 교통 수단은 무엇인가?(groupby+subquery)

select trans_type from (select
    trans_type,
    sum(total_acct_num) / sum(death_person_num) as cnt
from traffic_accident
group by trans_type
order by sum(total_acct_num) / sum(death_person_num) desc)
where rownum = 1;



-- 18. tblAddressbook. BMI(체중(kg)/키(m)^2) 지수가 30이 넘는 사람들 중 가장 많은 직업은?(subquery+groupby)

select * from (select 
    job, count(*) 
from tblAddressbook
where weight / power(height*0.01,2) > 30
group by job
order by count(*) desc)
where rownum = 1;



-- 19. tblHousekeeping. 가장 과소비를 한 날짜(Top 3)와 그 날짜에 구매한 물품 명단과 총금액을 가져오시오.(subquery+groupby+listagg)

select * from (select 
    buydate,
    listagg(item, ',') within group(order by item asc) as list,
    sum(qty * price) as totalprice
from tblHousekeeping
group by buydate
order by sum(qty * price) desc)
    where rownum <= 3;


-- 20. 고향(hometown)을 떠나 거주(address)하는 사람들 중에서 동명이인인 사람들이 어떤 직업들을 가지고 있는가?(subquery+groupby+listagg)

select
    name,
    count(*),
    listagg (job, ',') within group(order by job asc) as joblist
from tblAddressBook
where instr(address, hometown) = 0
group by name
having count(*) > 1
order by count(*);

