package com.tm.service;

import static org.junit.Assert.*;

import org.junit.Test;

import com.tm.model.Request;
import com.tm.model.Response;
import com.tm.utils.Error;
import com.tm.utils.Utils;

public class RobotMovementProviderTest {

	@Test
	public void testCalculateValidRequestResponse() {
		Request request = ServiceTestUtils.buildRequest(RequestType.VALID);
		RobotMovementProvider robotMovementProvider = new RobotMovementProvider(request);
		
		Response response = robotMovementProvider.calculateResponse();
		int[] expectedCoords = ServiceTestUtils.createCoords(1, 3);
		
		assertEquals(Integer.valueOf(1), response.getPatches());
		assertEquals(expectedCoords[Utils.COL_INDEX], response.getCoords()[Utils.COL_INDEX]);
		assertEquals(expectedCoords[Utils.ROW_INDEX], response.getCoords()[Utils.ROW_INDEX]);
	}
	
	@Test
	public void testCalculateNotValidRequestInstructionsResponse() {
		Request request = ServiceTestUtils.buildRequest(RequestType.NOT_A_VALID_INSTRUCTION);
		RobotMovementProvider robotMovementProvider = new RobotMovementProvider(request);
		
		Response response = robotMovementProvider.calculateResponse();
		int[] expectedCoords = ServiceTestUtils.createCoords(0, 3);
		
		assertEquals(Integer.valueOf(2), response.getPatches());
		assertEquals(expectedCoords[Utils.COL_INDEX], response.getCoords()[Utils.COL_INDEX]);
		assertEquals(expectedCoords[Utils.ROW_INDEX], response.getCoords()[Utils.ROW_INDEX]);
	}
	
	@Test
	public void testCalculateNotValidRequestStartingPositionResponse() {
		Request request = ServiceTestUtils.buildRequest(RequestType.NOT_A_VALID_STARTING_POSITION);
		RobotMovementProvider robotMovementProvider = new RobotMovementProvider(request);
		
		Response response = robotMovementProvider.calculateResponse();
		
		assertEquals(Error.NOT_A_VALID_STARTING_POSITION.getValue(), response.getError());
		assertNull(response.getCoords());
		assertNull(response.getPatches());
	}
	
	@Test
	public void testCalculateNotValidRequestRoomSizeResponse() {
		Request request = ServiceTestUtils.buildRequest(RequestType.NOT_A_VALID_ROOM_SIZE);
		RobotMovementProvider robotMovementProvider = new RobotMovementProvider(request);
		
		Response response = robotMovementProvider.calculateResponse();
		
		assertEquals(Error.NOT_A_VALID_ROOM_SIZE.getValue(), response.getError());
		assertNull(response.getCoords());
		assertNull(response.getPatches());
	}

}
