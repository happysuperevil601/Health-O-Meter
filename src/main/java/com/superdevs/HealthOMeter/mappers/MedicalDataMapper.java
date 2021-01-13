package com.superdevs.HealthOMeter.mappers;

import com.superdevs.HealthOMeter.dto.MedicalDataDto;
import com.superdevs.HealthOMeter.entity.MedicalData;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MedicalDataMapper {

    @Autowired
    private ModelMapper modelMapper;

    public MedicalData mapToMedicalData(final MedicalDataDto medicalDataDto) {
        return modelMapper.map(medicalDataDto, MedicalData.class);
    }

    public MedicalDataDto mapToMedicalDataDto(final MedicalData medicalData) {
        return modelMapper.map(medicalData, MedicalDataDto.class);
    }
}
