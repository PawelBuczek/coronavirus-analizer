package pl.sdacademy.credentials;

import org.hibernate.SessionFactory;

import java.util.ArrayList;
import java.util.List;

public class HibernateUserRepository implements UserRepository {
    //Utwórz implementację interfejsu UserRepository - HibernateUserRepository - implementacja posiada pole - fabrykę sesji.
    // Implementacje metod interfejsu UserRepository powinny być najprostsze możliwe (nic nie robią i zwracają null, jeśli mają zwrócić wartość).
    private SessionFactory sessionFactory;
    private List<User> users = new ArrayList<>();

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
    public void update(User user) {

    }

    @Override
    public void delete(User user) {

    }

}
