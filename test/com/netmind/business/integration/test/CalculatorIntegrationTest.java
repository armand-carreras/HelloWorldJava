package com.netmind.business.integration.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.netmind.business.Calculator;

public class CalculatorIntegrationTest {

	@Test
	public void testAdd() {
		Calculator calculator = new Calculator();
		assertEquals(calculator.add(1,6),7);
	}

	@Test
	public void testSubstract() {
		
		Calculator calculator = new Calculator();
		assertEquals(calculator.substract(1,6),-5);
		}

	@Test
	public void testMultiply() {
		Calculator calculator = new Calculator();
		assertEquals(calculator.multiply(1,6),6);
	}

	@Test
	public void testDivide() {
		Calculator calculator = new Calculator();
		assertEquals(calculator.divide(6,6),1);
	}

	
	@Test
	public void testSumaPares() {
		Calculator calculator = new Calculator();
		
		assertEquals(calculator.sumaPares(),678);
	}
}
