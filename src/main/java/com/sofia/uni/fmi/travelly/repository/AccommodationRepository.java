package com.sofia.uni.fmi.travelly.repository;

import com.sofia.uni.fmi.travelly.model.Accommodation;
import com.sofia.uni.fmi.travelly.model.Itinerary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccommodationRepository extends JpaRepository<Accommodation, Long> {
    List<Accommodation> findAllByItinerary(Itinerary itinerary);
    void deleteByItinerary(Itinerary itinerary);
}
