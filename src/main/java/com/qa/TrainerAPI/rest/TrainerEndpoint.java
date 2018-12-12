package com.qa.TrainerAPI.rest;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.TrainerAPI.service.business.TrainerService;
import com.qa.persistence.domain.Trainer;

@RequestMapping("${URL.base}")
@RestController
public class TrainerEndpoint {

	@Autowired
	private TrainerService service;

	public TrainerEndpoint(TrainerService service) {
		this.service = service;
	}

	public TrainerEndpoint() {
	}

	@GetMapping("${URL.method.Trainer.getByUserName}/{username}")
	public Optional<Trainer> getTrainer(@PathVariable String username) {
		return service.get(username);
	}

	@GetMapping("${URL.method.Trainer.getAll}")
	public Iterable<Trainer> getAllTrainers() {
		return service.getAll();
	}

	@DeleteMapping("${URL.method.Trainer.delete}/{username}")
	public String deleteTrainer(@PathVariable String username) {
		return service.delete(username);
	}

	@PostMapping("${URL.method.Trainer.add}")
	public String addTrainer(@RequestBody Trainer trainer) {
		return service.create(trainer);
	}

	@PutMapping("${URL.method.Trainer.update}/{trainerID}")
	public String updateTrainer(@PathVariable String username, @RequestBody Trainer trainer) {
		return service.update(username, trainer);
	}
}
