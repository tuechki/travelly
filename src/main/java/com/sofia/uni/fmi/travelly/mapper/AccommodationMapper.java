package com.sofia.uni.fmi.travelly.mapper;

import com.sofia.uni.fmi.travelly.dto.AccommodationCreateUpdateDto;
import com.sofia.uni.fmi.travelly.dto.AccommodationDto;
import com.sofia.uni.fmi.travelly.model.Accommodation;
import org.springframework.stereotype.Component;

@Component
public class AccommodationMapper {
    public Accommodation toEntity(AccommodationDto accommodationDto) {
        return Accommodation.builder()
            .id(accommodationDto.getId())
            .name(accommodationDto.getName())
            .address(accommodationDto.getAddress())
            .city(accommodationDto.getCity())
            .pricePerNight(accommodationDto.getPricePerNight())
            .build();
    }

    public AccommodationDto toDto(Accommodation accommodation) {
        return AccommodationDto.builder()
            .id(accommodation.getId())
            .name(accommodation.getName())
            .address(accommodation.getAddress())
            .city(accommodation.getCity())
            .pricePerNight(accommodation.getPricePerNight())
            .build();
    }

    public Accommodation toEntity(AccommodationCreateUpdateDto accommodationCreateUpdateDto) {
        return Accommodation.builder()
                .name(accommodationCreateUpdateDto.getName())
                .address(accommodationCreateUpdateDto.getAddress())
                .city(accommodationCreateUpdateDto.getCity())
                .pricePerNight(accommodationCreateUpdateDto.getPricePerNight())
                .build();
    }

    public AccommodationCreateUpdateDto toCreateUpdateDto(Accommodation accommodation) {
        return AccommodationCreateUpdateDto.builder()
                .name(accommodation.getName())
                .address(accommodation.getAddress())
                .city(accommodation.getCity())
                .pricePerNight(accommodation.getPricePerNight())
                .build();
    }
}