package net.andresbustamante.example.users.beans;

import java.io.Serializable;
import java.time.ZonedDateTime;

import static net.andresbustamante.example.common.util.DateUtils.getCurrentDateTime;

public class User implements Serializable {

    private Integer id;
    private String firstName;
    private String surname;
    private String email;
    private ZonedDateTime creationDate;
    private boolean active;

    public User() {
        this.id = null;
        this.active = true;
        this.creationDate = getCurrentDateTime();
    }

    public User(Integer id, String firstName, String surname, String email) {
        this.id = id;
        this.firstName = firstName;
        this.surname = surname;
        this.email = email;
        this.creationDate = getCurrentDateTime();
        this.active = true;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ZonedDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(ZonedDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
