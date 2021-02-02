package com.superdevs.HealthOMeter.mappers;

import com.superdevs.HealthOMeter.dto.MedicalDataDto;
import com.superdevs.HealthOMeter.dto.MedicalDataDto;
import com.superdevs.HealthOMeter.entity.MedicalData;
import com.superdevs.HealthOMeter.entity.MedicalData;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

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

    public List<MedicalData> mapToMedicalDataList(final List<MedicalDataDto> medicalDataDtoList) {
        return medicalDataDtoList.stream()
                .map(this::mapToMedicalData)
                .collect(Collectors.toList());
    }

    public List<MedicalDataDto> mapToMedicalDataDtoList(final List<MedicalData> medicalDataList) {
        return medicalDataList.stream()
                .map(this::mapToMedicalDataDto)
                .collect(Collectors.toList());
    }
}
