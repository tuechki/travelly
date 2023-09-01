package com.sofia.uni.fmi.travelly.mapper;

import com.sofia.uni.fmi.travelly.dto.TripCreateDto;
import com.sofia.uni.fmi.travelly.dto.TripDto;
import com.sofia.uni.fmi.travelly.dto.TripListDto;
import com.sofia.uni.fmi.travelly.model.Trip;
import org.springframework.stereotype.Component;

@Component
public class TripMapper {

    public TripDto toDto(Trip entity) {
        return TripDto.builder()
                .id(entity.getId())
                .destination(entity.getDestination())
                .name(entity.getName())
                .startDate(entity.getStartDate())
                .endDate(entity.getEndDate())
                .budget(entity.getBudget())
                .interests(entity.getInterests())
                .items(entity.getItems())
                .build();
    }

    public TripListDto toListDto(Trip entity) {
        return TripListDto.builder()
                .name(entity.getName())
                .destination(entity.getDestination())
                .startDate(entity.getStartDate())
                .endDate(entity.getEndDate())
                .build();
    }


    public Trip toEntity(TripDto dto) {
        return Trip.builder()
                .id(dto.getId())
                .destination(dto.getDestination())
                .name(dto.getName())
                .startDate(dto.getStartDate())
                .endDate(dto.getEndDate())
                .budget(dto.getBudget())
                .interests(dto.getInterests())
                .items(dto.getItems())
//                .users(dto.getUsers())
                .build();
    }


    public Trip toEntity(TripCreateDto dto) {
        return Trip.builder()
            .destination(dto.getDestination())
            .name(dto.getName())
            .startDate(dto.getStartDate())
            .endDate(dto.getEndDate())
            .budget(dto.getBudget())
            .interests(dto.getInterests())
            .build();
    }



}
