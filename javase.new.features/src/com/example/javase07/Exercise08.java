package com.example.javase07;

public class Exercise08 {
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		Shape shape = new ColorfulCircle(125,"red");
		if (shape instanceof ColorfulCircle colorfulCircle) {
			// ColorfulCircle colorfulCircle = (ColorfulCircle) shape;
			if (colorfulCircle.getColor().equals("red") && colorfulCircle.getRadius() < 100) {
				
			}
		} else if (shape instanceof Circle) {
			
		} else if (shape instanceof Square) {
			
		} else {
			throw new IllegalArgumentException("This is not a shape");						
		}
		
		switch (shape) {
			case ColorfulCircle colorfulCircle 
			     when colorfulCircle.getColor().equals("red") && colorfulCircle.getRadius() < 100 -> {
				
			}
			case Circle circle when circle.getRadius() > 100.0 -> {
				
			}
			case Square square -> {}
			default ->{
				throw new IllegalArgumentException("This is not a shape");			
			}
		}
		
	}
}

interface Shape {}
class Circle implements Shape {
	private int radius;

	public Circle(int radius) {
		this.radius = radius;
	}

	public int getRadius() {
		return radius;
	}
	
}
class ColorfulCircle extends Circle {
	private String color;

	public ColorfulCircle(int radius, String color) {
		super(radius);
		this.color = color;
	}

	public String getColor() {
		return color;
	}
	
}
class Square implements Shape {}
