package com.example.Bloodbank.repository;

import com.example.Bloodbank.entity.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Long> {
    Contact findByEmail(String email);
    void deleteByEmail(String email);
}
