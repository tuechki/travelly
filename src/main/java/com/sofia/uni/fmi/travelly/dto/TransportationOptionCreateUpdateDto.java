package com.sofia.uni.fmi.travelly.dto;

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
public class TransportationOptionCreateUpdateDto {
    private TransportationOptionType type;
    private LocalDateTime duration;
    private Double price;
}
