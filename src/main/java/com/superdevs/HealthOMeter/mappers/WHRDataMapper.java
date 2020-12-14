package com.superdevs.HealthOMeter.mappers;

import com.superdevs.HealthOMeter.dto.WHRDataDto;
import com.superdevs.HealthOMeter.entity.WHRData;
import org.springframework.stereotype.Component;

@Component
public class WHRDataMapper {

    public WHRData mapToWHRData(final WHRDataDto whrDataDto) {
        return new WHRData(
                whrDataDto.getWaistSize(),
                whrDataDto.getHipSize(),
                whrDataDto.getResult(),
                whrDataDto.getContact());
    }

    public WHRDataDto mapToWHRDataDto(final WHRData whrData) {
        return new
                WHRDataDto(
                whrData.getWaistSize(),
                whrData.getHipSize(),
                whrData.getResult(),
                whrData.getContact());
    }
}