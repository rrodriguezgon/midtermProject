package com.ironhack.midtermProject.service.security;

import com.ironhack.midtermProject.controller.dto.security.CreateAdminDto;
import com.ironhack.midtermProject.exception.DataNotFoundException;
import com.ironhack.midtermProject.exception.UserExistException;
import com.ironhack.midtermProject.model.security.AccountHolder;
import com.ironhack.midtermProject.model.security.Admin;
import com.ironhack.midtermProject.model.security.Role;
import com.ironhack.midtermProject.repository.security.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class AdminService {
    @Autowired
    private AdminRepository adminRepository;

    public List<Admin> findAll(){
        return adminRepository.findAll();
    }

    public Admin Create(CreateAdminDto createAdminDto){

        Admin user = adminRepository.findByUsername(createAdminDto.getUsername());

        if (user != null){
            throw new UserExistException("This user exists.");
        }

        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        Admin admin = new Admin(createAdminDto.getUsername(),createAdminDto.getPassword());

        admin.setPassword(passwordEncoder.encode(admin.getPassword()));

        Set<Role> roles = new HashSet<Role>();
        Role role = new Role("ROLE_ADMIN");
        role.setUser(admin);

        roles.add(role);

        return adminRepository.save(admin);
    }

    public Admin findById(Integer id){
        return adminRepository.findById(id).orElseThrow(() -> new DataNotFoundException("this Admin id not Found."));
    }

    public Admin update(Integer id, CreateAdminDto createAdminDto){
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        Admin adminFound = findById(id);

        adminFound.setUsername(createAdminDto.getUsername());
        adminFound.setPassword(passwordEncoder.encode(createAdminDto.getPassword()));


        return adminRepository.save(adminFound);
    }

    public void deleteById(Integer id){
        Admin admin = findById(id);

        adminRepository.delete(admin);
    }
}