package com.superdevs.HealthOMeter.mappers;

import com.superdevs.HealthOMeter.dto.HistoricalMedicalDataDto;
import com.superdevs.HealthOMeter.dto.HistoricalMedicalDataDto;
import com.superdevs.HealthOMeter.entity.HistoricalMedicalData;
import com.superdevs.HealthOMeter.entity.HistoricalMedicalData;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

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

    public List<HistoricalMedicalData> mapToHistoricalMedicalDataList(final List<HistoricalMedicalDataDto> historicalMedicalDataDtoList) {
        return historicalMedicalDataDtoList.stream()
                .map(this::mapToHistoricalMedicalData)
                .collect(Collectors.toList());
    }

    public List<HistoricalMedicalDataDto> mapToHistoricalMedicalDataDtoList(final List<HistoricalMedicalData> historicalMedicalDataList) {
        return historicalMedicalDataList.stream()
                .map(this::mapToHistoricalMedicalDataDto)
                .collect(Collectors.toList());
    }
}