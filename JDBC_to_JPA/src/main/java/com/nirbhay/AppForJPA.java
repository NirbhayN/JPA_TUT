package com.nirbhay;

import com.nirbhay.dao.PersonJdbcDao;
import com.nirbhay.entity.Person;
import com.nirbhay.repository.PersonJpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

/**
 * Hello world!
 *
 */

@SpringBootApplication
public class AppForJPA implements CommandLineRunner
{

    @Autowired
    PersonJpa personJpa;
//    Logger logger= (Logger) LoggerFactory.getLogger(this.getClass());

    public static void main( String[] args )
    {
        SpringApplication.run(AppForJPA.class,args);

    }


    @Override
    public void run(String... args) throws Exception {
//System.out.println("All users -> {}"+ personJdbcDao.findAllPersons());
/*
        System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$");
        System.out.println("All users -> {}"+ personJdbcDao.findByName("anshika"));


*/
        System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$");
        System.out.println("All users -> {}"+ personJpa.findById(10003));

        System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$");
        System.out.println("inserting this much record -> {}"+ personJpa.insert(new Person("omkar","mulund",new Date())));
        System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$");
        System.out.println("deleted this much record -> {}"+ personJpa.update(new Person(10001,"america","india",new Date())));
        System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$");
        personJpa.deleteById(10001);
        System.out.println("deleted this much record -> {}");
        System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$");
        System.out.println("this is the output of findall method"+personJpa.findALl());

    }
}
