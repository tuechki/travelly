package com.sofia.uni.fmi.travelly.service;

import com.sofia.uni.fmi.travelly.model.TransportationOption;
import com.sofia.uni.fmi.travelly.repository.TransportationOptionRepository;
import org.springframework.stereotype.Service;

@Service
public class TransportationOptionService {
    private TransportationOptionRepository transportationOptionRepository;

    public TransportationOptionService(TransportationOptionRepository transportationOptionRepository) {
        this.transportationOptionRepository = transportationOptionRepository;
    }

    public TransportationOption updateTransportationOption(TransportationOption transportationOption) {
        TransportationOption updatedTransportationOption = transportationOptionRepository.save(transportationOption);

        return updatedTransportationOption;
    }

    public void deleteTransportationOption(Long transportationOptionId) {
        transportationOptionRepository.deleteById(transportationOptionId);
    }
}
