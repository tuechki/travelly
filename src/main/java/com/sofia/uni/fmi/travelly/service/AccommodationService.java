package com.sofia.uni.fmi.travelly.service;

import com.sofia.uni.fmi.travelly.dto.AccommodationCreateUpdateDto;
import com.sofia.uni.fmi.travelly.mapper.AccommodationMapper;
import com.sofia.uni.fmi.travelly.model.Accommodation;
import com.sofia.uni.fmi.travelly.model.Itinerary;
import com.sofia.uni.fmi.travelly.repository.AccommodationRepository;
import com.sofia.uni.fmi.travelly.repository.ItineraryRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AccommodationService {
    private AccommodationRepository accommodationRepository;
    private ItineraryRepository itineraryRepository;
    private AccommodationMapper accommodationMapper;

    public AccommodationService(
            AccommodationRepository accommodationRepository,
            ItineraryRepository itineraryRepository,
            AccommodationMapper accommodationMapper) {
        this.accommodationRepository = accommodationRepository;
        this.itineraryRepository = itineraryRepository;
        this.accommodationMapper = accommodationMapper;
    }

    public List<Accommodation> getAccommodationsByItineraryId(Long itineraryId) {
        return accommodationRepository.findAllByItinerary(itineraryRepository.findById(itineraryId).get());
    }


    public Long addAccommodation(AccommodationCreateUpdateDto accommodationCreateUpdateDto, Long itineraryId) {
        Accommodation newAccommodation = accommodationMapper.toEntity(accommodationCreateUpdateDto);
        Itinerary itinerary = itineraryRepository.findById(itineraryId).get();
        newAccommodation.setItinerary(itinerary);
        Accommodation savedAccommodation = accommodationRepository.save(newAccommodation);

        return savedAccommodation.getId();
    }

    @Transactional
    public void deleteAllAccommodations(Long itineraryId) {
        Itinerary itinerary = itineraryRepository.findById(itineraryId).get();
        accommodationRepository.deleteByItinerary(itinerary);
    }

    public Accommodation updateAccommodation(Accommodation accommodation) {
        Accommodation existingAccommodation = accommodationRepository.findById(accommodation.getId()).get();
        accommodation.setItinerary(existingAccommodation.getItinerary());

        return accommodationRepository.save(accommodation);
    }

    public void deleteAccommodation(Long accommodationId) {
        accommodationRepository.deleteById(accommodationId);
    }
}
