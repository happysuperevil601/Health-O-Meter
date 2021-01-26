package com.superdevs.HealthOMeter.service;

import com.superdevs.HealthOMeter.entity.Gender;
import com.superdevs.HealthOMeter.service.managers.CalculatorManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class CalculatorService {

    private static final Logger logger = LoggerFactory.getLogger(CalculatorService.class);

    @Autowired
    CalculatorManager calculatorManager;

    public BigDecimal getCalculateBMI(BigDecimal height, BigDecimal weight) {
        logger.info("Started getCalculateBMI in CalculatorService");

        return calculatorManager.calculateBMI(height, weight);
    }

    public BigDecimal getCalculateWHR(BigDecimal waistRatio, BigDecimal hipRatio) {
        logger.info("Started getCalculateWHR in CalculatorService");

        return calculatorManager.calculateWhr(waistRatio, hipRatio);
    }

    public BigDecimal getCalculateRFM(Gender gender, BigDecimal height, BigDecimal waistRatio) {
        logger.info("Started getCalculateRFM in CalculatorService");

        return calculatorManager.calculateRFM(gender, height, waistRatio);
    }
}
