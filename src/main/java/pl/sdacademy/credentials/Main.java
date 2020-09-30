package pl.sdacademy.credentials;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        //create
        InMemoryUserRepository repo = new InMemoryUserRepository();
        repo.create(new User("Pawel", "Buczek", LocalDate.of(1993, 11, 24), true));
        repo.create(new User("Pawel", "Inny", LocalDate.of(1983, 11, 24), false));
        repo.create(new User("Adam", "Abacki", LocalDate.of(1983, 1, 5), true));
        User marek = new User("Marek", "Babacki", LocalDate.of(2000, 3, 15), true);
        repo.create(marek);
        repo.readAll();
        //delete
//        repo.delete(2);
//        repo.delete(marek);
//        System.out.println(repo.readAll());
//        System.out.println(repo.readById(marek.getId()));
        //update
//        User anna = new User("anna", "Cabacka", LocalDate.of(2010,1,25),true);
//        repo.create(anna);
//        repo.update(anna);
//        System.out.println(anna);

        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();
        HibernateUserRepository repo2 = new HibernateUserRepository(sessionFactory);
        repo2.create(new User("Marta", "Jaksa", LocalDate.of(1984, 8, 20), false));
        repo2.create(new User("Marek", "Wlizło", LocalDate.of(1976, 5, 12), false));
        repo2.create(new User("Edyta", "Ciemna", LocalDate.of(1999, 11, 22), false));
        repo2.create(new User("Ola", "Dudek", LocalDate.of(1994, 10, 6), true));
        System.out.println(repo2.readAll());
        System.out.println(repo2.readById(2));
        User anna = new User("anna", "Cabacka", LocalDate.of(2010, 1, 25), true);
        repo2.create(anna);
        anna.setFirstName("Basia");
        repo2.update(anna);
        System.out.println(anna);
        System.out.println(repo2.readAll());
        repo2.delete(anna);
        System.out.println(repo2.readAll());

        sessionFactory.close();
    }
}
