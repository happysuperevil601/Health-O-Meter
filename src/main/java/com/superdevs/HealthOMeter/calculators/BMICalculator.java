package com.superdevs.HealthOMeter.calculators;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

@Component
public class BMICalculator {

    Logger logger = LoggerFactory.getLogger(BMICalculator.class);

    public BigDecimal calculateBMI(BigDecimal height, BigDecimal weight) {
        MathContext mathContext = new MathContext(3, RoundingMode.HALF_UP);

        logger.debug("Starting BMI calculation!");

        if (weight == null
                || height == null
                || weight.compareTo(BigDecimal.ZERO) == 0
                || height.compareTo(BigDecimal.ZERO) == 0)
            return BigDecimal.ZERO;

        BigDecimal hundred = new BigDecimal(100);
        BigDecimal convertedHeight = height.divide(hundred);
        return weight.divide(convertedHeight.pow(2), mathContext);
    }
}