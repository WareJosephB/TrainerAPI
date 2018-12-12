package com.qa.TrainerAPI.service.business;

import java.util.Optional;

import com.qa.persistence.domain.Trainer;

public interface TrainerService {

	Iterable<Trainer> getAll();

	Optional<Trainer> get(String username);

	String create(Trainer trainer);

	String delete(String username);

	String update(String username, Trainer updatedTrainer);

}
