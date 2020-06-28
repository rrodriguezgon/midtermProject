/**
 *
 */
package com.ironhack.midtermProject.service.security;

import com.ironhack.midtermProject.controller.dto.security.CreateAdminDto;
import com.ironhack.midtermProject.controller.impl.TransferControllerImpl;
import com.ironhack.midtermProject.exception.DataNotFoundException;
import com.ironhack.midtermProject.exception.UserExistException;
import com.ironhack.midtermProject.model.security.AccountHolder;
import com.ironhack.midtermProject.model.security.Admin;
import com.ironhack.midtermProject.model.security.Role;
import com.ironhack.midtermProject.model.viewModel.AdminViewModel;
import com.ironhack.midtermProject.repository.security.AdminRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.joining;

/**
 *
 */
@Service
public class AdminService {

    private static final Logger LOGGER = LogManager.getLogger(AdminService.class);

    @Autowired
    private AdminRepository adminRepository;

    /**
     *
     * @return
     */
    public List<AdminViewModel> findAll(){
        return adminRepository.findAll().stream().map(holder -> transformAdminToViewModel(holder)).collect(Collectors.toList());
    }

    private AdminViewModel transformAdminToViewModel(Admin admin) {
        String roles = admin.getRoles().stream().map(rol -> rol.getRole()).collect(joining(","));

        return new AdminViewModel(admin.getId(),admin.getUsername(),admin.getPassword(), roles);
    }

    /**
     *
     * @param createAdminDto
     * @return
     */
    public AdminViewModel Create(CreateAdminDto createAdminDto){

        Admin user = adminRepository.findByUsername(createAdminDto.getUsername());

        if (user != null){
            UserExistException ex = new UserExistException("This user exists.");
            LOGGER.error("username: " + createAdminDto.getUsername(),ex);

            throw ex;
        }

        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        Admin admin = new Admin(createAdminDto.getUsername(),createAdminDto.getPassword());

        admin.setPassword(passwordEncoder.encode(admin.getPassword()));

        Set<Role> roles = new HashSet<Role>();
        Role role = new Role("ROLE_ADMIN");
        role.setUser(admin);

        roles.add(role);

        return transformAdminToViewModel(adminRepository.save(admin));
    }

    /**
     *
     * @param id
     * @return
     */
    private Admin findById(Integer id){
        return adminRepository.findById(id).orElseThrow(() -> new DataNotFoundException("this Admin id not Found."));
    }

    public AdminViewModel getById(Integer id){
        return transformAdminToViewModel(findById(id));
    }

    /**
     *
     * @param id
     * @param createAdminDto
     * @return
     */
    public void update(Integer id, CreateAdminDto createAdminDto){
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        Admin adminFound = findById(id);

        adminFound.setUsername(createAdminDto.getUsername());
        adminFound.setPassword(passwordEncoder.encode(createAdminDto.getPassword()));


        adminRepository.save(adminFound);
    }

    /**
     *
     * @param id
     */
    public void deleteById(Integer id){
        Admin admin = findById(id);

        adminRepository.delete(admin);
    }
}