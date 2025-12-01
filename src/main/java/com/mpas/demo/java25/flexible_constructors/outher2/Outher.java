package com.mpas.demo.java25.flexible_constructors.outher2;

class Outer {

	class Inner {

	}

	Outer() {
		//		var x = new Inner();       // Error - implicitly refers to the current instance of Outer
		//		var y = this.new Inner();  // Error - explicitly refers to the current instance of Outer
		super();
	}

}