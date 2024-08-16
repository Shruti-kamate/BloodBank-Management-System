package com.example.Bloodbank.Repository;

import com.example.Bloodbank.entity.Register;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RegisterRepository extends JpaRepository<Register, Integer> {
    List<Register> findByBloodGroup(String bloodGroup);
}
