package com.superdevs.HealthOMeter.service;

import com.superdevs.HealthOMeter.entity.Authority;
import com.superdevs.HealthOMeter.entity.User;
import com.superdevs.HealthOMeter.repository.AuthorityRepo;
import com.superdevs.HealthOMeter.repository.UserRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserService.class);
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private AuthorityRepo authorityRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public void addNewUser(User user) {
        if (ifUserNotExist(user)) {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            Set<Authority> userAuthorities = new HashSet<>();
            userAuthorities.add(authorityRepo.findByAuthority("ROLE_USER").orElseThrow());
            user.setAuthorities(userAuthorities);
            userRepo.save(user);
        } else {
            logger.info("Such user already exists");
        }
    }

    private boolean ifUserNotExist(User user) {
        return userRepo.findByUsername(user.getUsername()).isEmpty();
    }
}
