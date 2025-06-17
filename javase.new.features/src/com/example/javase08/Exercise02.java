package com.example.javase08;

public class Exercise02 {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		// imperative programming: procedural/OO
		// loops: for, while
		
		// declarative programming: OO/functional
		// functions: 
		//    I. Higher-Order Function (HoF) 
		//   II. Pure Function
		//   Method Chain: HoF -> Pipeline
		//   Data -> ... -> Data -> Result
		
		int x = 42; // Value
		Circle circle = new Circle(); // Reference -> Object -> Attribute
		// Lambda Expression
		Fun fun1 = (u, v) -> u*v;
		System.out.println(fun1.getClass().getName());
		A a = new A();
		// Method Reference
		Fun fun2 = a::armut; 
		Fun fun3 = B::kiraz; // static method 
		// Error: Fun fun4 = B::kavun; // static method 
	}

}

class Circle {}

class A {
	public int armut(int x,int y) {
		return 2* x + y * y;
	}	
}

class B {
	public static int kiraz(int x,int y) {
		return 2* x + y * y;
	}		
	public static String kavun(float f) {
		return "kavun-%12.3f".formatted(f);
	}		
}

// Marker Interface: empty interface
// Example: Serializable

// SAM: Single Abstract Method -> Functional Interface
@FunctionalInterface
interface Fun {
	public abstract int elma(int x,int y);
}