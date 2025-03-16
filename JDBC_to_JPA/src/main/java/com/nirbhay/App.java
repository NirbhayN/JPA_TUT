package com.nirbhay;

import com.nirbhay.dao.PersonJdbcDao;
//import org.slf4j.LoggerFactory;
import org.slf4j.LoggerFactory;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.logging.Logger;

/**
 * Hello world!
 *
 */

@SpringBootApplication
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
    }
}
