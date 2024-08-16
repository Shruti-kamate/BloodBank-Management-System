package com.example.Bloodbank.entity;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
@JsonPropertyOrder({"fullName", "email", "password", "conformPassword"})
public class Sign {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long id;
    private String fullName;
    private String email;
    private String password;
    private String conformPassword;



    public Sign() {
    }

    public Sign(String fullName, String email, String password, String conformPassword) {
        this.fullName = fullName;
        this.email = email;
        this.password = password;
        this.conformPassword = conformPassword;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return this.fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConformPassword() {
        return this.conformPassword;
    }

    public void setConformPassword(String conformPassword) {
        this.conformPassword = conformPassword;
    }

    public String toString() {
        return "Sign{id=" + this.id + ", fullName='" + this.fullName + "', email='" + this.email + "', password='" + this.password + "', conformPassword='" + this.conformPassword + "'}";
    }
}