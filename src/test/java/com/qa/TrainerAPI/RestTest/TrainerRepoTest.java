package com.qa.TrainerAPI.RestTest;

import java.util.Optional;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.qa.TrainerAPI.persistence.repository.TrainerRepository;
import com.qa.persistence.domain.Trainer;

@RunWith(SpringRunner.class)
@DataJpaTest
public class TrainerRepoTest {

	private Optional<Trainer> trainer;

	@Autowired
	TestEntityManager entityManager;

	@Autowired
	TrainerRepository traineeRepo;

	@Test
	public void getReservation_returnReservationDetails() {

		Trainer traineeList = new Trainer();

		trainer = Optional.of(traineeList);

		trainer.get().setFirstName("firstName");
		trainer.get().setLastName("lastName");

		Trainer savedTrainee = entityManager.persistAndFlush(trainer.get());
		Optional<Trainer> foundTrainee = traineeRepo.findById(trainer.get().getTrainerId());

		assertEquals(savedTrainee, foundTrainee.get());

	}
}
