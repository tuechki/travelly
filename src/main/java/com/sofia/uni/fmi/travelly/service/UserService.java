package com.sofia.uni.fmi.travelly.service;

import com.sofia.uni.fmi.travelly.exception.ResourceNotFoundException;
import com.sofia.uni.fmi.travelly.mapper.UserMapper;
import com.sofia.uni.fmi.travelly.model.User;
import com.sofia.uni.fmi.travelly.dto.UserDto;
import com.sofia.uni.fmi.travelly.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService {
    private UserRepository userRepository;
    private UserMapper userMapper;
    public User getUser(Long userId) {
        Optional<User> userOptional = userRepository.findById(userId);
        if (!userOptional.isPresent()) {
            throw new ResourceNotFoundException("No user present");
        }

        return userOptional.get();
    }

    public Long addUser(User user) {
        userRepository.save(user);
    }

    public User updateUser(User user) {
        userRepository.save(user);
    }

    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }

    public List<Trip> getTrips(Long userId) {
        Optional<User> userOptional = userRepository.findById(userId);
        if(!userOptional.isPresent()) {
            throw new ResourceNotFoundException("No user present");
        }
        
        return userOptional.get().getTrips();
    }

    public Long addTrip(Long userId, TripDto tripDto) {
        Optional<User> userOptional = userRepository.findById(userId);
        if(!userOptional.isPresent()) {
            throw new ResourceNotFoundException("No user present");
        }

        User user = userOptional.get();
        Trip trip = tripService.constructTripEntityBy(tripDto, user);

        return trip.getId();
    }

    public User constructUserEntityBy(UserDto userDto, Trip trip) {
        User user = userMapper.toEntity(userDto);
        user.addTrip(trip);

        return user;
    }
}
