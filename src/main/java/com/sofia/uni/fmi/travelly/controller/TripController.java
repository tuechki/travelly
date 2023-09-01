package com.sofia.uni.fmi.travelly.controller;

import com.sofia.uni.fmi.travelly.dto.ItemCreateDto;
import com.sofia.uni.fmi.travelly.dto.TripDto;
import com.sofia.uni.fmi.travelly.mapper.ItemMapper;
import com.sofia.uni.fmi.travelly.mapper.TripMapper;
import com.sofia.uni.fmi.travelly.model.Trip;
import com.sofia.uni.fmi.travelly.service.ItemService;
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

    public TripController(TripService tripService,TripMapper tripMapper, ItemService itemService, ItemMapper itemMapper) {
        this.tripService = tripService;
        this.tripMapper = tripMapper;
        this.itemService = itemService;
        this.itemMapper = itemMapper;
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
    public List<ItemCreateDto> getItemsByTripId(@PathVariable Long tripId) {
        return itemService.getItemsByTripId(tripId)
                .stream()
                .map(item -> itemMapper.toItemCreateDto(item))
                .toList();
    }

    @PostMapping("{tripId}/items")
    public void addItem(@PathVariable Long tripId, @RequestBody ItemCreateDto itemCreateDto) {
        itemService.addItem(itemCreateDto, tripId);
    }

    @DeleteMapping("{tripId}/items")
    public void deleteAllItems(@PathVariable Long tripId) {
        itemService.deleteAllItems(tripId);
    }
}
