package com.sofia.uni.fmi.travelly.repository;

import com.sofia.uni.fmi.travelly.model.Activity;
import com.sofia.uni.fmi.travelly.model.Itinerary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActivityRepository extends JpaRepository<Activity, Long> {
    List<Activity> findAllByItinerary(Itinerary itinerary);
    void deleteByItinerary(Itinerary itinerary);
}
