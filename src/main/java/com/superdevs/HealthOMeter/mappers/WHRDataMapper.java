package com.superdevs.HealthOMeter.mappers;

import com.superdevs.HealthOMeter.dto.WHRDataDto;
import com.superdevs.HealthOMeter.entity.WHRData;
import org.springframework.stereotype.Component;

@Component
public class WHRDataMapper {

    public WHRData mapToWHRData(WHRDataDto whrDataDto) {
        return new WHRData();
    }

    public WHRDataDto mapToWHRDataDto(WHRData whrData) {
        return new
                WHRDataDto(
                whrData.getId(),
                whrData.getWaistSize(),
                whrData.getHipSize(),
                whrData.getResult(),
                whrData.getContact());
    }
}