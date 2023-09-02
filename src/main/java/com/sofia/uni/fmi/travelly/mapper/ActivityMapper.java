package com.sofia.uni.fmi.travelly.mapper;

import com.sofia.uni.fmi.travelly.dto.ActivityCreateUpdateDto;
import com.sofia.uni.fmi.travelly.dto.ActivityDto;
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
                .build();
    }

    public ActivityCreateUpdateDto toCreateUpdateDto(Activity activity) {
        return ActivityCreateUpdateDto.builder()
                .type(activity.getType())
                .location(activity.getLocation())
                .startTime(activity.getStartTime())
                .endTime(activity.getEndTime())
                .description(activity.getDescription())
                .build();
    }

    public Activity toEntity(ActivityCreateUpdateDto activityCreateUpdateDto) {
        return Activity.builder()
                .type(activityCreateUpdateDto.getType())
                .location(activityCreateUpdateDto.getLocation())
                .startTime(activityCreateUpdateDto.getStartTime())
                .endTime(activityCreateUpdateDto.getEndTime())
                .description(activityCreateUpdateDto.getDescription())
                .build();
    }
}
