package com.mpas.demo.java25.flexible_constructors;

class Y {

	int i;

	void m() {
	}
}

class Z extends Y {

	Z() {
		//		var x = super.i;         // Error
		//		super.m();               // Error
		super();
	}

}
