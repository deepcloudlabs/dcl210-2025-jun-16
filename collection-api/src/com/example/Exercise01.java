package com.example;

import java.util.List;

public class Exercise01 {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		int x = 42; // 4-Byte
		Integer y = 542; // y: reference variable -> 8-Byte -> -XX:+CompressedOops -> 4-Byte
		                 // Heap Object -> Object Header ( 12-Byte ) + (int) 4-Byte 
		                 // 20-Byte
		x++;
		y++; // y = Integer.valueOf(y.intValue() + 1); // GC
		List<Integer> numbers = List.of(100,200,300,400,500);
        List<Circle> circles = List.of(new Circle(0, 0, 100),new Circle(10, 10, 200));
                               // 0 | 0 | 100 | 10 | 10 | 200
	}

}

record Circle(int x,int y,int radius) {}