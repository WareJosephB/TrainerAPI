package com.qa.TrainerAPI.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import com.qa.persistence.domain.Trainer;
import com.qa.persistence.domain.UserRequest;

@Component
public class TrainerProducer {

	@Autowired
	private JmsTemplate jmsTemplate;

	public String produce(Trainer trainer) {
		jmsTemplate.convertAndSend(Constants.INCOMING_TRAINER_QUEUE_NAME, trainer);
		return Constants.TRAINER_QUEUED_MESSAGE;
	}

	public String produce(Iterable<Trainer> trainers) {
		jmsTemplate.convertAndSend(Constants.INCOMING_TRAINER_QUEUE_NAME, trainers);
		return Constants.TRAINERS_QUEUED_MESSAGE;
	}

	public String produce(UserRequest request) {
		jmsTemplate.convertAndSend(Constants.INCOMING_TRAINER_QUEUE_NAME, request);
		return Constants.REQUEST_QUEUED_MESSAGE;

	}
}
