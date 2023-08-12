package com.sofia.uni.fmi.travelly.service;

import com.sofia.uni.fmi.travelly.model.Accommodation;
import com.sofia.uni.fmi.travelly.repository.AccommodationRepository;
import org.springframework.stereotype.Service;

@Service
public class AccommodationService {
    private AccommodationRepository accommodationRepository;

    public AccommodationService(AccommodationRepository accommodationRepository) {
        this.accommodationRepository = accommodationRepository;
    }

    public Accommodation updateAccommodation(Accommodation accommodation) {
        Accommodation updatedAccommodation = accommodationRepository.save(accommodation);

        return updatedAccommodation;
    }

    public void deleteAccommodation(Long accommodationId) {
        accommodationRepository.deleteById(accommodationId);
    }
}
