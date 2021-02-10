package com.superdevs.HealthOMeter.controllers;

import com.superdevs.HealthOMeter.dto.HistoricalMedicalDataDto;
import com.superdevs.HealthOMeter.mappers.HistoricalMedicalDataMapper;
import com.superdevs.HealthOMeter.service.HistoricalMedicalDataService;
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
public class HistoricalMedicalDataController {
    private static final Logger logger = LoggerFactory.getLogger(HistoricalMedicalDataController.class);

    @Autowired
    private HistoricalMedicalDataService historicalMedicalDataService;

    @Autowired
    private HistoricalMedicalDataMapper historicalMedicalDataMapper;

    @GetMapping(value = "/historicalMedicalData")
    public ResponseEntity<?> getAllHistoricalMedicalData() {
        logger.info("Started getAllHistoricalMedicalData HistoricalMedicalDataController!");
        try {
            logger.info("Success getAllHistoricalMedicalData HistoricalMedicalDataController!");
            return ResponseEntity.ok(historicalMedicalDataMapper.mapToHistoricalMedicalDataDtoList(historicalMedicalDataService.getAllHistoricalMedicalData()));
        } catch (ResponseStatusException | HttpServerErrorException e) {
            logger.warn("Failed getAllHistoricalMedicalData HistoricalMedicalDataController!");
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid" + e);
        }
    }

    @DeleteMapping(value = "/historicalMedicalData/{id}")
    public ResponseEntity<?> deleteHistoricalMedicalData(@PathVariable("id") Long id) {
        logger.info("Started deleteHistoricalMedicalData HistoricalMedicalDataController!");
        try {
            historicalMedicalDataService.deleteHistoricalMedicalData(id);
            logger.info("Success deleteHistoricalMedicalData HistoricalMedicalDataController!");
            return ResponseEntity.noContent().build();
        } catch (ResponseStatusException | HttpServerErrorException e) {
            logger.warn("Failed deleteHistoricalMedicalData HistoricalMedicalDataController!");
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid " + e);
        }
    }

    @PostMapping(value = "/historicalMedicalData")
    public ResponseEntity<?> createHistoricalMedicalData(@RequestBody HistoricalMedicalDataDto historicalMedicalDataDto) {
        logger.info("Started createHistoricalMedicalData HistoricalMedicalDataController!");
        try {
            return ResponseEntity.ok(historicalMedicalDataService.createHistoricalMedicalData(historicalMedicalDataMapper.mapToHistoricalMedicalData(historicalMedicalDataDto)));
        } catch (ResponseStatusException | HttpServerErrorException e) {
            logger.warn("Failed createHistoricalMedicalData HistoricalMedicalDataController!");
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid " + e);
        }
    }

    @GetMapping(value = "/historicalMedicalData/{id}")
    public ResponseEntity<?> getHistoricalMedicalData(@PathVariable("id") Long id) {
        logger.info("Started getHistoricalMedicalData HistoricalMedicalDataController!");
        try {
            logger.info("Success getHistoricalMedicalData HistoricalMedicalDataController!");
            return ResponseEntity.ok(historicalMedicalDataService.findHistoricalMedicalDataById(id));
        } catch (ResponseStatusException | HttpServerErrorException e) {
            logger.warn("Failed getHistoricalMedicalData HistoricalMedicalDataController!");
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid " + e);
        }
    }

    @PutMapping(value = "/historicalMedicalData/{id}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> updateHistoricalMedicalData(@RequestBody HistoricalMedicalDataDto historicalMedicalDataDto) {
        logger.info("Started updateHistoricalMedicalData HistoricalMedicalDataController!");
        try {
            logger.info("Success updateHistoricalMedicalData HistoricalMedicalDataController!");
            return ResponseEntity.ok(historicalMedicalDataService.updateHistoricalMedicalData(historicalMedicalDataMapper.mapToHistoricalMedicalData(historicalMedicalDataDto)));
        } catch (ResponseStatusException | HttpServerErrorException e) {
            logger.warn("Failed updateHistoricalMedicalData HistoricalMedicalDataController!");
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid " + e);
        }
    }

}