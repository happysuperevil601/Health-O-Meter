package com.superdevs.HealthOMeter.service;

import com.superdevs.HealthOMeter.calculator.BMICalculator;
import com.superdevs.HealthOMeter.calculator.RFMCalculator;
import com.superdevs.HealthOMeter.calculator.WHRCalculator;
import com.superdevs.HealthOMeter.entity.Gender;
import com.superdevs.HealthOMeter.service.managers.CalculatorManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.math.BigDecimal;

@SpringBootTest
public class CalculatorServiceTest {

    static ApplicationContext context;
    static CalculatorService calculatorService;

    @BeforeAll
    static void loadTestData(){
        context = new AnnotationConfigApplicationContext(CalculatorManager.class, CalculatorService.class,
                WHRCalculator.class, RFMCalculator.class, BMICalculator.class);
        calculatorService = context.getBean(CalculatorService.class);
    }

    @Test
    void contextLoads() {
    }

    @Test
    void testCalculatorServiceForBMI() {

        //Arrange
        BigDecimal weight = new BigDecimal("119.522");
        BigDecimal height = new BigDecimal("1.971");
        BigDecimal expectedValue = new BigDecimal("30.8");

        //Act
        BigDecimal result = calculatorService.getCalculateBMI(weight, height);

        //Assert
        Assertions.assertEquals(0, result.compareTo(expectedValue));
    }

    @Test
    void testCalculatorServiceForWHR(){

        //Arrange
        BigDecimal waist = new BigDecimal("72");
        BigDecimal hip = new BigDecimal("93");
        BigDecimal expectedScore = new BigDecimal("0.77");

        //Act
        BigDecimal result = calculatorService.getCalculateWHR(waist,hip);

        //Assert
        Assertions.assertEquals(expectedScore, result);
    }

    @Test
    void testCalculatorServiceForWHRWithZero(){

        //Arrange
        BigDecimal waist = new BigDecimal("0");
        BigDecimal hip = new BigDecimal("93");
        BigDecimal expectedScore = BigDecimal.ZERO;

        //Act
        BigDecimal result = calculatorService.getCalculateWHR(waist,hip);

        //Assert
        Assertions.assertEquals(expectedScore, result);
    }

    @Test
    void testCalculatorServiceForRFMForFemale() {

        //Arrange
        Gender gender = Gender.FEMALE;
        BigDecimal height = new BigDecimal("168.90");
        BigDecimal waist = new BigDecimal("72");
        BigDecimal expectedResult = new BigDecimal("29.1");

        //Act
        BigDecimal result = calculatorService.getCalculateRFM(gender, height, waist);

        //Assert
        Assertions.assertEquals(0, result.compareTo(expectedResult));
    }

    @Test
    void testCalculatorServiceForRFMMale() {

        //Arrange
        Gender gender = Gender.MALE;
        BigDecimal height = new BigDecimal("168.90");
        BigDecimal waist = new BigDecimal("72");
        BigDecimal expectedResult = new BigDecimal("17.1");

        //Act
        BigDecimal result = calculatorService.getCalculateRFM(gender, height, waist);

        //Assert
        Assertions.assertEquals(0, result.compareTo(expectedResult));
    }

    @Test
    void testCalculatorServiceForRFMZero() {

        //Arrange
        Gender gender = Gender.MALE;
        BigDecimal height = new BigDecimal("168.90");
        BigDecimal waist = new BigDecimal("0");
        BigDecimal expectedResult = BigDecimal.ZERO;

        //Act
        BigDecimal result = calculatorService.getCalculateRFM(gender, height, waist);

        //Assert
        Assertions.assertEquals(0, result.compareTo(expectedResult));
    }

}
