/**
 * com.ironhack.midtermProject.controller.impl.security
 */
package com.ironhack.midtermProject.controller.impl.security;

import com.ironhack.midtermProject.controller.dto.security.CreateThirdPartyDto;
import com.ironhack.midtermProject.controller.interfaces.security.ThirdPartyController;
import com.ironhack.midtermProject.model.security.ThirdParty;
import com.ironhack.midtermProject.service.security.ThirdPartyService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * ThirdParty Controller
 */
@Api(tags = "ThirdParty Controller")
@RestController
@RequestMapping("/")
public class ThirdPartyControllerImpl implements ThirdPartyController {

    @Autowired
    private ThirdPartyService thirdPartyService;

    /**
     * Get All thirdparties
     * @return Display all thirdparties
     */
    @GetMapping("/thirdparties")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value="Get All thirdparties",
            notes = "Display all thirdparties",
            response = ThirdParty.class, responseContainer = "List")
    public List<ThirdParty> getAll() {
        return thirdPartyService.findAll();
    }

    /**
     * Create thirdparty
     * @param thirdParty
     * @return Display thirdparty created
     */
    @PostMapping("thirdparty")
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value="Create thirdparty",
            notes = "Display thirdparty created",
            response = ThirdParty.class)
    public ThirdParty create(@RequestBody @Valid CreateThirdPartyDto thirdParty) {
        return thirdPartyService.Create(thirdParty);
    }

    /**
     * Get thirdparty by Id
     * @param id ThirdParty Id
     * @return Display thirdparty by Id
     */
    @GetMapping("/thirdparty/{id}")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value="Get thirdparty by Id",
            notes = "Display thirdparty by Id",
            response = ThirdParty.class)
    public ThirdParty getById(@PathVariable Integer id) {
        return thirdPartyService.findById(id);
    }

    /**
     * Update thirdparty
     * @param id ThirdParty Id
     * @param thirdParty
     */
    @PutMapping("/thirdparty/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ApiOperation(value="Update thirdparty")
    public void update(@PathVariable Integer id, @RequestBody @Valid CreateThirdPartyDto thirdParty) {
        thirdPartyService.update(id, thirdParty);
    }

    /**
     * Delete thirdparty
     * @param id ThirdParty Id
     */
    @DeleteMapping("/thirdparty/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ApiOperation(value="Delete thirdparty")
    public void deleteById(@PathVariable Integer id) {
        thirdPartyService.deleteById(id);
    }
}
