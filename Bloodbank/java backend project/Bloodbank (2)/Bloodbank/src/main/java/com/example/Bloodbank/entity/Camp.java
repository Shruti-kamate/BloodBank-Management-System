package com.example.Bloodbank.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;



@Entity
public class Camp {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String fullName;
    private String bloodGroup;
    private long contactNo;
    private String address;

    public Camp() {
    }

    public Camp(int id, String fullName, String bloodGroup, long contactNo, String address) {
        this.id = id;
        this.fullName = fullName;
        this.bloodGroup = bloodGroup;
        this.contactNo = contactNo;
        this.address = address;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Camp{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", bloodGroup='" + bloodGroup + '\'' +
                ", contactNo=" + contactNo +
                ", address='" + address + '\'' +
                '}';
    }
}
