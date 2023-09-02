package com.sofia.uni.fmi.travelly.controller;

import com.sofia.uni.fmi.travelly.dto.*;
import com.sofia.uni.fmi.travelly.mapper.*;
import com.sofia.uni.fmi.travelly.model.Accommodation;
import com.sofia.uni.fmi.travelly.model.Activity;
import com.sofia.uni.fmi.travelly.model.Trip;
import com.sofia.uni.fmi.travelly.service.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

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

    private final ActivityService activityService;
    private final ActivityMapper activityMapper;

    private final AccommodationService accommodationService;
    private final AccommodationMapper accommodationMapper;


    public TripController(TripService tripService, TripMapper tripMapper,
                          ItemService itemService, ItemMapper itemMapper,
                          ItineraryService itineraryService, ItineraryMapper itineraryMapper,
                          ActivityService activityService, ActivityMapper activityMapper,
                          AccommodationService accommodationService, AccommodationMapper accommodationMapper) {
        this.tripService = tripService;
        this.tripMapper = tripMapper;
        this.itemService = itemService;
        this.itemMapper = itemMapper;
        this.itineraryService = itineraryService;
        this.itineraryMapper = itineraryMapper;
        this.activityService = activityService;
        this.activityMapper = activityMapper;
        this.accommodationService = accommodationService;
        this.accommodationMapper = accommodationMapper;
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
    public List<Long> addItems(
            @PathVariable Long tripId,
            @RequestBody List<ItemCreateUpdateDto> itemCreateUpdateDtoList) {
        return itemService.addItems(itemCreateUpdateDtoList, tripId);
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

    @GetMapping("{tripId}/activities/recommend")
    public List<ActivityDto> recommendActivities(@PathVariable Long tripId) {
        List<Activity> recommendedActivities = activityService.recommendActivities(tripId);

        List<ActivityDto> recommendedActivitiesDto =
                recommendedActivities
                        .stream()
                        .map(activity -> activityMapper.toDto(activity))
                        .collect(Collectors.toList());

        return recommendedActivitiesDto;
    }

    @GetMapping("{tripId}/accommodations/recommend")
    public List<AccommodationDto> recommendAccommodations(@PathVariable Long tripId) {
        List<Accommodation> recommendedAccommodations = accommodationService.recommendAccommodations(tripId);

        List<AccommodationDto> recommendedAccommodationsDto =
                recommendedAccommodations
                        .stream()
                        .map(accommodation -> accommodationMapper.toDto(accommodation))
                        .collect(Collectors.toList());

        return recommendedAccommodationsDto;
    }
}
