package com.superdevs.HealthOMeter.config;

import com.superdevs.HealthOMeter.entity.Authorities_Users;
import com.superdevs.HealthOMeter.entity.Authority;
import com.superdevs.HealthOMeter.entity.User;
import com.superdevs.HealthOMeter.repository.AuthoritiesUsersRepo;
import com.superdevs.HealthOMeter.repository.AuthorityRepo;
import com.superdevs.HealthOMeter.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class Start {
    private PasswordEncoder passwordEncoder;
    private UserRepo userRepo;
    private AuthorityRepo authorityRepo;
    private AuthoritiesUsersRepo authoritiesUsersRepo;

    @Autowired
    public Start(PasswordEncoder passwordEncoder, UserRepo userRepo, AuthorityRepo authorityRepo, AuthoritiesUsersRepo authoritiesUsersRepo) {
        this.passwordEncoder = passwordEncoder;
        this.userRepo = userRepo;
        this.authorityRepo = authorityRepo;
        this.authoritiesUsersRepo = authoritiesUsersRepo;

        seedUsers();
        seedAuthority();
        seedRelationships();
    }

    private void seedUsers() {
        User userAdmin = new User();
        userAdmin.setUsername("Iza");
        userAdmin.setEnabled(true);
        userAdmin.setPassword(passwordEncoder.encode("Iza123"));

        User userUser = new User();
        userUser.setUsername("Darek");
        userUser.setEnabled(true);
        userUser.setPassword(passwordEncoder.encode("Darek123"));

        userRepo.save(userAdmin);
        userRepo.save(userUser);
    }

    private void seedAuthority() {
        Authority adminAuthority = new Authority();
        adminAuthority.setAuthority("ROLE_ADMIN");

        Authority userAuthority = new Authority();
        userAuthority.setAuthority("ROLE_USER");

        authorityRepo.save( adminAuthority );
        authorityRepo.save( userAuthority );
    }

    private void seedRelationships() {
        Optional<User> user = userRepo.findByUsername("Darek");
        Optional<User> admin = userRepo.findByUsername("Iza");

        Optional<Authority> userAuthorities = authorityRepo.findByAuthority("ROLE_USER");
        Optional<Authority> adminUthorities = authorityRepo.findByAuthority("ROLE_ADMIN");

        Authorities_Users darek_user= new Authorities_Users();
        darek_user.setAuthority_id(userAuthorities.get().getId());
        darek_user.setUser_id(user.get().getId());

        Authorities_Users iza_admin = new Authorities_Users();
        iza_admin.setAuthority_id(adminUthorities.get().getId());
        iza_admin.setUser_id(admin.get().getId());

        authoritiesUsersRepo.save(darek_user);
        authoritiesUsersRepo.save(iza_admin);
    }
}
