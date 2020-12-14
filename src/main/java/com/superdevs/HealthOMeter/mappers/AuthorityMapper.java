package com.superdevs.HealthOMeter.mappers;

import com.superdevs.HealthOMeter.dto.AuthorityDto;
import com.superdevs.HealthOMeter.entity.Authority;
import org.springframework.stereotype.Component;

@Component
public class AuthorityMapper {

    public Authority mapToAuthority(final AuthorityDto authorityDto) {
        return new Authority(
                authorityDto.getAuthority());
    }

    public AuthorityDto mapToAuthorityDto(final Authority authority) {
        return new AuthorityDto(
                authority.getAuthority());
    }
}
