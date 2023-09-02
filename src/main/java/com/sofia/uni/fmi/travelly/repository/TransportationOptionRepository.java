package com.sofia.uni.fmi.travelly.repository;

import com.sofia.uni.fmi.travelly.model.Itinerary;
import com.sofia.uni.fmi.travelly.model.TransportationOption;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransportationOptionRepository extends JpaRepository<TransportationOption, Long> {
    List<TransportationOption> findAllByItinerary(Itinerary itinerary);

    void deleteByItinerary(Itinerary itinerary);
}
