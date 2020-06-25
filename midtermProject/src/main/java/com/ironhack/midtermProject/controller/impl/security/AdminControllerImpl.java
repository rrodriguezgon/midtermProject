package com.ironhack.midtermProject.controller.impl.security;

import com.ironhack.midtermProject.controller.dto.security.CreateAdminDto;
import com.ironhack.midtermProject.controller.interfaces.security.AdminController;
import com.ironhack.midtermProject.model.security.Admin;
import com.ironhack.midtermProject.service.security.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class AdminControllerImpl implements AdminController {

    @Autowired
    private AdminService adminService;

    @GetMapping("/admins")
    @ResponseStatus(HttpStatus.OK)
    public List<Admin> getAll() {
        return adminService.findAll();
    }

    @PostMapping("/admin")
    @ResponseStatus(HttpStatus.CREATED)
    public Admin Create(@RequestBody @Valid CreateAdminDto admin) {
        return adminService.Create(admin);
    }

    @GetMapping("/admin/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Admin getById(@PathVariable Integer id) {
        return adminService.findById(id);
    }

    @PutMapping("/admin/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Admin update(@PathVariable Integer id, @RequestBody @Valid CreateAdminDto admin) {
        return adminService.update(id, admin);
    }

    @DeleteMapping("/admin/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Integer id) {
        adminService.deleteById(id);
    }
}