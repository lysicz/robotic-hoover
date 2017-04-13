package com.tm.service;

import java.util.HashMap;
import java.util.Map;

public enum Cardinals {
	NORTH("N"), EAST("E"), SOUTH("S"), WEST("W");
	
	private String value;
	private static final Map<String, Cardinals> map = new HashMap<>();
	
	static {
		for (Cardinals cardinals : values()) {
			map.put(cardinals.getValue(), cardinals);
		}
	}
	
	private Cardinals(String value) {
		this.value = value;
	}
	
	private String getValue() {
		return value;
	}
	
	public static Cardinals getCardinalByValue(String value) {
		return map.get(value);
	}
}
