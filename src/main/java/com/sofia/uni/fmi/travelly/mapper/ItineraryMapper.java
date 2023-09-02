package com.sofia.uni.fmi.travelly.mapper;

import com.sofia.uni.fmi.travelly.dto.ItineraryCreateUpdateDto;
import com.sofia.uni.fmi.travelly.dto.ItineraryDto;
import com.sofia.uni.fmi.travelly.model.Itinerary;
import org.springframework.stereotype.Component;

@Component
public class ItineraryMapper {
    public Itinerary toEntity(ItineraryDto itineraryDto) {
        return Itinerary.builder()
                .id(itineraryDto.getId())
                .trip(itineraryDto.getTrip())
                .dayNum(itineraryDto.getDayNum())
                .build();
    }

    public ItineraryDto toDto(Itinerary itinerary) {
        return ItineraryDto.builder()
                .id(itinerary.getId())
                .trip(itinerary.getTrip())
                .dayNum(itinerary.getDayNum())
                .build();
    }

    public ItineraryCreateUpdateDto toCreateUpdateDto(Itinerary itinerary) {
        return ItineraryCreateUpdateDto.builder()
                .dayNum(itinerary.getDayNum())
                .build();
    }

    public Itinerary toEntity(ItineraryCreateUpdateDto itineraryCreateUpdateDto) {
        return Itinerary.builder()
                .dayNum(itineraryCreateUpdateDto.getDayNum())
                .build();
    }
}
