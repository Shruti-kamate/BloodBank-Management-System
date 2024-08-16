package com.example.Bloodbank.service;

import com.example.Bloodbank.entity.Camp;
import com.example.Bloodbank.Repository.CampRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CampService {

    private final CampRepository campRepository;

    @Autowired
    public CampService(CampRepository campRepository) {
        this.campRepository = campRepository;
    }

    public List<Camp> getAllCamps() {
        return campRepository.findAll();
    }

    public Camp getCamp(int id) {
        return campRepository.findById(id).orElse(null);
    }

    public Camp addCamp(Camp camp) {
        return campRepository.save(camp);
    }

    public boolean updateCamp(int id, Camp newCamp) {
        if (campRepository.existsById(id)) {
            newCamp.setId(id);
            campRepository.save(newCamp);
            return true;
        }
        return false;
    }

    public Camp deleteCamp(int id) {
        Camp camp = campRepository.findById(id).orElse(null);
        if (camp != null) {
            campRepository.deleteById(id);
        }
        return camp;
    }

    // Adding 3 users prior
    public void addPriorUsers() {
        Camp user1 = new Camp(1, "John Doe", "A+", 1234567890, "123 Main St");
        Camp user2 = new Camp(2, "Alice Smith", "B-", 987654321, "456 Elm St");
        Camp user3 = new Camp(3, "Bob Johnson", "AB+", 456789123, "789 Oak St");
        campRepository.save(user1);
        campRepository.save(user2);
        campRepository.save(user3);
    }
}
