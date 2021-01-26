package com.superdevs.HealthOMeter.service;

import com.superdevs.HealthOMeter.entity.HistoricalMedicalData;
import com.superdevs.HealthOMeter.repositories.HistoricalMedicalDataRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HistoricalMedicalDataService {

    private static final Logger logger = LoggerFactory.getLogger(HistoricalMedicalDataService.class);

    @Autowired
    private HistoricalMedicalDataRepository historicalMedicalDataRepository;

    public List<HistoricalMedicalData> getAllHistoricalMedicalDatas() {
        logger.info("Started getAllHistoricalMedicalDatas in HistoricalMedicalDataService");

        return historicalMedicalDataRepository.findAll();
    }

    public HistoricalMedicalData findHistoricalMedicalDataById(Long historicalMedicalDataId) {
        logger.info("Started findHistoricalMedicalDataById in HistoricalMedicalDataService");

        return historicalMedicalDataRepository.findById(historicalMedicalDataId).orElseThrow();
    }

    public HistoricalMedicalData createHistoricalMedicalData(HistoricalMedicalData historicalMedicalData) {
        logger.info("Started createHistoricalMedicalData in HistoricalMedicalDataService");

        Optional<HistoricalMedicalData> historicalMedicalDataOptional = historicalMedicalDataRepository.findById(historicalMedicalData.getId());
        if (!historicalMedicalDataOptional.isPresent()) {
            return historicalMedicalDataRepository.save(historicalMedicalData);
        }
        return historicalMedicalData;
    }

    public HistoricalMedicalData updateHistoricalMedicalData(HistoricalMedicalData historicalMedicalData) {
        logger.info("Started updateHistoricalMedicalData in HistoricalMedicalDataService");

        Optional<HistoricalMedicalData> historicalMedicalDataOptional = historicalMedicalDataRepository.findById(historicalMedicalData.getId());
        if (!historicalMedicalDataOptional.isPresent()) {
            return historicalMedicalDataRepository.save(historicalMedicalData);
        }
        return historicalMedicalData;
    }

    public void deleteHistoricalMedicalData(Long id) {
        logger.info("Started deleteHistoricalMedicalData in HistoricalMedicalDataService");

        HistoricalMedicalData deleteHistoricalMedicalData = historicalMedicalDataRepository.findById(id).orElseThrow();
        historicalMedicalDataRepository.delete(deleteHistoricalMedicalData);
    }
}

