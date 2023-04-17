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
hrContact varchar(10),
hrJoinDate varchar(10)
)
drop table Hr

create table Resource
(
userId	Int	primary key identity(1,1),
firstName varchar(20) not null,
lastName varchar(20) not null,
emailId	varchar(30)	not null,
contactNo varchar(10) not null,
Gender varchar(7)	not null,
experience	Int	not null,
qualification varchar(20) not null,
resumeUrl varchar(max) not null
)
drop table Resource
select * from Resource

delete from Resource where firstName='mohit'

delete from Resource where userId=1
sp_rename 'Resource.resumeUr','resumeUrl','COLUMN'

create table Language
(
lanId int primary key identity(1,1),
lanName varchar(30) not null
)
select * from language

insert into Language values('C')
insert into Language values('C++')
insert into Language values('Java')
insert into Language values('Python')
insert into Language values('Ruby On Rails')


create table Technology	
(
techId int primary key identity(1,1),
techName varchar(50) not null
)

insert into Technology values('Jsp')
insert into Technology values('Servlet')
insert into Technology values('Spring Boot')
insert into Technology values('Angular')
insert into Technology values('React Js')

select * from Technology

create table Databases
(	
dbId int primary key identity(1,1),
dbName varchar(50) not null
)

insert into Databases values('MongoDb')
insert into Databases values('MSSQL')
insert into Databases values('MYSQL')


select * from Databases

create table User_Language			
(
ulanId int primary key identity(1,1),	
userId int references Resource(userId),	
lanId int references Language(lanId)
)

select * from User_Language
delete from User_Language where userId=1
insert  into User_Language values(1,1)
insert  into User_Language values(1,3)
			
create table User_Technology		
(	
utechId	int primary key identity(1,1),	
userId	int references Resource(userId),		
techId	int references Technology(techId)	
)
select * from User_Technology
			
create table User_Database
(			
udbId int primary key identity(1,1),		
userId int references Resource(userId),	
dbId int references Databases(dbId)	
)
select * from User_Database

drop table User_Database
drop table User_Language
drop table User_Technology

--Fetch languages of specific resource
select lanName from Language l,User_Language ul where ul.userId=4 and ul.lanId=l.lanId

select dbName from Databases d, User_Database ud where ud.userId=4 and ud.dbId=d.dbId

select techName from Technology	 t,User_Technology ut where ut.userId=2 and ut.techId=t.techId