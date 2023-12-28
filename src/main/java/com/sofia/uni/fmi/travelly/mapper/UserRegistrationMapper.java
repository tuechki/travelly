package com.sofia.uni.fmi.travelly.mapper;

import com.sofia.uni.fmi.travelly.dto.UserRegistrationDto;
import com.sofia.uni.fmi.travelly.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserRegistrationMapper {
    public UserRegistrationDto toDto(User user) {
        return UserRegistrationDto.builder()
            .username(user.getUsername())
            .password(user.getPassword())
            .build();
    }

    public User toEntity(UserRegistrationDto userRegistrationDto) {
        return User.builder()
            .username(userRegistrationDto.getUsername())
            .password(userRegistrationDto.getPassword())
            .build();
    }
}