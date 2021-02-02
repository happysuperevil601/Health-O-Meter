package com.superdevs.HealthOMeter.controllers;

import com.superdevs.HealthOMeter.dto.BMIDataDto;
import com.superdevs.HealthOMeter.mappers.BMIDataMapper;
import com.superdevs.HealthOMeter.service.BMIDataService;
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
public class BMIDataController {
    private static final Logger logger = LoggerFactory.getLogger(BMIDataController.class);

    @Autowired
    private BMIDataService bMIDataService;

    @Autowired
    private BMIDataMapper bMIDataMapper;

    @GetMapping(value = "/bMIDatas")
    public ResponseEntity<?> getAllBMIData() {
        logger.info("Started getAllBMIData BMIDataController!");
        try {
            logger.info("Success getAllBMIData BMIDataController!");
            return ResponseEntity.ok(bMIDataMapper.mapToBMIDataDtoList(bMIDataService.getAllBMIData()));
        } catch (ResponseStatusException | HttpServerErrorException e) {
            logger.warn("Failed getAllBMIData BMIDataController!");
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid" + e);
        }
    }

    @DeleteMapping(value = "/bMIData/{id}")
    public ResponseEntity<?> deleteBMIData(@PathVariable("id") Long id) {
        logger.info("Started deleteBMIData BMIDataController!");
        try {
            bMIDataService.deleteBMIData(id);
            logger.info("Success deleteBMIData BMIDataController!");
            return ResponseEntity.noContent().build();
        } catch (ResponseStatusException | HttpServerErrorException e) {
            logger.warn("Failed deleteBMIData BMIDataController!");
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid " + e);
        }
    }

    @PostMapping(value = "/bMIData")
    public ResponseEntity<?> createBMIData(@RequestBody BMIDataDto bMIDataDto) {
        logger.info("Started createBMIData BMIDataController!");
        try {
            return ResponseEntity.ok(bMIDataService.createBMIData(bMIDataMapper.mapToBMIData(bMIDataDto)));
        } catch (ResponseStatusException | HttpServerErrorException e) {
            logger.warn("Failed createBMIData BMIDataController!");
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid " + e);
        }
    }

    @GetMapping(value = "/bMIData/{id}")
    public ResponseEntity<?> getBMIData(@PathVariable("id") Long id) {
        logger.info("Started getBMIData BMIDataController!");
        try {
            logger.info("Success getBMIData BMIDataController!");
            return ResponseEntity.ok(bMIDataService.findBMIDataById(id));
        } catch (ResponseStatusException | HttpServerErrorException e) {
            logger.warn("Failed getBMIData BMIDataController!");
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid " + e);
        }
    }

    @PutMapping(value = "/bMIData/{id}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> updateBMIData(@RequestBody BMIDataDto bMIDataDto) {
        logger.info("Started updateBMIData BMIDataController!");
        try {
            logger.info("Success updateBMIData BMIDataController!");
            return ResponseEntity.ok(bMIDataService.updateBMIData(bMIDataMapper.mapToBMIData(bMIDataDto)));
        } catch (ResponseStatusException | HttpServerErrorException e) {
            logger.warn("Failed updateBMIData BMIDataController!");
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid " + e);
        }
    }

}