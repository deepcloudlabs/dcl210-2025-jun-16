package com.example.javase08;

import java.util.List;

public class Exercise03 {

	public static void main(String[] args) {
		var numbers = List.of(4,8,15,16,23,42);
		numbers.stream()
		       .filter(F::isOdd)
		       .count();

	}

}

interface F {
	// static: java 8
	public static boolean isOdd(int x) {
		return x%2 == 1;
	}
	// default [implementation]
	public default int fun() {
		return 42;
	}
}

class G implements F {
	
}