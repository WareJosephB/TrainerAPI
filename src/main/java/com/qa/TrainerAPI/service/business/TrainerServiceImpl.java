package com.qa.TrainerAPI.service.business;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.qa.TrainerAPI.util.TrainerProducer;
import com.qa.persistence.domain.Trainer;
import com.qa.persistence.domain.User;
import com.qa.persistence.domain.UserRequest;
import com.qa.persistence.domain.UserRequest.requestType;

@Component
public class TrainerServiceImpl implements TrainerService {

	@Autowired
	private TrainerProducer producer;

	public String create(Trainer trainer) {
		trainer.setType("Trainer");
		UserRequest thisRequest = new UserRequest(trainer);
		thisRequest.setHowToAct(requestType.CREATE);
		return producer.produceMessage(thisRequest);
	}

	public Optional<Trainer> get(String userName) {
		User dummyUser = new Trainer(userName);
		UserRequest thisRequest = new UserRequest(dummyUser);
		thisRequest.setHowToAct(requestType.READ);
		return producer.produceTrainer(thisRequest);
	}

	public Iterable<Trainer> getAll() {
		UserRequest thisRequest = new UserRequest();
		thisRequest.setHowToAct(requestType.READALL);
		return producer.produceTrainers(thisRequest);
	}

	public String delete(String userName) {
		User dummyUser = new Trainer(userName);
		UserRequest thisRequest = new UserRequest(dummyUser);
		thisRequest.setHowToAct(requestType.DELETE);
		return producer.produceMessage(thisRequest);

	}

	public String update(String userName, Trainer updatedTrainer) {
		User dummyUser = new Trainer(userName);
		UserRequest thisRequest = new UserRequest(dummyUser);
		thisRequest.setHowToAct(requestType.UPDATE);
		return producer.produceMessage(thisRequest);
	}

}
