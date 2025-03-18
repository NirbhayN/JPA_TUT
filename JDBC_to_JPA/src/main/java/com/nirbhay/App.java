package com.nirbhay;

import com.nirbhay.dao.PersonJdbcDao;
//import org.slf4j.LoggerFactory;
import com.nirbhay.entity.Person;
import org.slf4j.LoggerFactory;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;
import java.util.logging.Logger;

/**
 * Hello world!
 *
 */

//@SpringBootApplication // this line was commented to wrtite a new main class to run the JPA version of the code
public class App implements CommandLineRunner
{

    @Autowired
    PersonJdbcDao personJdbcDao;
//    Logger logger= (Logger) LoggerFactory.getLogger(this.getClass());

    public static void main( String[] args )
    {
        SpringApplication.run(App.class,args);

    }


    @Override
    public void run(String... args) throws Exception {
System.out.println("All users -> {}"+ personJdbcDao.findAllPersons());
System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$");
System.out.println("All users -> {}"+ personJdbcDao.findById(10003));
        System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$");
        System.out.println("All users -> {}"+ personJdbcDao.findByName("anshika"));
        System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$");
        System.out.println("deleted this much record -> {}"+ personJdbcDao.deleteById(10004));
    System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$");
        System.out.println("inserting this much record -> {}"+ personJdbcDao.insert(new Person(10005,"abhishek","chalishgaon",new Date())));
    System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$");
        System.out.println("deleted this much record -> {}"+ personJdbcDao.update(new Person(10003,"dunia","london",new Date())));

    }
}
