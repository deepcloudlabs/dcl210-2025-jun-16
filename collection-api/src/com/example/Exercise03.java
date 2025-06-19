package com.example;

import java.util.ArrayList;

public class Exercise03 {

	public static void main(String[] args) {
		// -XX:AutoBoxCacheMax=2048
		var numbers = new ArrayList<>(100_000_000); // capacity: 100_000_000
		var start = System.currentTimeMillis();
		for (var i=0;i<100_000_000;++i) { // capacity -> 1.5x
			numbers.add(Integer.valueOf(11542));
		}
		var stop = System.currentTimeMillis();
		System.err.println("Duration: %d ms.".formatted(stop-start));
	}

}
