package com.synchrony.img.userauthentication.service;
import com.synchrony.img.userauthentication.entity.UserData;
import com.synchrony.img.userauthentication.model.CustomUserDetails;
import com.synchrony.img.userauthentication.repository.UserDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserDataRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //check whether user with the said name exists in DB or not
        Optional<UserData> credential = repository.findByUsername(username);

        //Now convert the Entity (UserCredentials) into UserDetails instance type required by Spring security. So we need a DTO here, lets say, CustomUserDetails.
        return credential.map(CustomUserDetails::new).orElseThrow(() -> new UsernameNotFoundException("user not found with name :" + username));
    }
}