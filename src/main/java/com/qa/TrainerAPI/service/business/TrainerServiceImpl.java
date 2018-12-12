package com.qa.TrainerAPI.service.business;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import com.qa.TrainerAPI.util.TrainerProducer;
import com.qa.persistence.domain.Trainer;
import com.qa.persistence.domain.User;
import com.qa.persistence.domain.UserRequest;
import com.qa.persistence.domain.UserRequest.requestType;
import com.qa.TrainerAPI.util.Constants;

@Component
public class TrainerServiceImpl implements TrainerService {

	@Autowired
	private TrainerProducer producer;

	@Autowired
	private JmsTemplate jmsTemplate;

	public String create(Trainer trainer) {
		trainer.setType("Trainer");
		UserRequest thisRequest = new UserRequest(trainer);
		thisRequest.setHowToAct(requestType.CREATE);
		producer.produce(thisRequest);
		return Constants.TRAINER_QUEUED_MESSAGE;
	}

	public Optional<Trainer> get(String userName) {
		User dummyUser = new Trainer(userName);
		UserRequest thisRequest = new UserRequest(dummyUser);
		thisRequest.setHowToAct(requestType.READ);
		producer.produce(thisRequest);
		return (Optional<Trainer>) jmsTemplate.receiveAndConvert(Constants.OUTGOING_TRAINER_QUEUE_NAME);
	}

	public Iterable<Trainer> getAll() {
		UserRequest thisRequest = new UserRequest();
		thisRequest.setHowToAct(requestType.READALL);
		producer.produce(thisRequest);
		return (Iterable<Trainer>) jmsTemplate.receiveAndConvert(Constants.OUTGOING_TRAINER_QUEUE_NAME);
	}

	public String delete(String userName) {
		User dummyUser = new Trainer(userName);
		UserRequest thisRequest = new UserRequest(dummyUser);
		thisRequest.setHowToAct(requestType.DELETE);
		producer.produce(thisRequest);
		return Constants.REQUEST_QUEUED_MESSAGE;

	}

	public String update(String userName, Trainer updatedTrainer) {
		User dummyUser = new Trainer(userName);
		UserRequest thisRequest = new UserRequest(dummyUser);
		thisRequest.setHowToAct(requestType.UPDATE);
		producer.produce(thisRequest);
		return Constants.REQUEST_QUEUED_MESSAGE;
	}

}
