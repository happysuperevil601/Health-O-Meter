package com.superdevs.HealthOMeter.controllers;

import com.superdevs.HealthOMeter.dto.RFMDataDto;
import com.superdevs.HealthOMeter.mappers.RFMDataMapper;
import com.superdevs.HealthOMeter.service.RFMDataService;
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
public class RFMDataController {
    private static final Logger logger = LoggerFactory.getLogger(RFMDataController.class);

    @Autowired
    private RFMDataService rFMDataService;

    @Autowired
    private RFMDataMapper rFMDataMapper;

    @GetMapping(value = "/rFMData")
    public ResponseEntity<?> getAllRFMData() {
        logger.info("Started getAllRFMData RFMDataController!");
        try {
            logger.info("Success getAllRFMData RFMDataController!");
            return ResponseEntity.ok(rFMDataMapper.mapToRFMDataDtoList(rFMDataService.getAllRFMData()));
        } catch (ResponseStatusException | HttpServerErrorException e) {
            logger.warn("Failed getAllRFMData RFMDataController!");
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid" + e);
        }
    }

    @DeleteMapping(value = "/rFMData/{id}")
    public ResponseEntity<?> deleteRFMData(@PathVariable("id") Long id) {
        logger.info("Started deleteRFMData RFMDataController!");
        try {
            rFMDataService.deleteRFMData(id);
            logger.info("Success deleteRFMData RFMDataController!");
            return ResponseEntity.noContent().build();
        } catch (ResponseStatusException | HttpServerErrorException e) {
            logger.warn("Failed deleteRFMData RFMDataController!");
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid " + e);
        }
    }

    @PostMapping(value = "/rFMData")
    public ResponseEntity<?> createRFMData(@RequestBody RFMDataDto rFMDataDto) {
        logger.info("Started createRFMData RFMDataController!");
        try {
            return ResponseEntity.ok(rFMDataService.createRFMData(rFMDataMapper.mapToRFMData(rFMDataDto)));
        } catch (ResponseStatusException | HttpServerErrorException e) {
            logger.warn("Failed createRFMData RFMDataController!");
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid " + e);
        }
    }

    @GetMapping(value = "/rFMData/{id}")
    public ResponseEntity<?> getRFMData(@PathVariable("id") Long id) {
        logger.info("Started getRFMData RFMDataController!");
        try {
            logger.info("Success getRFMData RFMDataController!");
            return ResponseEntity.ok(rFMDataService.findRFMDataById(id));
        } catch (ResponseStatusException | HttpServerErrorException e) {
            logger.warn("Failed getRFMData RFMDataController!");
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid " + e);
        }
    }

    @PutMapping(value = "/rFMData/{id}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> updateRFMData(@RequestBody RFMDataDto rFMDataDto) {
        logger.info("Started updateRFMData RFMDataController!");
        try {
            logger.info("Success updateRFMData RFMDataController!");
            return ResponseEntity.ok(rFMDataService.updateRFMData(rFMDataMapper.mapToRFMData(rFMDataDto)));
        } catch (ResponseStatusException | HttpServerErrorException e) {
            logger.warn("Failed updateRFMData RFMDataController!");
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid " + e);
        }
    }

}
