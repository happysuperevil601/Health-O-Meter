package com.superdevs.HealthOMeter.service.managers;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

@Component
public class CalculatorManager {

    public BigDecimal calculateBMI(BigDecimal weight, BigDecimal height) {

        MathContext mathContext = new MathContext(3, RoundingMode.HALF_UP);
        // For now, because i don't know how we handle wrong data I added below "if" statement
        if (weight == null || height == null || weight.compareTo(BigDecimal.ZERO) == 0) {
            return new BigDecimal("0.000");
        }
        return weight.divide(height.pow(2), mathContext);
    }

    public BigDecimal calculateWhr (BigDecimal waistRatio, BigDecimal hipRatio){
        MathContext mathContext = new MathContext(2, RoundingMode.HALF_UP);

        if(waistRatio == null || hipRatio == null ||
                waistRatio.compareTo(BigDecimal.ZERO) == 0 || hipRatio.compareTo(BigDecimal.ZERO)== 0)
            return new BigDecimal("0.0000");

        return waistRatio.divide(hipRatio, mathContext);
    }

}
