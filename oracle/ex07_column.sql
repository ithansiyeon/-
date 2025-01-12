--p72~p126

-- ex07_column.sql


/*

distinct 
- 컬럼 리스트에서 사용
- 중복값 제거 
- distinct 컬럼명 


*/

-- 이 테이블에는 어떤 부서들이 있습니까?
select buseo from tblInsa;
select distinct buseo from tblInsa; --카테고리

select city from tblInsa;
select distinct city from tblInsa; 

select distinct continent from tblCountry; 

select distinct * from tblInsa; -- 전체를 한덩어리의 데이터로 봄
select distinct name from tblInsa; -- 중복값이 있을 때만 써

select distinct city, name from tblInsa; -- 하나의 덩어리로 distinct를 함 , *** 주의

select distinct city,buseo from tblInsa; --32



/*

case 
- 컬럼리스트에서 사용 + 조건절에서 사용
- 자바의 if or switch 역할 
- 조건을 만족하지 못하면 null 반환(*****)



*/

select
    last || first as name,
    gender 
from tblComedian;


select
    last || first as name,
    case 
        when gender = 'm' then '남자' 
        when gender = 'f' then '여자'
    end as genderName,
    gender
from tblComedian;

select 
    name,
    case 
        when continent = 'AS' then '아시아'
        when continent = 'EU' then '유럽'
        when continent = 'AF' then '아프리카'
        --when continent = 'SA' then '아메리카'
        --when continent = 'AU' then '호주'
        --else '기타' 
        --else capital -- X, 같은 의미의 데이터 반환
        --else area -- 자료형이 달라서 안됨 
    end as continent

from tblCountry;

select 
    distinct case 
        when continent = 'AS' then '아시아'
        when continent = 'EU' then '유럽'
        when continent = 'AF' then '아프리카'
        when continent = 'SA' then '아메리카'
        when continent = 'AU' then '호주'
    end as continent
from tblCountry;

select 
    last || first as name,
    weight,
    case 
        when weight > 100 then '과체중'
        when weight > 50 then '정상체중'
        when weight > 0 then '저체중'
    end as state
from tblComedian;

select 
    --title,
    case 
        when completedate is null then '[*]' || title
        when completedate is not null then title
    end as title,
    
    case 
        when completedate is null then '해야할 일'
        when completedate is not null then '완료한 일'
    end as state
    
from tblTodo;

select 
    name,
    buseo,
    jikwi,
    case 
        when ibsadate > '2016-10-23' then '주니어'
        when ibsadate <= '2016-10-23' and ibsadate > '2012-10-23' then '시니어'
        when ibsadate <= '2012-10-23' then '익스퍼트'
    end as lv
from tblInsa;

-- tblMen.couple

select * from tblMen;

select 
    name,
    case 
        when couple is null then '여자친구 없음'
        when couple is not null then '여자친구 있음'
    end as state
from tblMen;












