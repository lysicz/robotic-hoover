package com.tm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tm.model.Request;
import com.tm.model.Response;
import com.tm.repository.RequestRepository;
import com.tm.repository.ResponseRepository;

@Service
public class RobotService {
	
	@Autowired
	RequestRepository requestRepository;
	
	@Autowired
	ResponseRepository responseRepository;
	
	public Response handleRequest(Request request) {
		requestRepository.save(request);
		
		RobotMovementProvider robotMovementProvider = new RobotMovementProvider(request);
		
		Response response = robotMovementProvider.calculateResponse();
		responseRepository.save(response);
		
		return response;
	}
}
