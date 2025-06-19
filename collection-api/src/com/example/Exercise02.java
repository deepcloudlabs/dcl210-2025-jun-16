package com.example;

import java.util.Set;
import java.util.TreeSet;

public class Exercise02 {
	public static void main(String[] args) {
       // Linear Collections: 
	   // List: ArrayList, LinkedList
	   //       i. allow duplicates, ordered	
	   // Set : HashSet, LinkedHashSet, TreeSet
	   //       i. unique ii. unordered	
	   // Deque: ArrayDeque i. FIFO/LIFO ii. ordered iii. allow duplicates
	   // Associative Collection: Key -> Value	
	   // Map: HashMap, LinkedHashMap, TreeMap	
	   // Operations: Read, Write: Delete, Insert
	   // Access Pattern: Sequential, Random Access
	   // Sequential Read, RandomAccess Insert
	   Set<Integer> numbers = new TreeSet<>();
	   numbers.add(42);
	   numbers.add(4);
	   numbers.add(16);
	   numbers.add(23);
	   numbers.add(8);
	   numbers.add(15);
	   System.out.println(numbers);
	}
}
