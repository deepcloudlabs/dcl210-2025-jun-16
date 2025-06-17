package com.example.javase09;

public class Exercise02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

/*==============Abstraction============*/
sealed abstract class Animal permits Spider, Cat{}
                                  // final, sealed, non-sealed
abstract interface Pet {}

/*==============Concereat============*/
final class Spider extends Animal {}
sealed class Cat extends Animal implements Pet permits VanCat {}
non-sealed class VanCat extends Cat {}
class AAAA extends VanCat {}