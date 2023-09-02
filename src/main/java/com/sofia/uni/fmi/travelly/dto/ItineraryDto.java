package com.sofia.uni.fmi.travelly.dto;

import com.sofia.uni.fmi.travelly.model.Trip;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ItineraryDto {
    private Long id;
    private int dayNum;
}
