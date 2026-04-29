package javaAdvance.oops.inheritance;

public class SuperMethodDemo{

	public static void main(String[] args) {
		Parent p = new Parent();
		p.commonMeth();
		Child c = new Child();
		c.commonMeth();
	}
}

class Parent {
	void parantSpeech() {
		System.out.println("This is parent speech");
	}

	void commonMeth() {
		System.out.println("parent method");
	}
}

class Child extends Parent {

	void commonMeth() {
		super.commonMeth(); // Calling method from Parent class.
		super.parantSpeech();
		System.out.println("Child method");
	}

	void print() {
		System.out.println("child print");
	}
}
