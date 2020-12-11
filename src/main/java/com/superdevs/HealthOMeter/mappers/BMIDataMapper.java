package com.superdevs.HealthOMeter.mappers;

import com.superdevs.HealthOMeter.dto.BMIDataDto;
import com.superdevs.HealthOMeter.entity.BMIData;
import org.springframework.stereotype.Component;

@Component
public class BMIDataMapper {

    public BMIData mapToBMIData(final BMIDataDto bmiDataDto) {
        return new BMIData(
                bmiDataDto.getId(),
                bmiDataDto.getHeight(),
                bmiDataDto.getWeight(),
                bmiDataDto.getResult(),
                bmiDataDto.getContact());
    }

    public BMIDataDto mapToBMIDataDto(final BMIData bmiData) {
        return new BMIDataDto(
                bmiData.getId(),
                bmiData.getHeight(),
                bmiData.getWeight(),
                bmiData.getResult(),
                bmiData.getContact());
    }
}
