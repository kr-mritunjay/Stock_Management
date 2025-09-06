package com.ofss.Login;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.password.PasswordEncoder;

import org.springframework.stereotype.Service;

@Service
public class LoginService {

    @Autowired
    private LoginRepo userRepository;

    
//    private PasswordEncoder passwordEncoder;

    public boolean authenticate(String username, String rawPassword) {
    	
        Optional<LoginRequest> optionalUser = userRepository.findByUsername(username);
    

        if (optionalUser.isPresent()) { // ✅ check if user exists
            LoginRequest user = optionalUser.get();

            // Debug prints
            System.out.println("Username from request: " + username);
            System.out.println("Username from DB: " + user.getUsername());
            System.out.println("Password from request: " + rawPassword);
            System.out.println("Password from DB: " + user.getPasswordHash());

            if (rawPassword != null && rawPassword.equalsIgnoreCase(user.getPasswordHash())) {
                System.out.println(" Passwords match!");
                return true;
            } else {
                System.out.println(" Passwords do not match!");
                return false;
            }
        } else {
        	System.out.println(optionalUser);
            System.out.println("❌ User not found: " + username);
            System.out.println("Password from request: " + rawPassword);
            return true;
        }
    }


}

