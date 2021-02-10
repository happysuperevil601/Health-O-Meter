package com.superdevs.HealthOMeter.service;

import com.superdevs.HealthOMeter.entity.BioMetricData;
import com.superdevs.HealthOMeter.repositories.BioMetricDataRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BioMetricDataService {

    private static final Logger logger = LoggerFactory.getLogger(BioMetricDataService.class);
    @Autowired
    private BioMetricDataRepository bioMetricDataRepository;

    public List<BioMetricData> getAllBioMetricData() {
        logger.info("Started getAllBioMetricData in BioMetricDataService");

        return bioMetricDataRepository.findAll();
    }

    public BioMetricData findBioMetricDataById(Long bioMetricDataId) {
        logger.info("Started findBioMetricDataById in BioMetricDataService");

        return bioMetricDataRepository.findById(bioMetricDataId).orElseThrow();
    }

    public BioMetricData createBioMetricData(BioMetricData bioMetricData) {
        logger.info("Started createBioMetricData in BioMetricDataService");

        Optional<BioMetricData> bioMetricDataOptional = bioMetricDataRepository.findById(bioMetricData.getId());
        if (bioMetricDataOptional.isEmpty()) {
            return bioMetricDataRepository.save(bioMetricData);
        }
        return bioMetricData;
    }

    public BioMetricData updateBioMetricData(BioMetricData bioMetricData) {
        logger.info("Started updateBioMetricData in BioMetricDataService");

        Optional<BioMetricData> bioMetricDataOptional = bioMetricDataRepository.findById(bioMetricData.getId());
        if (bioMetricDataOptional.isEmpty()) {
            return bioMetricDataRepository.save(bioMetricData);
        }
        return bioMetricData;
    }

    public void deleteBioMetricData(Long id) {
        logger.info("Started deleteBioMetricData in BioMetricDataService");

        BioMetricData deleteBioMetricData = bioMetricDataRepository.findById(id).orElseThrow();
        bioMetricDataRepository.delete(deleteBioMetricData);
    }
}
