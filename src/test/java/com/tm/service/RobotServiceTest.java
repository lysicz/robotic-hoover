package com.tm.service;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import com.tm.model.Request;
import com.tm.model.Response;
import com.tm.repository.RequestRepository;
import com.tm.repository.ResponseRepository;

@RunWith(MockitoJUnitRunner.class)
public class RobotServiceTest {
	
	@Mock
	private RequestRepository requestRepository;
	@Mock
	private ResponseRepository responseRepository;
	
	@InjectMocks
	private RobotService robotService = new RobotService();
	
	@Before
	public void initializeMockito() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testHandleRequest() {
		Request request = ServiceTestUtils.buildRequest();

		Response response = robotService.handleRequest(request);
		
		Mockito.verify(requestRepository).save(request);
		Mockito.verify(responseRepository).save(response);
	}
}
