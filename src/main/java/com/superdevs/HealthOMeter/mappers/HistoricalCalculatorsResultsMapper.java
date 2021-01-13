package com.superdevs.HealthOMeter.mappers;

import com.superdevs.HealthOMeter.dto.HistoricalCalculatorsResultsDto;
import com.superdevs.HealthOMeter.entity.HistoricalCalculatorsResults;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class HistoricalCalculatorsResultsMapper {

    @Autowired
    private ModelMapper modelMapper;

    public HistoricalCalculatorsResults mapToHistoricalCalculatorsResults
            (final HistoricalCalculatorsResultsDto historicalCalculatorsResultsDto) {
        return modelMapper.map(historicalCalculatorsResultsDto, HistoricalCalculatorsResults.class);
    }

    public HistoricalCalculatorsResultsDto mapToHistoricalCalculatorsResultsDto
            (final HistoricalCalculatorsResults historicalCalculatorsResults) {
        return modelMapper.map(historicalCalculatorsResults, HistoricalCalculatorsResultsDto.class);
    }
}