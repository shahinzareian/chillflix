package com.example.demo.controlles;

import com.example.demo.models.Admin;
import com.example.demo.models.Movie;
import com.example.demo.repositories.AdminRepository;
import com.example.demo.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admins")
public class AdminController {
    @Autowired
    private AdminRepository adminRepository;

    @GetMapping
    public List<Admin> getAdmin(){return adminRepository.findAll();}

    @GetMapping("/{id}")
    public Admin getAdmin(@PathVariable Long id) {
        return adminRepository.findById(id).get();
    }

    @PostMapping
    public Long addAdmin(@RequestBody Admin admin) {
        Admin createAdmin=  adminRepository.save(admin);
        return createAdmin.getId();
    }

    @DeleteMapping("/{id}")
    void deleteAdmin(@PathVariable Long id) {
        adminRepository.deleteById(id);
    }

    @PutMapping("/{id}")
    public void updateAdmin(@PathVariable("id") Long id, @RequestBody Admin admin) {
        admin.setId(id);
        adminRepository.save(admin);
    }
}
