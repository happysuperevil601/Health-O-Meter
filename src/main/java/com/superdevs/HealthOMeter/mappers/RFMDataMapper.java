package com.superdevs.HealthOMeter.mappers;

import com.superdevs.HealthOMeter.dto.RFMDataDto;
import com.superdevs.HealthOMeter.entity.RFMData;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RFMDataMapper {

    @Autowired
    private ModelMapper modelMapper;

    public RFMData mapToRFMData(final RFMDataDto rfmDataDto) {
        return modelMapper.map(rfmDataDto, RFMData.class);
    }

    public RFMDataDto mapToRFMDataDto(final RFMData rfmData) {
        return modelMapper.map(rfmData, RFMDataDto.class);
    }
}