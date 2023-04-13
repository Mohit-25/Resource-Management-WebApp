create database Resource_Management

create table Admin
(
adminId	int primary key identity(1,1),
adminName varchar(30) not null,
adminEmail varchar(30) not null,
adminPassword varchar(30) not null
)	
select * from Admin
select * from Hr

insert into Admin values('Aakash','aakash123@gmail.com','Aakash@123')
insert into Admin values('Mohit','mohit123@gmail.com','Mohit@123')

create table Hr
(
hrId int primary key identity(1,1),
hrFirstName varchar(30),
hrLastName varchar(30),
hrEmail varchar(30),
hrPassword varchar(30),
hrGender varchar(7),
hrContact numeric(10),
hrJoinDate varchar(10)
)
drop table Hr
