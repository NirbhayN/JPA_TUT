package com.nirbhay.repository;


import com.nirbhay.entity.Person;
import jakarta.persistence.*;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public class PersonJpa {

    @PersistenceContext
    EntityManager entityManager;

    public Person findById(Integer id){

        return entityManager.find(Person.class,id);
    }


    public Person insert(Person person){
        return entityManager.merge(person);
    }
    public Person update(Person person){
        return entityManager.merge(person);
    }

    public void deleteById(Integer id ){
        Person p=findById(id);
        entityManager.remove(p);
        System.out.println( "::nirbhay-application-console::"+ p + " was deleted succcessfully");
    }

    public List<Person> findALl(){
        TypedQuery<Person> typedQuery=entityManager.createNamedQuery("find-all-person",Person.class);
        return typedQuery.getResultList();
    }
}
