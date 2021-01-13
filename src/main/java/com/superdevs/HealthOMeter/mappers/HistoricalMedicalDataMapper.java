package com.superdevs.HealthOMeter.mappers;

import com.superdevs.HealthOMeter.dto.HistoricalMedicalDataDto;
import com.superdevs.HealthOMeter.entity.HistoricalMedicalData;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class HistoricalMedicalDataMapper {

    @Autowired
    private ModelMapper modelMapper;

    public HistoricalMedicalData mapToHistoricalMedicalData(final HistoricalMedicalDataDto historicalMedicalDataDto){
        return modelMapper.map(historicalMedicalDataDto, HistoricalMedicalData.class);
    }

    public HistoricalMedicalDataDto mapToHistoricalMedicalDataDto(final HistoricalMedicalData historicalMedicalData){
        return modelMapper.map(historicalMedicalData, HistoricalMedicalDataDto.class);
    }
}