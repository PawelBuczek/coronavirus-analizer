package pl.sdacademy.credentials;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        //create
        InMemoryUserRepository repo = new InMemoryUserRepository();
        repo.create(new User("Pawel", "Buczek", LocalDate.of(1993,11,24),true));
        repo.create(new User("Pawel", "Inny", LocalDate.of(1983,11,24),false));
        repo.create(new User("Adam", "Abacki", LocalDate.of(1983,1,5),true));
        User marek = new User("Marek", "Babacki", LocalDate.of(2000,3,15),true);
        repo.create(marek);
        System.out.println(repo.readAll());
        //delete
        repo.delete(2);
        //repo.delete(marek);
        System.out.println(repo.readAll());
        repo.update(marek);
        System.out.println(repo.readById(marek.getId()));



    }
}
