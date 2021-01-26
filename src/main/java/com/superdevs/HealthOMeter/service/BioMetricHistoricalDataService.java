package com.superdevs.HealthOMeter.service;

import com.superdevs.HealthOMeter.entity.BioMetricHistoricalData;
import com.superdevs.HealthOMeter.repositories.BioMetricHistoricalDataRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BioMetricHistoricalDataService {

    private static final Logger logger = LoggerFactory.getLogger(BioMetricHistoricalDataService.class);

    @Autowired
    private BioMetricHistoricalDataRepository bioMetricHistoricalDataRepository;

    public List<BioMetricHistoricalData> getAllBioMetricHistoricalDatas() {
        logger.info("Started getAllBioMetricHistoricalDatas in BioMetricHistoricalDataService");

        return bioMetricHistoricalDataRepository.findAll();
    }

    public BioMetricHistoricalData findBioMetricHistoricalDataById(Long bioMetricHistoricalDataId) {
        logger.info("Started findBioMetricHistoricalDataById in BioMetricHistoricalDataService");

        return bioMetricHistoricalDataRepository.findById(bioMetricHistoricalDataId).orElseThrow();
    }

    public BioMetricHistoricalData createBioMetricHistoricalData(BioMetricHistoricalData bioMetricHistoricalData) {
        logger.info("Started createBioMetricHistoricalData in BioMetricHistoricalDataService");

        Optional<BioMetricHistoricalData> bioMetricHistoricalDataOptional = bioMetricHistoricalDataRepository.findById(bioMetricHistoricalData.getId());
        if (!bioMetricHistoricalDataOptional.isPresent()) {
            return bioMetricHistoricalDataRepository.save(bioMetricHistoricalData);
        }
        return bioMetricHistoricalData;
    }

    public BioMetricHistoricalData updateBioMetricHistoricalData(BioMetricHistoricalData bioMetricHistoricalData) {
        logger.info("Started updateBioMetricHistoricalData in BioMetricHistoricalDataService");

        Optional<BioMetricHistoricalData> bioMetricHistoricalDataOptional = bioMetricHistoricalDataRepository.findById(bioMetricHistoricalData.getId());
        if (!bioMetricHistoricalDataOptional.isPresent()) {
            return bioMetricHistoricalDataRepository.save(bioMetricHistoricalData);
        }
        return bioMetricHistoricalData;
    }

    public void deleteBioMetricHistoricalData(Long id) {
        logger.info("Started deleteBioMetricHistoricalData in BioMetricHistoricalDataService");

        BioMetricHistoricalData deleteBioMetricHistoricalData = bioMetricHistoricalDataRepository.findById(id).orElseThrow();
        bioMetricHistoricalDataRepository.delete(deleteBioMetricHistoricalData);
    }
}

