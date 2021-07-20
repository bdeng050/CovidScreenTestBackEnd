package com.loki.demo110.controller;

import com.loki.demo110.model.Person;
import com.loki.demo110.repository.PersonRepo;
import com.loki.demo110.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
@RestController
public class SignInController {
    @Autowired
    PersonService personService;
    @Autowired
    PersonRepo personRepo;

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping(path = "/add")
    public Boolean addPerson(@RequestBody Person p){
        personService.addPerson(p);
        return true;
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping (path="/delete")
    public boolean deletePerson(@RequestParam int ID){
        personService.deletePersonById(ID);
        return true;
    }


    @PutMapping(path="/update")
    public Person updatePerson(@RequestBody Person a, @RequestBody Person b){
        return personService.updatePerson(a,b);
    }
    @GetMapping(path="/find/{id}")
    public Person findPersonById(@PathVariable("id") Integer id){
        Person p=personService.findPersonById(id);
        System.out.println(p.toString());
        return p;
    }
    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping(path = "/login")
    public String login(@RequestBody Person pp) {
      String result = "";
      Person p = personService.findPersonByUserName(pp.getUserName());
      if(p==null){
        result="NO";
        return result;
      }
      if (pp.getUserName().equals("admin")) {
        result = "admin";
        return result;
      }
      if (p.getPassWord().equals(pp.getPassWord())) {
        result = "customer";
        return result;
      }
      else{
        result=null;
        return result;
      }
    }

  @CrossOrigin(origins = "http://localhost:4200")
  @GetMapping(path="/allPerson")
  public List<Person> getAllPerson(){
      Iterable iterable= personRepo.findAll();
      Iterator iterator = iterable.iterator();
      List<Person> persons= new ArrayList<Person>();
      while(iterator.hasNext()){
        persons.add((Person) iterator.next());
      }
      return persons;
  }




}
