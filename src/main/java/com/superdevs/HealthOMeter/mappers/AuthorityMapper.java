package com.superdevs.HealthOMeter.mappers;

import com.superdevs.HealthOMeter.dto.AuthorityDto;
import com.superdevs.HealthOMeter.entity.Authority;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AuthorityMapper {

    @Autowired
    private ModelMapper modelMapper;

    public Authority mapToAuthority(final AuthorityDto authorityDto) {
        return modelMapper.map(authorityDto, Authority.class);
    }

    public AuthorityDto mapToAuthorityDto(final Authority authority) {
        return modelMapper.map(authority, AuthorityDto.class);
    }
}
