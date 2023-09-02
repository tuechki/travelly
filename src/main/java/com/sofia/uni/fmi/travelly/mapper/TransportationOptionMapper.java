package com.sofia.uni.fmi.travelly.mapper;

import com.sofia.uni.fmi.travelly.dto.TransportationOptionCreateUpdateDto;
import com.sofia.uni.fmi.travelly.dto.TransportationOptionDto;
import com.sofia.uni.fmi.travelly.model.TransportationOption;
import org.springframework.stereotype.Component;

@Component
public class TransportationOptionMapper {
    public TransportationOption toEntity(TransportationOptionDto transportationOptionDto) {
        return TransportationOption.builder()
                .id(transportationOptionDto.getId())
                .type(transportationOptionDto.getType())
                .duration(transportationOptionDto.getDuration())
                .price(transportationOptionDto.getPrice())
                .build();
    }

    public TransportationOptionDto toDto(TransportationOption transportationOption) {
        return TransportationOptionDto.builder()
                .id(transportationOption.getId())
                .type(transportationOption.getType())
                .duration(transportationOption.getDuration())
                .price(transportationOption.getPrice())
                .build();
    }

    public TransportationOption toEntity(TransportationOptionCreateUpdateDto transportationOptionCreateUpdateDto) {
        return TransportationOption.builder()
                .type(transportationOptionCreateUpdateDto.getType())
                .duration(transportationOptionCreateUpdateDto.getDuration())
                .price(transportationOptionCreateUpdateDto.getPrice())
                .build();
    }

    public TransportationOptionCreateUpdateDto toCreateUpdateDto(TransportationOption transportationOption) {
        return TransportationOptionCreateUpdateDto.builder()
                .type(transportationOption.getType())
                .duration(transportationOption.getDuration())
                .price(transportationOption.getPrice())
                .build();
    }
}
