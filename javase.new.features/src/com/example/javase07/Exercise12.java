package com.example.javase07;

public class Exercise12 {
	@SuppressWarnings("finally")
	public static int fun() {
		try {
			return 42;
		} finally {
			return 108;
		}
	}
	@SuppressWarnings("finally")
	public static int gun() {
		try {
			throw new Exception("Oooopsss");
		} catch(Exception e){
			return 42;			
		} finally {
			return 108;
		}
	}

	public static void main(String[] args) {
		System.out.println(fun());
		System.out.println(gun());
	}

}
