package com.example;

public class Exercise07 {

	public static void main(String[] args) {
		var s = new StringBuilder(488890);
		var start = System.currentTimeMillis();
		for (var i=0;i<100_000;++i) {
			s.append(Integer.toString(i));
		}
		var stop = System.currentTimeMillis();
		System.err.println("Duration[%d]: %d ms.".formatted(s.length(),stop-start));

	}

}
