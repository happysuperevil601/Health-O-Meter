package com.superdevs.HealthOMeter.mappers;

import com.superdevs.HealthOMeter.dto.BMIDataDto;
import com.superdevs.HealthOMeter.entity.BMIData;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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
}
