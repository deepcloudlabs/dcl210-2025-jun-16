package com.example.exercises;

import java.util.List;

public class Exercise19 {

	public static void main(String[] args) {
		System.out.println("Application is started.");
		var numbers = List.of(4,8,15,16,23,42);
		numbers.stream()
		       .filter(Utility::isEven) // intermediary
		       .map(Utility::toCube) // intermediary
		       .reduce(0,Utility::accumulate); // terminal
		System.out.println("Application is done.");
	}

}


interface Utility {
	public static boolean isEven(int n) {
		System.out.println("isEven(%d) is called".formatted(n));
		return n%2 == 0;
	}
	public static int toCube(int n) {
		System.out.println("toCube(%d) is called".formatted(n));
		return n*n*n;
	}
	public static int accumulate(int acc,int n) {
		System.out.println("accumulate(%d,%d) is called".formatted(acc,n));
		return acc+n;
	}
}