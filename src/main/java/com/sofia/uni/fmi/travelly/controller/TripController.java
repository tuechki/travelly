package com.sofia.uni.fmi.travelly.controller;

import com.sofia.uni.fmi.travelly.dto.*;
import com.sofia.uni.fmi.travelly.mapper.ItemMapper;
import com.sofia.uni.fmi.travelly.mapper.ItineraryMapper;
import com.sofia.uni.fmi.travelly.mapper.TripMapper;
import com.sofia.uni.fmi.travelly.model.Trip;
import com.sofia.uni.fmi.travelly.service.ItemService;
import com.sofia.uni.fmi.travelly.service.ItineraryService;
import com.sofia.uni.fmi.travelly.service.TripService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("trips")
public class TripController {

    private final TripService tripService;
    private final TripMapper tripMapper;

    private final ItemService itemService;
    private final ItemMapper itemMapper;

    private final ItineraryService itineraryService;
    private final ItineraryMapper itineraryMapper;

    public TripController(TripService tripService,TripMapper tripMapper,
                          ItemService itemService, ItemMapper itemMapper,
                          ItineraryService itineraryService, ItineraryMapper itineraryMapper) {
        this.tripService = tripService;
        this.tripMapper = tripMapper;
        this.itemService = itemService;
        this.itemMapper = itemMapper;
        this.itineraryService = itineraryService;
        this.itineraryMapper = itineraryMapper;
    }

    @GetMapping("{tripId}")
    public TripDto getTripById(@PathVariable Long tripId) {
        Trip trip = tripService.getTripById(tripId);
        return tripMapper.toDto(trip);
    }

    @PatchMapping
    public Long updateTripById(@RequestBody TripDto tripDto) {
        Trip trip = tripMapper.toEntity(tripDto);
        return tripService.updateTrip(trip);
    }

    @DeleteMapping("{tripId}")
    public void deleteTripById(@PathVariable Long tripId) {
        tripService.deleteTripById(tripId);
    }


    @GetMapping("{tripId}/items")
    public List<ItemDto> getItemsByTripId(@PathVariable Long tripId) {
        return itemService.getItemsByTripId(tripId)
                .stream()
                .map(item -> itemMapper.toDto(item))
                .toList();
    }

    @PostMapping("{tripId}/items")
    public Long addItem(@PathVariable Long tripId, @RequestBody ItemCreateUpdateDto itemCreateUpdateDto) {
        return itemService.addItem(itemCreateUpdateDto, tripId);
    }

    @DeleteMapping("{tripId}/items")
    public void deleteAllItems(@PathVariable Long tripId) {
        itemService.deleteAllItems(tripId);
    }

    @GetMapping("{tripId}/itineraries")
    public List<ItineraryDto> getItinerariesByTripId(@PathVariable Long tripId) {
        return itineraryService.getItinerariesByTripId(tripId)
                .stream()
                .map(itinerary -> itineraryMapper.toDto(itinerary))
                .toList();
    }

    @PostMapping("{tripId}/itineraries")
    public Long addItinerary(@PathVariable Long tripId, @RequestBody ItineraryCreateUpdateDto itineraryCreateUpdateDto) {
        return itineraryService.addItinerary(itineraryCreateUpdateDto, tripId);
    }

    @DeleteMapping("{tripId}/itineraries")
    public void deleteAllItineraries(@PathVariable Long tripId) {
        itineraryService.deleteAllItineraries(tripId);
    }
}
