package com.tm.utils;

public enum Error {
	NOT_A_VALID_REQUEST("Not a valid request"), 
	NOT_A_VALID_STARTING_POSITION("Not a valid starting position"), 
	NOT_A_VALID_ROOM_SIZE("Not a valid room size");
	
	private String value;
	
	private Error(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return value;
	}
}
