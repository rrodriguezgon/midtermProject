/**
 * com.ironhack.midtermProject.controller.interfaces.security
 */
package com.ironhack.midtermProject.controller.interfaces.security;

import com.ironhack.midtermProject.controller.dto.security.CreateThirdPartyDto;
    import com.ironhack.midtermProject.model.security.ThirdParty;

import java.util.List;

/**
 * ThirdParty Controller Interface
 */
public interface ThirdPartyController {
    /**
     * Get All thirdparties
     * @return Display all thirdparties
     */
    public List<ThirdParty> getAll();

    /**
     * Create thirdparty
     * @param thirdParty
     * @return Display thirdparty created
     */
    public ThirdParty create(CreateThirdPartyDto thirdParty);

    /**
     * Get thirdparty by Id
     * @param id ThirdParty Id
     * @return Display thirdparty by Id
     */
    public ThirdParty getById(Integer id);

    /**
     * Update thirdparty
     * @param id ThirdParty Id
     * @param thirdParty
     */
    public void update(Integer id, CreateThirdPartyDto thirdParty);

    /**
     * Delete thirdparty
     * @param id ThirdParty Id
     */
    public void deleteById(Integer id);

}
