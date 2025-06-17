package com.example.javase08;

public class Exercise04 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

interface TTT {
	default int fun(int x) {
		return 2 * x;
	}
}

interface SSS {
	default int fun(int x) {
		return 4 * x * x + 5 * x;
	}
}

class YYY implements TTT, SSS {

	@Override
	public int fun(int x) {
		return SSS.super.fun(x);
	}
	
} 