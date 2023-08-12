package com.sofia.uni.fmi.travelly.mapper;

import com.sofia.uni.fmi.travelly.dto.TripDto;
import com.sofia.uni.fmi.travelly.model.Trip;
import org.springframework.stereotype.Component;

@Component
public class TripMapper {

    public TripDto toDto(Trip entity) {
        return TripDto.builder()
            .id(entity.getId())
            .name(entity.getName())
            .startDate(entity.getStartDate())
            .endDate(entity.getEndDate())
            .budget(entity.getBudget())
            .interests(entity.getInterests())
            .items(entity.getItems())
            .users(entity.getUsers())
            .build();
    }


    public Trip toEntity(TripDto dto) {
        return Trip.builder()
            .id(dto.getId())
            .name(dto.getName())
            .startDate(dto.getStartDate())
            .endDate(dto.getEndDate())
            .budget(dto.getBudget())
            .interests(dto.getInterests())
            .items(dto.getItems())
            .users(dto.getUsers())
            .build();
    }


}
