package com.superdevs.HealthOMeter.controllers;

import com.superdevs.HealthOMeter.dto.HistoricalCalculatorsResultsDto;
import com.superdevs.HealthOMeter.mappers.HistoricalCalculatorsResultsMapper;
import com.superdevs.HealthOMeter.service.HistoricalCalculatorsResultsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.server.ResponseStatusException;

@CrossOrigin("*")
@RestController
@RequestMapping("/hom")
public class HistoricalCalculatorsResultsController {
    private static final Logger logger = LoggerFactory.getLogger(HistoricalCalculatorsResultsController.class);

    @Autowired
    private HistoricalCalculatorsResultsService historicalCalculatorsResultsService;

    @Autowired
    private HistoricalCalculatorsResultsMapper historicalCalculatorsResultsMapper;

    @GetMapping(value = "/historicalCalculatorsResults")
    public ResponseEntity<?> getAllHistoricalCalculatorsResults() {
        logger.info("Started getAllHistoricalCalculatorsResults HistoricalCalculatorsResultsController!");
        try {
            logger.info("Success getAllHistoricalCalculatorsResults HistoricalCalculatorsResultsController!");
            return ResponseEntity.ok(historicalCalculatorsResultsMapper.mapToHistoricalCalculatorsResultsDtoList(historicalCalculatorsResultsService.getAllHistoricalCalculatorsResults()));
        } catch (ResponseStatusException | HttpServerErrorException e) {
            logger.warn("Failed getAllHistoricalCalculatorsResults HistoricalCalculatorsResultsController!");
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid" + e);
        }
    }

    @DeleteMapping(value = "/historicalCalculatorsResults/{id}")
    public ResponseEntity<?> deleteHistoricalCalculatorsResults(@PathVariable("id") Long id) {
        logger.info("Started deleteHistoricalCalculatorsResults HistoricalCalculatorsResultsController!");
        try {
            historicalCalculatorsResultsService.deleteHistoricalCalculatorsResults(id);
            logger.info("Success deleteHistoricalCalculatorsResults HistoricalCalculatorsResultsController!");
            return ResponseEntity.noContent().build();
        } catch (ResponseStatusException | HttpServerErrorException e) {
            logger.warn("Failed deleteHistoricalCalculatorsResults HistoricalCalculatorsResultsController!");
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid " + e);
        }
    }

    @PostMapping(value = "/historicalCalculatorsResults")
    public ResponseEntity<?> createHistoricalCalculatorsResults(@RequestBody HistoricalCalculatorsResultsDto historicalCalculatorsResultsDto) {
        logger.info("Started createHistoricalCalculatorsResults HistoricalCalculatorsResultsController!");
        try {
            return ResponseEntity.ok(historicalCalculatorsResultsService.createHistoricalCalculatorsResults(historicalCalculatorsResultsMapper.mapToHistoricalCalculatorsResults(historicalCalculatorsResultsDto)));
        } catch (ResponseStatusException | HttpServerErrorException e) {
            logger.warn("Failed createHistoricalCalculatorsResults HistoricalCalculatorsResultsController!");
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid " + e);
        }
    }

    @GetMapping(value = "/historicalCalculatorsResults/{id}")
    public ResponseEntity<?> getHistoricalCalculatorsResults(@PathVariable("id") Long id) {
        logger.info("Started getHistoricalCalculatorsResults HistoricalCalculatorsResultsController!");
        try {
            logger.info("Success getHistoricalCalculatorsResults HistoricalCalculatorsResultsController!");
            return ResponseEntity.ok(historicalCalculatorsResultsService.findHistoricalCalculatorsResultsById(id));
        } catch (ResponseStatusException | HttpServerErrorException e) {
            logger.warn("Failed getHistoricalCalculatorsResults HistoricalCalculatorsResultsController!");
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid " + e);
        }
    }

    @PutMapping(value = "/historicalCalculatorsResults/{id}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> updateHistoricalCalculatorsResults(@RequestBody HistoricalCalculatorsResultsDto historicalCalculatorsResultsDto) {
        logger.info("Started updateHistoricalCalculatorsResults HistoricalCalculatorsResultsController!");
        try {
            logger.info("Success updateHistoricalCalculatorsResults HistoricalCalculatorsResultsController!");
            return ResponseEntity.ok(historicalCalculatorsResultsService.updateHistoricalCalculatorsResults(historicalCalculatorsResultsMapper.mapToHistoricalCalculatorsResults(historicalCalculatorsResultsDto)));
        } catch (ResponseStatusException | HttpServerErrorException e) {
            logger.warn("Failed updateHistoricalCalculatorsResults HistoricalCalculatorsResultsController!");
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid " + e);
        }
    }

}