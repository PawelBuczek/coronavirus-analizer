package pl.sdacademy.credentials;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class HibernateUserRepository implements UserRepository {
    //Utwórz implementację interfejsu UserRepository - HibernateUserRepository - implementacja posiada pole - fabrykę sesji.
    // Implementacje metod interfejsu UserRepository powinny być najprostsze możliwe (nic nie robią i zwracają null, jeśli mają zwrócić wartość).
    private SessionFactory sessionFactory;
    private List<User> users = new ArrayList<>();

    private Connection connection;

    public HibernateUserRepository(Connection connection) {
        this.connection = connection;
    }

    public HibernateUserRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public User readById(int id) {
        return null;
    }

    @Override
    public List<User> readAll() {
        return users;

    }

    @Override
    public void create(User user) {



    }

    @Override
    public void delete(User user) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(user);
        transaction.commit();
        session.close();



    }
    @Override
    public void update(User user) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.update(user);
        transaction.commit();
        session.close();

    }


}
