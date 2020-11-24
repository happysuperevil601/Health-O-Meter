package com.superdevs.HealthOMeter;


import com.superdevs.HealthOMeter.service.CalculatorService;
import com.superdevs.HealthOMeter.service.managers.CalculatorManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.math.BigDecimal;

@SpringBootTest
class HealthOMeterApplicationTests {

	static ApplicationContext context;
	static CalculatorService calculatorService;

	@BeforeAll
	static void loadTestData(){
		context = new AnnotationConfigApplicationContext(CalculatorManager.class, CalculatorService.class);
		calculatorService = context.getBean(CalculatorService.class);
	}

	@Test
	void contextLoads() {
	}

	@Test
	void testCalculatorServiceForBMI() {
		//give
		BigDecimal weight = new BigDecimal("119.522");
		BigDecimal height = new BigDecimal("1.971");
		BigDecimal expectedValue = new BigDecimal("30.8");
		//when
		BigDecimal result = calculatorService.getCalculateBMI(weight, height);
		//then
		Assertions.assertEquals(0, result.compareTo(expectedValue));
	}

	@Test
	void testCalculatorServiceForWhr(){
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
	void testCalculatorServiceForWhrWithZero(){
		//Arrange
		BigDecimal waist = new BigDecimal("0");
		BigDecimal hip = new BigDecimal("93");
		BigDecimal expectedScore = new BigDecimal("0.0000");
		//Act
		BigDecimal result = calculatorService.getCalculateWHR(waist,hip);
		//Assert
		Assertions.assertEquals(expectedScore, result);
	}

	@Test
	void testCalculatorServiceForRfmForFemale() {
		//Arrange
		String sex = "female";
		BigDecimal height = new BigDecimal("168.90");
		BigDecimal waist = new BigDecimal("72");
		BigDecimal expectedResult = new BigDecimal("29.1");
		//Act
		BigDecimal result = calculatorService.getCalculateRFM(sex, height, waist);
		//Assert
		Assertions.assertEquals(0, result.compareTo(expectedResult));
	}

	@Test
	void testCalculatorServiceForRfmMale() {
		//Arrange
		String sex = "male";
		BigDecimal height = new BigDecimal("168.90");
		BigDecimal waist = new BigDecimal("72");
		BigDecimal expectedResult = new BigDecimal("17.1");
		//Act
		BigDecimal result = calculatorService.getCalculateRFM(sex, height, waist);
		//Assert
		Assertions.assertEquals(0, result.compareTo(expectedResult));
	}

	@Test
	void testCalculatorServiceForRfmZero() {
		//Arrange
		String sex = "male";
		BigDecimal height = new BigDecimal("168.90");
		BigDecimal waist = new BigDecimal("0");
		BigDecimal expectedResult = BigDecimal.ZERO;
		//Act
		BigDecimal result = calculatorService.getCalculateRFM(sex, height, waist);
		//Assert
		Assertions.assertEquals(0, result.compareTo(expectedResult));
	}
}
