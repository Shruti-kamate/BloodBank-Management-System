package com.example.Bloodbank.controller;

import com.example.Bloodbank.entity.Camp;
import com.example.Bloodbank.service.CampService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/camp")
@CrossOrigin
public class CampController {

    private final CampService campService;

    @Autowired
    public CampController(CampService campService) {
        this.campService = campService;
    }

    @GetMapping
    public List<Camp> getAllCamps() {
        return campService.getAllCamps();
    }

    @GetMapping("/{id}")
    public Camp getCampById(@PathVariable int id) {
        return campService.getCamp(id);
    }

    @PostMapping
    public Camp addCamp(@RequestBody Camp camp) {
        return campService.addCamp(camp);
    }

    @PutMapping("/{id}")
    public boolean updateCamp(@PathVariable int id, @RequestBody Camp newCamp) {
        return campService.updateCamp(id, newCamp);
    }

    @DeleteMapping("/{id}")
    public Camp deleteCamp(@PathVariable int id) {
        return campService.deleteCamp(id);
    }
}
