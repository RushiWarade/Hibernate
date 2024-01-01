package org.example.dao;

import org.example.model.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class StudentDao {

    public static void add(Student student){

        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
         SessionFactory sessionFactory = configuration.buildSessionFactory();
         Session session = sessionFactory.openSession();
         Transaction transaction = session.beginTransaction();
        session.save(student);
        transaction.commit();
        session.close();
        sessionFactory.close();

    }
}
