package com.example.Bloodbank.service;

import com.example.Bloodbank.entity.Register;
import com.example.Bloodbank.Repository.RegisterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class RegisterService {

    private final RegisterRepository registerRepository;

    @Autowired
    public RegisterService(RegisterRepository registerRepository) {
        this.registerRepository = registerRepository;
        initializeData();
    }

    private void initializeData() {
        if (registerRepository.count() == 0) {
            Register user1 = new Register(1, "John Doe", "O+", 1234567890, "john@example.com");
            Register user2 = new Register(2, "Alice Smith", "A-", 987654321, "alice@example.com");
            registerRepository.save(user1);
            registerRepository.save(user2);
        }
    }

    public List<Register> getAllRegisters() {
        return registerRepository.findAll();
    }

    public Register getRegisterById(int id) {
        return registerRepository.findById(id).orElse(null);
    }

    public List<Register> getRegistersByBloodGroup(String bloodGroup) {
        return registerRepository.findByBloodGroup(bloodGroup);
    }

    public Register addRegister(Register register) {
        return registerRepository.save(register);
    }

    public boolean updateRegister(int id, Register newRegister) {
        if (registerRepository.existsById(id)) {
            newRegister.setId(id);
            registerRepository.save(newRegister);
            return true;
        }
        return false;
    }

    public Register deleteRegister(int id) {
        Register register = registerRepository.findById(id).orElse(null);
        if (register != null) {
            registerRepository.deleteById(id);
        }
        return register;
    }

    public Map<String, Long> getBloodGroupCounts() {
        return registerRepository.findAll().stream()
                .collect(Collectors.groupingBy(Register::getBloodGroup, Collectors.counting()));
    }
}
