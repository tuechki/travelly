package com.sofia.uni.fmi.travelly.controller;

import com.sofia.uni.fmi.travelly.mapper.ActivityMapper;
import com.sofia.uni.fmi.travelly.dto.ActivityDto;
import com.sofia.uni.fmi.travelly.model.Activity;
import com.sofia.uni.fmi.travelly.service.ActivityService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("trips")
public class ActivityController {
    private ActivityService activityService;
    private ActivityMapper activityMapper;

    public ActivityController(ActivityService activityService, ActivityMapper activityMapper) {
        this.activityService = activityService;
        this.activityMapper = activityMapper;
    }

    @PutMapping("{activityId}")
    public ActivityDto updateActivity(@RequestParam Long activityId, @RequestBody ActivityDto activityDto) {
        Activity activity = activityMapper.toEntity(activityDto);
        activity.setId(activityId);
        Activity updatedActivity = activityService.updateActivity(activity);
        ActivityDto updatedActivityDto = activityMapper.toDto(updatedActivity);

        return updatedActivityDto;
    }

    @DeleteMapping("{activityId}")
    public void deleteActivity(@RequestParam Long activityId) {
        activityService.deleteActivity(activityId);
    }
}
