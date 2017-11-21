use master
go
if(DB_ID('jdbc') is not null) 
	drop database jdbc
go
create database jdbc
go
use jdbc
go

create table TbDept
(
	deptId int identity primary key not null,
	deptName nvarchar(50) unique not null,
	deptInfo nvarchar(500) not null,
	created datetime default getdate() not null
)
go

select * from TbDept
go


