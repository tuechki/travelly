package com.sofia.uni.fmi.travelly.service;

import com.sofia.uni.fmi.travelly.model.Item;
import com.sofia.uni.fmi.travelly.model.Trip;
import com.sofia.uni.fmi.travelly.repository.TripRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TripService {

    private TripRepository tripRepository;

    public TripService(TripRepository tripRepository) {
        this.tripRepository = tripRepository;
    }

    public Trip getTripById(Long tripId) {

        Optional<Trip> tripOptional = tripRepository.findById(tripId);

        if (!tripOptional.isPresent()) {
            // throw exception
        }

        return tripOptional.get();
    }

    public Long updateTripById(Trip trip) {
        return tripRepository.save(trip).getId();
    }

    public void deleteTripById(Long tripId) {
        tripRepository.deleteById(tripId);
    }

    public List<Item> getItemsByTripId(Long tripId) {
        return tripRepository.findById(tripId).get().getItems();
    }

    public void addItem(ItemDto ItemDto) {
        tripService.addDealership(mapper.toEntity(dealershipDto));
    }

    public void deleteAllItems(String tripId) {
        tripService.deleteAllItems(tripId);
    }

    public Trip constructTripEntityBy(TripDto tripDto, User user) {
        Trip trip = tripMapper.toEntity(tripDto);
        trip.getUsers().add(user);

        return trip;
    }

}
