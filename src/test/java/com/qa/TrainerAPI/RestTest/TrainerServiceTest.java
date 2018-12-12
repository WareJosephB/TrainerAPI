package com.qa.TrainerAPI.RestTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.qa.TrainerAPI.persistence.repository.TrainerRepository;
import com.qa.TrainerAPI.service.business.TrainerServiceImpl;
import com.qa.persistence.domain.Trainer;

@RunWith(MockitoJUnitRunner.class)
public class TrainerServiceTest {

	@InjectMocks
	TrainerServiceImpl service;

	@Mock
	TrainerRepository traineeRepo;

	@Before
	public void set() throws Exception {

	}

	@Test
	public void getTrainee_returnsTrainee() {
		Trainer traineeList = new Trainer();

		Mockito.when(traineeRepo.findById(111l)).thenReturn(Optional.of(traineeList));

		Assert.assertEquals(Optional.of(traineeList), service.get(111l));

	}

	@Test
	public void getAllTrainees_returnsAllTrainees() {
		ArrayList<Trainer> traineeList1 = new ArrayList<Trainer>();
		Trainer traineeList = new Trainer();

		traineeList1.add(traineeList);
		traineeList1.add(traineeList);

		Mockito.when(traineeRepo.findAll()).thenReturn((List<Trainer>) traineeList1);

		Assert.assertEquals(service.getAll(), traineeList1);

	}

}
