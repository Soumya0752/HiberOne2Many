package com.example4;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.example4.model.Department;
import com.example4.model.Employee;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        SessionFactory sessionFactory=HibernateUtil.getSessionFactory();
        Session session=sessionFactory.openSession();
        
        try 
        {
        Department department=new Department();
        department.setName("IT");
        
        Employee employee1=new Employee();
        employee1.setName("Amit");
        employee1.setDepartment(department);
        
        Employee employee2=new Employee();
        employee2.setName("Arun");
        employee2.setDepartment(department);
        
        department.getEmployees().add(employee1);
        department.getEmployees().add(employee2);
        session.beginTransaction();
        session.save(department);
        session.getTransaction().commit();
        }
        finally 
        {
        	session.close();
        	sessionFactory.close();
        }
        
        
        
    }
}




