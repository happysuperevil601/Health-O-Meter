package com.superdevs.HealthOMeter.mappers;

import com.superdevs.HealthOMeter.dto.UserDto;
import com.superdevs.HealthOMeter.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public User mapToUser(final UserDto userDto) {
        return new User(
                userDto.getId(),
                userDto.getUsername(),
                userDto.getPassword(),
                userDto.isEnabled(),
                userDto.getContact(),
                userDto.getAuthorities());
    }

    public UserDto mapToUserDto(final User user) {
        return new UserDto(
                user.getId(),
                user.getUsername(),
                user.getPassword(),
                user.isEnabled(),
                user.getContact(),
                user.getAuthorities());
    }
}
