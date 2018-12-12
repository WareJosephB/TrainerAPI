package com.qa.TrainerAPI.util;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.qa.persistence.domain.Trainer;

@Component
public class TrainerConsumer {

	@JmsListener(destination = Constants.OUTGOING_TRAINER_QUEUE_NAME, containerFactory = "myFactory")
	public Trainer trainerReceiveMessage(Trainer trainer) {
		return trainer;
	}

	@JmsListener(destination = Constants.OUTGOING_TRAINER_QUEUE_NAME, containerFactory = "myFactory")
	public Iterable<Trainer> trainerReceiveMessage(Iterable<Trainer> trainers) {
		return trainers;
	}

}