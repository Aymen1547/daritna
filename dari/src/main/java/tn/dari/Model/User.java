package tn.dari.Model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;

import lombok.Setter;
import org.springframework.lang.NonNull;

@Entity
public class User implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    @NonNull
    private String firstName;
    @NonNull
    private String lastName;
    @NonNull
    private String username;
    @Email
    @NonNull
    private String email;
    @NonNull
    private String password;
    @NonNull
    private LocalDate date;
    @NonNull
    private LocalDate cDate;
    @NonNull
    private LocalDate lDate;
    @NonNull
    private String role;
    @NonNull
    private boolean isNotLocked;
    public User(Long userId, String firstName, String lastName, String username, @Email String email, String password,
            LocalDate date, LocalDate cDate, LocalDate lDate, String role, boolean isNotLocked) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.email = email;
        this.password = password;
        this.date = date;
        this.cDate = cDate;
        this.lDate = lDate;
        this.role = role;
        this.isNotLocked = isNotLocked;
    }
    public User() {
    }
    public Long getUserId() {
        return userId;
    }
    public void setUserId(Long userId) {
        this.userId = userId;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public LocalDate getDate() {
        return date;
    }
    public void setDate(LocalDate date) {
        this.date = date;
    }
    public LocalDate getcDate() {
        return cDate;
    }
    public void setcDate(LocalDate cDate) {
        this.cDate = cDate;
    }
    public LocalDate getlDate() {
        return lDate;
    }
    public void setlDate(LocalDate lDate) {
        this.lDate = lDate;
    }
    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }
    public boolean isNotLocked() {
        return isNotLocked;
    }
    public void setNotLocked(boolean isNotLocked) {
        this.isNotLocked = isNotLocked;
    }



}
