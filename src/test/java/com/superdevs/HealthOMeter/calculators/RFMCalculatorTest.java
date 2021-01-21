package com.superdevs.HealthOMeter.calculators;

import com.superdevs.HealthOMeter.entity.Gender;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

@SpringBootTest
@RunWith(SpringRunner.class)
public class RFMCalculatorTest {
    @Autowired
    RFMCalculator rfmCalculator;

    @Test
    public void testCalculateRFMForMale() {
        //Given
        Gender gender = Gender.MALE;
        BigDecimal height = new BigDecimal("168.90");
        BigDecimal waist = new BigDecimal("72");
        BigDecimal expectedResult = new BigDecimal("17.1");

        //When
        BigDecimal result = rfmCalculator.calculateRFM(gender, height, waist);

        //Then
        Assertions.assertEquals(0, result.compareTo(expectedResult));
    }

    @Test
    public void testCalculateRFMForFemale() {
        //Given
        Gender gender = Gender.FEMALE;
        BigDecimal height = new BigDecimal("168.90");
        BigDecimal waist = new BigDecimal("72");
        BigDecimal expectedResult = new BigDecimal("29.1");

        //When
        BigDecimal result = rfmCalculator.calculateRFM(gender, height, waist);

        //Then
        Assertions.assertEquals(0, result.compareTo(expectedResult));
    }

    @Test
    public void testCalculateRFMWithZero() {
        //Given
        Gender gender = Gender.MALE;
        BigDecimal height = BigDecimal.ZERO;
        BigDecimal waist = new BigDecimal("72");
        BigDecimal expectedResult = BigDecimal.ZERO;

        //When
        BigDecimal result = rfmCalculator.calculateRFM(gender, height, waist);

        //Then
        Assertions.assertEquals(0, result.compareTo(expectedResult));
    }

    @Test
    public void testCalculateRFMWithNull() {
        //Given
        Gender gender = Gender.FEMALE;
        BigDecimal height = new BigDecimal("168.90");
        BigDecimal waist = null;
        BigDecimal expectedResult = BigDecimal.ZERO;

        //When
        BigDecimal result = rfmCalculator.calculateRFM(gender, height, waist);

        //Then
        Assertions.assertEquals(0, result.compareTo(expectedResult));
    }

    @Test
    public void testCalculateRFMWithNegativeValue() {
        //Given
        Gender gender = Gender.FEMALE;
        BigDecimal height = new BigDecimal("-168.90");
        BigDecimal waist = new BigDecimal("72");
        BigDecimal expectedResult = BigDecimal.ZERO;

        //When
        BigDecimal result = rfmCalculator.calculateRFM(gender, height, waist);

        //Then
        Assertions.assertEquals(0, result.compareTo(expectedResult));
    }
}
