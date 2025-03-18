--below query is commented as after use of Hibernate JPA the table was autocreated,there was no need to create the table manuaally
--create table person (id INTEGER NOT NULL, name VARCHAR(255) NOT NULL, location VARCHAR(255),birth_date timestamp, primary key(id));

insert into person (id,name,location,birth_date) values(10001,'nirbhay','Mumbai',CURRENT_DATE);
insert into person (id,name,location,birth_date) values(10002,'anshika','pune',CURRENT_DATE);
insert into person (id,name,location,birth_date) values(10003,'anita','pachora',CURRENT_DATE);
insert into person (id,name,location,birth_date) values(10004,'devyani','bttc',CURRENT_DATE);