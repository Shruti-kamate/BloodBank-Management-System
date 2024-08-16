package com.example.Bloodbank.controller;

import com.example.Bloodbank.entity.Sign;
import com.example.Bloodbank.service.SignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sign")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class SignController {
    private final SignService signService;

    @Autowired
    public SignController(SignService signService) {
        this.signService = signService;
    }

    @GetMapping
    public List<Sign> getAllSigns() {
        return signService.getAllSigns();
    }

    @GetMapping("/email/{email}")
    public Sign getSignByEmail(@PathVariable String email) {
        return signService.getSignByEmail(email);
    }

    @PostMapping
    public Sign addSign(@RequestBody Sign sign) {
        return signService.addSign(sign);
    }

    @PutMapping("/{id}")
    public boolean updateSign(@PathVariable Long id, @RequestBody Sign newSign) {
        return signService.updateSign(id, newSign);
    }

    @DeleteMapping("/{id}")
    public Sign deleteSign(@PathVariable Long id) {
        return signService.deleteSign(id);
    }
}
