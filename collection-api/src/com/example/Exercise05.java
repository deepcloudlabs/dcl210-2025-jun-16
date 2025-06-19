package com.example;

import java.util.ArrayList;

public class Exercise05 {

	public static void main(String[] args) {
		var numbers = new ArrayList<String>(100_000_000); // capacity: 100_000_000
		var start = System.currentTimeMillis();
		for (var i=0;i<100_000_000;++i) { // capacity -> 1.5x
			numbers.add(new String("jack")); // dynamic String -> Heap
			numbers.add("jack"); // static String -> constant pool
		}
		var stop = System.currentTimeMillis();
		System.err.println("Duration: %d ms.".formatted(stop-start));
	}

}
