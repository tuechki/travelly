package com.sofia.uni.fmi.travelly.mapper;

import com.sofia.uni.fmi.travelly.dto.AccommodationCreateUpdateDto;
import com.sofia.uni.fmi.travelly.dto.AccommodationDto;
import com.sofia.uni.fmi.travelly.dto.AccommodationMapDto;
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
                .latitude(accommodationDto.getLatitude())
                .longitude(accommodationDto.getLongitude())
                .build();
    }

    public AccommodationDto toDto(Accommodation accommodation) {
        return AccommodationDto.builder()
                .id(accommodation.getId())
                .name(accommodation.getName())
                .address(accommodation.getAddress())
                .city(accommodation.getCity())
                .pricePerNight(accommodation.getPricePerNight())
                .latitude(accommodation.getLatitude())
                .longitude(accommodation.getLongitude())
                .build();
    }

    public Accommodation toEntity(AccommodationCreateUpdateDto accommodationCreateUpdateDto) {
        return Accommodation.builder()
                .name(accommodationCreateUpdateDto.getName())
                .address(accommodationCreateUpdateDto.getAddress())
                .city(accommodationCreateUpdateDto.getCity())
                .pricePerNight(accommodationCreateUpdateDto.getPricePerNight())
                .latitude(accommodationCreateUpdateDto.getLatitude())
                .longitude(accommodationCreateUpdateDto.getLongitude())
                .build();
    }

    public AccommodationCreateUpdateDto toCreateUpdateDto(Accommodation accommodation) {
        return AccommodationCreateUpdateDto.builder()
                .name(accommodation.getName())
                .address(accommodation.getAddress())
                .city(accommodation.getCity())
                .pricePerNight(accommodation.getPricePerNight())
                .latitude(accommodation.getLatitude())
                .longitude(accommodation.getLongitude())
                .build();
    }

    public AccommodationMapDto toMapDto(Accommodation accommodation) {
        return AccommodationMapDto.builder()
                .name(accommodation.getName())
                .address(accommodation.getAddress())
                .city(accommodation.getCity())
                .pricePerNight(accommodation.getPricePerNight())
                .longitude(accommodation.getLongitude())
                .latitude(accommodation.getLatitude())
                .build();
    }
}