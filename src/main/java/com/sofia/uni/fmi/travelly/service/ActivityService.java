package com.sofia.uni.fmi.travelly.service;
import com.sofia.uni.fmi.travelly.model.Activity;
import com.sofia.uni.fmi.travelly.repository.ActivityRepository;
import org.springframework.stereotype.Service;

@Service
public class ActivityService {
    private ActivityRepository activityRepository;

    public ActivityService(ActivityRepository activityRepository) {
        this.activityRepository = activityRepository;
    }
    public Activity updateActivityById(Long activityId, Activity activity) {
        activity.setId(activityId);
        Activity savedActivity = activityRepository.save(activity);

        return savedActivity;
    }

    public void deleteActivityById(Long activityId) {
        activityRepository.deleteById(activityId);
    }
}
