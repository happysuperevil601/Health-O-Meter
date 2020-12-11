package com.superdevs.HealthOMeter.mappers;

import com.superdevs.HealthOMeter.dto.BioMetricDataDto;
import com.superdevs.HealthOMeter.entity.BioMetricData;
import org.springframework.stereotype.Component;

@Component
public class BioMetricDataMapper {

    public BioMetricData mapToBioMetricData(final BioMetricDataDto bioMetricDataDto) {
        return new BioMetricData(
                bioMetricDataDto.getId(),
                bioMetricDataDto.getGrowth(),
                bioMetricDataDto.getWeight(),
                bioMetricDataDto.getWaistCirc(),
                bioMetricDataDto.getHipCirc(),
                bioMetricDataDto.getContact());
    }

    public BioMetricDataDto mapToBioMetricDataDto(final BioMetricData bioMetricData) {
        return new BioMetricDataDto(
                bioMetricData.getId(),
                bioMetricData.getGrowth(),
                bioMetricData.getWeight(),
                bioMetricData.getWaistCirc(),
                bioMetricData.getHipCirc(),
                bioMetricData.getContact());
    }
}