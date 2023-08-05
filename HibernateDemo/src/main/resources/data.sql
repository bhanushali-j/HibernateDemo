insert into course(id, name,created_date,last_updated_date) values(10001,'JPA in 50 Steps',CURRENT_TIMESTAMP(),CURRENT_TIMESTAMP());
insert into course(id, name,created_date,last_updated_date) values(10002,'Spring in 50 Steps',CURRENT_TIMESTAMP(),CURRENT_TIMESTAMP());
insert into course(id, name,created_date,last_updated_date) values(10003,'Spring Boot in 100 Steps',CURRENT_TIMESTAMP(),CURRENT_TIMESTAMP());


insert into passport(id, number) values(40001,'E12345');
insert into passport(id, number) values(40002,'F67890');
insert into passport(id, number) values(40003,'G89075');


insert into student(id, name,passport_id) values(20001,'Goku','40001');
insert into student(id, name,passport_id) values(20002,'Naruto','40002');
insert into student(id, name,passport_id) values(20003,'Sasuke','40003');


insert into review(id, rating,description) values(50001,'5','Excellent course');
insert into review(id, rating,description) values(50002,'4','good course');
insert into review(id, rating,description) values(50003,'4','Very helpful');
