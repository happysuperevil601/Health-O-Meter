package com.superdevs.HealthOMeter.service;

import com.superdevs.HealthOMeter.service.managers.CalculatorManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class CalculatorService {

    @Autowired
    CalculatorManager calculatorManager;

    public BigDecimal getCalculateBMI(BigDecimal weight, BigDecimal height) {
        return calculatorManager.calculateBMI(weight, height);
    }

    public BigDecimal getCalculateWHR(BigDecimal waistRatio, BigDecimal hipRatio) {

        return calculatorManager.calculateWhr(waistRatio, hipRatio);
}
}
