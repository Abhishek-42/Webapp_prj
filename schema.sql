create database userappdb;

use userappdb;

create table users{
	
	user_id varchar(20) auto_increment primary key ,
	user_name varchar(20) not null,
	email_id varchar(50) not null unique,
	pass_word varchar(100) not null,
	age integer not null
	
};