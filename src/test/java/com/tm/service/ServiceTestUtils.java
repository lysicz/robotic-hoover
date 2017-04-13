package com.tm.service;

import java.util.ArrayList;
import java.util.List;

import com.tm.model.Request;
import com.tm.utils.Utils;

public final class ServiceTestUtils {
	
	public static Request buildRequest() {
		Request request = new Request();
		
		request.setInstructions("NNESEESWNWW");
		
		int[] coords = createCoords(1, 2);
		request.setCoords(coords);
		
		int[] roomSize = createCoords(5, 5);
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
