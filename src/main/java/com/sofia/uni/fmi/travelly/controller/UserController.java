package com.sofia.uni.fmi.travelly.controller;

import com.sofia.uni.fmi.travelly.dto.TripDto;
import com.sofia.uni.fmi.travelly.dto.TripListDto;
import com.sofia.uni.fmi.travelly.dto.UserDto;
import com.sofia.uni.fmi.travelly.mapper.TripMapper;
import com.sofia.uni.fmi.travelly.mapper.UserMapper;
import com.sofia.uni.fmi.travelly.model.Trip;
import com.sofia.uni.fmi.travelly.model.User;
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

    @GetMapping("/{userId}")
    public UserDto getUserById(@PathVariable Long userId) {
        User user = service.getUserById(userId);
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
    public Long updateUserById(@PathVariable Long userId, @RequestBody UserDto userDto) {
        User user = userMapper.toEntity(userDto);
        user.setId(userId);
        return service.updateUser(user);
    }

    @DeleteMapping("/{id}")
    public void deleteUserById(@PathVariable Long userId) {
        service.deleteUserById(userId);
    }

    @GetMapping("/{id}/trips")
    public List<TripListDto> getTrips(@PathVariable Long id) {

        return service.getTripsByUserId(id)
                .stream()
                .map(trip -> tripMapper.toListDto(trip))
                .collect(Collectors.toList());
    }
  
    public List<Trip> getTripsByUserId(@PathVariable Long userId) {
        return service.getTripsByUserId(userId);
    }

    @PostMapping("{id}/trips")
    public Long addTrip(@PathVariable Long userId, @RequestBody TripDto tripDto) {
        User user = service.getUserById(userId);
        return service.addTrip(userId, tripDto);
    }
}
