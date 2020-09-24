package pl.sdacademy.credentials;

import java.time.LocalDate;

public class User {
    private Integer id;
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private boolean admin;

    public Integer getId() {
        return id;
    }
}
