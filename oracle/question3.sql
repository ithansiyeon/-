--question3.sql
--join
--subquery
--group by
-- rownum



1. tblInsa. 80년대생 남자 직원들의 평균 월급(basicpay)보다 더 많이 받는 80년대생 여직원들을 출력하시오.(subquery)
select * from tblInsa;
and substr(ssn,8,1) = '2' and substr(ssn,1,1) = '8'
select name, buseo, jikwi, basicpay , (select avg(basicpay) from tblInsa) from tblInsa;
select * from tblInsa where (select avg(basicpay) from tblInsa where substr(ssn,8,1) = '1' and substr(ssn,1,1) = '8') < basicpay and substr(ssn,8,1) = '2' and substr(ssn,1,1) = '8';

2. tblStaff, tblProject. 현재 재직중인 모든 직원의 이름, 주소, 월급, 담당프로젝트명을 출력하시오.(join)
select * from tblStaff;
select * from tblProject;

desc tblStaff;
desc tblproject;
select * from tblStaff s
    inner join tblProject p
        on p.staff = s.seq;
        
select * from tblStaff s
    inner join tblProject p
        on s.seq = p.staff;

--on을 선이라고 생각, 연결(관련)되어 있는 것끼리 쓸 수 있어        

3. tblVideo, tblRent, tblMember. '뽀뽀할까요' 라는 비디오를 빌려간 회원의 이름?(join)
/*            
select * from tblVideo v
    inner join tblRent r 
       on r.seq = (select v.seq from v where v.name = '뽀뽀할까요')
            inner join tblMember m
                on m.seq = r.seq;
       */         
select m.name from tblMember m
    inner join tblRent r
      on  m.seq = r.member
      inner join tblVideo v
        on r.video = v.seq
            where v.name = '뽀뽀할까요';
        
    

4. tblInsa. 평균 이상의 월급을 받는 직원들?(subquery)
select * from tblInsa;
select * from tblInsa where (select avg(basicpay) from tblInsa) < basicpay;

5. tblStaff, tblProejct. 'TV 광고'을 담당한 직원의 월급?(join)
select s.salary from tblStaff s
    inner join tblProject p
        on s.seq = p.staff
            where p.project = 'TV 광고';


6. tblMember. 가장 나이가 많은 회원의 주소? (bYear)(subquery)
select * from tblMember;
select address from tblMember where byear=(select min(byear) from tblMember);

7. tblVideo. '털미네이터' 비디오를 한번이라도 빌려갔던 회원들의 이름?(join)
select m.name from tblMember m
    inner join tblRent r
        on m.seq = r.member
        inner join tblVideo v
            on v.seq = r.video
            where v.name = '털미네이터';

8. tblStaff, tblProject. 서울시에 사는 직원을 제외한 나머지 직원들의 이름, 월급, 담당프로젝트명을 출력하시오.(join)
select s.name,s.salary,p.project from tblStaff s
    inner join tblProject p
        on s.seq = p.staff
            where instr(s.address,'서울') = 0;

9. tblCustomer, tblSales. 상품을 2개(단일상품) 이상 구매한 회원의 연락처, 이름, 구매상품명, 수량 출력하시오.(join)
select c.tel,c.name,s.item,s.qty from tblCustomer c
    inner join tblSales s
        on c.seq=s.cseq
        where s.qty >= 2;

10. tblVideo. 모든 비디오 제목, 보유수량, 대여가격을 출력하시오.(join)
select v.name,v.qty,g.price from tblVideo v
    inner join tblGenre g
        on v.genre = g.seq;
        -- 보유수량 v.seq가 아니라 v.qty??

11. tblVideo. 2007년 2월에 대여된 구매내역을 출력하시오. 회원명, 비디오명, 언제, 대여가격을 가져오시오.(join)
select m.name,v.name,r.rentdate,g.price from tblGenre g
    inner join tblVideo v
        on  v.genre = g.seq
        inner join tblRent r
            on r.video = v.seq
            inner join tblMember m
                on m.seq = r.member
                    where to_char(r.rentdate,'yyyy') = '2007' and to_char(r.rentdate,'mm') ='02';
              
 
        


12. tblVideo. 현재 반납을 안한 회원명과 비디오명, 대여날짜 출력하시오.(join)
select m.name,v.name,r.rentdate from tblGenre g
    inner join tblVideo v
        on g.seq = v.genre
        inner join tblRent r
            on r.video = v.seq
            inner join tblMember m
                on m.seq = r.member
            where r.retdate is null;


13. tblInsa. basicpay+sudang가 100만원 미만, 100만원 이상~200만원 미만, 200만원 이상인 직원들의 수 출력하시오.(groupby)
select 
    case 
         when (basicpay+sudang)<1000000 and (basicpay+sudang)>=0 then '100만원 미만'
        when (basicpay+sudang)>=1000000 and (basicpay+sudang) < 2000000 then '200만원 미만 ~ 200만원 미만'
        when (basicpay+sudang)>=200 then '200만원 이상'
    end as price,
        count(*)
    from tblInsa
        group by case 
            when (basicpay+sudang)<1000000 and (basicpay+sudang)>=0  then '100만원 미만'
            when (basicpay+sudang)>=1000000 and (basicpay+sudang) < 2000000 then '200만원 미만 ~ 200만원 미만'
            when (basicpay+sudang)>=200 then '200만원 이상'
        end;

14. tblInsa. 주민번호를 가지고 생년월일의 년도별 직원수 출력하시오.(group by)
select substr(ssn,1,2) as 년도 ,count(*) from tblInsa 
    group by substr(ssn,1,2) order by  substr(ssn,1,2) asc;

15. tblInsa. 주민번호를 기준으로 월별 오름차순, 월이 같으면 년도 내림차순 출력하시오.(이름, 주민번호) . SUBSTR() 함수 이용.(orderby)
select name,ssn from tblInsa 
    order by substr(ssn,3,2) asc, substr(ssn,1,2) desc;

16. tblInsa. 입사일을 기준으로  월별 오름차순, 월이 같으면 년도 내림차순 출력하시오.(orderby)
select * from tblInsa;
select * 
    from tblInsa 
        order by to_char(ibsadate,'mm'), to_char(ibsadate,'yyyy') desc;

17. tblInsa. 전체인원수, 남자인원수, 여자인원수를 동시 출력하시오.(count+decode)
select count(*) as 전체인원수, count(decode(substr(ssn,8,1),'1',1)) as 남자인원수,count(decode(substr(ssn,8,1),'2',1)) as 여자인원수 from tblInsa;

18. tblInsa. 개발부, 영업부, 총무부 인원수 출력하시오.(count+decode)
select count(decode(buseo,'개발부',1)) as 개발부,  count(decode(buseo,'영업부',1)) as 영업부, count(decode(buseo,'총무부',1)) as 총무부 
from tblInsa;
19. tblInsa. 서울 사람의 남자와 여자의 기본급합을 출력하시오.(decode+group by)
select * from tblInsa;
select 
    decode(substr(ssn,8,1),'1','남자','2','여자') as gender, sum(basicpay)  as 급여합
            from tblInsa
            where city = '서울'
                group by   decode(substr(ssn,8,1),'1','남자','2','여자');

20. tblInsa. 부서별 남자와 여자 인원수를 출력하시오.(decode+group by)
select * from tblInsa;
select buseo 
         ,count(decode(substr(ssn,8,1),'1',1)) as 남자인원수
         ,count(decode(substr(ssn,8,1),'2',1)) as 여자인원수
          from tblInsa group by buseo 
          order by buseo;

21. employees. 총 사원 수 및 2003, 2004, 2005, 2006 년도 별 고용된 사원들의 총 수를 가져오시오.(groupby+subquery)
select * from employees;
select to_char(hire_date,'yyyy') as year,count(*) as 총사원
    from employees 
    group by to_char(hire_date,'yyyy') 
        order by year;
-- 데이터가 아니라 컬럼이 옴 

22. tblInsa. 남자 급여(기본급+수당)을 (내림차순)순위대로 가져오시오. (이름, 부서, 직위, 급여, 순위 출력)(rownum+subquery)
select * from tblInsa;
select name,buseo,jikwi,basicpay+sudang as 급여,rownum as rnum 
    from (select name,buseo,jikwi,basicpay,sudang 
            from tblInsa where substr(ssn,8,1) = 1 
                order by basicpay+sudang desc);

23. tblInsa. 여자 급여(기본급+수당)을 (오름차순)순위대로 가져오시오. (이름, 부서, 직위, 급여, 순위 출력)(rownum+subquery)
select name,buseo,jikwi,basicpay,rownum as rnum 
                from (select name,buseo,jikwi,basicpay
                    from tblInsa where substr(ssn,8,1)=2 
                        order by basicpay+sudang asc);

24. tblInsa. 여자 인원수가 (가장 많은 부서 및 인원수) 가져오시오.(rownum+subquery+groupby)
select * from tblInsa;
select a.* from 
        (select buseo,count(*) 
            from tblInsa where substr(ssn,8,1)=2 
                group by buseo order
                    by count(*) desc) a where rownum = 1 ;

25. tblInsa. 지역별 인원수 (내림차순)순위를 가져오시오.(city, 인원수)(subquery+groupby)
select * from tblInsa;
select a.* from (select city,count(*) from tblInsa group by city order by count(*) desc) a; 

26. tblInsa. 부서별 인원수가 가장 많은 부서 및 인원수 출력하시오.(rownum+subquery+groupby)
select a.* from(select buseo,count(*) from tblInsa group by buseo order by count(*) desc) a where rownum = 1;

27. tblInsa. 남자 급여(기본급+수당)을 (내림차순) 3~5등까지 가져오시오. (이름, 부서, 직위, 급여, 순위 출력)(rownum+subquery+groupby)
select * from tblInsa;
select * from(select a.*, rownum as rnum 
                    from(select name,buseo,jikwi,basicpay+sudang from tblInsa 
                        where substr(ssn,8,1)=1 
                            order by (basicpay+sudang) desc) a) where rnum between 3 and 5;
-- 남자라서...                            

28. tblInsa. 입사일이 빠른 순서로 5순위까지만 가져오시오.(rownum+subquery)
select * from tblInsa;
select a.*, rownum from (select * from tblInsa order by ibsadate asc) a where rownum <=5;

29. tblhousekeeping. 지출 내역(가격 * 수량) 중 가장 많은 금액을 지출한 내역 3가지를 가져오시오.(rownum+subquery)
select * from tblhousekeeping;
select * from (select * from tblhousekeeping order by qty * price desc) where rownum<=3;

30. tblinsa. 평균 급여 2위인 부서에 속한 직원들을 가져오시오.(rownum+subquery+groupby)
select * from tblInsa c 
    where c.buseo = (select buseo from(select buseo, rownum as rnum from (select buseo, round(avg(basicpay))
        from tblInsa group by buseo order by round(avg(basicpay)) desc)) where rnum = 2);
-- 총무부만 되어 있어서
31. tbltodo. 등록 후 가장 빠르게 완료한 할일을 순서대로 5개 가져오시오.(rownum+subquery)
select * from tbltodo;
select a.*, round((completedate - adddate)*24*60) || '분' as 걸린시간 
    from (select * from tbltodo where completedate is not null order by round((completedate - adddate)*24*60) asc) a where rownum<=5;


32. tblinsa. 남자 직원 중에서 급여를 3번째로 많이 받는 직원과 9번째로 많이 받는 직원의 급여 차액은 얼마인가?
select  
    (select basicpay from(select a.*, rownum as rnum from (select basicpay from tblinsa where substr(ssn,8,1) = 1 order by basicpay desc) a) where rnum = 3) -
    (select basicpay from(select a.*, rownum as rnum from (select basicpay from tblinsa where substr(ssn,8,1) = 1 order by basicpay desc) a) where rnum = 9) as 계산 from dual;
    
  