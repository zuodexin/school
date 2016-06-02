create table student(
	id  int,
	stu_id varchar(10) unique not null,
	password varchar(10) not null,
	name varchar(20) not null,
	primary key(id)
)
create table institute(
	id int,
	name varchar(20) not null,
	primary key(id)
)
create table professor(
	id int,
	work_id varchar(10) unique not null,
	password varchar(10) not null,
	name varchar(20) not null,
	institute int,
	primary key(id),
	foreign key(institute) references institute(id)
)

create table course(
	id int,
	institute int not null,
	name varchar(30) not null,
	peroid int not null,
	primary key(id),
	foreign key(institute) references institute(id)
)
create table instruct(
	id int,
	course int not null,
	professor int not null,
	primary key(id),
	foreign key(course) references course(id),
	foreign key(professor) references professor(id)
)
create table select_course(
	id int,
	student int not null,
	course int not null,
	grade int,
	primary key(id),
	foreign key(student) references student(id),
	foreign key(course) references course(id)
)
create table schoolclass(
	id int,
	course int not null,
	info text,
	primary key(id),
	foreign key(course) references course(id)
)
create table jion_class(
	id int,
	student int not null,
	schoolclass int not null,
	primary key(id),
	foreign key(student) references student(id),
	foreign key(schoolclass) references schoolclass(id)
)
create table teach_class(
	id int,
	professor int not null,
	schoolclass int not null,
	primary key(id),
	foreign key(professor) references professor(id),
	foreign key(schoolclass) references schoolclass(id)
)

create table hire(
	id int,
	institute int not null,
	professor int not null,
	primary key(id),
	foreign key(institute) references institute(id),
	foreign key(professor) references professor(id)
)
CREATE TABLE `school`.`admin` ( `id` INT NOT NULL , 
`username` VARCHAR(20) NOT NULL , 
`password` VARCHAR(20) NOT NULL ) ENGINE = InnoDB;
