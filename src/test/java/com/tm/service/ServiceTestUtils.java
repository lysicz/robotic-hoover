package com.tm.service;

import java.util.ArrayList;
import java.util.List;

import com.tm.model.Request;
import com.tm.utils.Utils;

public final class ServiceTestUtils {
	
	private static final String VALID_INSTRUCTION = "NNESEESWNWW";
	private static final String NOT_VALID_INSTRUCTION = "NNESEXSWNWW";
	
	public static Request buildRequest(RequestType requestType) {
		Request request = new Request();
		
		String instructions = null;
		int[] coords = null;
		int[] roomSize = null;
		
		switch (requestType) {
			case VALID:
				instructions = VALID_INSTRUCTION;
				coords = createCoords(1, 2);
				roomSize = createCoords(5, 5);
				break;
			case NOT_A_VALID_STARTING_POSITION:
				instructions = VALID_INSTRUCTION;
				coords = createCoords(-1, 2);
				roomSize = createCoords(5, 5);
				break;
			case NOT_A_VALID_INSTRUCTION:
				instructions = NOT_VALID_INSTRUCTION;
				coords = createCoords(1, 2);
				roomSize = createCoords(5, 5);
				break;
			case NOT_A_VALID_ROOM_SIZE:
				instructions = VALID_INSTRUCTION;
				coords = createCoords(1, 2);
				roomSize = createCoords(-5, 5);
				break;
			default:
				instructions = VALID_INSTRUCTION;
				coords = createCoords(1, 2);
				roomSize = createCoords(5, 5);
				break;
		}
		
		request.setInstructions(instructions);
		request.setCoords(coords);
		request.setRoomSize(roomSize);
		
		List<int[]> pathes = new ArrayList<>();
		int[] path = createCoords(1, 0);
		pathes.add(path);
		path = createCoords(2, 2);
		pathes.add(path);
		path = createCoords(2, 3);
		pathes.add(path);
		request.setPatches(pathes);
		
		return request;
	}
	
	public static int[] createCoords(int start, int end) {
		int[] coords = new int[2];
		coords[Utils.COL_INDEX] = start;
		coords[Utils.ROW_INDEX] = end;
		
		return coords;
	}
}
