--question2

--34. tblCountry. 인구가 5000 ~ 20000 사이인 국가 총 몇개입니까? 
select * from tblCountry;
select count(*) from tblCountry where population between 5000 and 20000;
--35. employees. 직업이 'IT_PROG'인 직원 중에서 급여가 5000불 넘는 직원 몇명입니까?
select * from employees;
select count(*) from employees where job_id = 'IT_PROG' and salary > 5000;
--36. tblInsa. 010이 아닌 번호를 사용하는 직원은 몇명입니까?(연락처가 없는 사람 제외)
select * from tblInsa;
select count(*) from tblInsa where tel not like '010%' and tel is not null;
--37. tblInsa. 서울 사람 빼고 나머지는 모두 몇명입니까?
select count(*) from tblInsa where city <> '서울';
--38. tblInsa. 남자 직원은 모두 몇명입니까?
select count(*) from tblInsa where substr(ssn,8,1) = '1';
--39. tblCountry. 유럽과 아프리카에 속한 나라의 모든 인구의 합은?
select count(*) from tblCountry where continent in ('EU','AF');
--40. employees. 매니저(108)이 관리하고 있는 직원들의 급여 총 합은?
select * from employees;
select sum(salary) from employees where manager_id = 108;
--41. employees. 직업이 ST_CLERK, SH_CLERK인 직원들을 급여 총 합은?
select * from employees;
select sum(salary) from employees where job_id in ('ST_CLERK','SH_CLERK');
--42. tblInsa. 서울에 있는 직원들의 급여 합은(급여 + 수당)?
select * from tblInsa;
select to_char(sum(basicpay+sudang),'L999,999,999') || '원' as "급여의 합" from tblInsa where city = '서울'; 질문
select sum(basicpay+sudang) || '원' as "급여의 합" from tblInsa where city = '서울';
--43. tblInsa. 장급(부장+과장)들의 총 급여 합은?
select sum(basicpay+sudang) as "급여의 합" from tblInsa where jikwi in ('부장','과장');
--44. tblCountry. 아시아에 속한 국가의 평균 인구수는?
select * from tblCountry;
select avg(population) from tblCountry where continent = 'AS'; 
--45. employees. 이름(first_name)에 'NI'이 포함된 직원들의 평균 급여는?(대소문자 구분없이)
select avg(salary) from employees where upper(first_name) like '%NI%';
--46. tblInsa. 간부급(과장,부장)들의 평균 급여는?
select * from tblInsa;
select round(avg(basicpay)) as "평균 급여" from tblInsa where jikwi in('과장','부장');

--47. tblInsa. 사원급(사원,대리)들의 평균 급여는?
select round(avg(basicpay)) as "평균 급여" from tblInsa where jikwi in('과장','부장');
--48. tblCountry. 면적이 가장 넓은 나라의 면적은?
select * from tblCountry;
select * from tblCountry where area = (select max(area) from tblCountry);
select max(area) from tblCountry;
--49. tblInsa. 급여(급여+수당)가 가장 적게 받는 직원의 금액은?
select * from tblInsa;
select basicpay + sudang from tblInsa where basicpay+sudang = (select min(basicpay+sudang) from tblInsa);
select min(basicpay+sudang) as "가장 적은 금액" from tblInsa;
--50. tblInsa. 직원명과 태어난 년도을 가져오되 태어난 년도를 오름차순으로 가져오시오.
select * from tblInsa;
select name, decode(substr(ssn,8,1),'1', '19', '2','19','3','20', '4', '20') || substr(ssn,1,2) as "태어난 년도" from tblInsa order by substr(ssn,1,2) asc;

--51. tblInsa. 서울에 사는 여직원 중 80년대생 몇명인지?
select * from tblInsa;
select count(*) from tblInsa where substr(ssn,1,1) = '8';
--52. tblInsa. 간부급(과장/부장)들은 어떤 성(김,이,박..)들이 있는지?
select distinct substr(name,1,1) from tblInsa;
--53. tblInsa. 직원들을 태어난 월순으로 정렬해서 가져오시오.(오름차순 → 월, 이름)
select * from tblInsa order by substr(ssn,3,2),name;
--54. tblInsa. 모든 직원을 남자 → 여자 순으로 정렬해서 가져오시오. (같은 성별끼리는 이름순으로 정렬)
select * from tblInsa order by substr(ssn,8,1),name;
--55. employees. 이름(first_name + last_name)이 가장 긴 순서대로 가져오시오.
select * from employees order by length(first_name||last_name) desc;
--56. employees. 이름(first_name + last_name)이 가장 긴사람은 몇글자?
select length(max(first_name||last_name)) as "가장 긴사람" from employees;
--57. employees. last_name이 5자 이상인 사람들은 first_name이 몇글자?
select length(first_name), first_name from employees where length(last_name) >= 5;
--58. tbldiary. 다이어리를 작성한 날짜가 총 며칠분이며, 날씨가 맑음, 흐림, 비가 온 날이 각각 며칠이었는지?
select * from tbldiary;
select count(*) as "총 일", count(decode(weather,'맑음',1)) as "맑음", count(decode(weather,'흐림',1)) as "흐림", count(decode(weather,'비',1)) as "비" from tbldiary;
--59. tbldiary. 공부와 관련된 작성 게시물이 총 몇개인가?('오라클', '자바', '코딩'이 들어간 게시물 개수)
select * from tbldiary;
select count(case when instr(subject,'오라클')>0 then 1 end) as 오라클,
            count(case when instr(subject,'자바')>0 then 1 end) as 자바,count(case when instr(subject,'코딩')>0 then 1 end) as 코딩 from tbldiary;
select count(*) from tbldiary where instr(subject,'오라클')>0 or instr(subject,'자바')>0 or  instr(subject,'코딩')>0;
--60. fine_dust_standard + fine_dust. 강남구의 미세먼지(PM10) 상태가 좋음, 보통, 나쁨, 매우나쁨이 각각 며칠이었는지?
select * from fine_dust_standard;
select * from fine_dust;
select count(case when pm10 between 0 and 30 and pm25 between 0 and 15 then 1 end) as "좋음", 
                 count(case when pm10 between 31 and 50 and pm25 between 16 and 25 then 1 end) as "보통",
                     count(case when pm10 between 51 and 70 and pm25 between 26 and 35 then 1 end) as "나쁨",
                         count(case when pm10 between 71 and 999 and pm25 between 36 and 999 then 1 end) as "매우나쁨" from fine_dust; 
--61. lotto_detail. 1인당 당첨금이 가장 많은 순으로 가져오시오. (1등 당첨자 수, 1등 당첨금, 총 당첨금) 해석
select * from lotto_detail;
select win_person_no, round(win_money/win_person_no) as "1등 당첨금", win_money as "총 당첨금" 
    from lotto_detail where rank_no = 1 and win_person_no <> 0 order by win_money/win_person_no desc; 

--62. tblsubway. 2017년 4월 2일에 승차한 승객수가 가장 많은 순으로 가져오시오.
select * from tblsubway;
select * from tblsubway where boardingdate = '2017/04/02' and gubun = '승차' order by passengernumber desc;
--63. tblzoo. 다리가 있고(leg) 날지 못하는(fly) 동물들의 종(family)을 가져오시오.
select * from tblzoo;
select DISTINCT family from tblzoo where leg > 0 and fly = 'n';
--65. tbltodo. 오전(0~11시)과 오후(12~23시)에 끝마친(completedate) 할일들의 개수를 각각 가져오시오.
select * from tbltodo;
select count(*) as 전체갯수,count(case when completedate is not null then 1 end) as "할일", count(case when to_number(to_char(completedate,'hh24')) between 0 and 11 and completedate is not null then 1 end) as 오전,
            count(case when to_number(to_char(completedate,'hh24')) between 12 and 23 and completedate is not null then 1 end) as 오후 from tbltodo;
--66. tbladdressbook. 구글 메일, 다음 메일, 네이버 메일을 사용하는 사람이 각각 몇명인지?
select * from tbladdressbook;
select count(case when instr(email,'gmail')>0 then 1 end) as 구글, count(case when instr(email,'daum')>0 then 1 end) as 다음, count(case when instr(email,'naver')>0 then 1 end) as 네이버 
 from tbladdressbook;
--67. tbladdressbook. 서울 이외의 지역에서 사는 사람들이 총 몇명인지?
select * from tbladdressbook;
select count(*) from tbladdressbook where instr(address,'서울') = 0;

-- question03

--1. tblInsa. 80년대생 남자 직원들의 평균 월급(basicpay)보다 더 많이 받는 80년대생 여직원들을 출력하시오.(subquery)

select * from tblInsa where substr(ssn,8,1) = '2' and substr(ssn,1,1) = '8' and basicpay>(select avg(basicpay) from tblInsa where substr(ssn,8,1) = '1'); 
--2. tblStaff, tblProject. 현재 재직중인 모든 직원의 이름, 주소, 월급, 담당프로젝트명을 출력하시오.(join)
select * from tblStaff;
select * from tblProject;
select name,address,salary, project from tblStaff s
    inner join tblProject p 
        on s.seq = p.seq;
        
--3. tblVideo, tblRent, tblMember. '뽀뽀할까요' 라는 비디오를 빌려간 회원의 이름?(join)
select m.name from tblVideo v
    inner join tblRent r
        on r.seq = v.seq
            inner join tblMember m 
                on m.seq = r.seq
                    where v.name = '뽀뽀할까요';
--4. tblInsa. 평균 이상의 월급을 받는 직원들?(subquery)
select * from tblInsa;
select * from tblInsa where basicpay >= (select avg(basicpay) from tblInsa);
--5. tblStaff, tblProejct. 'TV 광고'을 담당한 직원의 월급?(join)
select s.salary from tblStaff s
    inner join tblProject p
        on s.seq = p.seq
            where p.project = 'TV 광고';
--6. tblMember. 가장 나이가 많은 회원의 주소? (bYear)(subquery)
select address from tblMember where byear=(select min(byear) from tblMember);
--7. tblVideo. '털미네이터' 비디오를 한번이라도 빌려갔던 회원들의 이름?(join)
select m.name from tblRent r
    inner join tblVideo v
        on r.seq = v.seq
            inner join tblMember m
                on m.seq = r.seq
                    where v.name = '털미네이터';
                    
--8. tblStaff, tblProject. 서울시에 사는 직원을 제외한 나머지 직원들의 이름, 월급, 담당프로젝트명을 출력하시오.(join)
select * from tblStaff;
select s.name,s.salary,p.project from tblProject p
    inner join tblStaff s
        on s.seq = p.seq
            where s.address <> '서울시';
--9. tblCustomer, tblSales. 상품을 2개(단일상품) 이상 구매한 회원의 연락처, 이름, 구매상품명, 수량 출력하시오.(join)
select * from tblSales;
select c.address,c.name,s.item,s.qty from tblCustomer c
    inner join tblSales s
        on s.cseq = c.seq
            where s.qty >= 2;
--10. tblVideo. 모든 비디오 제목, 보유수량, 대여가격을 출력하시오.(join)
select v.name,v.qty,m.money from tblVideo v
    inner join tblRent r
        on r.video = v.seq
            inner join tblMember m
                on m.seq = r.member;
--11. tblVideo. 2007년 2월에 대여된 구매내역을 출력하시오. 회원명, 비디오명, 언제, 대여가격을 가져오시오.(join)
select * from tblVideo v
    inner join tblRent r
        on r.video = v.seq
            where to_char(rentdate,'yyyy-mm') = '2007-02';
--12. tblVideo. 현재 반납을 안한 회원명과 비디오명, 대여날짜 출력하시오.(join)
select m.name,v.name,r.rentdate from tblRent r
    inner join tblVideo v
        on v.seq = r.video
            inner join tblMember m
                on m.seq = r.member
                    where r.retdate is null;
--13. tblInsa. basicpay+sudang가 100만원 미만, 100만원 이상~200만원 미만, 200만원 이상인 직원들의 수 출력하시오.(groupby)
select * from tblInsa;
select (case when basicpay+sudang < 1000000  and basicpay+sudang >=0 then '100만원 미만'
                    when basicpay+sudang >= 1000000 and basicpay+sudang < 2000000 then '200만원 미만'
                    when basicpay+sudang >= 2000000 then '200만원 이상' end) as 급여, count(*) from tblInsa 
      group by (case when basicpay+sudang < 1000000  and basicpay+sudang >=0 then '100만원 미만'
                    when basicpay+sudang >= 1000000 and basicpay+sudang < 2000000 then '200만원 미만'
                    when basicpay+sudang >= 2000000 then '200만원 이상' end) order by   (case when basicpay+sudang < 1000000  and basicpay+sudang >=0 then '100만원 미만'
                    when basicpay+sudang >= 1000000 and basicpay+sudang < 2000000 then '200만원 미만'
                    when basicpay+sudang >= 2000000 then '200만원 이상' end) desc;

select decode(floor((basicpay+sudang)/1000000),0,'100만원미만',1,'100만원 이상 ~ 200만원 미만','200만원 이상') as 급여, count(*) from tblInsa group by floor((basicpay+sudang)/1000000)
        order by floor((basicpay+sudang)/1000000) asc;
--14. tblInsa. 주민번호를 가지고 생년월일의 년도별 직원수 출력하시오.(group by)

--15. tblInsa. 주민번호를 기준으로 월별 오름차순, 월이 같으면 년도 내림차순 출력하시오.(이름, 주민번호) . SUBSTR() 함수 이용.(orderby)

--16. tblInsa. 입사일을 기준으로  월별 오름차순, 월이 같으면 년도 내림차순 출력하시오.(orderby)

--17. tblInsa. 전체인원수, 남자인원수, 여자인원수를 동시 출력하시오.(count+decode)

--18. tblInsa. 개발부, 영업부, 총무부 인원수 출력하시오.(count+decode)

--19. tblInsa. 서울 사람의 남자와 여자의 기본급합을 출력하시오.(decode+group by)

--20. tblInsa. 부서별 남자와 여자 인원수를 출력하시오.(decode+group by)

--21. employees. 총 사원 수 및 2003, 2004, 2005, 2006 년도 별 고용된 사원들의 총 수를 가져오시오.(groupby+subquery)

--22. tblInsa. 남자 급여(기본급+수당)을 (내림차순)순위대로 가져오시오. (이름, 부서, 직위, 급여, 순위 출력)(rownum+subquery)

--23. tblInsa. 여자 급여(기본급+수당)을 (오름차순)순위대로 가져오시오. (이름, 부서, 직위, 급여, 순위 출력)(rownum+subquery)

--24. tblInsa. 여자 인원수가 (가장 많은 부서 및 인원수) 가져오시오.(rownum+subquery+groupby)

--25. tblInsa. 지역별 인원수 (내림차순)순위를 가져오시오.(city, 인원수)(subquery+groupby)

--26. tblInsa. 부서별 인원수가 가장 많은 부서 및원수 출력하시오.(rownum+subquery+groupby)

--27. tblInsa. 남자 급여(기본급+수당)을 (내림차순) 3~5등까지 가져오시오. (이름, 부서, 직위, 급여, 순위 출력)(rownum+subquery+groupby)

--28. tblInsa. 입사일이 빠른 순서로 5순위까지만 가져오시오.(rownum+subquery)

--29. tblhousekeeping. 지출 내역(가격 * 수량) 중 가장 많은 금액을 지출한 내역 3가지를 가져오시오.(rownum+subquery)

--30. tblinsa. 평균 급여 2위인 부서에 속한 직원들을 가져오시오.(rownum+subquery+groupby)

--31. tbltodo. 등록 후 가장 빠르게 완료한 할일을 순서대로 5개 가져오시오.(rownum+subquery)

--32. tblinsa. 남자 직원 중에서 급여를 3번째로 많이 받는 직원과 9번째로 많이 받는 직원의 급여 차액은 얼마인가?

--qeustion04
1. tblInsa. 입사년도별 남자와 여자 인원수를 가져오시오.(groupby+decode)

2. tblInsa. 부서별 남,여 인원수 출력. 여자인원수가 5명 이상인 부서만 가져오시오.(groupby+having+decode)

3. tblInsa. 입사월별 인원수 구하기. (월, 인원수)(groupby)
출력결과
월     인원수
1월    10명
2월    25명

4. (X). tblInsa. 전체인원수, 2000년, 1999년, 1998년도에 입사한 인원을 다음의 형식으로 가져오시오.(decode)
전체 2000 1999 1998
60    x    x    x

5. tblInsa. 아래 형식으로 지역별 인원수를 가져오시오(decode)
전체 서울  인천  경기
60    x     x     x

6. tblInsa. 부서별 기본급이 가장 높은 사람을 출력하시오.(이름, 부서, 기본급) 동급은 첫번째 사람만 출력하시오.(subquery+groupby)

7. tblInsa. 지역(city)별로 급여(기본급+수당) 1순위 직원만 출력하시오.(급여, 직원명,주민번호,입사일,지역,부서,직위)(groupby+subquery)

8. tblInsa. 부서별 인원수가 가장 많은 부서 및 인원수를 출력하시오.(groupby+subquery)

9. tblInsa. 여자 인원수가 가장 많은 부서 및 인원수를 출력하시오.(groupby+subquery)

10. tblInsa. 지역(city)별 평균 급여(basicpay+sudang)가 가장 높은 지역 및 평균급여를 출력하시오(groupby+subquery)

11. tblInsa. 이름, 부서, 출신도, 기본급, 수당, 기본급+수당, 세금, 실수령액 출력하시오.(case)
- 세금: 총급여가 250만원 이상이면 2%, 200만원 이상이면 1%, 나머지 0.
- 실수령액: 총급여-세금

12. tblInsa. 부서별 평균 급여를 출력하되, A, B, C 등급으로 나눠서 출력.
- 200만원 초과 - A등급
- 150~200만원 - B등급
- 150만원 미만 - C등급

13. lotto_detail. 역대 로또 1등 당첨금(1인 당첨금)이 가장 많은 순으로 5개를 가져오시오.(subquery)

14. lotto_master. 로또 번호(1~45) 중 가장 많이 나온 숫자를 6개 가져오시오.(bonus 숫자 포함)(union+groupby+subquery)

15. tblSubway. 승차 인원의 합보다 하차 인원의 합이 더 많은 역들을 가져오시오.(groupby+having+case+sum)

16. traffic_accident. 년도별(10년단위,1차그룹)+교통수단별(2차그룹) 총 사고 인원수와 사망자수를 가져오시오.(groupby)

17. traffic_accident. 발생 년도와 상관없이 사고당 평균 사망자수가 가장 많은 교통 수단은 무엇인가?(groupby+subquery)

18. tblAddressbook. BMI(체중(kg)/키(m)^2) 지수가 30이 넘는 사람들 중 가장 많은 직업은?(subquery+groupby)

19. tblHousekeeping. 가장 과소비를 한 날짜(Top 3)와 그 날짜에 구매한 물품 명단과 총금액을 가져오시오.(subquery+groupby+listagg)

20. tblAddressBook. 고향(hometown)을 떠나 거주(address)하는 사람들 중에서 동명이인인 사람들이 어떤 직업들을 가지고 있는가?(subquery+groupby+listagg)
