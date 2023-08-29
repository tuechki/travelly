package com.sofia.uni.fmi.travelly.service;

import com.sofia.uni.fmi.travelly.dto.TripDto;
import com.sofia.uni.fmi.travelly.exception.ResourceNotFoundException;
import com.sofia.uni.fmi.travelly.mapper.UserMapper;
import com.sofia.uni.fmi.travelly.model.Trip;
import com.sofia.uni.fmi.travelly.model.User;
import com.sofia.uni.fmi.travelly.dto.UserDto;
import com.sofia.uni.fmi.travelly.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService {
    private UserRepository userRepository;
    private UserMapper userMapper;

    private TripService tripService;

    public User getUser(Long userId) {
        Optional<User> userOptional = userRepository.findById(userId);
        if (!userOptional.isPresent()) {
            throw new ResourceNotFoundException("No user present");
        }

        return userOptional.get();
    }

    public Long addUser(User user) {
        User savedUser = userRepository.save(user);

        return savedUser.getId();
    }

    public Long updateUser(User user) {
        return userRepository.save(user).getId();
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
        user.getTrips().add(trip);

        return user;
    }
}
