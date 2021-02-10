package com.superdevs.HealthOMeter.mappers;

import com.superdevs.HealthOMeter.dto.BioMetricHistoricalDataDto;
import com.superdevs.HealthOMeter.dto.BioMetricHistoricalDataDto;
import com.superdevs.HealthOMeter.entity.BioMetricHistoricalData;
import com.superdevs.HealthOMeter.entity.BioMetricHistoricalData;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

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

    public List<BioMetricHistoricalData> mapToBioMetricHistoricalDataList(final List<BioMetricHistoricalDataDto> bioMetricHistoricalDataDtoList) {
        return bioMetricHistoricalDataDtoList.stream()
                .map(this::mapToBioMetricHistoricalData)
                .collect(Collectors.toList());
    }

    public List<BioMetricHistoricalDataDto> mapToBioMetricHistoricalDataDtoList(final List<BioMetricHistoricalData> bioMetricHistoricalDataList) {
        return bioMetricHistoricalDataList.stream()
                .map(this::mapToBioMetricHistoricalDataDto)
                .collect(Collectors.toList());
    }
}
