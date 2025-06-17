package com.example.javase07;

import java.util.List;

public class Exercise09 {

	public static void main(String[] args) {
		List<Animal> animals = List.of(new Cat(),new Spider(),null,new Fish(),new Cat(),new Spider(),new Fish());
        for (Animal animal: animals) {
        	if (animal instanceof Pet pet) {
        		// Pet pet = (Pet) animal;
        		pet.play();        		
        	}
        	switch(animal) {
	        	case null -> {
	        		System.out.println("No animal!");
	        	}
	        	case Cat cat when cat.legs > 3 -> {
	        		cat.walk();
	        	}
	        	case Spider spider when spider.legs > 6 -> {
	        		spider.bite();
	        	}
	        	case Fish fish when fish.legs == 0 -> {
	        		fish.swim();
	        	}
	        	case Fish fish when fish.legs > 0 -> {
	        		fish.swim();
	        		fish.walk();
	        	}
	        	default -> {
	        		throw new IllegalStateException("No such animal!");
	        	}
        	}
        } 
	}

}

abstract class Animal {
	public int legs;
}

interface Pet {
	default void play() {
	}
}

class Spider extends Animal {
	public void bite() {
	}
}

class Cat extends Animal implements Pet {
	public void walk() {
	}
}

class Fish extends Animal implements Pet {
	public void swim() {
	}

	public void walk() {
	}
}