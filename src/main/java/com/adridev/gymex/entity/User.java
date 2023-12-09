package com.adridev.gymex.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.UUID;

@Entity
public class User {
    @Id
    @GeneratedValue( strategy = GenerationType.UUID)
    private UUID id;
    @NotBlank(message = "{register.name.NotBlank}")
    @Size(min = 2, max = 20, message = "{register.name.Size}")
    private String name;
    @NotBlank(message = "{register.email.invalid}")
    @Size(min = 2, max = 20, message = "{register.email.Size}")
    @Email(message = "{register.email.format}")
    private String email;
    @NotBlank(message = "{register.sex.NotBlank}")
    private String sex;
    @NotBlank(message = "{register.password.NotBlank}")
    @Size(min = 2, max = 20, message = "{register.password.Size}")
    private String password;
    @NotBlank(message = "{register.confirmPassword.NotBlank}")
    private String confirmPassword;

    public User(String name, String email, String sex, String password, String confirmPassword) {
        this.name = name;
        this.email = email;
        this.sex = sex;
        this.password = password;
        this.confirmPassword = confirmPassword;
    }

    public User() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", sex='" + sex + '\'' +
                ", password='" + password + '\'' +
                ", confirmPassword='" + confirmPassword + '\'' +
                '}';
    }
}
