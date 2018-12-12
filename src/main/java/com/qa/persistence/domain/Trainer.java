package com.qa.persistence.domain;

public class Trainer extends User {

	public Trainer(String username) {
		super(username);
		this.type = "Trainer";
	}

	public Trainer() {
		super();
		this.type = "Trainer";
	}

}
