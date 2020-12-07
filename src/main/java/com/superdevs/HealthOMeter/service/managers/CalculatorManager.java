package com.superdevs.HealthOMeter.service.managers;

import com.superdevs.HealthOMeter.calculator.WHRCalculator;
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
        return whrCalculator.calculateWhr(waistRatio,hipRatio);
    }

    public BigDecimal calculateRFM(String sex, BigDecimal height, BigDecimal waistRatio) {
        MathContext mathContext = new MathContext(3);


        //Bismarck - this section (in future) requires refactor
        if (sex != null && height != null && waistRatio!= null
                && height.compareTo(BigDecimal.ZERO) > 0 && waistRatio.compareTo(BigDecimal.ZERO) > 0
                && (sex.equalsIgnoreCase("male") || sex.equalsIgnoreCase("female"))) {
            BigDecimal partialResult = new BigDecimal("20").multiply(height).divide(waistRatio, mathContext);
            if (sex.equalsIgnoreCase("male")) {
                return  new BigDecimal("64").subtract(partialResult);
            } else if (sex.equalsIgnoreCase("female")) {
                return new BigDecimal("76").subtract(partialResult);
            }
        }
        return BigDecimal.ZERO;
    }
}
