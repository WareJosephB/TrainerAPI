package com.qa.TrainerAPI.RestTest;

import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringRunner;

import com.qa.TrainerAPI.rest.TrainerEndpoint;
import com.qa.TrainerAPI.service.business.TrainerService;
import com.qa.persistence.domain.Trainer;

@RunWith(SpringRunner.class)

public class EndpointTest {

	@Mock
	TrainerService service;

	@InjectMocks
	private TrainerEndpoint endpoints;

	@Test
	public void endPointTests() {
		ArrayList<Trainer> trainerList = new ArrayList<Trainer>();
		Trainer traineeList = new Trainer();

		trainerList.add(traineeList);
		trainerList.add(traineeList);

		Mockito.when(service.getAll()).thenReturn((List<Trainer>) trainerList);

		Assert.assertEquals(endpoints.getAllTrainers(), trainerList);
	}

}
