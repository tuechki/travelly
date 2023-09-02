package com.sofia.uni.fmi.travelly.controller;

import com.sofia.uni.fmi.travelly.dto.AccommodationDto;
import com.sofia.uni.fmi.travelly.dto.AccommodationCreateUpdateDto;
import com.sofia.uni.fmi.travelly.mapper.AccommodationMapper;
import com.sofia.uni.fmi.travelly.model.Accommodation;
import com.sofia.uni.fmi.travelly.service.AccommodationService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("accommodation")
public class AccommodationController {
    private AccommodationService accommodationService;
    private AccommodationMapper accommodationMapper;

    public AccommodationController(AccommodationService accommodationService, AccommodationMapper accommodationMapper) {
        this.accommodationService = accommodationService;
        this.accommodationMapper = accommodationMapper;
    }

    @PatchMapping("{accommodationId}")
    public Long updateAccommodation(
            @PathVariable Long accommodationId,
            @RequestBody AccommodationCreateUpdateDto accommodationCreateUpdateDto) {
        Accommodation accommodation = accommodationMapper.toEntity(accommodationCreateUpdateDto);
        accommodation.setId(accommodationId);
        Accommodation updatedAccommodation = accommodationService.updateAccommodation(accommodation);
        AccommodationDto updatedAccommodationDto = accommodationMapper.toDto(updatedAccommodation);

        return updatedAccommodationDto.getId();
    }

    @DeleteMapping("{accommodationId}")
    public void deleteAccommodation(@PathVariable Long accommodationId) {
        accommodationService.deleteAccommodation(accommodationId);
    }
}
