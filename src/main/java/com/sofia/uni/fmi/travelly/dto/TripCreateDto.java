package com.sofia.uni.fmi.travelly.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TripCreateDto {

    private String name;

    private String destination;

    private LocalDateTime startDate;

    private LocalDateTime endDate;

    private Double budget;

    private String interests;

}
