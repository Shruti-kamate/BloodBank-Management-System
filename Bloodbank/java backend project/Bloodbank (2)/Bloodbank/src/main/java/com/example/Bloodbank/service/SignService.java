package com.example.Bloodbank.service;

import com.example.Bloodbank.Repository.SignRepository;
import com.example.Bloodbank.entity.Sign;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SignService {
    private final SignRepository signRepository;



    @Autowired
    public SignService(SignRepository signRepository) {
        this.signRepository = signRepository;
    }

    public List<Sign> getAllSigns() {
        return this.signRepository.findAll();
    }

    public Sign getSignByEmail(String email) {
        return this.signRepository.findByEmail(email);
    }

    public Sign addSign(Sign sign) {
        return (Sign)this.signRepository.save(sign);
    }

    public boolean updateSign(Long id, Sign newSign) {
        if (this.signRepository.existsById(id)) {
            newSign.setId(id);
            this.signRepository.save(newSign);
            return true;
        } else {
            return false;
        }
    }

    public Sign deleteSign(Long id) {
        Sign sign = (Sign)this.signRepository.findById(id).orElse(null);
        if (sign != null) {
            this.signRepository.deleteById(id);
        }

        return sign;
    }
}