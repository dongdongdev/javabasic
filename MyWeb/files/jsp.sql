use master
go
if(DB_ID('jsp') is not null) 
	drop database jsp
go
create database jsp
go
use jsp
go

create table TbGoods
(
	gid int identity primary key not null,
	gname nvarchar(50) unique not null,
	ginfo nvarchar(500) default '' not null,	
	price decimal(10,2) check(price>=0) not null,
	amount int check(amount>=0) not null
)
go

select * from TbGoods
go