/**
 * com.ironhack.midtermProject.controller.impl
 */
package com.ironhack.midtermProject.controller.impl;

import com.ironhack.midtermProject.controller.interfaces.ResetController;
import com.ironhack.midtermProject.model.entities.CreditCardAccount;
import com.ironhack.midtermProject.service.ResetService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * Reset Controller
 */
@Api(tags = "Reset Controller")
@RestController
@RequestMapping("/")
public class ResetControllerImpl implements ResetController {

    @Autowired
    private ResetService resetService;

    /**
     * Method for Reset Data
     */
    @ApiOperation(value="Method for Reset Data")
    @PutMapping("/resetData")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void resetData() {
        resetService.resetData();
    }
}
