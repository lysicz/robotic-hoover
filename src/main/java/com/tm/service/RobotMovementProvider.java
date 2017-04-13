package com.tm.service;

import java.util.ArrayList;
import java.util.List;

import com.tm.model.Request;
import com.tm.model.Response;
import com.tm.utils.Utils;

public class RobotMovementProvider {
	
	private final Request request;
	private int maxCol;
	private int maxRow;
	
	private List<Coords> dirt;
	private int removedDirtCounter = 0;
	
	public RobotMovementProvider(Request request) {
		this.request = request;
		this.maxCol = request.getRoomSize()[Utils.COL_INDEX];
		this.maxRow = request.getRoomSize()[Utils.ROW_INDEX];
		dirt = createDirtList(request.getPatches());
		
	}
	
	public Response calculateResponse() {
		Coords position = createCoords(request.getCoords());
		
		for (int i = 0; i < request.getInstructions().length(); i++) {
			String instruction = String.valueOf(request.getInstructions().charAt(i));
			Cardinals direction = convertToCardinal(instruction);
			if (direction != null) {
				position = moveRobot(position, direction);
			} else {
				//logger
			}
		}
		
		Response response = new Response();
		int[] newPosition = new int[2];
		newPosition[Utils.COL_INDEX] = position.getCol();
		newPosition[Utils.ROW_INDEX] = position.getRow();
		response.setCoords(newPosition);
		response.setPatches(removedDirtCounter);
		
		return response;
	}
	
	private List<Coords> createDirtList(List<int[]> patches) {
		final List<Coords> dirt = new ArrayList<>();
		patches.stream().forEach(p -> {
			dirt.add(createCoords(p));
		});
		
		return dirt;
	}
	
	private Coords createCoords(int[] coords) {
		Coords position = new Coords();
		
		position.setCol(coords[Utils.COL_INDEX]);
		position.setRow(coords[Utils.ROW_INDEX]);
		
		return position;
	}
	
	private Cardinals convertToCardinal(String value) {
		return Cardinals.getCardinalByValue(value);
	}
	
	private Coords moveRobot(Coords position, Cardinals direction) {
		int col = position.getCol();
		int row = position.getRow();
		
		switch (direction) {
			case NORTH:
				if (row < maxRow) {
					position.setRow(++row);
				}
				break;
			case EAST:
				if (col < maxCol) {
					position.setCol(++col);
				}
				break;
			case SOUTH:
				if (row > Utils.MIN_ROW_COL) {
					position.setRow(--row);
				}
				break;
			case WEST:
				if (col > Utils.MIN_ROW_COL) {
					position.setCol(--col);
				}
				break;
			default:
				//logger
				break;
		}
		
		if (dirt.contains(position)) {
			dirt.remove(position);
			removedDirtCounter++;
		}
		
		return position;
	}
}
