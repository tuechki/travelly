package com.sofia.uni.fmi.travelly.controller;

import com.sofia.uni.fmi.travelly.dto.UserDto;
import com.sofia.uni.fmi.travelly.mapper.UserMapper;
import com.sofia.uni.fmi.travelly.model.User;
import com.sofia.uni.fmi.travelly.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UserController {
    private UserService service;
    private TripService tripService;

    private UserMapper userMapper;

    @GetMapping("/{id}")
    public UserDto getUser(@PathVariable Long id) {
        User user = service.getUser(id);
        return userMapper.toDto(user);
    }

    @PostMapping("/")
    public UserDto addUser(@RequestBody UserDto userDto) {
        User user = userMapper.toEntity(userDto);
        return service.addUser(user);
    }

    @PutMapping("/{id}")
    public UserDto updateUser(@PathVariable Long id, @RequestBody UserDto userDto) {
        User user = userMapper.toEntity(userDto);
        user.setId(id);
        return service.updateUser(user);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        service.deleteUser(id);
    }

    @GetMapping("/{id}/trips")
    public List<Trip> getTrips(@PathVariable Long id) {
        return service.getTrips(id);
    }

    @PostMapping("{id}/trips")
    public Long addTrip(@PathVariable Long id, @RequestBody TripDto tripDto) {
        User user = service.getUser(id);
        return service.addTrip(id, tripDto);
    }
}
