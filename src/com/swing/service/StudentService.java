package com.swing.service;

import java.io.Serializable;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.swing.hibernate.HibernateUtil;

public class StudentService {
	
	Session session = HibernateUtil.getSessionFactory().openSession();
	
	public void saveStudent(Object obj) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // save the student object
            session.save(obj);
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
	
	public List find(final Class clazz) {
		if (clazz == null) {
			throw new IllegalArgumentException("Class to list must not be null");
		}
		List list = session.createQuery(
				"from " + clazz.getName() + " entity").getResultList();
		return list;
	}

	public Object find(Class clazz, Serializable key) {
		return session.find(clazz, key);

	}
	
	public List find(String Query)
	{
		return session.createSQLQuery(Query).list();
	}
}
