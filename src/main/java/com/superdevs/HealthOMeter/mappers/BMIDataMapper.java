package com.superdevs.HealthOMeter.mappers;

import com.superdevs.HealthOMeter.dto.BMIDataDto;
import com.superdevs.HealthOMeter.dto.BMIDataDto;
import com.superdevs.HealthOMeter.entity.BMIData;
import com.superdevs.HealthOMeter.entity.BMIData;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class BMIDataMapper {

    @Autowired
    private ModelMapper modelMapper;

    public BMIData mapToBMIData(final BMIDataDto bmiDataDto) {
        return modelMapper.map(bmiDataDto, BMIData.class);
    }

    public BMIDataDto mapToBMIDataDto(final BMIData bmiData) {
        return modelMapper.map(bmiData, BMIDataDto.class);
    }

    public List<BMIData> mapToBMIDataList(final List<BMIDataDto> bMIDataDtoList) {
        return bMIDataDtoList.stream()
                .map(this::mapToBMIData)
                .collect(Collectors.toList());
    }

    public List<BMIDataDto> mapToBMIDataDtoList(final List<BMIData> bMIDataList) {
        return bMIDataList.stream()
                .map(this::mapToBMIDataDto)
                .collect(Collectors.toList());
    }
}
