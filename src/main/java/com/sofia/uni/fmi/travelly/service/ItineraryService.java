package com.sofia.uni.fmi.travelly.service;

import com.sofia.uni.fmi.travelly.model.Itinerary;
import com.sofia.uni.fmi.travelly.repository.ItineraryRepository;
import org.springframework.stereotype.Service;

@Service
public class ItineraryService {
    private ItineraryRepository itineraryRepository;
    private ItineraryMapper itineraryMapper;
    private TripRepository tripRepository;

    public ItineraryService(ItineraryRepository itineraryRepository,
                            TripRepository tripRepository,
                            ItineraryMapper itineraryMapper) {
        this.itineraryRepository = itineraryRepository;
        this.tripRepository = tripRepository;
        this.itineraryMapper = itineraryMapper;
    }

    public Itinerary updateItinerary(Itinerary itinerary) {
        Itinerary existingItinerary = itineraryRepository.findById(itinerary.getId()).get();
        itinerary.setTrip(existingItinerary.getTrip());
        itinerary.setActivities(existingItinerary.getActivities());
        itinerary.setAccommodations(existingItinerary.getAccommodations());
        itinerary.setTransportationOptions(existingItinerary.getTransportationOptions());

        return itineraryRepository.save(itinerary);
    }

    public void deleteItinerary(Long itineraryId) {
        itineraryRepository.deleteById(itineraryId);
    }
}
