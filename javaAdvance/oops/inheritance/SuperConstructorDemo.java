package javaAdvance.oops.inheritance;

public class SuperConstructorDemo {

	public static void main(String[] args) {
		Child2 c = new Child2();
	}
}

class Parent2 {
	Parent2() {
		System.out.println("Parent Contructor");
	}
}

class Child2 extends Parent2 {
	Child2() {
		super();
		System.out.println("Child Constructor");
	}
}