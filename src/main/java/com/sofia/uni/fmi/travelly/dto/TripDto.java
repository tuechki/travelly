package com.sofia.uni.fmi.travelly.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TripDto {

    private Long id;

    private String name;

    private String destination;

    private LocalDateTime startDate;

    private LocalDateTime endDate;

    private Double budget;

    private Set<String> interests;

    private List<Item> items;

    private Set<User> users;
}
