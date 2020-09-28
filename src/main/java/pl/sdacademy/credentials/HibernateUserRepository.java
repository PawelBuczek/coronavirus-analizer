package pl.sdacademy.credentials;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class HibernateUserRepository implements UserRepository {
    //Utwórz implementację interfejsu UserRepository - HibernateUserRepository - implementacja posiada pole - fabrykę sesji.
    // Implementacje metod interfejsu UserRepository powinny być najprostsze możliwe (nic nie robią i zwracają null, jeśli mają zwrócić wartość).
    private SessionFactory sessionFactory;


    public HibernateUserRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public User readById(int id) {
        Session session = sessionFactory.openSession();
        User user= session.get(User.class,id);
        session.close();
        return user;
    }

    @Override
    public List<User> readAll() {
        Session session = sessionFactory.openSession();
        Query<User> query1 = session.createQuery("SELECT id,firstName," +
                "lastName,dateOfBirth,admin FROM User", User.class);
        List<User> result = query1.getResultList();
        return result;


    }

    @Override
    public void create(User user) {

    }

    @Override
    public void update(User user) {

    }

    @Override
    public void delete(User user) {

    }

}
