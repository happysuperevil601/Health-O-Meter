package com.superdevs.HealthOMeter.service;

import com.superdevs.HealthOMeter.calculators.BMICalculator;
import com.superdevs.HealthOMeter.calculators.RFMCalculator;
import com.superdevs.HealthOMeter.calculators.WHRCalculator;
import com.superdevs.HealthOMeter.entity.Gender;
import com.superdevs.HealthOMeter.service.managers.CalculatorManager;
import org.junit.jupiter.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

@SpringBootTest
@RunWith(SpringRunner.class)
public class CalculatorServiceTest {

    public ApplicationContext context = new AnnotationConfigApplicationContext(CalculatorManager.class, CalculatorService.class,
            WHRCalculator.class, RFMCalculator.class, BMICalculator.class);
    public CalculatorService calculatorService = context.getBean(CalculatorService.class);

    @Test
    public void testCalculatorServiceForBMI() {

        //Given
        BigDecimal weight = new BigDecimal("119.52");
        BigDecimal height = new BigDecimal("197");
        BigDecimal expectedValue = new BigDecimal("30");

        //When
        BigDecimal result = calculatorService.getCalculateBMI(height, weight);
        System.out.println(result);

        //Then
        Assertions.assertEquals(expectedValue, result);
    }

    @Test
    public void testBMIWithZeroWeightValue() {

        //Given
        BigDecimal weight = new BigDecimal("0");
        BigDecimal height = new BigDecimal("197");
        BigDecimal expectedValue = BigDecimal.ZERO;

        //When
        BigDecimal result = calculatorService.getCalculateBMI(height, weight);
        System.out.println(result);

        //Then
        Assertions.assertEquals(expectedValue, result);
    }

    @Test
    public void testBMIWithZeroHeightValue() {

        //Given
        BigDecimal weight = new BigDecimal("119.522");
        BigDecimal height = new BigDecimal("0");
        BigDecimal expectedValue = BigDecimal.ZERO;

        //When
        BigDecimal result = calculatorService.getCalculateBMI(height, weight);
        System.out.println(result);

        //Then
        Assertions.assertEquals(expectedValue, result);
    }

    @Test
    public void testCalculatorServiceForWHR() {

        //Given
        BigDecimal waist = new BigDecimal("72");
        BigDecimal hip = new BigDecimal("93");
        BigDecimal expectedScore = new BigDecimal("0.77");

        //When
        BigDecimal result = calculatorService.getCalculateWHR(waist, hip);

        //Then
        Assertions.assertEquals(expectedScore, result);
    }

    @Test
    public void testCalculatorServiceForWHRWithZero() {

        //Given
        BigDecimal waist = new BigDecimal("0");
        BigDecimal hip = new BigDecimal("93");
        BigDecimal expectedScore = BigDecimal.ZERO;

        //When
        BigDecimal result = calculatorService.getCalculateWHR(waist, hip);

        //Then
        Assertions.assertEquals(expectedScore, result);
    }

    @Test
    public void testCalculatorServiceForRFMForFemale() {

        //Given
        Gender gender = Gender.FEMALE;
        BigDecimal height = new BigDecimal("168.90");
        BigDecimal waist = new BigDecimal("72");
        BigDecimal expectedResult = new BigDecimal("29.1");

        //When
        BigDecimal result = calculatorService.getCalculateRFM(gender, height, waist);

        //Then
        Assertions.assertEquals(0, result.compareTo(expectedResult));
    }

    @Test
    public void testCalculatorServiceForRFMMale() {

        //Given
        Gender gender = Gender.MALE;
        BigDecimal height = new BigDecimal("168.90");
        BigDecimal waist = new BigDecimal("72");
        BigDecimal expectedResult = new BigDecimal("17.1");

        //When
        BigDecimal result = calculatorService.getCalculateRFM(gender, height, waist);

        //Then
        Assertions.assertEquals(0, result.compareTo(expectedResult));
    }

    @Test
    public void testCalculatorServiceForRFMZero() {

        //Given
        Gender gender = Gender.MALE;
        BigDecimal height = new BigDecimal("168.90");
        BigDecimal waist = new BigDecimal("0");
        BigDecimal expectedResult = BigDecimal.ZERO;

        //When
        BigDecimal result = calculatorService.getCalculateRFM(gender, height, waist);

        //Then
        Assertions.assertEquals(0, result.compareTo(expectedResult));
    }

}
