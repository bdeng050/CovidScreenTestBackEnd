package com.loki.demo110.repository;

import com.loki.demo110.model.Person;
import org.springframework.data.jpa.repository.support.CrudMethodMetadata;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PersonRepo extends CrudRepository<Person,Integer> {
    Person findPersonByID(int ID);
    Person findPersonByUserName(String userName);



}
