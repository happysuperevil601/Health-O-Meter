package com.superdevs.HealthOMeter.service.managers;

import com.superdevs.HealthOMeter.calculators.BMICalculator;
import com.superdevs.HealthOMeter.calculators.RFMCalculator;
import com.superdevs.HealthOMeter.calculators.WHRCalculator;
import com.superdevs.HealthOMeter.entity.Gender;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class CalculatorManager {

    private static final Logger logger = LoggerFactory.getLogger(CalculatorManager.class);

    @Autowired
    @Qualifier("WHRCalculator")
    public WHRCalculator whrCalculator;

    @Autowired
    @Qualifier("RFMCalculator")
    public RFMCalculator rfmCalculator;

    @Autowired
    @Qualifier("BMICalculator")
    public BMICalculator bmiCalculator;

    public CalculatorManager() {
    }

    public BigDecimal calculateBMI(BigDecimal weight, BigDecimal height) {
        logger.info("Started calculateBMI in CalculatorManager");

        return bmiCalculator.calculateBMI(weight, height);
    }

    public BigDecimal calculateWhr(BigDecimal waistRatio, BigDecimal hipRatio){
        logger.info("Started calculateWhr in CalculatorManager");

        return whrCalculator.calculateWHR(waistRatio,hipRatio);
    }

    public BigDecimal calculateRFM(Gender gender, BigDecimal height, BigDecimal waistRatio) {
        logger.info("Started calculateRFM in CalculatorManager");

        return rfmCalculator.calculateRFM(gender, height, waistRatio);
    }
}
