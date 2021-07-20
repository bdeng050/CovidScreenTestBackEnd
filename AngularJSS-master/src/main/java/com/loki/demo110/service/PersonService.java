package com.loki.demo110.service;

import com.loki.demo110.model.Person;
import com.loki.demo110.repository.PersonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PersonService {
    @Autowired
    PersonRepo personRepo;


    public void addPerson(Person p){
        personRepo.save(p);

    }
    public void deletePersonById(int id){
//        Person p=personRepo.findPersonByID(id);
//        personRepo.delete(p);
        Person p= personRepo.findPersonByID(id);
        personRepo.deleteById(id);
    }
    public Person updatePerson(Person a, Person b){
        personRepo.delete(a);
        personRepo.save(b);
        return b;
    }
    public Person findPersonById(int id){
        return personRepo.findPersonByID(id);
    }
    public Person findPersonByUserName(String userName){
        return personRepo.findPersonByUserName(userName);
    }





}
