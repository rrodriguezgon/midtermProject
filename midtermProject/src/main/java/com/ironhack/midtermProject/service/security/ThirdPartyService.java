package com.ironhack.midtermProject.service.security;

import com.ironhack.midtermProject.controller.dto.security.CreateThirdPartyDto;
import com.ironhack.midtermProject.exception.DataNotFoundException;
import com.ironhack.midtermProject.exception.UserExistException;
import com.ironhack.midtermProject.model.security.Admin;
import com.ironhack.midtermProject.model.security.Role;
import com.ironhack.midtermProject.model.security.ThirdParty;
import com.ironhack.midtermProject.repository.security.ThirdPartyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class ThirdPartyService {
    @Autowired
    private ThirdPartyRepository thirdPartyRepository;

    public List<ThirdParty> findAll(){
        return thirdPartyRepository.findAll();
    }

    public ThirdParty Create(CreateThirdPartyDto createThirdPartyDto){
        ThirdParty user = thirdPartyRepository.findByUsername(createThirdPartyDto.getName());

        if (user != null){
            throw new UserExistException("This user exists.");
        }

        ThirdParty thirdParty = new ThirdParty(createThirdPartyDto.getName(),
                createThirdPartyDto.getPassword(),createThirdPartyDto.getHashKey());

        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        thirdParty.setPassword(passwordEncoder.encode(createThirdPartyDto.getPassword()));

        HashSet<Role> roles = new HashSet<Role>();
        Role role = new Role("ROLE_THIRDPARTY");
        role.setUser(thirdParty);
        roles.add(role);
        thirdParty.setRoles(roles);

        return thirdPartyRepository.save(thirdParty);
    }

    public ThirdParty findById(Integer id){
        return thirdPartyRepository.findById(id).orElseThrow(() -> new DataNotFoundException("this ThirdParty id not Found."));
    }

    public ThirdParty update(Integer id, CreateThirdPartyDto createThirdPartyDto){
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        ThirdParty thirdPartyFound = findById(id);

        thirdPartyFound.setHashKey(createThirdPartyDto.getHashKey());
        thirdPartyFound.setPassword(passwordEncoder.encode(createThirdPartyDto.getPassword()));
        thirdPartyFound.setUsername(createThirdPartyDto.getName());

        return thirdPartyRepository.save(thirdPartyFound);
    }

    public void deleteById(Integer id){
        ThirdParty thirdPartyFound = findById(id);

        thirdPartyRepository.delete(thirdPartyFound);
    }
}
