package com.nirbhay.dao;

import java.util.List;

import com.nirbhay.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class PersonJdbcDao {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Person> findAllPersons(){
       return jdbcTemplate.query("select * from persons",new BeanPropertyRowMapper(Person.class));
    }



}
