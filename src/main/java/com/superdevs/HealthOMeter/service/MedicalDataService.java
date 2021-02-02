package com.superdevs.HealthOMeter.service;

import com.superdevs.HealthOMeter.entity.MedicalData;
import com.superdevs.HealthOMeter.repositories.MedicalDataRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MedicalDataService {

    private static final Logger logger = LoggerFactory.getLogger(MedicalDataService.class);

    @Autowired
    private MedicalDataRepository medicalDataRepository;

    public List<MedicalData> getAllMedicalData() {
        logger.info("Started getAllMedicalData in MedicalDataService");

        return medicalDataRepository.findAll();
    }

    public MedicalData findMedicalDataById(Long medicalDataId) {
        logger.info("Started findMedicalDataById in MedicalDataService");

        return medicalDataRepository.findById(medicalDataId).orElseThrow();
    }

    public MedicalData createMedicalData(MedicalData medicalData) {
        logger.info("Started createMedicalData in MedicalDataService");

        Optional<MedicalData> medicalDataOptional = medicalDataRepository.findById(medicalData.getId());
        if (medicalDataOptional.isEmpty()) {
            return medicalDataRepository.save(medicalData);
        }
        return medicalData;
    }

    public MedicalData updateMedicalData(MedicalData medicalData) {
        logger.info("Started updateMedicalData in MedicalDataService");

        Optional<MedicalData> medicalDataOptional = medicalDataRepository.findById(medicalData.getId());
        if (medicalDataOptional.isEmpty()) {
            return medicalDataRepository.save(medicalData);
        }
        return medicalData;
    }

    public void deleteMedicalData(Long id) {
        logger.info("Started deleteMedicalData in MedicalDataService");

        MedicalData deleteMedicalData = medicalDataRepository.findById(id).orElseThrow();
        medicalDataRepository.delete(deleteMedicalData);
    }
}
