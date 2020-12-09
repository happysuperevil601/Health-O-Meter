package com.superdevs.HealthOMeter.dto;

public class AuthoritiesUsersDto {

    private Long id;
    private Long user_id;
    private Long authority_id;

    public AuthoritiesUsersDto() {
    }

    public AuthoritiesUsersDto(Long id, Long user_id, Long authority_id) {
        this.id = id;
        this.user_id = user_id;
        this.authority_id = authority_id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public Long getAuthority_id() {
        return authority_id;
    }

    public void setAuthority_id(Long authority_id) {
        this.authority_id = authority_id;
    }
}