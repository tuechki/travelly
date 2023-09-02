package com.sofia.uni.fmi.travelly.service;

import com.sofia.uni.fmi.travelly.dto.AccommodationCreateUpdateDto;
import com.sofia.uni.fmi.travelly.dto.ActivityCreateUpdateDto;
import com.sofia.uni.fmi.travelly.mapper.AccommodationMapper;
import com.sofia.uni.fmi.travelly.model.Accommodation;
import com.sofia.uni.fmi.travelly.model.Activity;
import com.sofia.uni.fmi.travelly.model.Itinerary;
import com.sofia.uni.fmi.travelly.repository.AccommodationRepository;
import com.sofia.uni.fmi.travelly.repository.ItineraryRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
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

    public List<Long> addAccommodations(
            List<AccommodationCreateUpdateDto> accommodationCreateUpdateDtoList, Long itineraryId) {
        List<Long> savedAccommodationsIds = new ArrayList<>();

        for(AccommodationCreateUpdateDto accommodationCreateUpdateDto : accommodationCreateUpdateDtoList) {
            Accommodation newAccommodation = accommodationMapper.toEntity(accommodationCreateUpdateDto);
            Itinerary itinerary = itineraryRepository.findById(itineraryId).get();
            newAccommodation.setItinerary(itinerary);
            Accommodation savedAccommodation = accommodationRepository.save(newAccommodation);

            savedAccommodationsIds.add(savedAccommodation.getId());
        }

        return savedAccommodationsIds;
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
