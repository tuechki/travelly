package com.sofia.uni.fmi.travelly.controller;

import com.sofia.uni.fmi.travelly.dto.ItineraryDto;
import com.sofia.uni.fmi.travelly.mapper.ItineraryMapper;
import com.sofia.uni.fmi.travelly.model.Itinerary;
import com.sofia.uni.fmi.travelly.service.ItineraryService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("itineraries")
public class ItineraryController {
    private ItineraryService itineraryService;
    private ItineraryMapper itineraryMapper;

    public ItineraryController(ItineraryService itineraryService, ItineraryMapper itineraryMapper) {
        this.itineraryService = itineraryService;
        this.itineraryMapper = itineraryMapper;
    }

    @PutMapping("{itineraryId}")
    public ItineraryDto updateItinerary(@PathVariable Long itineraryId, @RequestBody ItineraryDto itineraryDto) {
        Itinerary itinerary = itineraryMapper.toEntity(itineraryDto);
        itinerary.setId(itineraryId);
        Itinerary updatedItinerary = itineraryService.updateItinerary(itinerary);
        ItineraryDto updatedItineraryDto = itineraryMapper.toDto(updatedItinerary);

        return updatedItineraryDto;
    }

    @DeleteMapping("{itineraryId}")
    public void deleteItinerary(@PathVariable Long itineraryId) {
        itineraryService.deleteItinerary(itineraryId);
    }
}
