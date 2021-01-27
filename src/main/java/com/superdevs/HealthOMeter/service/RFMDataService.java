package com.superdevs.HealthOMeter.service;

import com.superdevs.HealthOMeter.entity.RFMData;
import com.superdevs.HealthOMeter.repositories.RFMDataRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RFMDataService {

    private static final Logger logger = LoggerFactory.getLogger(RFMDataService.class);

    @Autowired
    private RFMDataRepository rFMDataRepository;

    public List<RFMData> getAllRFMDatas() {
        logger.info("Started getAllRFMDatas in RFMDataService");

        return rFMDataRepository.findAll();
    }

    public RFMData findRFMDataById(Long rFMDataId) {
        logger.info("Started findRFMDataById in RFMDataService");

        return rFMDataRepository.findById(rFMDataId).orElseThrow();
    }

    public RFMData createRFMData(RFMData rFMData) {
        logger.info("Started createRFMData in RFMDataService");

        Optional<RFMData> rFMDataOptional = rFMDataRepository.findById(rFMData.getId());
        if (!rFMDataOptional.isPresent()) {
            return rFMDataRepository.save(rFMData);
        }
        return rFMData;
    }

    public RFMData updateRFMData(RFMData rFMData) {
        logger.info("Started updateRFMData in RFMDataService");

        Optional<RFMData> rFMDataOptional = rFMDataRepository.findById(rFMData.getId());
        if (!rFMDataOptional.isPresent()) {
            return rFMDataRepository.save(rFMData);
        }
        return rFMData;
    }

    public void deleteRFMData(Long id) {
        logger.info("Started deleteRFMData in RFMDataService");

        RFMData deleteRFMData = rFMDataRepository.findById(id).orElseThrow();
        rFMDataRepository.delete(deleteRFMData);
    }
}
