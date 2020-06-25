package com.ironhack.midtermProject.security;

import com.ironhack.midtermProject.service.security.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.savedrequest.NullRequestCache;

@Configuration
@EnableGlobalMethodSecurity(securedEnabled=true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    /**
     * This method encrypts a password
     *
     * @return a encrypted password from BCryptPassword
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        return passwordEncoder;
    }

    /**
     * This method matches a login user and password
     *
     * @param auth
     * @throws Exception If there isn't matched between user and passord
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder);
    }

    /**
     * This method checks if a Login user has authority
     *
     * @param httpSecurity a HttpSecurity element
     * @throws Exception If a login user hasn't an authority to do actions. (level access)
     */
    @Override
    public void configure(HttpSecurity httpSecurity) throws Exception {

        httpSecurity.httpBasic();

        httpSecurity.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and().authorizeRequests()
                // region ---- Account Holder Controller ----

                .mvcMatchers(HttpMethod.GET,"/accounts-holder").hasAuthority("ROLE_ADMIN")
                .mvcMatchers(HttpMethod.GET,"/accounts-holder/{id}").hasAnyAuthority("ROLE_HOLDER","ROLE_ADMIN")
                .mvcMatchers(HttpMethod.PUT,"/accounts-holder/{id}").hasAnyAuthority("ROLE_HOLDER","ROLE_ADMIN")
                .mvcMatchers(HttpMethod.DELETE,"/accounts-holder/{id}").hasAuthority("ROLE_ADMIN")

                // endregion

                // region ---- Admin Controller ----

                .mvcMatchers("/admins").hasAuthority("ROLE_ADMIN")
                .mvcMatchers(HttpMethod.POST,"/admin").hasAuthority("ROLE_ADMIN")
                .mvcMatchers(HttpMethod.GET,"/admin/{id}").hasAuthority("ROLE_ADMIN")
                .mvcMatchers(HttpMethod.PUT,"/admin/{id}").hasAuthority("ROLE_ADMIN")
                .mvcMatchers(HttpMethod.DELETE,"/admin/{id}").hasAuthority("ROLE_ADMIN")

                // endregion

                // region ----  ThirdParty Controller ----

                .mvcMatchers("/thirdparties").hasAuthority("ROLE_ADMIN")
                .mvcMatchers(HttpMethod.POST,"/thirdarty").hasAuthority("ROLE_ADMIN")
                .mvcMatchers(HttpMethod.GET,"/thirdarty/{id}").hasAnyAuthority("ROLE_THIRDPARTY","ROLE_ADMIN")
                .mvcMatchers(HttpMethod.PUT,"/thirdarty/{id}").hasAuthority("ROLE_ADMIN")
                .mvcMatchers(HttpMethod.DELETE,"/thirdarty/{id}").hasAuthority("ROLE_ADMIN")

                // endregion

                // region ---- Checking Account Controller ----

                .mvcMatchers("/checking-accounts").hasAnyAuthority("ROLE_HOLDER","ROLE_ADMIN")
                .mvcMatchers("/checking-account/{id}").hasAnyAuthority("ROLE_HOLDER","ROLE_ADMIN")
                .mvcMatchers(HttpMethod.POST, "/checking-account").hasAnyAuthority("ROLE_HOLDER","ROLE_ADMIN")

                // endregion

                // region ---- Credit Card Account Controller ----
                .mvcMatchers("/credit-card-accounts").hasAnyAuthority("ROLE_HOLDER","ROLE_ADMIN")
                .mvcMatchers("/credit-card-account/{id}").hasAnyAuthority("ROLE_HOLDER","ROLE_ADMIN")
                .mvcMatchers(HttpMethod.POST, "/credit-card-account").hasAnyAuthority("ROLE_HOLDER","ROLE_ADMIN")
                // endregion

                // region ---- Saving Account Controller ----
                .mvcMatchers("/savings-accounts").hasAnyAuthority("ROLE_HOLDER","ROLE_ADMIN")
                .mvcMatchers("/savings-account/{id}").hasAnyAuthority("ROLE_HOLDER","ROLE_ADMIN")
                .mvcMatchers(HttpMethod.POST, "/savings-account").hasAnyAuthority("ROLE_HOLDER","ROLE_ADMIN")
                // endregion

                // region ---- Transfer Controller ----
                .mvcMatchers("/transfers").hasAuthority("ROLE_ADMIN")
                .mvcMatchers("/transfers/{id}").hasAnyAuthority("ROLE_HOLDER","ROLE_ADMIN")
                .mvcMatchers("/transfer/{id}").hasAnyAuthority("ROLE_HOLDER","ROLE_ADMIN")
                .mvcMatchers(HttpMethod.POST, "/transfer").hasAnyAuthority("ROLE_HOLDER","ROLE_ADMIN")
                .mvcMatchers(HttpMethod.POST, "/transaction").hasAnyAuthority("ROLE_THIRDPARTY","ROLE_HOLDER","ROLE_ADMIN")
                // endregion
                .and().requestCache().requestCache(new NullRequestCache()).and().httpBasic().and().cors().and().csrf().disable();
    }
}
