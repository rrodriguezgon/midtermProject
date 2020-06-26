/**
 * com.ironhack.midtermProject.controller.impl.security
 */
package com.ironhack.midtermProject.controller.impl.security;

import com.ironhack.midtermProject.controller.dto.security.CreateAdminDto;
import com.ironhack.midtermProject.controller.interfaces.security.AdminController;
import com.ironhack.midtermProject.model.security.*;
import com.ironhack.midtermProject.service.security.AdminService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Admin Controller
 */
@Api(tags = "Admin Controller")
@RestController
@RequestMapping("/")
public class AdminControllerImpl implements AdminController {

    private static final Logger LOGGER = LogManager.getLogger(AdminControllerImpl.class);

    @Autowired
    private AdminService adminService;

    /**
     * Get All Admins
     * @return Display all Admins
     */
    @GetMapping("/admins")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value="Get All Admins",
            notes = "Display all Admins",
            response = Admin.class, responseContainer = "List")
    public List<Admin> getAll() {
        return adminService.findAll();
    }

    /**
     * Create Admin
     * @param admin Info for Create Admin
     * @return Display Admin created
     */
    @PostMapping("/admin")
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value="Create Admin",
            notes = "Display Admin created",
            response = Admin.class)
    public Admin create(@RequestBody @Valid CreateAdminDto admin) {
        return adminService.Create(admin);
    }

    /**
     * Get Admin by Id
     * @param id Admin Id
     * @return Display Admin by Id
     */
    @GetMapping("/admin/{id}")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value="Get Admin by Id",
            notes = "Display Admin by Id",
            response = Admin.class)
    public Admin getById(@PathVariable Integer id) {
        return adminService.findById(id);
    }

    /**
     * Update Admin
     * @param id Admin id
     * @param admin Info for Update Admin
     */
    @PutMapping("/admin/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ApiOperation(value="Update Admin")
    public void update(@PathVariable Integer id, @RequestBody @Valid CreateAdminDto admin) {
        adminService.update(id, admin);
    }

    /**
     * Delete Admin
     * @param id Admin id
     */
    @DeleteMapping("/admin/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ApiOperation(value="Delete Admin")
    public void deleteById(@PathVariable Integer id) {
        adminService.deleteById(id);
    }
}