package com.superdevs.HealthOMeter.mappers;

import com.superdevs.HealthOMeter.dto.HistoricalCalculatorsResultsDto;
import com.superdevs.HealthOMeter.entity.HistoricalCalculatorsResults;
import org.springframework.stereotype.Component;

@Component
public class HistoricalCalculatorsResultsMapper {

    public HistoricalCalculatorsResults mapToHistoricalCalculatorsResults
            (final HistoricalCalculatorsResultsDto historicalCalculatorsResultsDto) {
        return new HistoricalCalculatorsResults(
                historicalCalculatorsResultsDto.getResult(),
                historicalCalculatorsResultsDto.isWHR(),
                historicalCalculatorsResultsDto.isBMI(),
                historicalCalculatorsResultsDto.isRFM(),
                historicalCalculatorsResultsDto.getContact());
    }

    public HistoricalCalculatorsResultsDto mapToHistoricalCalculatorsResultsDto
            (final HistoricalCalculatorsResults historicalCalculatorsResults) {
        return new HistoricalCalculatorsResultsDto(
                historicalCalculatorsResults.getResult(),
                historicalCalculatorsResults.isWHR(),
                historicalCalculatorsResults.isBMI(),
                historicalCalculatorsResults.isRFM(),
                historicalCalculatorsResults.getContact());
    }
}