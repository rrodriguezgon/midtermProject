package com.ironhack.midtermProject.service.security;

import com.ironhack.midtermProject.model.security.User;
import com.ironhack.midtermProject.repository.security.*;
import com.ironhack.midtermProject.security.CustomSecurityUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private AccountHolderRepository accountHolderRepository;

    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private ThirdPartyRepository thirdPartyRepository;

    /**
     * This method found a match between login user and user from data base
     * @param username a String value
     * @return a userDetails element
     * @throws UsernameNotFoundException If there isn't a match.
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
            User user = adminRepository.findByUsername(username);
            if (user == null){
                user = accountHolderRepository.findByUsername(username);

                if (user == null){
                    user = thirdPartyRepository.findByUsername(username);
                }
            }

            if (user == null) {
                throw new UsernameNotFoundException("Invalid username/password combination.");
            }

            return new CustomSecurityUser(user);
    }
}