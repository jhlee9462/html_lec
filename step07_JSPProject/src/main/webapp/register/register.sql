--테이블명 : member
--id :varchar2(10) primary key
--passwd : varchar2(10)널 허용X
--name : varchar2(20)  널 허용 X
--email : varchar2(30)
--phone : varchar2(15)
--zipcode : varchar2(7)
--addr : varchar2(70)

drop table member purge;

create table member(
id varchar2(10) primary key,
passwd varchar2(10) not null,
name varchar2(20) not null,
email varchar2(30),
phone varchar2(15),
zipcode varchar2(5),
addr varchar2(70));

select * from tab;
select * from member;


select * from zipcode;

update ZIPCODE set ri=' ' where ri is NULL;
update ZIPCODE set bunji=' ' where bunji is NULL;
commit
select  *  from zipcode where dong like '%신사동%';

SELECT COUNT(*) FROM MEMBER WHERE ID='abcd';






















