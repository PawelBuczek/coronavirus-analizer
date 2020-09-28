package pl.sdacademy.credentials;

import java.util.ArrayList;
import java.util.List;

public class HibernateUserRepository implements UserRepository {
    //Utwórz implementację interfejsu UserRepository - HibernateUserRepository - implementacja posiada pole - fabrykę sesji.
    // Implementacje metod interfejsu UserRepository powinny być najprostsze możliwe (nic nie robią i zwracają null, jeśli mają zwrócić wartość).
    private List<Integer> sessionFactory;

    @Override
    public User readById(int id) {
        return null;
    }

    @Override
    public List<User> readAll() {
        return null;

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
