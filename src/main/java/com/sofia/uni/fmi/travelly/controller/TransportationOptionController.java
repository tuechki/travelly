package com.sofia.uni.fmi.travelly.controller;

import com.sofia.uni.fmi.travelly.dto.TransportationOptionDto;
import com.sofia.uni.fmi.travelly.mapper.TransportationOptionMapper;
import com.sofia.uni.fmi.travelly.model.TransportationOption;
import com.sofia.uni.fmi.travelly.service.TransportationOptionService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("transportationOption")
public class TransportationOptionController {
    private TransportationOptionService transportationOptionService;
    private TransportationOptionMapper transportationOptionMapper;

    public TransportationOptionController(
            TransportationOptionService transportationOptionService,
            TransportationOptionMapper transportationOptionMapper) {
        this.transportationOptionService = transportationOptionService;
        this.transportationOptionMapper = transportationOptionMapper;
    }

    @PutMapping("{transportationOptionId}")
    public TransportationOptionDto updateTransportationOption(
            @PathVariable Long transportationOptionId, @RequestBody transportationOptionDto) {
        TransportationOption transportationOption = transportationOptionMapper.toEntity(transportationOptionDto);
        transportationOption.setId(transportationOptionId);
        TransportationOption updatedTransportationOption =
                transportationOptionService.updateTransportationOption(transportationOption);
        TransportationOptionDto updatedTransportationOptionDto =
                transportationOptionMapper.toDto(updatedTransportationOption);

        return updatedTransportationOptionDto;
    }

    @DeleteMapping("{transportationOptionId}")
    public void deleteTransportationOption(@PathVariable Long transportationOptionId) {
        transportationOptionService.deleteTransportationOption(transportationOptionId);
    }
}
