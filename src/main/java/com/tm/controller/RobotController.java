package com.tm.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tm.model.Request;
import com.tm.model.Response;
import com.tm.service.RobotService;
import com.tm.utils.Error;
import com.tm.utils.Utils;

@RestController
@RequestMapping("/robot")
public class RobotController {
	
	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

	@Autowired
	RobotService robotService;
	
	@RequestMapping(method=RequestMethod.POST)
	public Response handleRequest(@Valid @RequestBody Request request, Errors errors) {
		if (errors.hasErrors()) {
			LOGGER.warn("Errors processing request: ");
			errors.getAllErrors().stream().forEach(e -> {
				LOGGER.warn(e.getDefaultMessage());
			});
			return Utils.createErrorResponse(Error.NOT_A_VALID_REQUEST);
		}
		
		return robotService.handleRequest(request);
	}
}
