package com.superdevs.HealthOMeter.mappers;

import com.superdevs.HealthOMeter.dto.HistoricalCalculatorsResultsDto;
import com.superdevs.HealthOMeter.dto.HistoricalCalculatorsResultsDto;
import com.superdevs.HealthOMeter.entity.HistoricalCalculatorsResults;
import com.superdevs.HealthOMeter.entity.HistoricalCalculatorsResults;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

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

    public List<HistoricalCalculatorsResults> mapToHistoricalCalculatorsResultsList(final List<HistoricalCalculatorsResultsDto> historicalCalculatorsResultsDtoList) {
        return historicalCalculatorsResultsDtoList.stream()
                .map(this::mapToHistoricalCalculatorsResults)
                .collect(Collectors.toList());
    }

    public List<HistoricalCalculatorsResultsDto> mapToHistoricalCalculatorsResultsDtoList(final List<HistoricalCalculatorsResults> historicalCalculatorsResultsList) {
        return historicalCalculatorsResultsList.stream()
                .map(this::mapToHistoricalCalculatorsResultsDto)
                .collect(Collectors.toList());
    }
}