package com.example.javase07;

public class Exercise10 {

	public static void fun() throws E2 {} 
	public static void sun() throws E1 {} 
	public static void gun() throws E2 {
		try {
			fun(); // E2
		} catch(E1 e) {
			System.err.println("Error has occured: %s".formatted(e.getMessage()));
			throw e; // e -> E1 
		}
	} 
	public static void main(String[] args) throws E2 {
		gun();

	}

}

@SuppressWarnings("serial")
class E1 extends Exception {} // Checked/Business Exception
@SuppressWarnings("serial")
class E2 extends E1 {} // Checked/Business Exception
@SuppressWarnings("serial")
class E3 extends E2 {} // Checked/Business Exception