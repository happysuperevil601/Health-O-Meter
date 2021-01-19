package com.superdevs.HealthOMeter.calculators;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

@SpringBootTest
@RunWith(SpringRunner.class)
public class WHRCalculatorTest {
    @Autowired
    WHRCalculator whrCalculator;

    @Test
    public void testCalculateWHR() {
        //Given
        BigDecimal waist = new BigDecimal("72");
        BigDecimal hip = new BigDecimal("93");
        BigDecimal expectedScore = new BigDecimal("0.77");

        //When
        BigDecimal result = whrCalculator.calculateWHR(waist, hip);

        //Then
        Assertions.assertEquals(0, expectedScore.compareTo(result));
    }

    @Test
    public void testCalculateWHRWithNull() {
        //Given
        BigDecimal waist = null;
        BigDecimal hip = new BigDecimal("93");
        BigDecimal expectedScore = BigDecimal.ZERO;

        //When
        BigDecimal result = whrCalculator.calculateWHR(waist, hip);

        //Then
        Assertions.assertEquals(0, expectedScore.compareTo(result));
    }

    @Test
    public void testCalculateWHRWithZero() {
        //Given
        BigDecimal waist = BigDecimal.ZERO;
        BigDecimal hip = new BigDecimal("93");
        BigDecimal expectedScore = BigDecimal.ZERO;

        //When
        BigDecimal result = whrCalculator.calculateWHR(waist, hip);

        //Then
        Assertions.assertEquals(0, expectedScore.compareTo(result));
    }

    @Test
    public void testCalculateWHRWithNegativeValue() {
        //Given
        BigDecimal waist = new BigDecimal("-72");
        BigDecimal hip = new BigDecimal("93");
        BigDecimal expectedScore = new BigDecimal("-0.77");

        //When
        BigDecimal result = whrCalculator.calculateWHR(waist, hip);

        //Then
        Assertions.assertEquals(0, expectedScore.compareTo(result));
    }
}