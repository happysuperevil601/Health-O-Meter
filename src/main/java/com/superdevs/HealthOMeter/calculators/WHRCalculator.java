package com.superdevs.HealthOMeter.calculators;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

@Component
public class WHRCalculator {

    Logger logger = LoggerFactory.getLogger(WHRCalculator.class);

    public BigDecimal calculateWHR(BigDecimal waistRatio, BigDecimal hipRatio){
        MathContext mathContext = new MathContext(2, RoundingMode.HALF_UP);

        logger.debug("Starting WHR calculation!");

        if(waistRatio == null
                || hipRatio == null
                || waistRatio.compareTo(BigDecimal.ZERO) == 0
                || hipRatio.compareTo(BigDecimal.ZERO)== 0)
            return BigDecimal.ZERO;

        return waistRatio.divide(hipRatio, mathContext);
    }
}