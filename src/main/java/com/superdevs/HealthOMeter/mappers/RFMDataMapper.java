package com.superdevs.HealthOMeter.mappers;

import com.superdevs.HealthOMeter.dto.RFMDataDto;
import com.superdevs.HealthOMeter.dto.RFMDataDto;
import com.superdevs.HealthOMeter.entity.RFMData;
import com.superdevs.HealthOMeter.entity.RFMData;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

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

    public List<RFMData> mapToRFMDataList(final List<RFMDataDto> rFMDataDtoList) {
        return rFMDataDtoList.stream()
                .map(this::mapToRFMData)
                .collect(Collectors.toList());
    }

    public List<RFMDataDto> mapToRFMDataDtoList(final List<RFMData> rFMDataList) {
        return rFMDataList.stream()
                .map(this::mapToRFMDataDto)
                .collect(Collectors.toList());
    }
}