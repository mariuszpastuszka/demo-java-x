package com.mpas.demo.java22;

public class Unnamed3 {
	public static double parseDouble(String s) {
		try {
			return Double.parseDouble(s);
		} catch (NumberFormatException _) {
			return Double.NaN;
		}
	}

	public static void main(String[] args) {
		System.out.println(parseDouble("3.14"));
		System.out.println(parseDouble("Fred"));
	}
}
