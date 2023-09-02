package com.sofia.uni.fmi.travelly.service;

import com.sofia.uni.fmi.travelly.dto.TransportationOptionCreateUpdateDto;
import com.sofia.uni.fmi.travelly.mapper.TransportationOptionMapper;
import com.sofia.uni.fmi.travelly.model.TransportationOption;
import com.sofia.uni.fmi.travelly.model.Itinerary;
import com.sofia.uni.fmi.travelly.repository.TransportationOptionRepository;
import com.sofia.uni.fmi.travelly.repository.ItineraryRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TransportationOptionService {
    private TransportationOptionRepository transportationOptionRepository;
    private ItineraryRepository itineraryRepository;
    private TransportationOptionMapper transportationOptionMapper;

    public TransportationOptionService(
            TransportationOptionRepository transportationOptionRepository,
            ItineraryRepository itineraryRepository,
            TransportationOptionMapper transportationOptionMapper) {
        this.transportationOptionRepository = transportationOptionRepository;
        this.itineraryRepository = itineraryRepository;
        this.transportationOptionMapper = transportationOptionMapper;
    }

    public List<TransportationOption> getTransportationOptionsByItineraryId(Long itineraryId) {
        return transportationOptionRepository.findAllByItinerary(itineraryRepository.findById(itineraryId).get());
    }


    public Long addTransportationOption(TransportationOptionCreateUpdateDto transportationOptionCreateUpdateDto, Long itineraryId) {
        TransportationOption newTransportationOption =
                transportationOptionMapper.toEntity(transportationOptionCreateUpdateDto);
        Itinerary itinerary = itineraryRepository.findById(itineraryId).get();
        newTransportationOption.setItinerary(itinerary);
        TransportationOption savedTransportationOption = transportationOptionRepository.save(newTransportationOption);

        return savedTransportationOption.getId();
    }

    @Transactional
    public void deleteAllTransportationOptions(Long itineraryId) {
        Itinerary itinerary = itineraryRepository.findById(itineraryId).get();
        transportationOptionRepository.deleteByItinerary(itinerary);
    }

    public TransportationOption updateTransportationOption(TransportationOption transportationOption) {
        TransportationOption existingTransportationOption = transportationOptionRepository.findById(transportationOption.getId()).get();
        transportationOption.setItinerary(existingTransportationOption.getItinerary());

        return transportationOptionRepository.save(transportationOption);
    }

    public void deleteTransportationOption(Long transportationOptionId) {
        transportationOptionRepository.deleteById(transportationOptionId);
    }
}
