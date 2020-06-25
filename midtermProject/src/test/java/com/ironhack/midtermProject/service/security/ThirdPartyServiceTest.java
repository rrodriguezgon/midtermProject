package com.ironhack.midtermProject.service.security;

import com.ironhack.midtermProject.controller.dto.security.CreateThirdPartyDto;
import com.ironhack.midtermProject.exception.UserExistException;
import com.ironhack.midtermProject.model.security.ThirdParty;
import com.ironhack.midtermProject.repository.security.ThirdPartyRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
class ThirdPartyServiceTest {

    @Autowired
    private ThirdPartyService thirdPartyService;

    @MockBean
    private ThirdPartyRepository thirdPartyRepository;

    private ThirdParty thirdParty;

    @BeforeEach
    void setUp() {
        thirdParty = new ThirdParty("name", "password", "hashKey");
        thirdParty.setId(1);

        List<ThirdParty> list = Collections.singletonList(thirdParty);

        when(thirdPartyRepository.findAll()).thenReturn(list);
        when(thirdPartyRepository.save(any(ThirdParty.class))).thenReturn(thirdParty);
        when(thirdPartyRepository.findById(thirdParty.getId())).thenReturn(java.util.Optional.ofNullable(thirdParty));
        when(thirdPartyRepository.findByUsername(thirdParty.getUsername())).thenReturn(thirdParty);
        when(thirdPartyRepository.findByUsername(thirdParty.getUsername())).thenReturn(thirdParty);
    }

    @Test
    void findAll() {
        int size = 1;

        assertEquals(size,thirdPartyService.findAll().size());
    }

    @Test
    void create() {
        CreateThirdPartyDto createThirdPartyDto =
                new CreateThirdPartyDto("name2", "password", "hashKey");

        assertEquals(thirdParty.getPassword(),
                thirdPartyService.Create(createThirdPartyDto).getPassword());
    }

    @Test
    void createThrows() {
        CreateThirdPartyDto createThirdPartyDto =
                new CreateThirdPartyDto("name", "password", "hashKey");

        assertThrows(UserExistException.class,() ->
                thirdPartyService.Create(createThirdPartyDto));
    }

    @Test
    void findById() {
        assertEquals(thirdParty.getPassword(),thirdPartyService.findById(thirdParty.getId()).getPassword());
    }

    @Test
    void update() {
        Integer id = 1;
        CreateThirdPartyDto createThirdPartyDto =
                new CreateThirdPartyDto("name", "password", "hashKey");

        assertEquals(thirdParty.getUsername(),thirdPartyService.update(id,createThirdPartyDto).getUsername());
    }

    @Test
    void deleteById() {
        Integer id = 1;

        thirdPartyService.deleteById(id);
    }
}