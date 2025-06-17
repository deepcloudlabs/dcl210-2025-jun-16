package com.example.javase07;

public class Exercise04 {
	public static void main(String[] args) {
		// byte, short, int, char, Enum, **String**
		String weekDay = "Tuesday"; 
		switch(weekDay) {
		case "Monday","Tuesday","Wednesday","Thursday","Friday":
			System.out.println("Work hard!");
			break;
		case "Saturday","Sunday":
			System.out.println("Rest now!");
			break;
			default:
				throw new IllegalArgumentException("%d is not a valid week day!".formatted(weekDay));
		}	
	}
}
