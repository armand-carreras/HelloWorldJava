package com.netmind.business;

import java.util.Arrays;

public class Calculator {
	
	public int add(int num1, int num2) {
		return num1 + num2;
	}
	
	public int substract(int num1, int num2) {
		return num1 - num2;
	}
	
	public int multiply(int num1, int num2) {
		return num1 * num2;
	}
	
	public int divide(int num1, int num2) {
		return num1 / num2;
	}
	
	public double pow(double base, double exponent) {
		return Math.pow(base, exponent);
	}
	public int sumaPares() {
		int[] arr = new int[100];
		Arrays.fill(arr, 4);
		Arrays.fill(arr, 1, 40, 10);
		Arrays.fill(arr, 41, 70, 30);
		int arrSum = 0;
		for(int index = 0; index < arr.length; index++) {
			if(index%2==0) {
				arrSum+=arr[index];
			}
		}
		System.out.println(Arrays.toString(arr));
		return arrSum;
	}
	
	
	public int sumaParesArr(int[] arr) {
		int arrSum = 0;
		
		for(int index = 0; index < arr.length; index++) {
			if(index%2==0) {
				arrSum+=arr[index];
			}
		}
		System.out.println(arr.length);
		System.out.println(Arrays.toString(arr));
		return arrSum;
	}
}
