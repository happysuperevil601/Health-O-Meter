package com.superdevs.HealthOMeter.mappers;

import com.superdevs.HealthOMeter.dto.BioMetricHistoricalDataDto;
import com.superdevs.HealthOMeter.entity.BioMetricHistoricalData;
import org.springframework.stereotype.Component;

@Component
public class BioMetricHistoricalDataMapper {

    public BioMetricHistoricalData mapToBioMetricHistoricalData(final BioMetricHistoricalDataDto bioMetricHistoricalDataDto) {
        return new BioMetricHistoricalData(
                bioMetricHistoricalDataDto.getGrowth(),
                bioMetricHistoricalDataDto.getWeight(),
                bioMetricHistoricalDataDto.getWaistCirc(),
                bioMetricHistoricalDataDto.getHipCirc(),
                bioMetricHistoricalDataDto.getContact());
    }

    public BioMetricHistoricalDataDto mapToBioMetricHistoricalDataDto(final BioMetricHistoricalData bioMetricHistoricalData) {
        return new BioMetricHistoricalDataDto(
                bioMetricHistoricalData.getGrowth(),
                bioMetricHistoricalData.getWeight(),
                bioMetricHistoricalData.getWaistCirc(),
                bioMetricHistoricalData.getHipCirc(),
                bioMetricHistoricalData.getContact());
    }
}
