package com.superdevs.HealthOMeter.controllers;

import com.superdevs.HealthOMeter.entity.Gender;
import com.superdevs.HealthOMeter.service.CalculatorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@CrossOrigin("*")
@RestController
@RequestMapping("/hom")
public class CalculatorController {

    private static final Logger logger = LoggerFactory.getLogger(CalculatorController.class);

    @Autowired
    CalculatorService calculatorService;

    @GetMapping(value = "/bmi")
    ResponseEntity<?> calculateBMI(@RequestParam BigDecimal height, @RequestParam BigDecimal weight) {
        logger.info("Calculating BMI!");
        return ResponseEntity.ok(calculatorService.getCalculateBMI(height, weight));
    }

    @GetMapping(value = "/rfm")
    ResponseEntity<?> calculateRFM(@RequestParam Gender gender, @RequestParam BigDecimal height, @RequestParam BigDecimal waistRatio) {
        logger.info("Calculating RFM!");
        return ResponseEntity.ok(calculatorService.getCalculateRFM(gender, height, waistRatio));
    }

    @GetMapping(value = "/whr")
    ResponseEntity<?> calculateWHR(@RequestParam BigDecimal waistRatio, @RequestParam BigDecimal hipRatio) {
        logger.info("Calculating WHR!");
        return ResponseEntity.ok(calculatorService.getCalculateWHR(waistRatio, hipRatio));
    }
}