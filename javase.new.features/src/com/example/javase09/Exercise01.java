package com.example.javase09;

public class Exercise01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

interface OOO {
	public static void fun() {
		sun();
	}
	public static void gun() {
		sun();
	}
	private static void sun() { // java se 9
		
	}
	
	default void run() {
		pun();
	}
	default void tun() {
		pun();		
	}
	private void pun() {} // java se 9
}
