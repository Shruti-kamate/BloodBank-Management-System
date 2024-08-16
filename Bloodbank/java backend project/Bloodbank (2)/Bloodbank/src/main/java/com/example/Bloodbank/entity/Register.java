package com.example.Bloodbank.entity;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.persistence.*;

@Entity


public class Register {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "blood_group")
    private String bloodGroup;

    @Column(name = "contact_no")
    private long contactNo;

    @Column(name = "email")
    private String email;
    public Register() {
        // Default constructor
    }

    public Register(int id, String fullName, String bloodGroup, long contactNo, String email) {
        this.id = id;
        this.fullName = fullName;
        this.bloodGroup = bloodGroup;
        this.contactNo = contactNo;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public long getContactNo() {
        return contactNo;
    }

    public void setContactNo(long contactNo) {
        this.contactNo = contactNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Register{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", bloodGroup='" + bloodGroup + '\'' +
                ", contactNo=" + contactNo +
                ", email='" + email + '\'' +
                '}';
    }
    // Constructors, getters, setters, and toString method...
}
