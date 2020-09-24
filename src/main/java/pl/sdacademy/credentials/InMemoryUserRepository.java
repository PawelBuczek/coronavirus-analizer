package pl.sdacademy.credentials;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class InMemoryUserRepository implements UserRepository{


    private List<User> users = new ArrayList<>();

    @Override
    public User readById(int id) {
        return users.stream().filter(e->e.getId()==id).findFirst().orElse(null);
    }

    @Override
    public List<User> readAll() {
        return users;
    }

    @Override
    public void create(User user) {

        Integer id = users.stream().mapToInt(User::getId).max().orElse(0) + 1;
        String firstName = user.getFirstName();
        String lastName = user.getLastName();
        LocalDate dateOfBirth = user.getDateOfBirth();
        boolean admin = user.getAdmin();

        user = new User(firstName,lastName,dateOfBirth,admin);
        user.setId(id);


    }

    @Override
    public void update(User user) {

    }

    @Override
    public void delete(User user) {

    }
}
