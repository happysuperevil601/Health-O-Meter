package com.superdevs.HealthOMeter.service;

import com.superdevs.HealthOMeter.entity.Authority;
import com.superdevs.HealthOMeter.entity.User;
import com.superdevs.HealthOMeter.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserRepo userRepo;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User appUser = userRepo.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("No user exists!"));

        List<GrantedAuthority> grantList = new ArrayList<>();
        for (Authority authority : appUser.getAuthorities()) {
            GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(authority.getAuthority());
            grantList.add(grantedAuthority);
        }

        return new org.springframework.security.core.userdetails.User(
                appUser.getUsername(), appUser.getPassword(), grantList);
    }
}
