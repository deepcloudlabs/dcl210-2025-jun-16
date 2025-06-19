package com.example;

import java.util.HashSet;
import java.util.Set;

public class Exercise08 {

	public static void main(String[] args) {
		Set<A> set = new HashSet<>();
		for (var i=0;i<1_000_000;++i) {
			set.add(new A(42));
		}
        System.out.println(set.size()); 
        for (var i=0;i<1_000_000;++i) {
        	set.remove(new A(42));
        }
        System.out.println(set.size()); 
        
	}

}

record A(int i) {}
