package org.example.dao;

import org.example.Util.HibernateUtil;
import org.example.model.Course;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class Dao {

    public void add(Course course) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Object save = session.save(course);
        transaction.commit();
        session.close();
        System.out.println("Data Successfully save");
    }


    public void update(Course course) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.update(course);
        transaction.commit();
        session.close();
        System.out.println("Data Successfully Updated");
    }

    public void get(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Course course = session.get(Course.class, id);
        transaction.commit();
        session.close();
        System.out.println(course);
    }

    public void delete(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Course course = session.get(Course.class, id);
        if (course != null) {
            session.delete(course);
            System.out.println("course Delete Successfully....!");
        } else {
            System.out.println("Course not found for this ID"+id);
        }
        transaction.commit();
        session.close();
    }
}
