package com.sofia.uni.fmi.travelly.dto;

import com.sofia.uni.fmi.travelly.model.Trip;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@AllArgsConstructor
@Builder
@Data
public class UserDto {
    private Long id;
    private String email;
    private String username;
    private String password;
    private List<Trip> trips;
}
