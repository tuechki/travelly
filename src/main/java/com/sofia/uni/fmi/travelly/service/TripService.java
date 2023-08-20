package com.sofia.uni.fmi.travelly.service;

import com.sofia.uni.fmi.travelly.dto.TripDto;
import com.sofia.uni.fmi.travelly.exception.ResourceNotFoundException;
import com.sofia.uni.fmi.travelly.mapper.TripMapper;
import com.sofia.uni.fmi.travelly.model.Trip;
import com.sofia.uni.fmi.travelly.model.User;
import com.sofia.uni.fmi.travelly.repository.TripRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TripService {

    private final TripRepository tripRepository;

    private final TripMapper tripMapper;

    private final ItemService itemService;

    public TripService(TripRepository tripRepository, TripMapper tripMapper, ItemService itemService) {
        this.tripRepository = tripRepository;
        this.tripMapper = tripMapper;
        this.itemService = itemService;
    }

    public Trip getTripById(Long tripId) {
        Optional<Trip> tripOptional = tripRepository.findById(tripId);

        if (!tripOptional.isPresent()) {
            throw new ResourceNotFoundException("No trip with id=" + tripId + "is present.");
        }

        return tripOptional.get();
    }

    public Long updateTripById(Trip trip) {
        return tripRepository.save(trip).getId();
    }

    public void deleteTripById(Long tripId) {
        tripRepository.deleteById(tripId);
    }

    public Trip constructTripEntityBy(TripDto tripDto, User user) {
        Trip trip = tripMapper.toEntity(tripDto);
        trip.getUsers().add(user);

        return trip;
    }

}
