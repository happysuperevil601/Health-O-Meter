package com.superdevs.HealthOMeter.service;

import com.superdevs.HealthOMeter.entity.BMIData;
import com.superdevs.HealthOMeter.repositories.BMIDataRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BMIDataService {

    private static final Logger logger = LoggerFactory.getLogger(BMIDataService.class);

    @Autowired
    private BMIDataRepository bMIDataRepository;

    public List<BMIData> getAllBMIDatas() {
        logger.info("Started getAllBMIDatas in BMIDataService");

        return bMIDataRepository.findAll();
    }

    public BMIData findBMIDataById(Long bMIDataId) {
        logger.info("Started findBMIDataById in BMIDataService");

        return bMIDataRepository.findById(bMIDataId).orElseThrow();
    }

    public BMIData createBMIData(BMIData bMIData) {
        logger.info("Started createBMIData in BMIDataService");

        Optional<BMIData> bMIDataOptional = bMIDataRepository.findById(bMIData.getId());
        if (!bMIDataOptional.isPresent()) {
            return bMIDataRepository.save(bMIData);
        }
        return bMIData;
    }

    public BMIData updateBMIData(BMIData bMIData) {
        logger.info("Started updateBMIData in BMIDataService");

        Optional<BMIData> bMIDataOptional = bMIDataRepository.findById(bMIData.getId());
        if (!bMIDataOptional.isPresent()) {
            return bMIDataRepository.save(bMIData);
        }
        return bMIData;
    }

    public void deleteBMIData(Long id) {
        logger.info("Started deleteBMIData in BMIDataService");

        BMIData deleteBMIData = bMIDataRepository.findById(id).orElseThrow();
        bMIDataRepository.delete(deleteBMIData);
    }
}