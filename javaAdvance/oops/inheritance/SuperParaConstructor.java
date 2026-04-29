package javaAdvance.oops.inheritance;

public class SuperParaConstructor {

	public static void main(String[] args) {
		Circle c = new Circle(12, 0, 0);
		System.out.println("Area of Circle " + c.area());

		Rectangle r = new Rectangle(5, 6);
		System.out.println("Area of Rec " + r.area());
		r.newArea();
		
		Shape s = new Rectangle(5, 6);
		s.area();
		
	}
}

class Shape {
	double pi = 3.14;
	int length;
	int breadth;

	Shape() {
		System.out.println("Parent Constructor");
	}

	Shape(int len, int bre) {
		this.length = len;
		this.breadth = bre;
	}

	double area() {
		System.out.println("shape area");
		return 0;
	}
}

class Circle extends Shape {
	int radius;

	Circle() {
		System.out.println("Circle constructor");
	}

	Circle(int r, int len, int br) {
		super(len, br);
		this.radius = r;
		System.out.println("Circle constructor");
	}

	double area() {
		return super.pi * (radius * radius);
	}
}

class Rectangle extends Shape {

	// This super will user shape cunstructor
	// This length and breath are shapes fields wit
	Rectangle(int length, int breadth) {
		//super(length, breadth);
		System.out.println("CONSTRUCTURE Area of const in rec " + (length * breadth));
	}

	@Override
	double area() {
		System.out.println("Override Rec area len " + length + " bre " + breadth);
		return length * breadth;

	}

	void newArea() {
		System.out.println("new Area " + length * breadth);
	}
}
