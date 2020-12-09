package com.superdevs.HealthOMeter.mappers;

import com.superdevs.HealthOMeter.dto.HistoricalCalculatorsResultsDto;
import com.superdevs.HealthOMeter.entity.HistoricalCalculatorsResults;
import org.springframework.stereotype.Component;

@Component
public class HistoricalCalculatorsResultsMapper {

    public HistoricalCalculatorsResults mapToHistoricalCalculatorsResults
            (HistoricalCalculatorsResultsDto historicalCalculatorsResultsDto) {
        return new HistoricalCalculatorsResults();
    }

    public HistoricalCalculatorsResultsDto mapToHistoricalCalculatorsResultsDto
            (HistoricalCalculatorsResults historicalCalculatorsResults) {
        return new HistoricalCalculatorsResultsDto(
                historicalCalculatorsResults.getId(),
                historicalCalculatorsResults.getResult(),
                historicalCalculatorsResults.isWHR(),
                historicalCalculatorsResults.isBMI(),
                historicalCalculatorsResults.isRFM(),
                historicalCalculatorsResults.getContact());
    }
}