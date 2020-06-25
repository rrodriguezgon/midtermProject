package com.ironhack.midtermProject.controller.interfaces.security;

import com.ironhack.midtermProject.controller.dto.security.CreateAdminDto;
import com.ironhack.midtermProject.model.security.Admin;

import java.util.List;

public interface AdminController {
    public List<Admin> getAll();
    public Admin Create(CreateAdminDto accountHolder);
    public Admin getById(Integer id);
    public Admin update(Integer id, CreateAdminDto accountHolder);
    public void deleteById(Integer id);
}
