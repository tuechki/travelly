package com.sofia.uni.fmi.travelly.repository;

import com.sofia.uni.fmi.travelly.model.Accommodation;
import com.sofia.uni.fmi.travelly.model.Activity;
import com.sofia.uni.fmi.travelly.model.Itinerary;
import com.sofia.uni.fmi.travelly.model.TransportationOption;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransportationOptionRepository extends JpaRepository<TransportationOption, Long> {
    List<TransportationOption> findAllByItinerary(Itinerary itinerary);

    void deleteByItinerary(Itinerary itinerary);

    @Query("SELECT a FROM TransportationOption a WHERE a.price <= :budget")
    List<TransportationOption> findTransportationOptionsByCriteria(@Param("budget") Double budget);
}
