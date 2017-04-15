package com.tm.utils;

import com.tm.model.Response;

public final class Utils {
	public static final int COL_INDEX = 0;
	public static final int ROW_INDEX = 1;
	
	public static final int MIN_ROW_COL = 0;
	
	public static final int STD_ARRAY_SIZE = 2;
	
	public static Response createErrorResponse(Error error) {
		Response response = new Response();
		response.setPatches(null);
		response.setError(error.getValue());
		
		return response;
	}
}
