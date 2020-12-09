package com.superdevs.HealthOMeter.mappers;

import com.superdevs.HealthOMeter.dto.BioMetricHistoricalDataDto;
import com.superdevs.HealthOMeter.entity.BioMetricHistoricalData;
import org.springframework.stereotype.Component;

@Component
public class BioMetricHistoricalDataMapper {

    public BioMetricHistoricalData mapToBioMetricHistoricalData(BioMetricHistoricalDataDto bioMetricHistoricalDataDto) {
        return new BioMetricHistoricalData();
    }

    public BioMetricHistoricalDataDto mapToBioMetricHistoricalDataDto(BioMetricHistoricalData bioMetricHistoricalData) {
        return new BioMetricHistoricalDataDto(
                bioMetricHistoricalData.getId(),
                bioMetricHistoricalData.getGrowth(),
                bioMetricHistoricalData.getWeight(),
                bioMetricHistoricalData.getWaistCirc(),
                bioMetricHistoricalData.getHipCirc(),
                bioMetricHistoricalData.getContact());
    }
}
