package com.example.Bloodbank.controller;

import com.example.Bloodbank.entity.Register;
import com.example.Bloodbank.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/register")
@CrossOrigin
public class RegisterController {

    private final RegisterService registerService;

    @Autowired
    public RegisterController(RegisterService registerService) {
        this.registerService = registerService;
    }

    @GetMapping
    public List<Register> getAllRegisters() {
        return registerService.getAllRegisters();
    }

    @GetMapping("/{id}")
    public Register getRegisterById(@PathVariable int id) {
        return registerService.getRegisterById(id);
    }

    @GetMapping("/search")
    public List<Register> getRegistersByBloodGroup(@RequestParam String bloodGroup) {
        return registerService.getRegistersByBloodGroup(bloodGroup);
    }

    @PostMapping
    public Register addRegister(@RequestBody Register register) {
        return registerService.addRegister(register);
    }

    @PutMapping("/{id}")
    public boolean updateRegister(@PathVariable int id, @RequestBody Register newRegister) {
        return registerService.updateRegister(id, newRegister);
    }

    @DeleteMapping("/{id}")
    public Register deleteRegister(@PathVariable int id) {
        return registerService.deleteRegister(id);
    }

    @GetMapping("/blood-group-counts")
    public Map<String, Long> getBloodGroupCounts() {
        return registerService.getBloodGroupCounts();
    }
}
