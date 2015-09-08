package users.logic;

import org.hibernate.Session;
import users.HibernateUtil;
import users.UsersEntity;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
public class ManagementSystem {

    private static ManagementSystem instance;

    private ManagementSystem() {
    }

    public static synchronized ManagementSystem getInstance() {
        if (instance == null) {
            instance = new ManagementSystem();
        }
        return instance;
    }

    public Collection getAllUsers() throws SQLException {
        Session session = null;
        Collection users = new ArrayList<UsersEntity>();
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            users = session.createCriteria(UsersEntity.class).list();
        } catch (Exception e) {
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return users;
    }

    public UsersEntity getUserById(long user_id) throws SQLException {
        Session session = null;
        UsersEntity user = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            user = session.load(UsersEntity.class, user_id);
        } catch (Exception e) {
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return user;
    }

    public void insertUser(UsersEntity user) throws SQLException {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(user);
            session.getTransaction().commit();
        } catch (Exception e) {
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    public void updateUser(UsersEntity user) throws SQLException {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(user);
            session.getTransaction().commit();
        } catch (Exception e) {
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    public void deleteUser(UsersEntity user) throws SQLException {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(user);
            session.getTransaction().commit();
        } catch (Exception e) {
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }
}
