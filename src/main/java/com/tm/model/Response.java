package com.tm.model;

public class Response {
	
	private int[] coords;
	private Integer patches;
	private String error;
	
	public int[] getCoords() {
		return coords;
	}
	public void setCoords(int[] coords) {
		this.coords = coords;
	}
	public Integer getPatches() {
		return patches;
	}
	public void setPatches(Integer patches) {
		this.patches = patches;
	}
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
}
