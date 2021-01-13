package com.superdevs.HealthOMeter.service.calculatorServiceTests;

import com.superdevs.HealthOMeter.calculators.BMICalculator;
import com.superdevs.HealthOMeter.calculators.RFMCalculator;
import com.superdevs.HealthOMeter.calculators.WHRCalculator;
import com.superdevs.HealthOMeter.service.CalculatorService;
import com.superdevs.HealthOMeter.service.managers.CalculatorManager;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
@RunWith(SpringRunner.class)
public class CalculatorServiceTestsForBMI {

    public ApplicationContext context = new AnnotationConfigApplicationContext(CalculatorManager.class,
            CalculatorService.class, BMICalculator.class);

    public CalculatorService calculatorService = context.getBean(CalculatorService.class);


    @Test
    public void testCalculatorServiceForBMI() {

        //Given
        BigDecimal weight = new BigDecimal(119.522);
        BigDecimal height = new BigDecimal(197);
        BigDecimal expectedValue = new BigDecimal(30.8);

        //When
        BigDecimal result = calculatorService.getCalculateBMI(height, weight);
        System.out.println(result);

        //Then
        Assertions.assertEquals(expectedValue, result);
    }

    @Test
    public void testBMIWithZeroWeightValue() {

        //Given
        BigDecimal weight = new BigDecimal(0);
        BigDecimal height = new BigDecimal(197);
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
        BigDecimal weight = new BigDecimal(119.522);
        BigDecimal height = new BigDecimal(0);
        BigDecimal expectedValue = BigDecimal.ZERO;

        //When
        BigDecimal result = calculatorService.getCalculateBMI(height, weight);
        System.out.println(result);

        //Then
        Assertions.assertEquals(expectedValue, result);
    }

    @Test
    public void testBMIWithNegativeValue() {

        //Given
        BigDecimal weight = new BigDecimal(-119.522);
        BigDecimal height = new BigDecimal(197);
        BigDecimal result = calculatorService.getCalculateBMI(height, weight);

        //Then
        try {
            calculatorService.getCalculateBMI(height, weight);
        } catch (Exception e) {
            assertThat(e)
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("Negative values are not allowed here.");
        }

        System.out.println(result);

    }

}