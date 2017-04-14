package com.tm.model;

import java.util.List;

import javax.validation.constraints.NotNull;

public class Request {
	
	@NotNull
	private int[] roomSize;
	@NotNull
	private int[] coords;
	@NotNull
	private List<int[]> patches;
	@NotNull
	private String instructions;
	
	public int[] getRoomSize() {
		return roomSize;
	}
	public void setRoomSize(int[] roomSize) {
		this.roomSize = roomSize;
	}
	public int[] getCoords() {
		return coords;
	}
	public void setCoords(int[] coords) {
		this.coords = coords;
	}
	public List<int[]> getPatches() {
		return patches;
	}
	public void setPatches(List<int[]> patches) {
		this.patches = patches;
	}
	public String getInstructions() {
		return instructions;
	}
	public void setInstructions(String instructions) {
		this.instructions = instructions;
	}
}
