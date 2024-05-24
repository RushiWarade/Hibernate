package dao;

import model.Expense;
import model.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import util.HibernateUtil;

import java.util.ArrayList;
import java.util.List;

public class UserDao {
    public boolean addUser(User user) {

        boolean msg = false;
        Transaction transaction = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.save(user);
            transaction.commit();
            msg = true;


        } catch (Exception e) {
            if (transaction != null) {
                msg = false;
                System.out.println(e.getMessage());
            }
        }
        return msg;

    }

    public User login(String email, String password) {
        User user = null;
        Transaction transaction = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            Query query = session.createQuery("from user where email=:em and password=:pass ");

            query.setParameter("em", email);
            query.setParameter("pass", password);

            user = (User) query.uniqueResult();

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                user = null;
            }
        }
        return user;
    }

    public boolean addExpense(Expense expense) {

        boolean msg = false;
        Transaction transaction = null;
        try {

            Session session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.save(expense);
            transaction.commit();
            msg = true;
        } catch (Exception e) {
            if (transaction != null) {
                msg = false;
                System.out.println(e.getMessage());
            }
        }


        return msg;
    }


    public List<Expense> expenseList(User user) {
        List<Expense> expenseList = new ArrayList<>();

        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            Query query = session.createQuery("from expense where user=:user");
            query.setParameter("user", user);

            expenseList = query.list();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


        return expenseList;
    }

    public Expense getExpense(int id) {
        Expense expense = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            Query query = session.createQuery("from expense  where id=:id");
            query.setParameter("id", id);

            expense = (Expense) query.uniqueResult();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


        return expense;
    }

    public boolean updateExpense(Expense expense) {
        boolean b = false;
        Transaction transaction = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.update(expense);
            transaction.commit();
            b = true;
        } catch (Exception e) {
            if (transaction != null) {
                b = false;
                System.out.println(e.getMessage());
            }
        }
        return b;
    }

    public boolean deleteExpense(int delete) {
        boolean del = false;
        Transaction transaction = null;
        try {


            Session session = HibernateUtil.getSessionFactory().openSession();

            transaction = session.beginTransaction();
            Query query = session.createQuery("delete  from  expense where id=:delete");
            query.setParameter("delete", delete);
            query.executeUpdate();
            transaction.commit();
            del = true;
        } catch (Exception e) {
            if (transaction != null) {
                del = false;
                System.out.println(e.getMessage());
            }
        }
        return del;
    }

    public User getUser(int id) {
        User user = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.createQuery("from user  where id=:user");
        query.setParameter("user", id);
        user = (User) query.uniqueResult();
        return user;
    }

    public boolean updateProfile(User user) {
        boolean msg = false;
        Transaction transaction = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.saveOrUpdate(user);
            transaction.commit();
            msg = true;
        } catch (Exception e) {
            if (transaction != null) {
                msg = false;
                System.out.println(e.getMessage());
            }
        }
        return msg;
    }

    public boolean isEmailExist(String email) {
        boolean b = false;
        try {


            Session session = HibernateUtil.getSessionFactory().openSession();
//        Transaction transaction = session.beginTransaction();
            Query query = session.createQuery("from user where email=:email");
            query.setParameter("email", email);
            User user = (User) query.uniqueResult();
            if (user != null) {
                b = true;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
//        transaction.commit();

        return b;
    }
}
