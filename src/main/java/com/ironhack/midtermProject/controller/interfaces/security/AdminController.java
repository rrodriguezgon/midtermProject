/**
 * com.ironhack.midtermProject.controller.interfaces.security
 */
package com.ironhack.midtermProject.controller.interfaces.security;

import com.ironhack.midtermProject.controller.dto.security.CreateAdminDto;
import com.ironhack.midtermProject.model.security.Admin;
import com.ironhack.midtermProject.model.viewModel.AdminViewModel;

import java.util.List;

/**
 * Admin Controller Interface
 */
public interface AdminController {

    /**
     * Get All Admins
     * @return Display all Admins
     */
    public List<AdminViewModel> getAll();

    /**
     * Create Admin
     * @param admin Info for Create Admin
     * @return Display Admin created
     */
    public AdminViewModel create(CreateAdminDto admin);

    /**
     * Get Admin by Id
     * @param id Admin Id
     * @return Display Admin by Id
     */
    public AdminViewModel getById(Integer id);

    /**
     * Update Admin
     * @param id Admin id
     * @param admin Info for Update Admin
     */
    public void update(Integer id, CreateAdminDto admin);

    /**
     * Delete Admin
     * @param id Admin id
     */
    public void deleteById(Integer id);
}
