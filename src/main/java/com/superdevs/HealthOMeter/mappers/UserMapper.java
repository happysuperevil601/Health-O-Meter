package com.superdevs.HealthOMeter.mappers;

import com.superdevs.HealthOMeter.dto.UserDto;
import com.superdevs.HealthOMeter.entity.User;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    @Autowired
    private ModelMapper modelMapper;

    public User mapToUser(final UserDto userDto) {
        return modelMapper.map(userDto, User.class);
    }

    public UserDto mapToUserDto(final User user) {
        return modelMapper.map(user, UserDto.class);
    }
}
