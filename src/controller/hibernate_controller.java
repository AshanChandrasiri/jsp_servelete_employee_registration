package controller;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import models.Employee;

public class hibernate_controller {
	
    protected SessionFactory sessionFactory;

    
    public hibernate_controller(){
    	setup();
    }
 
    protected void setup() {
    	
    	final StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure() .build();
    	
    	try {
    	    sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
    	} catch (Exception ex) {
    	    StandardServiceRegistryBuilder.destroy(registry);
    	    System.out.println("errrrrrrrrr : "+ ex.getMessage());
    	}
    }
 
    protected void exit() {
    	sessionFactory.close();
    }
    
    public void create(String name, String contact, String address) {
    	
    	if(sessionFactory == null){
    		setup();
    	}
    	
        Employee emp = new Employee();
        emp.setAddress(address);
        emp.setContact(contact);
        emp.setName(name);
     
        Session session = sessionFactory.openSession();
        session.beginTransaction();
     
        session.save(emp);
        session.getTransaction().commit();
        session.close();
        
//        exit();
    }
    
    public void update(Long id, String name, String contact, String address) {
    	
    	if(sessionFactory == null){
    		setup();
    	}
    	
        Employee emp = new Employee();
        emp.setId(id);
        emp.setAddress(address);
        emp.setContact(contact);
        emp.setName(name);
     
        Session session = sessionFactory.openSession();
        session.beginTransaction();
     
        session.update(emp);;
        session.getTransaction().commit();
        session.close();
        
//        exit();
    }
 
    protected void read() {
        // code to get a book
    }
 
    protected void update() {
        // code to modify a book
    }
 
    public void delete(Long id) {
      
        Employee emp = new Employee();
        emp.setId(id);
        
        Session session = sessionFactory.openSession();
        session.beginTransaction();
     
        session.delete(emp);
        session.getTransaction().commit();
        session.close();
    }
    
    public List<Employee> getAllBooks(){
    	
    	if(sessionFactory == null){
    		setup();
    	}
    	
    	 Session session = sessionFactory.openSession();
         session.beginTransaction();
         
         List<Employee> result = session.createQuery(
        		  "select new models.Employee(b.id, b.name,b.contact,b.address) FROM Employee b",
        		Employee.class).getResultList();
           
         session.getTransaction().commit();
         session.close();
         
        return result;
    	
    }
 

}
