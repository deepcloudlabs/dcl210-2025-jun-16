package com.example.javase07;

public class Exercise13 {
	@SuppressWarnings("unused")
	public static void main(String[] args) {

		// try-with-resources
		try(
				PreciousResource res1 = new PreciousResource(1);
				PreciousResource res2 = new PreciousResource(2);
				PreciousResource res3 = new PreciousResource(3);
				// Error: MyResource res4 = new MyResource();
		) {
			System.out.println("Using the resources...");
			throw new Exception("Something is wrong!");
		} catch (Exception e) {
			System.err.println("An error has occured while running the application: %s".formatted(e.getMessage()));
		    for (Throwable t : e.getSuppressed()) {
		    	System.err.println(t.getMessage());
		    }
		} 
	}

}

class MyResource {}
