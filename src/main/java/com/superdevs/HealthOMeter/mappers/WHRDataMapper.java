package com.superdevs.HealthOMeter.mappers;

import com.superdevs.HealthOMeter.dto.WHRDataDto;
import com.superdevs.HealthOMeter.dto.WHRDataDto;
import com.superdevs.HealthOMeter.entity.WHRData;
import com.superdevs.HealthOMeter.entity.WHRData;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class WHRDataMapper {

    @Autowired
    private ModelMapper modelMapper;

    public WHRData mapToWHRData(final WHRDataDto whrDataDto) {
        return modelMapper.map(whrDataDto, WHRData.class);
    }

    public WHRDataDto mapToWHRDataDto(final WHRData whrData) {
        return modelMapper.map(whrData, WHRDataDto.class);
    }

    public List<WHRData> mapToWHRDataList(final List<WHRDataDto> wHRDataDtoList) {
        return wHRDataDtoList.stream()
                .map(this::mapToWHRData)
                .collect(Collectors.toList());
    }

    public List<WHRDataDto> mapToWHRDataDtoList(final List<WHRData> wHRDataList) {
        return wHRDataList.stream()
                .map(this::mapToWHRDataDto)
                .collect(Collectors.toList());
    }
}