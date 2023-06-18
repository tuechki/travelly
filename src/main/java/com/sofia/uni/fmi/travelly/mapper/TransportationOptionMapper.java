package com.sofia.uni.fmi.travelly.mapper;

import com.sofia.uni.fmi.travelly.dto.TransportationOptionDto;
import com.sofia.uni.fmi.travelly.model.TransportationOption;
import com.sofia.uni.fmi.travelly.model.TransportationOptionType;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class TransportationOptionMapper {
    public TransportationOption toEntity(TransportationOptionDto transportationOptionDto) {
        return TransportationOption.builder()
                .id(transportationOptionDto.getId())
                .itinerary(transportationOptionDto.getItinerary())
                .type(transportationOptionDto.getType())
                .duration(transportationOptionDto.getDuration())
                .price(transportationOptionDto.getPrice())
                .build();
    }

    public TransportationOptionDto toDto(TransportationOption transportationOption) {
        return TransportationOptionDto.builder()
                .id(transportationOption.getId())
                .itinerary(transportationOption.getItinerary())
                .type(transportationOption.getType())
                .duration(transportationOption.getDuration())
                .price(transportationOption.getPrice())
                .build();
    }
}
