package com.netweb.services;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.netweb.IO.Students;
import com.netweb.Implementation.IStudentServices;
import com.netweb.xml.Employee;


public class StudentServices implements IStudentServices {

	private static SessionFactory factory;
	static{
			try{
				factory = new Configuration().configure().buildSessionFactory();		
			}catch(Exception e){
				e.printStackTrace();
			}
	}
	
	@Override
	public boolean addStudent(Students student) {
		Session session = factory.openSession();
		Transaction tx = null;
		Integer employeeID = null;
		try {
			tx = session.beginTransaction();
			employeeID = (Integer) session.save(student);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return false;
	}

	

}
