package com.sofia.uni.fmi.travelly.ActivityMapper;

import com.sofia.uni.fmi.travelly.dto.ActivityDto;
import com.sofia.uni.fmi.travelly.model.Activity;
import org.springframework.stereotype.Component;

@Component
public class ActivityMapper {
    public ActivityDto toDto(Activity activity) {
        return ActivityDto.builder()
                .id(activity.getId())
                .itinerary(activity.getItinerary())
                .activityType(activity.getActivityType())
                .activityLocation(activity.getActivityLocation())
                .startTime(activity.getStartTime())
                .endTime(activity.getEndTime())
                .description(activity.getDescription())
                .build();
    }

    public Activity toEntity(ActivityDto activityDto) {
        return Activity.builder()
                .id(activityDto.getId())
                .itinerary(activityDto.getItinerary())
                .activityType(activityDto.getActivityType())
                .activityLocation(activityDto.getActivityLocation())
                .startTime(activityDto.getStartTime())
                .endTime(activityDto.getEndTime())
                .description(activityDto.getDescription())
                .build();
    }
}
