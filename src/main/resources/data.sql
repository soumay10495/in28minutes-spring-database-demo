/*create table person(
    id integer primary key,
    name varchar(255) not null,
    location varchar(255),
    birthdate timestamp);
*/
Insert into Person(id,name,location,birthdate)
Values(10001,'Soumay','Noida',sysdate());

Insert into Person(id,name,location,birthdate)
Values(10002,'Prateek','Gurgaon',sysdate());

Insert into Person(id,name,location,birthdate)
Values(10003,'Jatin','Ghaziabad',sysdate());

Insert into Person(id,name,location,birthdate)
Values(10004,'Aakash','New Delhi',sysdate());
