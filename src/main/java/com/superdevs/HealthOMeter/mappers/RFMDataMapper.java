package com.superdevs.HealthOMeter.mappers;

import com.superdevs.HealthOMeter.dto.RFMDataDto;
import com.superdevs.HealthOMeter.entity.RFMData;
import org.springframework.stereotype.Component;

@Component
public class RFMDataMapper {

    public RFMData mapToRFMData (RFMDataDto rfmDataDto){
        return new RFMData();
    }

    public RFMDataDto mapToRFMDataDto (RFMData rfmData){
        return new RFMDataDto(
                rfmData.getId(),
                rfmData.getWaistSize(),
                rfmData.getHeight(),
                rfmData.getResult(),
                rfmData.getContact()
        );
    }
}