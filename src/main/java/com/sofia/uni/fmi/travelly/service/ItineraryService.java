package com.sofia.uni.fmi.travelly.service;

import com.sofia.uni.fmi.travelly.model.Itinerary;
import com.sofia.uni.fmi.travelly.repository.ItineraryRepository;
import org.springframework.stereotype.Service;

@Service
public class ItineraryService {
    private ItineraryRepository itineraryRepository;

    public ItineraryService(ItineraryRepository itineraryRepository) {
        this.itineraryRepository = itineraryRepository;
    }

    public Itinerary updateItinerary(Itinerary itinerary) {
        Itinerary updatedItinerary = itineraryRepository.save(itinerary);

        return updatedItinerary;
    }

    public void deleteItinerary(Long itineraryId) {
        itineraryRepository.deleteById(itineraryId);
    }
}
