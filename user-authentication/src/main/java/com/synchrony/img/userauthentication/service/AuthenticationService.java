package com.synchrony.img.userauthentication.service;
import com.synchrony.img.userauthentication.entity.UserData;
import com.synchrony.img.userauthentication.repository.UserDataRepository;
import io.jsonwebtoken.JwtException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticatioService {

    @Autowired
    private UserDataRepository userCredentialsRepository;
    private static final Logger log = LoggerFactory.getLogger(AuthenticatioService.class);
    @Autowired
    private JwtService jwtService;

    //bean defined in AuthConfig
    @Autowired
    private PasswordEncoder passwordEncoder;

    public Integer saveUser(UserData userData){
        //encrypt the password and then save
        userData.setPassword(passwordEncoder.encode(userData.getPassword()));
        UserData userData1=userCredentialsRepository.save(userData);
        return userData1.getId();
    }


    public String generateToken(String username) {
        String token=jwtService.generateToken(username);
        return token;
    }

    public String validateToken(String token) throws JwtException {
        return jwtService.validateToken(token);
    }

    public String getUserDetailsFromToken(String token) {
        return jwtService.getUserDetails(token);
    }
}