package com.superdevs.HealthOMeter.mappers;

import com.superdevs.HealthOMeter.dto.BioMetricHistoricalDataDto;
import com.superdevs.HealthOMeter.entity.BioMetricHistoricalData;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BioMetricHistoricalDataMapper {

    @Autowired
    private ModelMapper modelMapper;

    public BioMetricHistoricalData mapToBioMetricHistoricalData(final BioMetricHistoricalDataDto bioMetricHistoricalDataDto) {
        return modelMapper.map(bioMetricHistoricalDataDto, BioMetricHistoricalData.class);
    }

    public BioMetricHistoricalDataDto mapToBioMetricHistoricalDataDto(final BioMetricHistoricalData bioMetricHistoricalData) {
        return modelMapper.map(bioMetricHistoricalData, BioMetricHistoricalDataDto.class);
    }
}
