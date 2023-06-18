package com.sofia.uni.fmi.travelly.controller;

import com.sofia.uni.fmi.travelly.dto.TripDto;
import com.sofia.uni.fmi.travelly.mapper.TripMapper;
import com.sofia.uni.fmi.travelly.model.Trip;
import com.sofia.uni.fmi.travelly.service.TripService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("trips")
public class TripController {

    private TripService tripService;
    private TripMapper tripMapper;

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
    public Long updateTripById(@RequestParam Long tripId, @RequestBody TripDto tripDto) {
        return tripService.updateTripById(tripId, tripDto);
    }

    @DeleteMapping("{tripId}")
    public void deleteTripById(@RequestParam Long tripId) {
        tripService.deleteTripById(tripId);
    }


    @GetMapping("{tripId}/items")
    public List<ItemDto> getItemsByTripId(@RequestParam String tripId) {
        return tripService.getItemsByTripId(tripId);
    }

    @PostMapping("{tripId}/items")
    public void addItem(@RequestBody @Valid ItemDto itemDto) {
        tripService.addItem(itemMapper.toEntity(itemDto));
    }

    @DeleteMapping("{tripId}/items")
    public void deleteAllItems(@RequestParam String tripId) {
        tripService.deleteAllItems(tripId);
    }
}
