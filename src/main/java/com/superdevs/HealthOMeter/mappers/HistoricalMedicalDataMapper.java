package com.superdevs.HealthOMeter.mappers;

import com.superdevs.HealthOMeter.dto.HistoricalMedicalDataDto;
import com.superdevs.HealthOMeter.entity.HistoricalMedicalData;
import org.springframework.stereotype.Component;

@Component
public class HistoricalMedicalDataMapper {

    public HistoricalMedicalData mapToHistoricalMedicalData(HistoricalMedicalDataDto historicalMedicalDataDto){
        return new HistoricalMedicalData();
    }

    public HistoricalMedicalDataDto mapToHistoricalMedicalDataDto(HistoricalMedicalData historicalMedicalData){
        return new HistoricalMedicalDataDto(
                historicalMedicalData.getId(),
                historicalMedicalData.getContact());
    }
}