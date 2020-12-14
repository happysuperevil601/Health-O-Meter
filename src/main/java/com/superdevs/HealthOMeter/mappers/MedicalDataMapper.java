package com.superdevs.HealthOMeter.mappers;

import com.superdevs.HealthOMeter.dto.MedicalDataDto;
import com.superdevs.HealthOMeter.entity.MedicalData;
import org.springframework.stereotype.Component;

@Component
public class MedicalDataMapper {

    public MedicalData mapToMedicalData(final MedicalDataDto medicalDataDto) {
        return new MedicalData(
                medicalDataDto.getContact());
    }

    public MedicalDataDto mapToMedicalDataDto(final MedicalData medicalData) {
        return new MedicalDataDto(
                medicalData.getContact());
    }
}
