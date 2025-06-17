package com.example.javase08;

public class Exercise01 {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		AAA aRef1 = new BBB();
		AAA aRef2 = new CCC();
		AAA aRef3 = new DDD();
        if (aRef1 instanceof CCC) {}
        if (aRef2 instanceof DDD) {}
        // Error: if (aRef1 instanceof EEE) {}
        if (aRef1 instanceof III) {}
        if (aRef1 instanceof JJJ) {}
        JJJ aRef4 = (JJJ) new EEE(); // Runtime: Class Cast Exception
        // Compilte-time: Error: AAA aRef4 = (AAA) new EEE();
	}

}

// interface -> OO Design
// GoF -> Design Patterns
// SOLID Principles: SRP, OCP, LSP, ISP, DIP
// centered around Java Interface
interface III {
}
interface JJJ {
	// implicitly: public static final 
	int x = 42;
	// implicit: public abstract 
	int fun(); 
}
interface KKK {}
interface MMM extends III, JJJ, KKK {} // multiple inheritance

abstract class AAA implements III {}
class BBB extends AAA {}
class CCC extends AAA {}
class DDD extends CCC {}
class EEE {}
class FFF implements III,JJJ,KKK {

	@Override
	public int fun() {
		// TODO Auto-generated method stub
		return 0;
	}}
class UUU {}
class VVV {}