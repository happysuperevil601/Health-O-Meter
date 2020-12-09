package com.superdevs.HealthOMeter.service.managers;

import com.superdevs.HealthOMeter.calculators.BMICalculator;
import com.superdevs.HealthOMeter.calculators.RFMCalculator;
import com.superdevs.HealthOMeter.calculators.WHRCalculator;
import com.superdevs.HealthOMeter.entity.Gender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class CalculatorManager {

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
        return bmiCalculator.calculateBMI(weight, height);
    }

    public BigDecimal calculateWhr(BigDecimal waistRatio, BigDecimal hipRatio){
        return whrCalculator.calculateWHR(waistRatio,hipRatio);
    }

    public BigDecimal calculateRFM(Gender gender, BigDecimal height, BigDecimal waistRatio) {
        return rfmCalculator.calculateRFM(gender, height, waistRatio);
    }
}
