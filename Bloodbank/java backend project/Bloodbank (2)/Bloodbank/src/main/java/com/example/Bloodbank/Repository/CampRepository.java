package com.example.Bloodbank.Repository;

import com.example.Bloodbank.entity.Camp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CampRepository extends JpaRepository<Camp, Integer> {
}
