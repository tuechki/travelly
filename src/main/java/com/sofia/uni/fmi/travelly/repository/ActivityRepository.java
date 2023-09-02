package com.sofia.uni.fmi.travelly.repository;

import com.sofia.uni.fmi.travelly.model.Activity;
import com.sofia.uni.fmi.travelly.model.Itinerary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ActivityRepository extends JpaRepository<Activity, Long> {
    List<Activity> findAllByItinerary(Itinerary itinerary);
    void deleteByItinerary(Itinerary itinerary);

    @Query("SELECT a FROM Activity a WHERE " +
            "(a.activityLocation = :tripActivityLocation OR a.description LIKE CONCAT('%', :tripInterest, '%')) " +
            "AND a.startTime > :startTime " +
            "AND a.endTime < :endTime " +
            "AND (a.activityType = :filterActivityType OR :filterActivityType = -1)" +
            "AND (a.activityLocation = :filterActivityLocation OR :filterActivityLocation = '')" +
            "AND (a.description = :filterActivityDescription OR :filterActivityDescription = '')")
    List<Activity> findActivitiesByCriteria(
            @Param("tripActivityLocation") String tripActivityLocation,
            @Param("startTime") LocalDateTime startTime,
            @Param("endTime") LocalDateTime endTime,
            @Param("tripInterest") String tripInterest,
            @Param("filterActivityType") Integer filterActivityType,
            @Param("filterActivityLocation") String filterActivityLocation,
            @Param("filterActivityDescription") String filterActivityDescription);
}
