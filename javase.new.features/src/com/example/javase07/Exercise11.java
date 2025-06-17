package com.example.javase07;

import java.io.Closeable;
import java.io.IOException;

public class Exercise11 {

	public static void main(String[] args) {
		PreciousResource res1 = new PreciousResource(1);
		PreciousResource res2 = new PreciousResource(2);
		PreciousResource res3 = new PreciousResource(3);
		try {
			System.out.println("Using the resources...");
			throw new Exception("Something is wrong!");
		} catch (Exception e) {
			System.err.println("An error has occured while running the application: %s".formatted(e.getMessage()));
		} finally {
			try {
				res1.close();
			} catch (IOException e) {
				System.err.println("An error has occured while closing the resource: %s".formatted(e.getMessage()));
			} finally {
				try {
					res2.close();
				} catch (IOException e) {
					System.err.println("An error has occured while closing the resource: %s".formatted(e.getMessage()));
				} finally {
					try {
						res3.close();
					} catch (IOException e) {
						System.err.println("An error has occured while closing the resource: %s".formatted(e.getMessage()));
					}
				}
			}
		}
	}

}

class PreciousResource implements Closeable {
    private final int id;
    
	public PreciousResource(int id) {
		this.id = id;
	}

	@Override
	public void close() throws IOException {
		System.err.println("Closing the resource with id %d".formatted(id));
		throw new IllegalStateException("Ooooppps. Something is wrong with closing the resource with id %d".formatted(id));
	}
}