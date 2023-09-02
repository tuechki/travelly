package com.sofia.uni.fmi.travelly.controller;

import com.sofia.uni.fmi.travelly.dto.*;
import com.sofia.uni.fmi.travelly.mapper.AccommodationMapper;
import com.sofia.uni.fmi.travelly.mapper.ActivityMapper;
import com.sofia.uni.fmi.travelly.mapper.ItineraryMapper;
import com.sofia.uni.fmi.travelly.model.Itinerary;
import com.sofia.uni.fmi.travelly.service.AccommodationService;
import com.sofia.uni.fmi.travelly.service.ActivityService;
import com.sofia.uni.fmi.travelly.service.ItineraryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("itineraries")
public class ItineraryController {
    private ItineraryService itineraryService;
    private ItineraryMapper itineraryMapper;

    private ActivityService activityService;
    private ActivityMapper activityMapper;

    private AccommodationService accommodationService;
    private AccommodationMapper accommodationMapper;

    public ItineraryController(
            ItineraryService itineraryService,
            ItineraryMapper itineraryMapper,
            ActivityService activityService,
            ActivityMapper activityMapper,
            AccommodationService accommodationService,
            AccommodationMapper accommodationMapper
    ) {
        this.itineraryService = itineraryService;
        this.itineraryMapper = itineraryMapper;
        this.activityService = activityService;
        this.activityMapper = activityMapper;
        this.accommodationService = accommodationService;
        this.accommodationMapper = accommodationMapper;
    }

    @PatchMapping("{itineraryId}")
    public Long updateItinerary(@PathVariable Long itineraryId,
                                @RequestBody ItineraryCreateUpdateDto itineraryCreateUpdateDto) {
        Itinerary itinerary = itineraryMapper.toEntity(itineraryCreateUpdateDto);
        itinerary.setId(itineraryId);
        Itinerary updatedItinerary = itineraryService.updateItinerary(itinerary);
        ItineraryDto updatedItineraryDto = itineraryMapper.toDto(updatedItinerary);

        return updatedItineraryDto.getId();
    }

    @DeleteMapping("{itineraryId}")
    public void deleteItinerary(@PathVariable Long itineraryId) {
        itineraryService.deleteItinerary(itineraryId);
    }

    @GetMapping("{itineraryId}/activities")
    public List<ActivityCreateUpdateDto> getActivitiesByItineraryId(@PathVariable Long itineraryId) {
        return activityService.getActivitiesByItineraryId(itineraryId)
                .stream()
                .map(activity -> activityMapper.toCreateUpdateDto(activity))
                .toList();
    }

    @PostMapping("{itineraryId}/activities")
    public Long addActivity(
            @PathVariable Long itineraryId,
            @RequestBody ActivityCreateUpdateDto activityCreateUpdateDto) {
        return activityService.addActivity(activityCreateUpdateDto, itineraryId);
    }

    @DeleteMapping("{itineraryId}/activities")
    public void deleteAllActivities(@PathVariable Long itineraryId) {
        activityService.deleteAllActivities(itineraryId);
    }

    @GetMapping("{itineraryId}/accommodations")
    public List<AccommodationDto> getAccommodationsByItineraryId(@PathVariable Long itineraryId) {
        return accommodationService.getAccommodationsByItineraryId(itineraryId)
                .stream()
                .map(accommodation -> accommodationMapper.toDto(accommodation))
                .toList();
    }

    @PostMapping("{itineraryId}/accommodations")
    public Long addAccommodation(
            @PathVariable Long itineraryId,
            @RequestBody AccommodationCreateUpdateDto accommodationCreateUpdateDto) {
        return accommodationService.addAccommodation(accommodationCreateUpdateDto, itineraryId);
    }

    @DeleteMapping("{itineraryId}/accommodations")
    public void deleteAllAccommodations(@PathVariable Long itineraryId) {
        accommodationService.deleteAllAccommodations(itineraryId);
    }
}
