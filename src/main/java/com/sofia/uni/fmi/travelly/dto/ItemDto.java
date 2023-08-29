package com.sofia.uni.fmi.travelly.dto;

import com.sofia.uni.fmi.travelly.model.Trip;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ItemDto {
    private Long id;
    private Trip trip;
    private String name;
    private String description;
    private Double amount;
    private boolean isPacked;
}
