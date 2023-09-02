package com.sofia.uni.fmi.travelly.dto;

import com.sofia.uni.fmi.travelly.model.Itinerary;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AccommodationDto {
    private Long id;
    private String name;
    private String address;
    private String city;
    private Double pricePerNight;
}
