package com.example;

import java.util.HashSet;
import java.util.Set;

public class Exercise04 {

	public static void main(String[] args) {
		Set<Integer> map = new HashSet<>(200_000_000,0.5f);
		var start = System.currentTimeMillis();
        for (var i=0;i<100_000_000;i++) {
        	map.add(i);
        }
		var stop = System.currentTimeMillis();
		System.err.println("Duration: %d ms.".formatted(stop-start));        
	}

}
