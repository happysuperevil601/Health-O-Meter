package com.superdevs.HealthOMeter.service;

import com.superdevs.HealthOMeter.entity.HistoricalCalculatorsResults;
import com.superdevs.HealthOMeter.repositories.HistoricalCalculatorsResultsRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HistoricalCalculatorsResultsService {

    private static final Logger logger = LoggerFactory.getLogger(HistoricalCalculatorsResultsService.class);

    @Autowired
    private HistoricalCalculatorsResultsRepository historicalCalculatorsResultsRepository;

    public List<HistoricalCalculatorsResults> getAllHistoricalCalculatorsResultss() {
        logger.info("Started getAllHistoricalCalculatorsResultss in HistoricalCalculatorsResultsService");

        return historicalCalculatorsResultsRepository.findAll();
    }

    public HistoricalCalculatorsResults findHistoricalCalculatorsResultsById(Long historicalCalculatorsResultsId) {
        logger.info("Started findHistoricalCalculatorsResultsById in HistoricalCalculatorsResultsService");

        return historicalCalculatorsResultsRepository.findById(historicalCalculatorsResultsId).orElseThrow();
    }

    public HistoricalCalculatorsResults createHistoricalCalculatorsResults(HistoricalCalculatorsResults historicalCalculatorsResults) {
        logger.info("Started createHistoricalCalculatorsResults in HistoricalCalculatorsResultsService");

        Optional<HistoricalCalculatorsResults> historicalCalculatorsResultsOptional = historicalCalculatorsResultsRepository.findById(historicalCalculatorsResults.getId());
        if (!historicalCalculatorsResultsOptional.isPresent()) {
            return historicalCalculatorsResultsRepository.save(historicalCalculatorsResults);
        }
        return historicalCalculatorsResults;
    }

    public HistoricalCalculatorsResults updateHistoricalCalculatorsResults(HistoricalCalculatorsResults historicalCalculatorsResults) {
        logger.info("Started updateHistoricalCalculatorsResults in HistoricalCalculatorsResultsService");

        Optional<HistoricalCalculatorsResults> historicalCalculatorsResultsOptional = historicalCalculatorsResultsRepository.findById(historicalCalculatorsResults.getId());
        if (!historicalCalculatorsResultsOptional.isPresent()) {
            return historicalCalculatorsResultsRepository.save(historicalCalculatorsResults);
        }
        return historicalCalculatorsResults;
    }

    public void deleteHistoricalCalculatorsResults(Long id) {
        logger.info("Started deleteHistoricalCalculatorsResults in HistoricalCalculatorsResultsService");

        HistoricalCalculatorsResults deleteHistoricalCalculatorsResults = historicalCalculatorsResultsRepository.findById(id).orElseThrow();
        historicalCalculatorsResultsRepository.delete(deleteHistoricalCalculatorsResults);
    }
}
