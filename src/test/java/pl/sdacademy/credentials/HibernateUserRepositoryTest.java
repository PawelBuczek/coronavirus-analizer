package pl.sdacademy.credentials;

import org.hibernate.SessionFactory;

import org.hibernate.cfg.Configuration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class HibernateUserRepositoryTest {
    private static HibernateUserRepository hibernateUserRepository;
    private static User user1 = new User(
            "FirstName",
            "LastName",
            LocalDate.of(2000, 1, 1),
            true
    );

    @Test
    public void readAllShouldReturnUser1() {
        SessionFactory sessionFactory = new Configuration()
                .configure()
                .buildSessionFactory();
        hibernateUserRepository = new HibernateUserRepository(sessionFactory);
        hibernateUserRepository.create(user1);
        List<User> result = hibernateUserRepository.readAll();
        assertEquals(result.get(0).toString(), user1.toString());
    }

    @Test
    public void readById1ShouldReturnUser1() {
        SessionFactory sessionFactory = new Configuration()
                .configure()
                .buildSessionFactory();
        hibernateUserRepository = new HibernateUserRepository(sessionFactory);
        hibernateUserRepository.create(user1);
        User result = hibernateUserRepository.readById(1);
        assertEquals(result.toString(), user1.toString());
    }

    @Test
    public void deleteUser1ShouldReturnEmptyList() {
        SessionFactory sessionFactory = new Configuration()
                .configure()
                .buildSessionFactory();
        hibernateUserRepository = new HibernateUserRepository(sessionFactory);
        hibernateUserRepository.create(user1);
        hibernateUserRepository.delete(user1);
        List<User> result = hibernateUserRepository.readAll();
        assertEquals(Collections.emptyList(), result);
    }

}




