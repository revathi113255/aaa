package com.javatpoint;

import java.util.List;


import javax.transaction.Transactional;
 
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

 
@Repository
@Transactional
public class PersonDAO {
    @Autowired
    private SessionFactory sessionFactory;
    	
    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }
  
    public String savePerson(Person person) {
    	
   
    	         Long isSuccess = (Long)getSession().save(person);
    	        
    	       
        if(isSuccess >= 1){
        	
            return "Success";
        }else{
            return "Error while Saving Person";
        }
         
    }
 
    public boolean delete(Person person) {
    	 //Transaction transaction = getSession().getTransaction();
     	
     	//transaction.begin();
        getSession().delete(person);
       // transaction.commit();
        return true;
    }
 
    @SuppressWarnings("unchecked")
    public List<Person> getAllPersons() {
    	// Transaction transaction = getSession().getTransaction();
      	
      	//transaction.begin();
      	//transaction.commit();
        return getSession().createQuery("from Person").list();
        
    }
}