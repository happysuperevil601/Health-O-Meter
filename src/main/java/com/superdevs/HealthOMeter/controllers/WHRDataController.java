package com.superdevs.HealthOMeter.controllers;

import com.superdevs.HealthOMeter.dto.WHRDataDto;
import com.superdevs.HealthOMeter.mappers.WHRDataMapper;
import com.superdevs.HealthOMeter.service.WHRDataService;
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
public class WHRDataController {
    private static final Logger logger = LoggerFactory.getLogger(WHRDataController.class);

    @Autowired
    private WHRDataService wHRDataService;

    @Autowired
    private WHRDataMapper wHRDataMapper;

    @GetMapping(value = "/wHRDatas")
    public ResponseEntity<?> getAllWHRData() {
        logger.info("Started getAllWHRData WHRDataController!");
        try {
            logger.info("Success getAllWHRData WHRDataController!");
            return ResponseEntity.ok(wHRDataMapper.mapToWHRDataDtoList(wHRDataService.getAllWHRData()));
        } catch (ResponseStatusException | HttpServerErrorException e) {
            logger.warn("Failed getAllWHRData WHRDataController!");
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid" + e);
        }
    }

    @DeleteMapping(value = "/wHRData/{id}")
    public ResponseEntity<?> deleteWHRData(@PathVariable("id") Long id) {
        logger.info("Started deleteWHRData WHRDataController!");
        try {
            wHRDataService.deleteWHRData(id);
            logger.info("Success deleteWHRData WHRDataController!");
            return ResponseEntity.noContent().build();
        } catch (ResponseStatusException | HttpServerErrorException e) {
            logger.warn("Failed deleteWHRData WHRDataController!");
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid " + e);
        }
    }

    @PostMapping(value = "/wHRData")
    public ResponseEntity<?> createWHRData(@RequestBody WHRDataDto wHRDataDto) {
        logger.info("Started createWHRData WHRDataController!");
        try {
            return ResponseEntity.ok(wHRDataService.createWHRData(wHRDataMapper.mapToWHRData(wHRDataDto)));
        } catch (ResponseStatusException | HttpServerErrorException e) {
            logger.warn("Failed createWHRData WHRDataController!");
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid " + e);
        }
    }

    @GetMapping(value = "/wHRData/{id}")
    public ResponseEntity<?> getWHRData(@PathVariable("id") Long id) {
        logger.info("Started getWHRData WHRDataController!");
        try {
            logger.info("Success getWHRData WHRDataController!");
            return ResponseEntity.ok(wHRDataService.findWHRDataById(id));
        } catch (ResponseStatusException | HttpServerErrorException e) {
            logger.warn("Failed getWHRData WHRDataController!");
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid " + e);
        }
    }

    @PutMapping(value = "/wHRData/{id}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> updateWHRData(@RequestBody WHRDataDto wHRDataDto) {
        logger.info("Started updateWHRData WHRDataController!");
        try {
            logger.info("Success updateWHRData WHRDataController!");
            return ResponseEntity.ok(wHRDataService.updateWHRData(wHRDataMapper.mapToWHRData(wHRDataDto)));
        } catch (ResponseStatusException | HttpServerErrorException e) {
            logger.warn("Failed updateWHRData WHRDataController!");
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid " + e);
        }
    }

}
