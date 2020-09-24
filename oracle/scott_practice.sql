--125p
select * from emp;
select * from emp where ename like '%S';

select empno,ename,sal,deptno from emp where deptno = 30 and job = 'SALESMAN';

select empno,ename,job,sal,deptno from emp where deptno in (20,30) and sal >2000;

select * from emp where sal>=2000 and sal <=3000;

select ename,empno,sal,deptno from emp where ename like '%E%' and deptno = 30;

select * from emp where mgr is not null and comm is null and job in ('MANAGER','CLERK') and not ename like '_L%'; 

desc emp;
select empno,empno from emp where length(ename) > = 5 and length(ename) < 6;

create sequence seq;

select seq.currVal from dual; -- 확인 + 0 -> peek
select seq.nextVal from dual; -- 확인 + 1 -> pop()

select * from emp; --12
select * from dept; --4
select * from emp,dept; --48

--174p
select empno,rpad(substr(empno,1,2),length(empno),'*') as MASKING_EMPNO, ename, rpad(substr(ename,1,1),length(ename),'*') as MASKING_ENAME 
        from emp where length(ename) >=5 and length(ename) < 6;
        
select * from emp;
select empno,ename,sal, round(sal/21.5,2) as "DAY_PAY", round(sal/21.5/8,1) as "TIME_PAY" from emp;

select empno,ename,hiredate, to_char(add_months(hiredate,3),'yyyy-mm-dd') as R_JOB, decode(COMM,null,'N/A') as COMM from emp;

select empno,ename,mgr, 
     to_char(decode(substr(mgr,1,2),null,0,'75',5555,'76',6666,'77',7777,'78',8888,mgr),'0000') as CHG_MGR from emp;
     
--239p chapter 8 

select * from emp;
select * from dept;
select D.deptno,D.dname,E.empno,E.ename,E.sal from EMP E, DEPT d where E.sal>2000 and E.deptno = D.deptno;
select D.deptno,D.dname,E.empno,E.ename,E.sal
    from EMP E inner join DEPT D on E.deptno = D.deptno where E.sal > 2000; 
     
SELECT DEPTNO, D.DNAME, E.EMPNO, E.ENAME, E.SAL
  FROM EMP E NATURAL JOIN DEPT D
 WHERE E.SAL > 2000;         
 
select e.deptno,d.dname,trunc(avg(e.sal)) as "AVG_SAL", trunc(max(e.sal)) as "MAX_SAL", trunc(min(e.sal)) as "MIN_SAL", count(*)
    from emp e
        inner join dept d on e.deptno = d.deptno group by e.deptno,d.dname;
        
select e.deptno,d.dname,trunc(avg(e.sal)) as "AVG_SAL", trunc(max(e.sal)) as "MAX_SAL", trunc(min(e.sal)) as "MIN_SAL", count(*)
    from emp e, dept d
       where e.deptno = d.deptno group by e.deptno,d.dname;
        
select d.deptno,d.dname,e.empno,e.ename,job,sal from emp e, dept d
    where d.deptno = e.deptno order by e.empno,e.ename;

select d.deptno,d.dname,e.empno,e.ename,job,sal from emp e
    inner join dept d on d.deptno = e.deptno order by e.empno,e.ename;
    
select * from emp;
select * from dept;
select * from salgrade;

select d.deptno,d.dname,e.empno,e.ename,e.mgr,e.sal,d.deptno as "DEPTNO_1",s.losal,s.hisal,s.grade,e.empno as mgr_empno, e.ename as "MGR_ENAME"
    from emp e, emp e1, dept d, salgrade s
        where e.deptno(+) = d.deptno and e.mgr = e1.empno(+) and e.sal between s.losal(+) and s.hisal(+) order by deptno,empno;
        
select d.deptno,d.dname,e.empno,e.ename,e.mgr,e.sal,d.deptno as "DEPTNO_1",s.losal,s.hisal,s.grade,e.empno as mgr_empno, e.ename as "MGR_ENAME"
    from emp e right outer join dept d on e.deptno = d.deptno
            left outer join emp e1 on e.mgr = e1.empno
                left outer join salgrade s on e.sal between s.losal and s.hisal order by deptno,empno;
                

SELECT D.DEPTNO, D.DNAME,
       E.EMPNO, E.ENAME, E.MGR, E.SAL, E.DEPTNO,
       S.LOSAL, S.HISAL, S.GRADE,
       E2.EMPNO AS MGR_EMPNO, E2.ENAME AS MGR_ENAME
  FROM EMP E RIGHT OUTER JOIN DEPT D
                ON (E.DEPTNO = D.DEPTNO)
              LEFT OUTER JOIN SALGRADE S
                ON (E.SAL BETWEEN S.LOSAL AND S.HISAL)
              LEFT OUTER JOIN EMP E2
                ON (E.MGR = E2.EMPNO)
ORDER BY D.DEPTNO, E.EMPNO; 

-- p212
select * from emp;
select deptno,trunc(avg(sal)) as "AVG_SAL", max(sal) as "MAX_SAL", min(sal) as "MIN_SAL", count(*) as CNT from emp group by deptno;

select job,count(*) from emp group by job having count(*) >= 3;

select to_char(hiredate,'yyyy') as HIRE_YEAR, deptno, count(*) as CNT from emp group by to_char(hiredate,'yyyy'),deptno order by to_char(hiredate,'yyyy') desc;

select decode(comm,null,'X','O') as "EXIST_COMM",count(*) as CNT from emp group by decode(comm,null,'X','O');

select deptno,to_char(hiredate,'yyyy') as "HIRE_DATE", count(*) as CNT, max(sal) as "MAX_SAL", sum(sal) as "SUM_SAL", trunc(avg(sal)) as "AVG_SAL" 
    from emp group by rollup(deptno, to_char(hiredate,'yyyy'));
    
--p262 chapter 9
select * from emp, dept;
select c.job,c.empno,c.ename,c.sal,c.deptno,d.dname from emp c,dept d where c.deptno = d.deptno and job=(select job from emp where ename = 'ALLEN') ;
select * from emp;
select * from emp,dept,salgrade;
select * from dept;
select * from salgrade;
select e.empno,e.ename,d.dname,e.hiredate,d.loc,e.sal,s.grade from emp e,dept d,salgrade s where  e.sal > (select avg(sal) from emp) and e.deptno = d.deptno 
    and e.sal between losal and s.hisal
        order by e.sal desc, e.empno; 

select e.empno,e.ename,e.job,e.deptno,d.dname,d.loc from emp e, dept d where  e.deptno = 10 and e.deptno = d.deptno  and 
    e.job not in (select job from emp where deptno = 30); 
    
select e.empno,e.ename,e.sal,(select grade from salgrade where sal between losal and hisal) as GRADE from emp e where sal > (select max(sal) from emp where job = 'SALESMAN') 
    order by empno;

SELECT E.EMPNO, E.ENAME, E.SAL, S.GRADE
  FROM EMP E, SALGRADE S
 WHERE E.SAL BETWEEN S.LOSAL AND S.HISAL
   AND SAL > (SELECT MAX(SAL)
                FROM EMP
               WHERE JOB = 'SALESMAN')
ORDER BY E.EMPNO; 

select empno,rpad(substr(empno,1,2),length(empno),'*') as MASKING_EMPNO, ename, rpad(substr(ename,1,1),length(ename),'*') as MASKING_ENAME 
        from emp where length(ename) >=5 and length(ename) < 6;
        

--287p
create table chap10hw_emp as select * from emp;
create table chap10hw_dept as select * from dept;
create table chap10hw_salgrade as select * from salgrade;

select * from chap10hw_dept;
insert into chap10hw_dept(deptno,dname,loc) values (50,'ORACLE','BUSAN');
insert into chap10hw_dept(deptno,dname,loc) values (60,'SQL','ILSAN');
insert into chap10hw_dept(deptno,dname,loc) values (70,'SELECT','INCHEON');
insert into chap10hw_dept(deptno,dname,loc) values (80,'DML','BUNDANG');

select * from chap10hw_dept;
desc chap10hw_emp;
insert into chap10hw_emp(empno,ename,job,mgr,hiredate,sal,comm,deptno) values(7201,'TEST_USER1','MANAGER',7788,to_date('2016-01-02','yyyy-mm-dd'),4500,null,50); 
insert into chap10hw_emp(empno,ename,job,mgr,hiredate,sal,comm,deptno) values(7202,'TEST_USER2','CLERK',7201,to_date('2016-02-21','yyyy-mm-dd'),1800,null,50); 
insert into chap10hw_emp(empno,ename,job,mgr,hiredate,sal,comm,deptno) values(7203,'TEST_USER3','ANALYST',7201,to_date('2016-04-11','yyyy-mm-dd'),3400,null,60); 
insert into chap10hw_emp(empno,ename,job,mgr,hiredate,sal,comm,deptno) values(7204,'TEST_USER4','SALESMAN',7201,to_date('2016-05-31','yyyy-mm-dd'),2700,300,60); 
insert into chap10hw_emp(empno,ename,job,mgr,hiredate,sal,comm,deptno) values(7205,'TEST_USER5','CLERK',7201,to_date('2016-07-20','yyyy-mm-dd'),2600,null,70); 
insert into chap10hw_emp(empno,ename,job,mgr,hiredate,sal,comm,deptno) values(7206,'TEST_USER6','CLERK',7201,to_date('2016-09-08','yyyy-mm-dd'),2600,null,70); 
insert into chap10hw_emp(empno,ename,job,mgr,hiredate,sal,comm,deptno) values(7207,'TEST_USER7','LECTURER',7201,to_date('2016-10-28','yyyy-mm-dd'),2300,null,80); 
insert into chap10hw_emp(empno,ename,job,mgr,hiredate,sal,comm,deptno) values(7208,'TEST_USER8','STUDENT',7201,to_date('2018-03-09','yyyy-mm-dd'),1200,null,80); 


select * from chap10hw_emp;

rollback;

create table tblhi(
  name varchar2(30)
);

select * from emp;
insert into tblhi values((select ename from emp where empno=7369));

select * from tblhi;

update chap10hw_emp set deptno = 70 where sal > (select avg(sal) from chap10hw_emp);
select * from chap10hw_emp;

rollback;

UPDATE CHAP10HW_EMP
   SET DEPTNO = 70
 WHERE SAL > (SELECT AVG(SAL)
                FROM CHAP10HW_EMP
               WHERE DEPTNO = 50);
               
select * from chap10hw_emp;

update chap10hw_emp set sal = sal*1.1,deptno= 80 where hiredate > (select min(hiredate) from chap10hw_emp where deptno = 60);

select * from salgrade;
delete from chap10hw_emp where sal between (select losal from salgrade where grade = 5) and (select hisal from salgrade where grade = 5);

rollback;


DELETE FROM CHAP10HW_EMP
 WHERE EMPNO IN (SELECT E.EMPNO
                   FROM CHAP10HW_EMP E, CHAP10HW_SALGRADE S
                  WHERE E.SAL BETWEEN S.LOSAL AND S.HISAL
                    AND S.GRADE = 5);
--p324
create table EMP_HW (
    empno number(4),
    ename varchar2(10),
    job varchar2(9),
    mgr number(4),
    hiredate date,
    sal number(7,2),
    comm number(7,2),
    deptno number(2)
);

alter table emp_hw 
    add bigo varchar2(20);

select * from emp_hw;
desc emp_hw;
-- 자료형 변경 
alter table emp_hw
    modify bigo varchar2(30);
    
alter table emp_hw rename column bigo to remark;

insert into emp_hw select empno,ename,job,mgr,hiredate,sal,comm,deptno,null from emp;

drop table emp_hw;

--357p
create view empidx as (select * from emp);
drop view empidx;
create table empidx as (select * from emp);
select * from empidx;
create index idx_empidx_empno on empidx(empno);
SELECT * 
  FROM USER_INDEXES 
 WHERE INDEX_NAME = 'IDX_EMPIDX_EMPNO';

create view empidx_over15k as(select * from empidx where sal > 1500);
select empno,ename,job,mgr,hiredate,sal,decode(comm,null,'X','O') from empidx_over15k;

drop view empidx_over15k;
select * from empidx_over15k;
create or replace view empidx_over15k as(select empno,ename,job,deptno,sal,nvl2(comm,'X','O') as comm from empidx where sal>1500);
--NVL2
--NVL2 함수는 null이 아닌경우 지정값1을  출력하고, null인 경우 지정값2을 출력 한다.

create table deptseq as (select * from dept);
create sequence seq_deptseq
    INCREMENT by 1
    start with 1
    maxvalue 99
    minvalue 1
    nocycle
    nocache;
    
insert into deptseq values(seq_deptseq.nextVal,'DATABASE','SEOUL');
insert into deptseq values(seq_deptseq.nextVal,'WEB','BUSAN');
insert into deptseq values(seq_deptseq.nextVal,'MOBILE','ILSAN');

select * from deptseq;

--394p
create table dept_const(
    deptno number(2) constraint DEPTCONS_DEPTNO_PK primary key,
    dname varchar2(14) constraint DEPTCONST_DNAME_UNQ unique,
    loc varchar2(13) constraint DEPTCONST_LOC_NN not null
);

create table emp_const(
    empno number(4) constraint empconst_empno_pk primary key,
    ename varchar2(10) constraint empconst_ename_nn not null,
    job varchar2(9),
    tel varchar2(20) constraint empconst_tel_unq unique,
    hiredate date,
    sal number(7,2) constraint empconst_sal_chk check (sal between 1000 and 9999),
    comm number(7,2),
    deptno number(2) constraint empconst_deptno_fk references dept_const(deptno)
);


select table_name,constraint_name,constraint_type from user_constraints where table_name in ('EMP_CONST','DEPT_CONST')
order by constraint_name;

--444p
set serveroutput on;

declare 
i number:=0;
begin
    while i<10 loop
    i := i+1;
    continue when mod(i,2)=0;
    dbms_output.put_line('현재 i의 값 : ' || i);
    end loop;
end;

BEGIN
   FOR i IN 1..10 LOOP
      CONTINUE WHEN MOD(i, 2) = 0;
      DBMS_OUTPUT.PUT_LINE('현재 i의 값 : ' || i);
      END LOOP;
END;

set serveroutput on;

declare 
    v_deptno dept.deptno%type;
    v_result dpet.dname%type default 'N/A';
    begin 
        v_deptno := 10;
--        case v_deptno 
           -- when v_deptno in (10,20,30,40);
--             when 10 then dbms_output.put_line('DNAME : ACOOUNTING');
--             when 20 then dbms_output.put_line('DNAME : RESEARCH');
--             when 30 then dbms_output.put_line('DNAME : SALES');
--             when 40 then dbms_output.put_line('DNAME : OPERATIONS');
        case  when v_deptno in (10,20,30,40) then
              select dname into v_result from dept where deptno = v_deptno;
               dbms_output.put_line('DNAME : ' || v_result);
        else dbms_output.put_line('DNAME : '|| v_result);
        end case;
end;

        
    


















