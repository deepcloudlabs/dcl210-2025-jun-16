package com.example.javase07;

public class Exercise03 {
	public static void main(String[] args) {
		// byte, short, int, char, Enum, **String**
		String weekDay = "Tuesday"; 
		switch(weekDay) {
		case "Monday":
		case "Tuesday":
		case "Wednesday":
		case "Thursday":
		case "Friday":
			System.out.println("Work hard!");
			break;
		case "Saturday":
		case "Sunday":
			System.out.println("Rest now!");
			break;
			default:
				throw new IllegalArgumentException("%d is not a valid week day!".formatted(weekDay));
		}	
	}
}
