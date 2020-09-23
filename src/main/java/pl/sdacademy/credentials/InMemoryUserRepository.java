package pl.sdacademy.credentials;

import java.util.ArrayList;
import java.util.List;

public class InMemoryUserRepository implements UserRepository{


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
