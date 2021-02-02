package com.superdevs.HealthOMeter.mappers;

import com.superdevs.HealthOMeter.dto.BioMetricDataDto;
import com.superdevs.HealthOMeter.dto.BioMetricDataDto;
import com.superdevs.HealthOMeter.entity.BioMetricData;
import com.superdevs.HealthOMeter.entity.BioMetricData;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

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

    public List<BioMetricData> mapToBioMetricDataList(final List<BioMetricDataDto> bioMetricDataDtoList) {
        return bioMetricDataDtoList.stream()
                .map(this::mapToBioMetricData)
                .collect(Collectors.toList());
    }

    public List<BioMetricDataDto> mapToBioMetricDataDtoList(final List<BioMetricData> bioMetricDataList) {
        return bioMetricDataList.stream()
                .map(this::mapToBioMetricDataDto)
                .collect(Collectors.toList());
    }
}