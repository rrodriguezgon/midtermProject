package com.ironhack.midtermProject.controller.interfaces.security;

    import com.ironhack.midtermProject.controller.dto.security.CreateThirdPartyDto;
    import com.ironhack.midtermProject.model.security.ThirdParty;

import java.util.List;

public interface ThirdPartyController {
    public List<ThirdParty> getAll();
    public ThirdParty Create(CreateThirdPartyDto thirdParty);
    public ThirdParty getById(Integer id);
    public ThirdParty update(Integer id, CreateThirdPartyDto thirdParty);
    public void deleteById(Integer id);

}
