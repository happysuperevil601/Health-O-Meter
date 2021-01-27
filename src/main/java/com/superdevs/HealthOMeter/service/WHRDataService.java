package com.superdevs.HealthOMeter.service;

import com.superdevs.HealthOMeter.entity.WHRData;
import com.superdevs.HealthOMeter.repositories.WHRDataRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WHRDataService {

    private static final Logger logger = LoggerFactory.getLogger(WHRDataService.class);

    @Autowired
    private WHRDataRepository wHRDataRepository;

    public List<WHRData> getAllWHRData() {
        logger.info("Started getAllWHRData in WHRDataService");

        return wHRDataRepository.findAll();
    }

    public WHRData findWHRDataById(Long wHRDataId) {
        logger.info("Started findWHRDataById in WHRDataService");

        return wHRDataRepository.findById(wHRDataId).orElseThrow();
    }

    public WHRData createWHRData(WHRData wHRData) {
        logger.info("Started createWHRData in WHRDataService");

        Optional<WHRData> wHRDataOptional = wHRDataRepository.findById(wHRData.getId());
        if (!wHRDataOptional.isPresent()) {
            return wHRDataRepository.save(wHRData);
        }
        return wHRData;
    }

    public WHRData updateWHRData(WHRData wHRData) {
        logger.info("Started updateWHRData in WHRDataService");

        Optional<WHRData> wHRDataOptional = wHRDataRepository.findById(wHRData.getId());
        if (!wHRDataOptional.isPresent()) {
            return wHRDataRepository.save(wHRData);
        }
        return wHRData;
    }

    public void deleteWHRData(Long id) {
        logger.info("Started deleteWHRData in WHRDataService");

        WHRData deleteWHRData = wHRDataRepository.findById(id).orElseThrow();
        wHRDataRepository.delete(deleteWHRData);
    }
}
