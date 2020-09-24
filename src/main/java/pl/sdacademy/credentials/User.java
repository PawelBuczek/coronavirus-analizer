package pl.sdacademy.credentials;

import java.time.LocalDate;

public class User {
    private Integer id;
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private boolean admin;


    public User(String firstName, String lastName, LocalDate dateOfBirth, Boolean admin) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.admin = admin;
    }

    public Integer getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public Boolean getAdmin() {
        return admin;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setAdmin(Boolean admin) {
        this.admin = admin;
    }
}
