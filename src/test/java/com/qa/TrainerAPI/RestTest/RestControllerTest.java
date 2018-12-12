package com.qa.TrainerAPI.RestTest;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.qa.TrainerAPI.rest.TrainerEndpoint;
import com.qa.TrainerAPI.service.business.TrainerService;
import com.qa.persistence.domain.Trainer;

@RunWith(SpringRunner.class)
@WebMvcTest(TrainerEndpoint.class)
public class RestControllerTest {

	private Iterable<Trainer> traineeList;
	private Optional<Trainer> trainer;

	@MockBean
	TrainerService service;

	@Before
	public void start() {

		Trainer trainerList = new Trainer();
		trainer = Optional.of(trainerList);

		trainer.get().setFirstName("firstName");
		trainer.get().setLastName("lastName");
		trainer.get().setTrainerId(111l);

	}

	@Test
	public void getTrainee_shouldReturnTrainee() {
		BDDMockito.given(service.get(111l)).willReturn(trainer);

	}

	@Test
	public void getAllTrainees_shouldReturnAllTrainees() {

		BDDMockito.given(service.getAll()).willReturn((Iterable<Trainer>) traineeList);

	}

}
