package com.sofia.uni.fmi.travelly.controller;

import com.sofia.uni.fmi.travelly.dto.TripDto;
import com.sofia.uni.fmi.travelly.dto.TripListDto;
import com.sofia.uni.fmi.travelly.dto.UserDto;
import com.sofia.uni.fmi.travelly.mapper.TripMapper;
import com.sofia.uni.fmi.travelly.mapper.UserMapper;
import com.sofia.uni.fmi.travelly.model.Trip;
import com.sofia.uni.fmi.travelly.model.User;
import com.sofia.uni.fmi.travelly.service.TripService;
import com.sofia.uni.fmi.travelly.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UserController {
    private UserService service;
    private TripMapper tripMapper;
    private UserMapper userMapper;

    @GetMapping("/{id}")
    public UserDto getUser(@PathVariable Long id) {
        User user = service.getUser(id);
        return userMapper.toDto(user);
    }

    @PostMapping("/")
    public UserDto addUser(@RequestBody UserDto userDto) {
        User user = userMapper.toEntity(userDto);
        Long userId = service.addUser(user);
        user.setId(userId);
        UserDto addedUserDto = userMapper.toDto(user);

        return addedUserDto;
    }

    @PutMapping("/{id}")
    public UserDto updateUser(@PathVariable Long id, @RequestBody UserDto userDto) {
        User user = userMapper.toEntity(userDto);
        user.setId(id);
        User updatedUser =  service.updateUser(user);
        UserDto updatedUserDto = userMapper.toDto(updatedUser);

        return updatedUserDto;
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        service.deleteUser(id);
    }

    @GetMapping("/{id}/trips")
    public List<TripListDto> getTrips(@PathVariable Long id) {

        return service.getTrips(id)
                .stream()
                .map(trip -> tripMapper.toListDto(trip))
                .collect(Collectors.toList());
    }

//    @PostMapping("{id}/trips")
//    public Long addTrip(@PathVariable Long id, @RequestBody TripDto tripDto) {
//        User user = service.getUser(id);
//        return service.addTrip(id, tripDto);
//    }
}
