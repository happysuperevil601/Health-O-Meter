package com.superdevs.HealthOMeter.calculators;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@RunWith(SpringRunner.class)
class BMICalculatorTest {

    @Autowired
    private BMICalculator bmiCalculator;

    @Test
    public void testCalculateBMI() {

        //Given
        BigDecimal weight = new BigDecimal("119.52");
        BigDecimal height = new BigDecimal("197");
        BigDecimal expectedValue = new BigDecimal("30");

        //When
        BigDecimal result = bmiCalculator.calculateBMI(height, weight);

        //Then
        assertEquals(expectedValue, result);
    }

    @Test
    public void testCalculateBMIWithZero() {

        //Given
        BigDecimal weight = new BigDecimal("119.52");
        BigDecimal height = new BigDecimal("0");
        BigDecimal expectedValue = BigDecimal.ZERO;

        //When
        BigDecimal result = bmiCalculator.calculateBMI(height, weight);

        //Then
        assertEquals(expectedValue, result);
    }

    @Test
    public void testCalculateBMIWithNegativeValue() {

        //Given
        BigDecimal weight = new BigDecimal("-119.52");
        BigDecimal height = new BigDecimal("197");
        BigDecimal expectedValue = new BigDecimal("-30");

        //When
        BigDecimal result = bmiCalculator.calculateBMI(height, weight);
        System.out.println(result);

        //Then
        assertEquals(expectedValue, result);
    }

}