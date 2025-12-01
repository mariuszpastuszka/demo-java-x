package com.mpas.demo.java25.flexible_constructors.demo2;

class Person {

	String name;
	String surname;
	int age;

	void show() {
		System.out.println("Age: " + this.age);
	}

	Person(String name, String surname, int age) {
		if (age < 0) {
			throw new IllegalArgumentException("Age cannot be < 0");
		}
		this.name = name;
		this.surname = surname;
		this.age = age;
		show();
	}

}

class Employee extends Person {

	String officeID;

	@Override
	void show() {
		System.out.println("Age: " + this.age);
		System.out.println("Office: " + this.officeID);
	}

	Employee(String name, String surname, int age, String officeID) {
		if (age < 18 || age > 67) {
			throw new IllegalArgumentException("Wrong age");
		}
		this.officeID = officeID;
		super(name, surname, age);
	}

	static void main() {
		Person person = new Employee("John", "Doe", 40, "Google");
	}
}

