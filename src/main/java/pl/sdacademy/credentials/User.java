package pl.sdacademy.credentials;

import java.time.LocalDate;

public class User {
    Integer id;
    String firstName;
    String lastName;
    LocalDate dateOfBirth;
    Boolean admin;



    public Integer getId() {
        return id;
    }
}
