package com.netmind.business.integration.test;

import static org.junit.Assert.*;

import java.util.stream.IntStream;

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
	
	@Test
	public void testSumaParesArr() {
		Calculator calculator = new Calculator();
		int [] myIntArray = IntStream.rangeClosed(0, 99).toArray();
		assertEquals(calculator.sumaParesArr(myIntArray),2550);
	}
}
