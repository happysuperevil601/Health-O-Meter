package com.superdevs.HealthOMeter.mappers;

import com.superdevs.HealthOMeter.dto.BioMetricDataDto;
import com.superdevs.HealthOMeter.entity.BioMetricData;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BioMetricDataMapper {

    @Autowired
    private ModelMapper modelMapper;

    public BioMetricData mapToBioMetricData(final BioMetricDataDto bioMetricDataDto) {
        return modelMapper.map(bioMetricDataDto, BioMetricData.class);
    }

    public BioMetricDataDto mapToBioMetricDataDto(final BioMetricData bioMetricData) {
        return modelMapper.map(bioMetricData, BioMetricDataDto.class);
    }
}