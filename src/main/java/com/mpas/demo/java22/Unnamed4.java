package com.mpas.demo.java22;

import java.util.*;

class DynamicScope implements AutoCloseable {
	private List<HashMap<String, Object>> namedValues = new LinkedList<>();

	public DynamicScope open() {
		namedValues.addFirst(new HashMap<>());
		return this;
	}
	public void close() {
		namedValues.removeFirst();
	}
	public void put(String name, Object value) {
		if (namedValues.size() == 0) throw new IllegalStateException("Not open");
		else namedValues.get(0).put(name, value);
	}
	public Object get(String name) {
		for (var map : namedValues)
			if (map.containsKey(name)) return map.get(name);
		throw new NoSuchElementException(name);
	}
}

public class Unnamed4 {
	public static void main(String[] args) {
		var scope = new DynamicScope();
		try (var _ = scope.open()) {
			scope.put("name", "Fred");
			System.out.println(scope.get("name"));
			try (var _ = scope.open()) {
				scope.put("name", "Wilma");
				System.out.println(scope.get("name"));
			}
			System.out.println(scope.get("name"));
		}
	}
}
