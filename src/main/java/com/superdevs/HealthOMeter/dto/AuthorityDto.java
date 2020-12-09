package com.superdevs.HealthOMeter.dto;

public class AuthorityDto {

    private Long id;
    private String authority;

    public AuthorityDto() {
    }

    public AuthorityDto(Long id, String authority) {
        this.id = id;
        this.authority = authority;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }
}