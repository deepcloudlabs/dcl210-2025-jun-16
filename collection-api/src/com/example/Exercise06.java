package com.example;

public class Exercise06 {

	public static void main(String[] args) {
		var name1 = "Jack"; // Constant Pool
		var name2 = new String("Jack"); // Heap
		var name3 = "Jack"; // Constant Pool
		// name2 = name2.intern(); // internalize: Heap -> Constant Pool
		// -XX:+UseStringDeduplication
		// -XX:+UseG1GC // default since Java 9
		// Full GC -> StringDeduplication
		System.out.println("name1 == name2: "+(name1==name2));
		System.out.println("name1 == name3: "+(name1==name3));
	}

}
