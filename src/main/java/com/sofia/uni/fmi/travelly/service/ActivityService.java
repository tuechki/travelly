package com.sofia.uni.fmi.travelly.service;
import com.sofia.uni.fmi.travelly.dto.ActivityCreateUpdateDto;
import com.sofia.uni.fmi.travelly.mapper.ActivityMapper;
import com.sofia.uni.fmi.travelly.model.Activity;
import com.sofia.uni.fmi.travelly.model.Itinerary;
import com.sofia.uni.fmi.travelly.repository.ActivityRepository;
import com.sofia.uni.fmi.travelly.repository.ItineraryRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class ActivityService {
    private ActivityRepository activityRepository;
    private ItineraryRepository itineraryRepository;
    private ActivityMapper activityMapper;

    public ActivityService(
            ActivityRepository activityRepository,
            ItineraryRepository itineraryRepository,
            ActivityMapper activityMapper) {
        this.activityRepository = activityRepository;
        this.itineraryRepository = itineraryRepository;
        this.activityMapper = activityMapper;
    }

    public List<Activity> getActivitiesByItineraryId(Long itineraryId) {
        return activityRepository.findAllByItinerary(itineraryRepository.findById(itineraryId).get());
    }


    public List<Long> addActivities(List<ActivityCreateUpdateDto> activityCreateUpdateDtoList, Long itineraryId) {
        List<Long> savedActivitiesIds = new ArrayList<>();

        for(ActivityCreateUpdateDto activityCreateUpdateDto : activityCreateUpdateDtoList) {
            Activity newActivity = activityMapper.toEntity(activityCreateUpdateDto);
            Itinerary itinerary = itineraryRepository.findById(itineraryId).get();
            newActivity.setItinerary(itinerary);
            Activity savedActivity = activityRepository.save(newActivity);

            savedActivitiesIds.add(savedActivity.getId());
        }

        return savedActivitiesIds;
    }

    @Transactional
    public void deleteAllActivities(Long itineraryId) {
        Itinerary itinerary = itineraryRepository.findById(itineraryId).get();
        activityRepository.deleteByItinerary(itinerary);
    }

    public Activity updateActivity(Activity activity) {
        Activity existingActivity = activityRepository.findById(activity.getId()).get();
        activity.setItinerary(existingActivity.getItinerary());

        return activityRepository.save(activity);
    }

    public void deleteActivity(Long activityId) {
        activityRepository.deleteById(activityId);
    }
}
