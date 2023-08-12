package com.sofia.uni.fmi.travelly.dto;

import com.sofia.uni.fmi.travelly.model.ActivityType;
import com.sofia.uni.fmi.travelly.model.Itinerary;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ActivityDto {
    private Long id;
    private Itinerary itinerary;
    private ActivityType activityType;
    private String activityLocation;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private String description;
}
