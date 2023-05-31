package com.main.sbp.repository;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.main.sbp.entity.Car;

@DataJpaTest
public class CarRepositoryTest {

	@Autowired
	private CarRepository carRepository;
	
	@Test
//	@Rollback(value = false)
	public void testFindByName () {
		
		Optional<Car> car = carRepository.findByName("duster");
		
		assertTrue(car.isPresent());
		
	}
	
	@Test
//	@Rollback(value = false)
	public void testFindByName_NotFound () {
		
		Optional<Car> car = carRepository.findByName("Pulse");
		
		assertFalse(car.isPresent());
		
	}
}
