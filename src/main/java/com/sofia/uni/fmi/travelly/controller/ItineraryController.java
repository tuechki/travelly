package com.sofia.uni.fmi.travelly.controller;

import com.sofia.uni.fmi.travelly.dto.ActivityCreateUpdateDto;
import com.sofia.uni.fmi.travelly.dto.ItineraryCreateUpdateDto;
import com.sofia.uni.fmi.travelly.dto.ItineraryDto;
import com.sofia.uni.fmi.travelly.mapper.ActivityMapper;
import com.sofia.uni.fmi.travelly.mapper.ItineraryMapper;
import com.sofia.uni.fmi.travelly.model.Itinerary;
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


    public ItineraryController(
            ItineraryService itineraryService,
            ItineraryMapper itineraryMapper,
            ActivityService activityService,
            ActivityMapper activityMapper
    ) {
        this.itineraryService = itineraryService;
        this.itineraryMapper = itineraryMapper;
        this.activityService = activityService;
        this.activityMapper = activityMapper;
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
    public void addActivity(
            @PathVariable Long itineraryId,
            @RequestBody ActivityCreateUpdateDto activityCreateUpdateDto) {
        activityService.addActivity(activityCreateUpdateDto, itineraryId);
    }

    @DeleteMapping("{itineraryId}/activities")
    public void deleteAllActivities(@PathVariable Long itineraryId) {
        activityService.deleteAllActivities(itineraryId);
    }
}
