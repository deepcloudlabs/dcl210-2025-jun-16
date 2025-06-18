package com.example.lottery.application;

import java.util.concurrent.TimeUnit;

public class HelloMars {

	public static void main(String[] args) throws InterruptedException {
		System.out.println("Hello Mars!");
		while (true) {
			System.gc();
			TimeUnit.SECONDS.sleep(5);
		}
	}

}
