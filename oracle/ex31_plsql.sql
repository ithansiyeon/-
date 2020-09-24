--ex31_plsql.sql

/*

PL/SQL
- Procedural Language Extensions to SQL

ANSI-SQL
- 비 절차성 언어(순서가 없고, 연속적이지 않다.) -> 문장 단위 구조
- ANSI-SQL + 절차적인 기능 추가 -> 오라클 -> PL/SQL 


SQL 처리 순서 
1. ANSI-SQL
    : 클라이언트 구문 작성(select) -> 실행(Ctrl + Enter) -> 명령어가 오라클에게 전달
     -> 수신 -> 구문 분석(파싱) -> 컴파일 -> 실행 -> 결과 처리 
    : 위의 구문(select)을 다시 실행 한다. -> 위의 과정을 처음 ~ 끝까지 동일하게 반복 
    
2.PL/SQL
    : 클라이언트 구문 작성(select) -> 실행(Ctrl + Enter) -> 명령어가 오라클에게 전달
     -> 수신 -> 구문 분석(파싱) -> 컴파일 -> 실행 -> 결과 처리
     
    1. 처음 실행 : 위의 과정 처음 ~ 끝까지 실행
    2. 이후 반복 실행: 구문 분석(파싱) ~ 컴파일 생략됨(컴파일된 결과를 서버에 저장을 해 둠)
        : (저장)프로시저(=Stored Procedure)
        
프로시저, Procedure 
- 메서드, 함수, 서브루틴 등..
- 순서가 있는 코드의 집합 
1. 익명 프로시저 -> 1회용 코드 -> PL/SQL은 프로시저가 아니면 실행을 못한다.
2. 실명 프로시저 -> 반복 코드 

PL/SQL 프로시저 블럭 구조

1. 4개의 키워드로 구성
    - declare
    - begin
    - exception
    - end
        
2. declare 
    - 선언부 
    - 프로시저에서 사용할 변수, 객체 등을 선언하는 영역
    - 생략 가능 

3. begin
    - 실행부(begin ~ end) 
    - 구현되는 코드를 가지는 영역(메서드 body 역할)
    - 생략 불가능 
    - 연산, 제어 + ANSI-SQL 등으로 구성 

4. exception
    - 예외 처리부 
    - catch 역할 
    - 예외 처리 코드를 작성 
    - 생략 가능 

5. end
    - begin 블럭의 종료 역할 
    - 생략 불가능 

6. PL/SQL 블럭 중첩

begin 
    ANSI-SQL
    begin 
        begin 
        end;
    end;
end;

변수 + 자료형 

자료형 
- 오라클과 동일(유사->확장)

변수 선언하기
- 변수명 자료형[not null][default 값] 
- 변수는 질의의 결과나 인자를 저장하는 용도 

대입 연산자 
- 오라클과 동일
- 변수명 := 값 (PL)
- 컬럼명 = 값(ANSI)



*/
-- 익명 프로시저
-- 절차지향적이라서 ; 필수 
set serveroutput on; --매번해야 돼, 로그인 할때마다

declare 
    num number;
    name varchar2(30);
    today date;
begin 
    num :=10;
    dbms_output.put_line(num);
    
    name := '홍길동';
    dbms_output.put_line(name);
    
    today := sysdate; -- ANSI-SQL
    dbms_output.put_line(today);
    dbms_output.put_line(to_char(today,'yyyy-mm-dd')); --같이 섞어서 쓸 수 있어서 확장형
end;
-- declare ~ end 프로시저, 일의 순서가 생김(절차적)

declare
    num number default 100;
    num2 number not null default 200;
begin
    dbms_output.put_line(num); -- 초기화 없이 하면 null이 찍혀(안보임)
    dbms_output.put_line(num2);
end;

/*

변수 -> 테이블 select 결과를 담는 용도 
- 질의의 결과가 단일값이어야 한다.
    a. 결과셋이 1개의 레코드와 1개의 컬럼으로 구성(원자값) -> PK을 조건으로 하는 경우
    b. 집계함수의 결과값(1행 1열의 결과) 

select into 절
1. 1행 1열
2. 1행 N열

프로시저내에서는 select문을 그냥 사용 못한다. 
    -> 반드시 select의 결과를 PL/SQL 변수에 옮겨 담아야 한다.
*/
declare 
    vbuseo varchar2(15);
begin
     select buseo into vbsueo from tblInsa where name = '홍길동'; --ANSI-SQL
     dbms_output.put_line(vbuseo);
end;

desc tblInsa; -- 원본 테이블의 자료형이 얼마인지 확인해야 돼

declare 
    vbuseo varchar2(15);
    vname varchar2(15);
begin
     vname :='홍길동';
     select buseo into vbuseo from tblInsa where name = '홍길동'; --ANSI-SQL
     dbms_output.put_line(vbuseo);
end;


declare 
    vcnt number;
begin
    select count(*) into vcnt from tblInsa where buseo ='기획부';
    dbms_output.put_line('기획부 직원수: ' || vcnt || '명');
end;
    
-- 1행 N열 

declare 
    vname varchar2(20);
    vbuseo varchar2(15);
    vjikwi varchar2(15);
begin 
    select name,buseo,jikwi into vname, vbuseo, vjikwi from tblInsa where num = '1001'; -- 순서(**)와 갯가 맞아야 돼 
    dbms_output.put_line(vname);
    dbms_output.put_line(vbuseo);
    dbms_output.put_line(vjikwi);
end;

/*
참조형
- 원본의 자료형을 몰라도 된다.
- 유지 보수성이 좋다.

1. %type
    - 사용하는 테이블의 특정 컬럼의 자료형을 그대로 참조해서 적용
    - 복사되는 정보
        a. 자료형
        b. 길이
        c. not null 제약
        
*/

declare 
    vname tblInsa.name%type;
begin
    select name into vname from tblInsa where num = '1001';
    dbms_output.put_line(vname);
end;

declare 
    vname tblInsa.name%type;
    vbuseo tblInsa.buseo%type;
    vjikwi tblInsa.jikwi%type;
begin 
    select name,buseo,jikwi into vname, vbuseo, vjikwi from tblInsa where num = '1001'; -- 순서(**)와 갯가 맞아야 돼 
    dbms_output.put_line(vname);
    dbms_output.put_line(vbuseo);
    dbms_output.put_line(vjikwi);
end;

select * from tblInsa;

-- 직원 중 일부에게 보너스 지급 -> 내역 저장 
create table tblBonus
(
    seq number primary key,
    name varchar2(15) not null,
    bonus number not null
);

select * from tblInsa where city = '서울' and jikwi = '부장' 
    and months_between(sysdate,ibsadate) / 12 > = 14;
 
declare 
    vname tblInsa.name%type;
    vsudang tblInsa.sudang%type;
    
begin 
    select name,sudang * 3 into vname,vsudang from tblInsa
         where city = '서울' and jikwi = '부장' 
             and months_between(sysdate,ibsadate) / 12 > = 14;
             
    dbms_output.put_line(vname);
    dbms_output.put_line(vsudang);
    
    insert into tblBonus(seq,name,bonus)
        values (2,vname,vsudang); -- 서브쿼리로 할 수 있지만 비대해져서 이게 더 나음, 서브퀴리는 간단하게 쓰는 용도로
end;

select * from tblBonus;


/*
참조형
1. %type
    - 컬럼을 참조
2. %rowtype
    - 행을 참조(여러개의 컬럼을 한번에 참조)
    - %type의 집합형 
    
*/
declare 
    vrow tblInsa%rowtype; -- 행 전체를 참조하는 변수(집합), hashmap하고 비슷
begin
  --  select num,name,ssn,vibsadate,city,tel,buseo,jikwi,basicpay,sudang 
  --     into vnum,vname,vssn,vibsadate,vcity,vtel,vbuseo,vjikwi,vbasicpay,vsudang
  --       from tblInsa
  --         where num = '1001';
  
  select * into vrow from tblInsa where num = '1001'; -- 10개 : 10개 쓸데 없는 걸 가져올수도 있어서 
  --dbms_output.put_line(vrow); --객체는 출력을 못해 vrow 덤프 기능이 없어 
  dbms_output.put_line(vrow.name);
  dbms_output.put_line(vrow.buseo);
  dbms_output.put_line(vrow.jikwi);
  dbms_output.put_line(vrow.basicpay);
end;

-- ANSI-SQL + PL/SQL
-- 오라클은 키워드(구문)에서 대소문자 구분하지 않는다.
-- 데이터의 대소문자는 구분한다.
-- 오라클은 컴파일 시 모든 키워드를 대문자로 변환
--      a. 사용자 쿼리 -> 구문만 대문자, 데이터 유지
--      b. 시스템 쿼리, DB 객체 생성 -> 모든 구문 대문자 변환(table, view, synonym, index, sequence, cluster, partition table
-- 데이터베이스 객체를 저장시에도 객체명이 대문자로 변환되어 저장(****)

select * from tblInsa;
SELECT * FROM TBLINSA;
select * from employees where first_name = 'Steven';
select * from employees where first_name = 'steven';

SELECT * FROM EMPLOYEES WHERE FIRST_NAME = 'steven';

-- 시스템 테이블(오라클이 관리하는 정보를 저장하는 테이블)
select * from tabs where table_name = 'TBLINSA'; -- hr이 접속할 수 있는 테이블 목록을 보여주는, 대문자 이름으로 시스템을 관리하고 있어


-- 제어문 
-- 조건문 


set serveroutput on;

declare 
    vnum number :=10;
begin
   if vnum>0 then
    dbms_output.put_line('양수');
   end if;
end;


declare 
    vnum number :=-10;
begin
   if vnum>0 then
    dbms_output.put_line('양수');
    else 
        dbms_output.put_line('음수');
   end if;
end;


declare 
    vnum number :=0;
begin
   if vnum>0 then
    dbms_output.put_line('양수');
    elsif vnum < 0 then    --else if,elseif, elsif 등...
        dbms_output.put_line('음수');
    else 
        dbms_output.put_line('영');
   end if;
end;

declare 
    vgender char(1); --성별
begin
    select substr(ssn,8,1) into vgender 
        from tblInsa where num = '1003';
    
    if vgender = '1' then
        --남자 직원 업무 추가(select, insert ....)
            dbms_output.put_line('남자 업무 추가');
    else 
        --여자 직원 업무 추가(select, insert ....)
         dbms_output.put_line('여자 업무 추가');
    end if;
end;

commit;
rollback;

-- select 결과를 분기시켜

declare 
    -- %type
    --%rowtype
    vrow tblInsa%rowtype; --테이블 예약어
    --vnum number(5);
    vnum tblInsa.num%type;
begin
    
   vnum :=1001;
   
    select * into vrow from tblInsa where num = vnum;
    
    if vrow.basicpay > 2000000 and substr(vrow.ssn,1,2) = '88' then
        update tblInsa set sudang = 1000000 where num = vnum;
        --dbms_output.put_line('처리O');
    else 
        delete from tblInsa where num = vnum;
       --dbms_output.put_line('처리X');
    end if;
end;

select * from tblInsa;


-- case문
-- 자바의 switch case문 유사
-- ANSI-SQL의 case와는 다른 구문

declare
    vname tblCountry.name%type;
    vcontinent tblCountry.continent%type;
    vpopulation tblCountry.population%type;
    vresult varchar2(30);
begin
    select name, continent, population into vname, vcontinent, vpopulation 
        from tblCountry where name = '대한민국';
    if vcontinent = 'AS' then
        vresult := '아시아';
    elsif vcontinent = 'EU' then
        vresult :='유럽';
    else 
        vresult:='기타';
    end if;
    dbms_output.put_line(vresult);
    
    -- case end, case when 
    case vcontinent --비교값(변수) 
        when 'AS' then vresult := '아시아';
        when 'EU' then vresult := '유럽';
        else vresult :='기타'; -- default
        end case;
    dbms_output.put_line(vresult);
    
    -- 범위 비교
    case 
        when vpopulation > 10000 then vresult :='너무 많음';
        when vpopulation > 5000 then vresult :='조금 많음';
        when vpopulation > 1000 then vresult :='적당함';
        else vresult :='모자람';
    end case;
    dbms_output.put_line(vresult);
end;

/*
반복문 

1. loop 
    - 조건 반복
2. for loop 
    - 지정 횟수 반복(자바 for)
3. while loop 
    - 조건 반복(자바 while)

*/
-- 무한 루프
begin 
    loop 
        dbms_output.put_line(to_char(sysdate,'hh24:mi:ss')); -- 오버플로우 발생, 무한 루프가 발생
    end loop;
end;

-- 무한 루프 + 조건 탈출
declare 
    vnum number :=1;
begin 
    loop 
        dbms_output.put_line(to_char(sysdate,'hh24:mi:ss')); 
        --exit; --break 문
        vnum := vnum +1;
        exit when vnum > 10; -- 탈출 조건
    end loop;
end;

delete sequence loopSeq;

create table tblLoop(
    seq number primary key,
    data varchar2(30) not null
);

create sequence loopSeq;

-- 데이터 X 1000건 
-- 데이터1 > 데이터2 > 데이터3....

declare 
    vnum number :=1;
begin
    loop 
        insert into tblLoop(seq,data) values (loopSeq.nextVal,'데이터'||vnum);
        vnum:=vnum+1;
        exit when vnum = 10001;
    end loop;
end;

select count(*) from tblLoop;

/*

2. for loop 
    - 지정 횟수 반복(자바 for)

*/

begin   
    -- i: 루프 변수
    -- 1: 초깃값
    -- .. : 증가
    for i in 1..10 loop --i에 대입하는
        dbms_output.put_line('숫자: '||i);
    end loop;
end;

create table tblGugudan
(
    seq number primary key,
    dan number not null,
    num number not null,
    result number not null
);

create sequence gugudanSeq;

declare 
    vdan number;
    vnum number;
    vresult number;

begin 
    for dan in 2..9 loop
        for num in 1..9 loop
            insert into tblGugudan values(gugudanSeq.nextVal,dan,num,dan*num);
        end loop;
    end loop;
end;

select * from tblGugudan;

-- 3. while loop
declare 
    vnum number:=1;
begin   
    while vnum<=10 loop
    dbms_output.put_line(vnum);
    vnum:=vnum+1;
    end loop;
end;


/*
select 실행 > 데이터 가져오기 > PL/SQL 변수에 대입

1. select into 절 사용하기 
    - 결과셋의 레코드가 1개일 때만 사용이 가능하다.
2. cursor 사용하기(행의 컬럼값에 접근 가능) 
    - 결과셋의 레코드가 0개 이상일 때 사용이 가능하다.

declare 
    변수 선언;
    커서 선언; -- 결과셋 참조 객체
begin
    커서 열기;
        loop 
            데이터 접근(레코드 접근) + 커서 사용
        end loop;
    커서 닫기;
end;

*/

declare 
    vname tblInsa.name%type;
begin
    select name into vname from tblInsa; -- 변수1개에 60개를 넣을 수 없어, 담을 수 있는 변수는 하나 
    dbms_output.put_line(vname);
end;

--다중행 + 단일컬럼 
-- 직업명 60개 가져오기 
declare 
    vname tblInsa.name%type;
    cursor vcursor is select name from tblInsa order by name asc; --커서 선언, 결과 테이블을 참조
begin    
    open vcursor; --커서 열기 
    
    loop --한바퀴 = 레코드 1줄 접근하기, 무한루프, 황진이가 남아서 계속 읽고 읽고 한 것
    
        fetch vcursor into vname; -- select 느낌, 현재 커서가 가리키는 레코드의 컬럼값 가져오기 + 변수 복사 
        exit when vcursor%notfound; -- boolean값 없으면 true, 있으면 false
        dbms_output.put_line(vname);
        
    end loop;

    close vcursor; --커서 닫기
end;

-- 다중행 + 다중컬럼 
select * from tblInsa;
select * from tblInsa where buseo = '기획부';
select * from tblBonus;

declare 
    --vname tblInsa.name%type;
    --vsudang tblInsa.sudang%type;
    vrow tblInsa%rowtype;
    vseq number;
    
    cursor vcursor 
    is select * from tblInsa where buseo = '기획부'; -- 모든 컬럼이 필요 없어서 
begin 
    open vcursor;
    loop 
        fetch vcursor into vrow;
        
        exit when vcursor%notfound;
        --기획부직원에게 보너스 지급 > insert
        select max(seq) + 1 into vseq from tblBonus;
        insert into tblBonus values(vseq,vrow.name,vrow.sudang * 3); 
    end loop;
    close vcursor;
end;

-- 커서 탐색
-- 1. 커서 + loop
-- 2. 커서 + for loop
-- - 커서 탐색을 단순화 시켜놓은 방법

declare 
    cursor vcursor 
    is select * from tblInsa;
    --vrow tblInsa%rowtype; --아래에서 작성
    
begin
    --open vcursor;
    --loop
    for vrow in vcursor loop -- loop + fetch + exit 
    -- 향상된 for문
    
        --fetch vcursor into vrow;
        --exit when vcursor%notfound;
        --업무 영역
        dbms_output.put_line(vrow.name || ':' || vrow.buseo);
    end loop;    
    --close vcursor;
end;

-- 단순 쿼리 용도O, 복잡한 쿼리 용도X 가독성이 떨어짐
begin
    for vrow in (select * from tblInsa) loop 
        dbms_output.put_line(vrow.name);
    end loop;
end;

--예외 처리부
-- - 실행부에서 발생하는 예외를 처리하는 블럭
declare 
    vdata number;
begin
    dbms_output.put_line('시작');
    select name into vdata from tblInsa where num = 1001; -- 자료형이 달라서
    dbms_output.put_line('끝');
exception 
    -- 예외처리부
    when others then -- 모든 예외 잡는 역할  
        dbms_output.put_line('예외 처리');
end;

select * from tblInsa;
drop table tblLog;
drop sequence logSeq;

create table tblLog
(
    seq number primary key,
    code varchar(7) not null check(code in('AAA0001','AAA0002','AAB0001')),
    message varchar2(1000) not null,
    regdate date default sysdate not null
    
);
-- 그 외의 에러를 넣고 싶은데 생각이 나지를 않음
-- 데이터의 갯수가 많거나 적거나

create sequence logSeq;

declare 
    vcnt number;
    vname varchar2(30);

begin
    select count(*) into vcnt from tblCountry;
    select name into vname from tblInsa where num = 1001;
    select name into vname from tblInsa;
    
    dbms_output.put_line(100/vcnt);
    dbms_output.put_line(vname);
exception
    when zero_divide then
        insert into tblLog values (logSeq.nextVal,'AAA0002','tblCountry 테이블에 데이터가 없습니다.',default);
    when no_data_found then
         insert into tblLog values (logSeq.nextVal,'AAB0001','tblInsa 테이블에서 가져온 데이터가 없습니다.',default);
    when others then
        insert into tblLog values (logSeq.nextVal,'AAA0001','에러발생',default);
end;


select * from tblCountry;
delete from tblCountry;
select * from tblLog;

select * from tblInsa;

-- https://docs.oracle.com/cd/E11882_01/timesten.112/e21639/exceptions.htm#TTPLS196

--익명 프로시저
--실명 프로시저(저장 프로시저) - 이름을 붙이는 순간 DB에 저장이 돼 

--저장 프로그램 종류(메소드)
--1. 저장 프로시저, Stored Procedure 
--2. 저장 함수, Stored Function 

/*

[declare
    변수 선언;
    커서 선언; ]
begin
    구현부;
[exception
    예외처리; ]
end;


create [or replace] procedure 프로시저명 --DB object 객체 생성 
is(as) --declare
    [변수 선언;
    커서 선언;]
begin
    구현부;
[exception
    예외처리; ]
end [프로시저명];

*/

set serveroutput on;


declare 
    vnum number;
begin
    vnum := 100;
    dbms_output.put_line('num:' || vnum);
end;

-- 실행이 아니라 객체를 만든 것, 호출을 통해서 재사용을 함, 메소드 
create or replace procedure procTest
is 
    vnum number;
begin
    vnum := 100;
    dbms_output.put_line('num:' || vnum);
end;

/*

저장 프로시저 호출하는 방법
1. PL/SQL 블럭에서 호출하기

2. 스트립트 환경에서 호출하기(ANSI-SQL환경) 


*/

select * from tblInsa; --2 

begin
    select * from tblInsa; --1번 
end;

--1. PL/SQL 블록에서 프로시저 호출하기(FM)
begin
    procTest; --프로시저 호출 
    procTest;
    procTest;
    procTest;
    procTest;
end;

--2. 스트립트에서 호출하기(비권장)
execute procTest;
exec procTest;
call procTest; --**** 뒤에 수업에서 사용

-- 프로시저 = 메서드 
-- - 매개변수 or 반환값 

--1. 매개변수 있는 프로시저 
create or replace procedure procTest(pnum number) -- 수정을 함
is 
    -- 선언부에서 선언한 변수는 해당 프로시저 전체에서 사용이 가능한 전역 변수
    vsum number := 0;
begin

    vsum := pnum + 100;
    dbms_output.put_line(vsum);
    
end procTest; -- 적는게 좋아, --m1 가독성을 위해서, end 블록의 소유주를 알기 쉬움

begin
    procTest(100);
end;

create or replace procedure procTest(
    width number,
    height number -- 목록, 매개변수
)
is 
    vresult number; --독립된 변수
begin
    vresult := width * height;
    dbms_output.put_line(vresult);
end procTest;


begin
    procTest(100,200); -- 매개변수의 갯수가 적거나 많아도 에러가 나
end;


create or replace procedure procTest(
    width number,
    height number default 10
)
is 
    vresult number; --독립된 변수
begin
    vresult := width * height;
    dbms_output.put_line(vresult);
end procTest;

begin
    procTest(100); -- height를 디폴트에서 공급받음, 매개변수의 다양성을 구현할 수 있음
end;

/*
매개변수 모드(*****)
- 매개변수의 값을 전달하는 방법

1. in 모드 : 기본모드 
2. out 모드 
3. in out모드 (복잡)
*/
set serveroutput on;
create or replace procedure procTest(
    vnum1 in number,
    vnum2 in number,
    vresult out number, -- 반환값, 주소값(참조가 넘어가), 같은 참조 주소 반환값과 같은 역할의 메소드 실행과 같은 역할을 해, 갯수가 많아도 상관없어
    vresult2 out number
)
is 
    
begin
    vresult := vnum1 + vnum2;
    vresult2 := vnum1 * vnum2;
end;

declare 
    vresult number;
    vresult2 number;
begin 
--    dbms_output.put_line(procTest(10,20));
      procTest(10,20,vresult,vresult3);
      dbms_output.put_line(vresult);
      dbms_output.put_line(vresult2);
end;

-- 직원 번호 전달 > 이름,나이,부서, 직위 반환 프로시저 
create or replace procedure procGetInsa(
    pnum in number,
    pname out varchar2, -- 매개변수는 길이를 표현할 수 없다.
    page out number,
    pbuseo out varchar2,
    pjikwi out varchar2
)
is 
begin 
    select name, floor(months_between(sysdate,to_date(case 
        when substr(ssn,8,1) in ('1','2') then '19' || substr(ssn,1,6)
        when substr(ssn,8,1) in ('3','4') then '20' || substr(ssn,1,6)
    end,'yyyymmdd')) / 12) -- 두 날짜 사이의 개월 수
    ,buseo,jikwi into pname,page,pbuseo,pjikwi
    from tblInsa 
        where num = pnum;
    
end procGetInsa;

-- select 테스트용
select 
    --19951010 or 20011010
    floor(months_between(sysdate,to_date(case 
        when substr(ssn,8,1) in ('1','2') then '19' || substr(ssn,1,6)
        when substr(ssn,8,1) in ('3','4') then '20' || substr(ssn,1,6)
    end,'yyyymmdd')) / 12)
from tblInsa;

-- sysdate - 하면 355 또는 366

declare 
    vnum tblInsa.num%type;
    vname tblInsa.name%type;
    vage number;
    vbuseo tblInsa.buseo%type;
    vjikwi tblInsa.jikwi%type;
begin
    vnum:=1050;
    procGetInsa(vnum,vname,vage,vbuseo,vjikwi);
    dbms_output.put_line(vname);
    dbms_output.put_line(vage);
    dbms_output.put_line(vbuseo);
    dbms_output.put_line(vjikwi);
end;

-- 직원 추가 
select * from tblInsa;
insert into tblInsa (num,name,ssn,ibsadate,city,tel,buseo,jikwi,basicpay,sudang)
    values((select max(num) + 1 from tblInsa), '','',?,'','','','',0,0);

create or replace procedure procAddInsa(
    pname varchar2,
    pssn varchar2,
    pyear varchar2,
    pmonth varchar2,
    pdate varchar2,
    pcity varchar2,
    ptel varchar2,
    pbuseo varchar2,
    pjikwi varchar2,
    pbasicpay number,
    psudang number,
    presult out number -- 1 or 0 
)
is 
begin
    --insert
    insert into tblInsa (num,name,ssn,ibsadate,city,tel,buseo,jikwi,basicpay,sudang)
    values((select max(num) + 1 from tblInsa), pname,pssn,
    to_date(pyear||pmonth||pdate,'yyyymmdd'),pcity,ptel,pbuseo,pjikwi,pbasicpay,psudang);
    presult := 1;
exception 
    when others then 
        presult := 0;

end procAddInsa;

declare 
    vresult number;
begin
    procAddInsa('아무개','920115-1023456','2003','05','20','서울',
                '010-1234-5678','영업부','대리',2500000,10000,vresult);
    if vresult = 1 then
        dbms_output.put_line('추가 성공');
    else 
        dbms_output.put_line('추가 실패');
    end if;
end;

select * from tblInsa;

delete from tblInsa where num = 1062;

-- 6/4
-- 프로시저(인자값+반환값)
select * from tblStaff; --직원
select * from tblProject;   --프로젝트 

--퇴사 프로시저 
-- 1. 퇴사직원 업무 위임 -> 2. 퇴사 처리 
create or replace procedure procDeleteStaff(
    pseq number, -- 퇴사할 직원번호(PK)
    pstaff number,  -- 위임받을 직원번호
    presult out number -- 성공(1) or 실패(0)
)
is 
    --변수?
    vcnt number;
begin

    -- 1. 해당 직원의 담당 프로젝트가 있는지?
    select count(*) into vcnt from tblProject where staff = pseq;
    
    --2. 담당 업무가 있는지? 조건
    if vcnt > 0 then 
        --3. 위임 후 퇴사
        update tblProject set staff = pstaff --위임자
            where staff=pseq;   --퇴사자
      
    else 
        --3. 퇴사
        null; -- 빈 블록 표시 용도
    end if;
      delete from tblStaff where seq = pseq;
    
    presult := 1;
    commit; --프로시저가 끝나면 자동으로 커밋이 돼, commit은 안해도 돼
exception 
    when others then 
        presult := 0;
        rollback;   -- 롤백은 꼭해야 되고 없었던걸로 해야 돼서 
end;

set serveroutput on;

declare 
    vresult number; -- 성공유무 
begin
    procDeleteStaff(3,4,vresult);
    if vresult = 1 then 
        dbms_output.put_line('퇴사 성공');
    else  dbms_output.put_line('퇴사 실패');
    end if;
end;


select * from tblStaff; -- 하하하 퇴사 
select * from tblProject; -- 3번이 4번으로 바뀜

-- DML 
-- 요구 분석 > 모든 업무 > 질의 > select,insert,update,delete -> SQL 작성 -> Text SQL
-- 위의 Text SQL -> 1. 크기 큰 SQL, 2. 복잡한 SQL, 3. 자주 반복 SQL 4. 여러 쿼리 + 하나의 업무 -> 프로시저,함수 작성
-- 조인해야 되는게 많아 
-- -> 그 중 select -> 뷰 작성(select 만 들어감)
-- -> 트리거 or 인덱스 생성 + 적용

-- DB 결과 + (JDBC) + 자바(사용법만 처리함, 메뉴, 입력, 프로시저 루프돌리고)



-- 함수, Function(리턴문 있는걸 함수라고 함)
-- - 실행 후 결과값을 1개만 반환하는 프로그램 
-- - 함수에서도 out 매개변수를 사용할 수 있다. -> 사용하면 안된다. -> return 을 사용해야 한다. 

-- public int fnSum(int num1, int num2)
create or replace function fnSum(
    pnum1 number, pnum2 number
) return number
is 
    
begin
    return pnum1 + pnum2;
end;

declare 
    vresult number;
begin
    vresult := fnSum(100,200);
    dbms_output.put_line(vresult);
end;

-- 함수와 프로시저의 차이점 
-- 함수는 ANSI-SQL와 같이 사용이 가능하다.

select basicpay,sudang,fnSum(basicpay,sudang) from tblInsa;

-- 프로시저는 PL-SQL을 조직적으로 하기 위한, ANSI를 도와주기 위한 프로시저 함수

create or replace view vwInsa
as
select name, 
    case
        when substr(ssn,8,1) = '1' then '남자'
        when substr(ssn,8,1) = '1' then '여자'
    end as gender
from tblInsa; -- 뷰로 만들면 재사용이 가능했지만

select * from vwInsa; -- 출력용으로 밖에 못써 

create or replace function fnGender (
    pssn varchar2 
) return varchar2
is 
begin
  return  case 
            when substr(pssn,8,1) = '1' then '남자'
            when substr(pssn,8,1) = '1' then '여자'
         end; 
end;

select name,ssn, fnGender(ssn) from tblInsa;

-- 반환값과 리턴 문, function으로 만들꺼리.. 프로젝트


/*
Trigger, 트리거(사건을 걸어놓는, 일반적인 것들은 우리가 호출해서 하는데, 집중해야 되는 일에 집중 가능)
- 프로시저 
- 특정 사건이 발생하면 자동으로 실행되는 프로시저(예약)
- 특정 테이블 목표 -> 감시 -> insert,update or delete -> 미리 준비해놓은 프로시저를 호출 
- 트리거가 많아지면 시스템 속도가 느려진다. 감시하는 얘들이 많아져서(24시간 동안 살아 있어)


트리거 구문

create or replace trigger 트리거명 
    -- 트리거 옵션 
    before|after
    insert|update|delete on 테이블명 -- 모니터링할 사건의 종류
    for each row 
declare 
    선언부;
begin 
    실행부;
end;

*/

-- tblStaff -> 직원 퇴사 
-- 특정 요일(목)에는 tblStaff의 데이터 조작(delete)을 못하게 금지한다. 어떤 사건이 발생하면 행동 후속 조취
create or replace trigger trgStaff
    before
    delete on tblStaff -- 어떤 테이블에서 사건이 발생이 되는지
begin
    --dbms_output.put_line('트리거가 실행되었습니다.');
    if to_char(sysdate,'dy') = '목' then
        -- 현재 진행하려던 업무를 없었던 일로 처리하기 -> 강제 에러 발생 throw Exception()
        -- -20000 ~ -29999
        raise_application_error(-20001,'목요일에는 퇴사가 불가능합니다.');
    end if;
end; -- 자동 커밋

rollback;
select * from tblStaff;
update tblProject set staff = 4 where staff = 2;
delete from tblStaff where seq = 2;

insert into tblStaff values (5,'홍길동',300,'서울시');
delete from tblStaff where seq = 5;

drop trigger trgStaff;

-- 로그(흔적을 남겨놓을때)
-- tblStaff 테이블에 변화가 발생하면 기록을 남기자 

create table tblLogStaff(
    seq number primary key,
    message varchar2(1000) not null,
    regdate date default sysdate not null
);

create sequence seqLogStaff;


create or replace trigger trgLogStaff 
    after
    insert or update or delete on tblStaff 
declare
    vmessage varchar(1000);
begin 
    if inserting then 
         vmessage := '새 직원이 추가되었습니다.';
    elsif updating then
         vmessage := '직원 정보가 수정되었습니다.';
    elsif deleting then
         vmessage := '직원이 삭제되었습니다.';
    end if;
    
    insert into tblLogStaff values (seqLogStaff.nextVal,vmessage,default);
end;

select * from tblLogStaff;

commit;

-- 트리거
-- 1. for each row 표현 O : 행 단위 트리거  -> 트리거 실행이 반복 
--      -> 감시하는 작업이 발생한 레코드의 수만큼 트리거 실행
--  : 적용되는 레코드의 정보가 중요한 경우 -> 변경이 발생된 데이터를 참조 가능

-- 2. for each row 표현 X : 문장 단위 트리거 -> 트리거 실행이 1회 
--      -> 감시하는 작업이 발생한 레코드의 수에 상관없이 트리거는 1번 실행
--  : 적용되는 레코드의 정보는 중요하지 않음. 사건만 중요한 경우
select * from tblComedian;

set serveroutput on;

create or replace trigger trgComedian
    after 
    update on tblComedian 
    for each row 
--declare
begin
    dbms_output.put_line('코미디언 정보가 수정되었습니다.'); 
end;

update tblComedian set 
    weight = weight * 1.1
        where first = '재석' and last = '유';  --업데이트 행의 갯수 -> 1개 
        

update tblComedian set 
    weight = weight * 1.1
        where gender = 'm'; --업데이트 행의 갯수 -> 8개 
rollback;
--행의 갯수와 무관하게 트리거를 한번만 실행을 해 

/*

for each row를 사용하는 경우 
- 상관 관계(: old, :new)를 사용한다.


1. insert
    - 트리거내에서 방금 insert된 레코드의 컬럼값들을 참조할 수 있다.
    - : new = 방금 추가된 행 
    - : new.컬럼명 = 방금 추가된 행의 컬럼
    - after 트리거에서 사용(추가된 후의 정보 행이라서)
2. update
    - 트리거내에서 방금 update된 레코드의 전후 컬럼값들을 참조할 수 있다.
    - : new = 방금 수정후 행
    - : old = 방금 수정전 행
    
3. delete
    - 트리거내에서 방금 삭제된 레코드를 참조할 수 있다.
    - :old = 방금 삭제된 행 
    - before 

insert + after -> :new
update + after -> :new + :old
delete + before -> :old

*/


create or replace trigger trgComedian
    before -- 취소 같은 거는 before를 써야 돼  
    update on tblComedian 
    for each row 
begin
    dbms_output.put_line(:old.last || :old.first); 
    dbms_output.put_line('이전 몸무게:' || :old.weight);
    dbms_output.put_line('현재 몸무게: ' || :new.weight);
end;

select * from tblStaff;
select * from tblProject;

rollback;

insert into tblStaff values(5,'홍길동',300,'서울시');
update tblProject set staff = 5 where seq in (1,3,6);


-- before전에 위임을 처리하자
delete from tblStaff where seq = 5; -- 바로 실행 가능하게 만들자!!!

--업무 인수 인계 트리거
create or replace trigger trgStaff 
    before
    delete on tblStaff
    for each row
declare
begin
    update tblProject set
        staff = 4
            where staff = :old.seq; -- old가 된 이유: delete는 old만 존재, 삭제되기 직전의 레코드를 접근 가능 5번
end;



-- 게시판 + 댓글 
-- 테이블 삭제 -> 자식 테이블? -> 찾아내야 방법 
-- 1. 강제 삭제(FK 제약 강제 삭제 ) -> 부모 테이블 삭제 
-- DROP TABLE 테이블명 CASCADE CONSTRAINTS PURGE; -- 자식 외래키가 사라짐(제약조건을 없앰)

-- 2. 관계 있는 테이블들 목록 조회
--SELECT fk.owner, fk.constraint_name , fk.table_name
--  FROM all_constraints fk, all_constraints pk
-- WHERE fk.R_CONSTRAINT_NAME = pk.CONSTRAINT_NAME
--   AND fk.CONSTRAINT_TYPE = 'R'
--   AND pk.TABLE_NAME = 'TBLBOARD'
-- ORDER BY fk.TABLE_NAME;

-- 3. 관계있는 테이블들 목록 조회(ERD) : 역공학


drop table tblBoard;
drop table tblComment;

create table tblBoard(
    seq number primary key, --글번호(PK)
    subject varchar2(1000) not null, --글제목
    commentCount number default 0 not null -- 댓글 수
);  -- 부모

create table tblComment(
    seq number primary key, -- 댓글번호(PK)
    subject varchar2(1000) not null,    --댓글제목
    pseq number not null references tblBoard(seq) --부모글번호(FK)
);  -- 자식, 댓글을 달수 있어

-- 테이블 내의 열 중 다른 테이블의 기본키를 참조하는 열을 외래키
--글쓰기
insert into tblBoard values(1,'게시판입니다.',default); 
insert into tblBoard values(2,'안녕하세요~ 홍길동입니다..',default); 
insert into tblBoard values(3,'오라클 수업중입니다.',default); 

-- 댓글쓰기
insert into tblComment values(1,'1번글에 대한 댓글입니다.',1);
update tblBoard set commentCount = commentCount + 1 where seq=1;

select * from tblComment;
select * from tblBoard;

create or replace procedure procAddComment(
    pseq number, --댓글
    psubject varchar2, --댓글제목
    ppseq number --부모글번호
)
is 

begin
    insert into tblComment values(pseq,psubject,ppseq);
    update tblBoard set commentCount = commentCount + 1 where seq=ppseq;
end;

begin
    procAddComment(2,'2번에 다는 댓글입니다.',2);
end;

create or replace trigger trgAddComment
    after
    insert on tblComment
    for each row 
begin
    update tblBoard set commentCount = commentCount + 1 where seq =:new.pseq;
end;

insert into tblComment values (3,'1번에 두번째 댓글입니다.',1);


select * from tblBoard;

-- 프로시저 권장

/*

-- Text Query
-- 1. 단일 문장
    - 프로시저
    - 뷰 
    
-- 2. 다중 문장 
    - 프로시저

1+2. 결과 테이블 반환
-- 어떤 강의실의 학생 목록을 확인 할 수 있다. select 
a. Text SQL -> select 
b. procedure 

-- 커서(결과셋)를 반환하는 프로시저 만들기 




*/
select * from tblInsa where buseo = '영업부';

create or replace procedure procBuseo(
    pbuseo varchar2
)
is
    cursor vcursor is select * from tblInsa where buseo = pbuseo;
    vrow tblInsa%rowtype;
begin
    open vcursor;
    loop 
        fetch vcursor into vrow; -- 레코드 1개 가져와서 변수에 복사
        exit when vcursor%notfound;
        
        dbms_output.put_line(vrow.name);
    end loop;
    close vcursor;
end;

        
begin
    procBuseo('영업부');
end;

--프로젝트 => select, 출력은 반환값으로 받아서 자바에서 출력을 함
create or replace procedure procBuseo(
    pbuseo varchar2,
    presult out sys_refcursor --반환값으로 커서를 사용할 때 사용하는 자료형
)
is
begin
   open presult
        for select * from tblInsa where buseo = pbuseo; --결과 테이블
end;


--커서를 반환한 프로시저를 호출하기 
declare
    vresult sys_refcursor; --커서
    vrow tblInsa%rowtype;
begin
    procBuseo('영업부',vresult);   -- 목록 만들기
    
    loop 
        fetch vresult into vrow;
        exit when vresult%notfound;
        
        dbms_output.put_line(vrow.name);
    end loop;
end;    -- 자바에서 이렇게 사용할 수 있음

--커서,테이블 반환