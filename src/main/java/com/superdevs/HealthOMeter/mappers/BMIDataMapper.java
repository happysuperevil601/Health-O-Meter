package com.superdevs.HealthOMeter.mappers;

import com.superdevs.HealthOMeter.dto.BMIDataDto;
import com.superdevs.HealthOMeter.entity.BMIData;
import org.springframework.stereotype.Component;

@Component
public class BMIDataMapper {

    public BMIData mapToBMIData(BMIDataDto bmiDataDto) {
        return new BMIData();
    }

    public BMIDataDto mapToBMIDataDto(BMIData bmiData) {
        return new BMIDataDto(
                bmiData.getId(),
                bmiData.getResult(),
                bmiData.getContact());
    }
}
