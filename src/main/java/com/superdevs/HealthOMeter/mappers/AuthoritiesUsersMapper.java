package com.superdevs.HealthOMeter.mappers;

import com.superdevs.HealthOMeter.dto.AuthoritiesUsersDto;
import com.superdevs.HealthOMeter.entity.AuthoritiesUsers;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AuthoritiesUsersMapper {

    @Autowired
    private ModelMapper modelMapper;

    public AuthoritiesUsers mapToAuthoritiesUsersMapper(final AuthoritiesUsersDto authoritiesUsersDto) {
        return modelMapper.map(authoritiesUsersDto, AuthoritiesUsers.class);
    }

    public AuthoritiesUsersDto mapToAuthoritiesUsersDto(final AuthoritiesUsers authoritiesUsers) {
        return modelMapper.map(authoritiesUsers, AuthoritiesUsersDto.class);
    }
}