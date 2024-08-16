package com.example.Bloodbank.Repository;

import com.example.Bloodbank.entity.Sign;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SignRepository extends JpaRepository<Sign, Long> {

    Sign findByEmail(String email);
}
