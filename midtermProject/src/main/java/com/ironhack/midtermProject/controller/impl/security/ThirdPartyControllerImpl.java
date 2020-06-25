package com.ironhack.midtermProject.controller.impl.security;

import com.ironhack.midtermProject.controller.dto.security.CreateThirdPartyDto;
import com.ironhack.midtermProject.model.security.ThirdParty;
import com.ironhack.midtermProject.service.security.ThirdPartyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class ThirdPartyControllerImpl {
    @Autowired
    private ThirdPartyService thirdPartyService;

    @GetMapping("/thirdparties")
    @ResponseStatus(HttpStatus.OK)
    public List<ThirdParty> getAll() {
        return thirdPartyService.findAll();
    }

    @PostMapping("thirdarty")
    @ResponseStatus(HttpStatus.CREATED)
    public ThirdParty Create(@RequestBody @Valid CreateThirdPartyDto thirdParty) {
        return thirdPartyService.Create(thirdParty);
    }

    @GetMapping("/thirdarty/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ThirdParty getById(@PathVariable Integer id) {
        return thirdPartyService.findById(id);
    }

    @PutMapping("/thirdarty/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ThirdParty update(@PathVariable Integer id, @RequestBody @Valid CreateThirdPartyDto thirdParty) {
        return thirdPartyService.update(id, thirdParty);
    }

    @DeleteMapping("/thirdarty/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Integer id) {
        thirdPartyService.deleteById(id);
    }
}
