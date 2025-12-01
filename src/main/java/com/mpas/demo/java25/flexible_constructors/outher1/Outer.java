package com.mpas.demo.java25.flexible_constructors.outher1;

class Outer {

	int i;

	void hello() {
		System.out.println("Hello");
	}

	class Inner {

		int j;

		Inner() {
			var x = i;             // OK - implicitly refers to field of enclosing instance
			var y = Outer.this.i;  // OK - explicitly refers to field of enclosing instance
			hello();               // OK - implicitly refers to method of enclosing instance
			Outer.this.hello();    // OK - explicitly refers to method of enclosing instance
			super();
		}

	}

}
