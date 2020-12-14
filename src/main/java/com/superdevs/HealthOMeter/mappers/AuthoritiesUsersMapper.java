package com.superdevs.HealthOMeter.mappers;

import com.superdevs.HealthOMeter.dto.AuthoritiesUsersDto;
import com.superdevs.HealthOMeter.entity.AuthoritiesUsers;
import org.springframework.stereotype.Component;

@Component
public class AuthoritiesUsersMapper {

    public AuthoritiesUsers mapToAuthoritiesUsersMapper(final AuthoritiesUsersDto authoritiesUsersDto) {
        return new AuthoritiesUsers(
                authoritiesUsersDto.getUser_id(),
                authoritiesUsersDto.getAuthority_id());
    }

    public AuthoritiesUsersDto mapToAuthoritiesUsersDto(final AuthoritiesUsers authoritiesUsers) {
        return new AuthoritiesUsersDto(
                authoritiesUsers.getUser_id(),
                authoritiesUsers.getAuthority_id());
    }
}