package com.example.javase07;

public class Exercise07 {
	public static void main(String[] args) {
		// byte, short, int, char, Enum, **String**
		String weekDay = "Tuesday";
		String message = switch (weekDay) {
			case "Monday", "Tuesday", "Wednesday", "Thursday", "Friday" -> {
				yield "Work hard!";
			}
			case "Saturday", "Sunday" -> {
				yield "Rest now!";
			}
			default -> {
				throw new IllegalArgumentException("%d is not a valid week day!".formatted(weekDay));
			}
		};
		System.out.println(message);
	}
}
