package com.example.javase07;

public class Exercise02 {
	public static void main(String[] args) {
		// byte, short, int, char, Enum
		int weekDay = 3; 
		switch(weekDay) {
		case 1:
		case 2:
		case 3:
		case 4:
		case 5:
			System.out.println("Work hard!");
			break;
		case 6:
		case 7:
			System.out.println("Rest now!");
			break;
			default:
				throw new IllegalArgumentException("%d is not a valid week day!".formatted(weekDay));
		}	
	}
}
