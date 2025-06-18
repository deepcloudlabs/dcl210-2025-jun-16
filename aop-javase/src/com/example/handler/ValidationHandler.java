package com.example.handler;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class ValidationHandler implements InvocationHandler {
	private final Object target;
	public ValidationHandler(Object target) {
		this.target = target;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        for (var arg : args) {
        	if (arg instanceof Double value && value < 0.0) {
        		throw new IllegalArgumentException("Double value is negative!");
        	}
        }  
        System.err.println("There are no negative double value!");
		return method.invoke(target, args);
	}

}
