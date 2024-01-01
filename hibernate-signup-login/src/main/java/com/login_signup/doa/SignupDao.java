package com.login_signup.doa;

import com.login_signup.model.Signup;
import com.login_signup.utility.HibernateUtility;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class SignupDao {

    public static boolean signup(Signup signup) {

        boolean b = false;

        Session session = HibernateUtility.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        int i = (Integer) session.save(signup);
        if (i > 0) {
            b = true;
        }
        transaction.commit();
        session.close();

        return b;
    }

    public Signup login(String email, String password) {
        Signup signup = null;

        Session session = HibernateUtility.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        Query query = session.createQuery("from signup where email=:em and password=:ps");
        query.setParameter("em", email);
        query.setParameter("ps", password);
//        int i = query.executeUpdate();

        signup = (Signup) query.uniqueResult();

        transaction.commit();
        session.close();


        return signup;
    }
}
