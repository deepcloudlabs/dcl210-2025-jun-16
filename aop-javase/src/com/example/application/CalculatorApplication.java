package com.example.application;

import java.lang.reflect.Proxy;

import com.example.handler.ProfileHandler;
import com.example.handler.ValidationHandler;
import com.example.service.ArithmeticCalculator;
import com.example.service.business.StandardArithmeticCalculator;

public class CalculatorApplication {

	public static void main(String[] args) {
		ArithmeticCalculator arithmeticCalculator = new StandardArithmeticCalculator();
		var calculatorProxy = (ArithmeticCalculator) Proxy.newProxyInstance(
				arithmeticCalculator.getClass().getClassLoader(), 
				arithmeticCalculator.getClass().getInterfaces(), 
				new ProfileHandler(arithmeticCalculator)
		);
		arithmeticCalculator = (ArithmeticCalculator) Proxy.newProxyInstance(
				arithmeticCalculator.getClass().getClassLoader(), 
				arithmeticCalculator.getClass().getInterfaces(), 
				new ValidationHandler(calculatorProxy)
				);
		
		System.out.println(arithmeticCalculator.getClass().getName());
		System.out.println("3+5=%f".formatted(arithmeticCalculator.add(3,5))); 
		System.out.println("3-5=%f".formatted(arithmeticCalculator.sub(3,5))); 
		System.out.println("3*-5=%f".formatted(arithmeticCalculator.mul(3,-5))); 
		System.out.println("3/5=%f".formatted(arithmeticCalculator.div(3,5))); 
	}

}
