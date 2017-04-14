package com.tm.service;

import static org.junit.Assert.*;

import org.junit.Test;

import com.tm.model.Request;
import com.tm.model.Response;
import com.tm.utils.Utils;

public class RobotMovementProviderTest {

	@Test
	public void testCalculateResponse() {
		Request request = ServiceTestUtils.buildRequest();
		RobotMovementProvider robotMovementProvider = new RobotMovementProvider(request);
		
		Response response = robotMovementProvider.calculateResponse();
		int[] expectedCoords = ServiceTestUtils.createCoords(1, 3);
		
		assertEquals(Integer.valueOf(1), response.getPatches());
		assertEquals(expectedCoords[Utils.COL_INDEX], response.getCoords()[Utils.COL_INDEX]);
		assertEquals(expectedCoords[Utils.ROW_INDEX], response.getCoords()[Utils.ROW_INDEX]);
	}

}
