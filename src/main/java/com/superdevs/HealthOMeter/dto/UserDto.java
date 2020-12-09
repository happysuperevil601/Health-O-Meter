package com.superdevs.HealthOMeter.dto;

import com.superdevs.HealthOMeter.entity.Authority;
import com.superdevs.HealthOMeter.entity.Contact;

import java.util.Set;

public class UserDto {

    private Long id;
    private String username;
    private String password;
    private boolean enabled;
    private Contact contact;
    private Set<Authority> authorities;

    public UserDto() {
    }

    public UserDto(Long id, String username, String password, boolean enabled, Contact contact, Set<Authority> authorities) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.enabled = enabled;
        this.contact = contact;
        this.authorities = authorities;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public Set<Authority> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(Set<Authority> authorities) {
        this.authorities = authorities;
    }
}
