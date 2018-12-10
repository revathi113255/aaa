package com.javatpoint;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
 
@Controller
@RequestMapping(value = "/person")
public class PersonController {
    @Autowired
    private PersonDAO personDao;
 
    @RequestMapping(value = "/delete{id}")
    @ResponseBody
    public String delete(@PathVariable long id) {//?id=2
        try {//DELETE/1
            Person person = new Person();
            person.setId(id);
            personDao.delete(person);
        } catch (Exception ex) {
            return ex.getMessage();
        }
        return "Person succesfully deleted!";
    }
 
    @RequestMapping(value = "/save")
    @ResponseBody
    public String create() {
        try {
            Person person = new Person();
            person.setName("drishanaa");
            person.setCity("chennai");
            personDao.savePerson(person);
            
        } catch (Exception ex) {
            return ex.getMessage();
        }
        return "Person succesfully saved!";
    }
  
   @RequestMapping(value = "/allPersons")
    @ResponseBody
    public List<Person> getAllPersons() {
        try {
            return personDao.getAllPersons();
        } catch (Exception ex) {
            return null;
        }
    }
}