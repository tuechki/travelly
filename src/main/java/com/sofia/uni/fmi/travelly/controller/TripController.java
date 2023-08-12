package com.sofia.uni.fmi.travelly.controller;

import com.sofia.uni.fmi.travelly.dto.ItemDto;
import com.sofia.uni.fmi.travelly.dto.TripDto;
import com.sofia.uni.fmi.travelly.dto.UserDto;
import com.sofia.uni.fmi.travelly.mapper.ItemMapper;
import com.sofia.uni.fmi.travelly.mapper.TripMapper;
import com.sofia.uni.fmi.travelly.model.Trip;
import com.sofia.uni.fmi.travelly.model.User;
import com.sofia.uni.fmi.travelly.service.TripService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("trips")
public class TripController {

    private TripService tripService;
    private TripMapper tripMapper;
    private ItemMapper itemMapper;

    public TripController(final TripService tripService, final TripMapper tripMapper) {
        this.tripService = tripService;
        this.tripMapper = tripMapper;
    }

    @GetMapping("{tripId}")
    public TripDto getTripById(@RequestParam Long tripId) {
        Trip trip = tripService.getTripById(tripId);
        return tripMapper.toDto(trip);
    }

    @PutMapping("{tripId}")
    public Long updateTripById(@PathVariable Long tripId, @RequestBody TripDto tripDto) {
        Trip trip = tripMapper.toEntity(tripDto);
        trip.setId(tripId);
        return tripService.updateTripById(trip);

        Trip trip = tripMapper.toEntity(tripDto);
        trip.setId(tripId);
        Trip updatedTrip =  tripService.updateTripById(trip);
        UserDto updatedUserDto = userMapper.toDto(updatedUser);
    }

    @DeleteMapping("{tripId}")
    public void deleteTripById(@PathVariable Long tripId) {
        tripService.deleteTripById(tripId);
    }


    @GetMapping("{tripId}/items")
    public List<ItemDto> getItemsByTripId(@PathVariable Long tripId) {
        return tripService.getItemsByTripId(tripId)
                .stream()
                .map(item -> itemMapper.toDto(item))
                .toList();
    }

    @PostMapping("{tripId}/items")
    public void addItem(@RequestBody ItemDto itemDto) {
        tripService.addItem(itemDto);
    }

    @DeleteMapping("{tripId}/items")
    public void deleteAllItems(@PathVariable String tripId) {
        tripService.deleteAllItems(tripId);
    }
}
