package com.sofia.uni.fmi.travelly.dto;

import com.sofia.uni.fmi.travelly.model.ActivityType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ActivityCreateUpdateDto {
    private ActivityType type;
    private String location;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private String description;
}
