package com.sofia.uni.fmi.travelly.dto;

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
    private String desc;
    private Double amount;
    private boolean isPacked;
}
