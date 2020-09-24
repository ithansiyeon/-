--ex26_hierarchicalQuery.sql

/*

계층형 쿼리, Hierarchical Query
- 오라클 전용 
- 레코드간의 관계가 서로 상하 수직 구조의 관계가 있는 경우 적당한 구조의 결과셋을 만들어 준다.
- 부모와 자식 역할을 하는 레코드로 구성된 테이블 
- 카테고리, 답변형 게시판, 조직 구성원 등...


컴퓨터
    - 본체
        - 메인보드
        - 그래픽 카드
        - 랜카드
        - CPU
        - 메모리
    - 모니터 
        - 보호필름
    - 프린터
        - 카트리지 
        - 용지 
*/

create table tblComputer 
(
    seq number primary key,     --식별자(PK)
    name varchar2(50) not null, --요소명
    qty number not null,        --수량
    pseq number null references tblComputer(seq) --부모요소(FK)
    
    
);

select * from tblSelf;

insert into tblComputer values(1,'컴퓨터',1,null); -- 1세대(루트)

insert into tblComputer values(2,'본체',1,1);      -- 2세대
insert into tblComputer values(3,'모니터',1,1);
insert into tblComputer values(4,'프린터',1,1);

insert into tblComputer values(5,'메인보드',1,2);            --3세대
insert into tblComputer values(6,'그래픽카드',1,2);
insert into tblComputer values(7,'랜카드',1,2);
insert into tblComputer values(8,'CPU',1,2);
insert into tblComputer values(9,'메모리',2,2);

insert into tblComputer values(10,'보호필름',1,3);

insert into tblComputer values(11,'카트리지',1,4);
insert into tblComputer values(12,'용지',100,4);

select * from tblComputer;

select c1.name as 자식,c2.name as 부모 from tblComputer c1 --자식부품
    left outer join tblComputer c2 --부모부품
        on c1.pseq = c2.seq; -- 부모가 존재하지 않는 컴퓨터 

-- 계층형 쿼리
-- starts with절 connect by 절 
-- 계층형 쿼리에서만 사용 가능한 의사 컬럼(level,prior)이 있음 

select  
    lpad(' ',(level-1)*5) || name, prior name 
from tblComputer 
    --start with seq = 1 -- 누구로부터 시작할거냐?, 루트 요소 지정 
    --start with seq = (select seq from tblComputer where name = '컴퓨터')
    start with pseq is null -- (부모가 없는게 유일하게 컴퓨터 밖에 없어)
        connect by prior seq = pseq; -- prior 부모 레코드를 뜻해, 부모 테이블의 레코드, on과 같아

-- 조직도 
select 
    lpad(' ', (level-1)*3) || name as "직원명",
    prior name as "상사명"
    from tblSelf
        start with super is null
            connect by super = prior seq;
            
select 
    lpad(' ',(level-1)*5) || name as "부품명",
    prior name as "부모부품명",
    level as "레벨",
    connect_by_root name as "루트부품명", --계층형 쿼리에서 최상위 로우를 반환하는 연산자
    connect_by_isleaf as "리프노드", -- 가장 말단에 있는 노드 
    sys_connect_by_path(name,'▷') --▷컴퓨터▷본체▷그래픽카드
from tblComputer
    start with pseq is null
        connect by pseq = prior seq
            --order by name asc;
            order SIBLINGS by name asc; --같은 그룹에서만 정렬
            






