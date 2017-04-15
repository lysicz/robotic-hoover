package com.tm.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessResourceFailureException;
import org.springframework.stereotype.Service;

import com.tm.model.Request;
import com.tm.model.Response;
import com.tm.repository.RequestRepository;
import com.tm.repository.ResponseRepository;

@Service
public class RobotService {
	
	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass()); 
	
	@Autowired
	RequestRepository requestRepository;
	
	@Autowired
	ResponseRepository responseRepository;
	
	public Response handleRequest(Request request) {
		try {
			requestRepository.save(request);
		} catch (DataAccessResourceFailureException e) {
			LOGGER.warn("No database connection. Request will not be saved.");
		}
		
		RobotMovementProvider robotMovementProvider = new RobotMovementProvider(request);
		Response response = robotMovementProvider.calculateResponse();
		
		try {
			responseRepository.save(response);
		} catch (DataAccessResourceFailureException e) {
			LOGGER.warn("No database connection. Response will not be saved.");
		}
		
		return response;
	}
}
