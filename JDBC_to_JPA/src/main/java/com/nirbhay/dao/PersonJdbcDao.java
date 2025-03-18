package com.nirbhay.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

import com.nirbhay.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import java.util.Date;
@Repository
public class PersonJdbcDao {
    @Autowired
    JdbcTemplate jdbcTemplate;


    private class PersonRowMapper implements RowMapper<Person>{


        @Override
        public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
            Person p=new Person();
            p.setId(rs.getInt("id"));
            p.setName(rs.getString("name"));
            p.setLocation(rs.getString("location"));
            p.setBirth_date(rs.getTimestamp("birth_date"));

            return p;
        }
    }
    public List<Person> findAllPersons(){
       return jdbcTemplate.query("select * from persons",new PersonRowMapper());
    }

    public Person findById(Integer id){
        return jdbcTemplate.queryForObject("select * from persons where id=?",new Object[]{id},new PersonRowMapper());
    }

    public List<Person> findByName(String name){
        return jdbcTemplate.query("select * from persons where name=?",new Object[]{name},new PersonRowMapper());
    }

    public int deleteById(Integer id){
        return jdbcTemplate.update("delete from persons where id=?",new Object[]{id});
    }

    public int insert(Person person){
        return jdbcTemplate.update("insert into persons (id,name,location,birth_date) values(? ,? ,? ,? )",new Object[]{person.getId(),person.getName(),person.getLocation(),new Timestamp(person.getBirth_date().getTime())});
    }

    public int update(Person person){
        return jdbcTemplate.update("update persons set name=?, location=?, birth_date=? where id=?",new Object[]{person.getName(),person.getLocation(),new Timestamp(person.getBirth_date().getTime()),person.getId()});
    }

}
