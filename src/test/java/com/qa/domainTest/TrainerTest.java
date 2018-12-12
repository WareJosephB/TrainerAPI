package com.qa.domainTest;

import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.junit.Test;

import com.qa.persistence.domain.Trainer;

public class TrainerTest {

	@Test
	public void setAndGetTest(){
	Trainer trainer = new Trainer();	
	
	trainer.setFirstName("firstName");
	trainer.setLastName("lastName");
	trainer.setTrainerId(1L);
	
	assertEquals( "firstName", trainer.getFirstName());
	assertEquals( "lastName", trainer.getLastName());
	Assert.assertEquals( Long.valueOf(1L),trainer.getTrainerId());
		
		
	}
	
	@Test
	public void toStringTest() {
		Trainer trainer= new Trainer();
		
		trainer.setFirstName("firstName");
		trainer.setLastName("lastName");
		trainer.setTrainerId(2L);
		
		assertEquals( "Trainer [firstName=firstName, lastName=lastName, trainerId=2]", trainer.toString());
	
	} 
		
		
	}
	

