package pl.sdacademy.credentials;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
        user.setId(id);
        users.add(user);
    }

    @Override
    public void update(User user) {



    }

    @Override
    public void delete(User user) {
        users = users.stream()
                .filter(userInList -> !user.equals(userInList))
                .collect(Collectors.toList());
    }

    public void delete(int id) {
        users.stream()
                .filter(user -> user.getId() == id)
                .findAny()
                .ifPresent(this::delete);
    }
}
