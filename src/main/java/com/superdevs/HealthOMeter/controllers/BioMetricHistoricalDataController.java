package com.superdevs.HealthOMeter.controllers;

import com.superdevs.HealthOMeter.dto.BioMetricHistoricalDataDto;
import com.superdevs.HealthOMeter.mappers.BioMetricHistoricalDataMapper;
import com.superdevs.HealthOMeter.service.BioMetricHistoricalDataService;
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
public class BioMetricHistoricalDataController {

    private static final Logger logger = LoggerFactory.getLogger(BioMetricHistoricalDataController.class);

    @Autowired
    private BioMetricHistoricalDataService bioMetricHistoricalDataService;

    @Autowired
    private BioMetricHistoricalDataMapper bioMetricHistoricalDataMapper;

    @GetMapping(value = "/bioMetricHistoricalData")
    public ResponseEntity<?> getAllBioMetricHistoricalData() {
        logger.info("Started getAllBioMetricHistoricalData BioMetricHistoricalDataController!");
        try {
            logger.info("Success getAllBioMetricHistoricalData BioMetricHistoricalDataController!");
            return ResponseEntity.ok(bioMetricHistoricalDataMapper.mapToBioMetricHistoricalDataDtoList(bioMetricHistoricalDataService.getAllBioMetricHistoricalData()));
        } catch (ResponseStatusException | HttpServerErrorException e) {
            logger.warn("Failed getAllBioMetricHistoricalData BioMetricHistoricalDataController!");
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid" + e);
        }
    }

    @DeleteMapping(value = "/bioMetricHistoricalData/{id}")
    public ResponseEntity<?> deleteBioMetricHistoricalData(@PathVariable("id") Long id) {
        logger.info("Started deleteBioMetricHistoricalData BioMetricHistoricalDataController!");
        try {
            bioMetricHistoricalDataService.deleteBioMetricHistoricalData(id);
            logger.info("Success deleteBioMetricHistoricalData BioMetricHistoricalDataController!");
            return ResponseEntity.noContent().build();
        } catch (ResponseStatusException | HttpServerErrorException e) {
            logger.warn("Failed deleteBioMetricHistoricalData BioMetricHistoricalDataController!");
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid " + e);
        }
    }

    @PostMapping(value = "/bioMetricHistoricalData")
    public ResponseEntity<?> createBioMetricHistoricalData(@RequestBody BioMetricHistoricalDataDto bioMetricHistoricalDataDto) {
        logger.info("Started createBioMetricHistoricalData BioMetricHistoricalDataController!");
        try {
            return ResponseEntity.ok(bioMetricHistoricalDataService.createBioMetricHistoricalData(bioMetricHistoricalDataMapper.mapToBioMetricHistoricalData(bioMetricHistoricalDataDto)));
        } catch (ResponseStatusException | HttpServerErrorException e) {
            logger.warn("Failed createBioMetricHistoricalData BioMetricHistoricalDataController!");
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid " + e);
        }
    }

    @GetMapping(value = "/bioMetricHistoricalData/{id}")
    public ResponseEntity<?> getBioMetricHistoricalData(@PathVariable("id") Long id) {
        logger.info("Started getBioMetricHistoricalData BioMetricHistoricalDataController!");
        try {
            logger.info("Success getBioMetricHistoricalData BioMetricHistoricalDataController!");
            return ResponseEntity.ok(bioMetricHistoricalDataService.findBioMetricHistoricalDataById(id));
        } catch (ResponseStatusException | HttpServerErrorException e) {
            logger.warn("Failed getBioMetricHistoricalData BioMetricHistoricalDataController!");
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid " + e);
        }
    }

    @PutMapping(value = "/bioMetricHistoricalData/{id}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> updateBioMetricHistoricalData(@RequestBody BioMetricHistoricalDataDto bioMetricHistoricalDataDto) {
        logger.info("Started updateBioMetricHistoricalData BioMetricHistoricalDataController!");
        try {
            logger.info("Success updateBioMetricHistoricalData BioMetricHistoricalDataController!");
            return ResponseEntity.ok(bioMetricHistoricalDataService.updateBioMetricHistoricalData(bioMetricHistoricalDataMapper.mapToBioMetricHistoricalData(bioMetricHistoricalDataDto)));
        } catch (ResponseStatusException | HttpServerErrorException e) {
            logger.warn("Failed updateBioMetricHistoricalData BioMetricHistoricalDataController!");
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid " + e);
        }
    }

}
