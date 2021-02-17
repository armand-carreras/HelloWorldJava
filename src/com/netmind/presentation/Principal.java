 package com.netmind.presentation;

import java.util.stream.IntStream;

import com.netmind.business.Calculator;

public class Principal {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Calculator calculator = new Calculator();
		
		System.out.println(calculator.sumaPares());
		
		
		int [] myIntArray = IntStream.rangeClosed(0, 99).toArray();
		
		System.out.println(calculator.sumaParesArr(myIntArray));
		
		
		System.out.println("This is my first Java Project");
	}

}
