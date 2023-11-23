create database apartment;
use apartment;
create table room(
id int auto_increment primary key,
floor int,
price double,
people int,
bedroom int,
area double
);
create table facility(
id int auto_increment primary key,
`name` varchar(50) 
);
create table detail_room(
id_room int,
foreign key(id_room) references room(id),
id_facility int,
foreign key(id_facility) references facility(id),
primary key (id_room,id_facility),
amount int
);
create table customer(
id int auto_increment primary key,
`name` varchar(50),
gender bit,
citizen_id varchar(12),
phone_number varchar(12),
date_of_birth date,
email varchar(50),
set_delete bit
);
create table roles(
id int auto_increment primary key,
poisition varchar(50)
);
create table employee(
id int auto_increment primary key,
`name` varchar(50),
gender bit,
citizen_id varchar(12) ,
phone_number varchar(12) unique not null,
date_of_birth date,
roles int,
foreign key(roles) references roles(id),
email varchar(50),
set_delete bit
);
create table users(
id varchar(12) primary key,
foreign key(id) references employee(phone_number),
pass varchar(20)
); 
create table kind_contract(
id int auto_increment primary key,
`name` varchar(30)
);
create table contract(
id int auto_increment primary key,
id_room int,
foreign key(id_room) references room(id),
id_customer int,
foreign key(id_customer) references customer(id),
id_employee int,
foreign key(id_employee) references employee(id),
kind_contract int,
foreign key(kind_contract) references kind_contract(id),
period int,
date_start date,
director_confirm bit,
manager_confirm bit,
set_delete bit
);
create table payment(
id_contract int,
foreign key(id_contract) references contract(id),
times int,
primary key (id_contract,times),
paided bit
);

