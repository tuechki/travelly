package com.sofia.uni.fmi.travelly.mapper;

import com.sofia.uni.fmi.travelly.dto.ActivityCreateUpdateDto;
import com.sofia.uni.fmi.travelly.dto.ActivityDto;
import com.sofia.uni.fmi.travelly.dto.ActivityMapDto;
import com.sofia.uni.fmi.travelly.model.Activity;
import org.springframework.stereotype.Component;

@Component
public class ActivityMapper {
    public ActivityDto toDto(Activity activity) {
        return ActivityDto.builder()
                .id(activity.getId())
                .type(activity.getType())
                .location(activity.getLocation())
                .startTime(activity.getStartTime())
                .endTime(activity.getEndTime())
                .description(activity.getDescription())
                .latitude(activity.getLatitude())
                .longitude(activity.getLongitude())
                .build();
    }

    public Activity toEntity(ActivityDto activityDto) {
        return Activity.builder()
                .id(activityDto.getId())
                .type(activityDto.getType())
                .location(activityDto.getLocation())
                .startTime(activityDto.getStartTime())
                .endTime(activityDto.getEndTime())
                .description(activityDto.getDescription())
                .latitude(activityDto.getLatitude())
                .longitude(activityDto.getLongitude())
                .build();
    }

    public ActivityCreateUpdateDto toCreateUpdateDto(Activity activity) {
        return ActivityCreateUpdateDto.builder()
                .type(activity.getType())
                .location(activity.getLocation())
                .startTime(activity.getStartTime())
                .endTime(activity.getEndTime())
                .description(activity.getDescription())
                .latitude(activity.getLatitude())
                .longitude(activity.getLongitude())
                .build();
    }

    public Activity toEntity(ActivityCreateUpdateDto activityCreateUpdateDto) {
        return Activity.builder()
                .type(activityCreateUpdateDto.getType())
                .location(activityCreateUpdateDto.getLocation())
                .startTime(activityCreateUpdateDto.getStartTime())
                .endTime(activityCreateUpdateDto.getEndTime())
                .description(activityCreateUpdateDto.getDescription())
                .latitude(activityCreateUpdateDto.getLatitude())
                .longitude(activityCreateUpdateDto.getLongitude())
                .build();
    }

    public ActivityMapDto toMapDto(Activity activity) {
        return ActivityMapDto.builder()
                .type(activity.getType())
                .location(activity.getLocation())
                .startTime(activity.getStartTime())
                .endTime(activity.getEndTime())
                .latitude(activity.getLatitude())
                .longitude(activity.getLongitude())
                .build();
    }
}
