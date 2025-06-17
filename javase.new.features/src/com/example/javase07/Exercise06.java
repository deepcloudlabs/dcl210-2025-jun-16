package com.example.javase07;

public class Exercise06 {
	public static void main(String[] args) {
		// byte, short, int, char, Enum, **String**
		String weekDay = "Tuesday";
		String message = "";
		switch (weekDay) {
			case "Monday", "Tuesday", "Wednesday", "Thursday", "Friday" -> {
				message = "Work hard!";
			}
			case "Saturday", "Sunday" -> {
				message = "Rest now!";
			}
			default -> {
				throw new IllegalArgumentException("%d is not a valid week day!".formatted(weekDay));
			}
		}
		System.out.println(message);
	}
}
