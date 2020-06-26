/**
 *
 */
package com.ironhack.midtermProject.service.security;

import com.ironhack.midtermProject.model.security.User;
import com.ironhack.midtermProject.repository.security.*;
import com.ironhack.midtermProject.security.CustomSecurityUser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;

/**
 *
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private static final Logger LOGGER = LogManager.getLogger(UserDetailsServiceImpl.class);

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
                UsernameNotFoundException ex = new UsernameNotFoundException("Invalid username/password combination.");
                LOGGER.error("username: " + username,ex);
                throw ex;
            }

            return new CustomSecurityUser(user);
    }
}