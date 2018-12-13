package com.qa.TrainerAPI.util;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Component;

import com.qa.persistence.domain.Trainer;
import com.qa.persistence.domain.UserRequest;

@Component
public class TrainerProducer {

	@Autowired
	private JmsMessagingTemplate jmsTemplate;

	public Optional<Trainer> produceTrainer(UserRequest request) {
		return jmsTemplate.convertSendAndReceive(Constants.INCOMING_TRAINER_QUEUE_NAME, request, Optional.class);
	}

	public Iterable<Trainer> produceTrainers(UserRequest request) {
		return jmsTemplate.convertSendAndReceive(Constants.INCOMING_TRAINER_QUEUE_NAME, request, List.class);
	}

	public String produceMessage(UserRequest request) {
		return jmsTemplate.convertSendAndReceive(Constants.INCOMING_TRAINER_QUEUE_NAME, request, String.class);
	}
}
