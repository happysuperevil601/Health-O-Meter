package com.superdevs.HealthOMeter.service.managers;

import com.superdevs.HealthOMeter.calculator.RFMCalculator;
import com.superdevs.HealthOMeter.calculator.WHRCalculator;
import com.superdevs.HealthOMeter.entity.Gender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

@Component
public class CalculatorManager {

    @Autowired
    @Qualifier("WHRCalculator")
    public WHRCalculator whrCalculator;

    @Autowired
    @Qualifier("RFMCalculator")
    public RFMCalculator rfmCalculator;

    public CalculatorManager(@Qualifier("WHRCalculator") WHRCalculator whrCalculator) {
        this.whrCalculator = whrCalculator;
    }

    public BigDecimal calculateBMI(BigDecimal weight, BigDecimal height) {

        MathContext mathContext = new MathContext(3, RoundingMode.HALF_UP);
        // For now, because i don't know how we handle wrong data I added below "if" statement
        if (weight == null || height == null || weight.compareTo(BigDecimal.ZERO) == 0) {
            return new BigDecimal("0.000");
        }
        return weight.divide(height.pow(2), mathContext);
    }

    public BigDecimal calculateWhr(BigDecimal waistRatio, BigDecimal hipRatio){
        return whrCalculator.calculateWHR(waistRatio,hipRatio);
    }

    public BigDecimal calculateRFM(Gender gender, BigDecimal height, BigDecimal waistRatio) {
        return rfmCalculator.calculateRFM(gender, height, waistRatio);
    }
}
