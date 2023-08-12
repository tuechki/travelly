package com.sofia.uni.fmi.travelly.dto;

import com.sofia.uni.fmi.travelly.model.Itinerary;
import com.sofia.uni.fmi.travelly.model.TransportationOptionType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TransportationOptionDto {
    private Long id;
    private Itinerary itinerary;
    private TransportationOptionType type;
    private LocalDateTime duration;
    private Double price;
}
