package com.tm.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.tm.model.Request;
import com.tm.model.Response;
import com.tm.utils.Utils;

public class RobotMovementProvider { 
	
	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass()); 
	
	private final Request request;
	private int maxCol;
	private int maxRow;
	
	//change dirt collection to Set if more than one dirt patch at single location requires only one robot visit
	private List<Coords> dirt;
	private int removedDirtCounter = 0;
	
	public RobotMovementProvider(Request request) {
		this.request = request;
		this.maxCol = request.getRoomSize()[Utils.COL_INDEX];
		this.maxRow = request.getRoomSize()[Utils.ROW_INDEX];
		dirt = createDirtList(request.getPatches());
		
	}
	
	public Response calculateResponse() {
		LOGGER.debug("New request will be processed: " + request);
		Coords position = createCoords(request.getCoords());
		
		for (int i = 0; i < request.getInstructions().length(); i++) {
			String instruction = String.valueOf(request.getInstructions().charAt(i));
			Cardinals direction = convertToCardinal(instruction);
			if (direction != null) {
				position = moveRobot(position, direction);
			} else {
				LOGGER.info("Not a valid robot instruction: " + instruction);
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
		LOGGER.debug("Robot initial position: " + position + ". Robot move direction: " + direction);
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
				LOGGER.info("Not a valid robot direction: " + direction);
				break;
		}
		
		if (dirt.contains(position)) {
			dirt.remove(position);
			removedDirtCounter++;
		}
		
		LOGGER.debug("Robot new position: " + position);
		
		return position;
	}
}
