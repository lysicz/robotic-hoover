package com.tm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tm.model.Request;
import com.tm.model.Response;
import com.tm.service.RobotService;

@RestController
@RequestMapping("/robot")
public class RobotController {

	@Autowired
	RobotService robotService;
	
	@RequestMapping(method=RequestMethod.POST, value="/new")
	public Response handleRequest(@RequestBody Request request) {
		return robotService.handleRequest(request);
	}
	
	@RequestMapping("/requests")
	public List<Request> getAllRequests() {
		return robotService.getAllRequests();
	}
	
	@RequestMapping("/responses")
	public List<Response> getAllResponses() {
		return robotService.getAllResponses();
	}
	
}
