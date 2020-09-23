package pl.sdacademy.credentials;

import java.util.List;

public interface UserRepository {
    User readById(int id);
    List<User> readAll();
    void create (User user);
    void update (User user);
    void delete (User user);

}
