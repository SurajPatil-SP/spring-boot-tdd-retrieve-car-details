package com.main.sbp.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.main.sbp.entity.Car;
import com.main.sbp.exception.CarNotFoundException;
import com.main.sbp.repository.CarRepository;

@Service
public class CarService {
	
	@Autowired
	private CarRepository carRepository;

	public Car getCarDetails(String name) {

		Car car = null;
		
		Optional<Car> optionalCar = carRepository.findByName(name);
		if (optionalCar.isPresent()) {
			car = optionalCar.get();
		} else {
			throw new CarNotFoundException();
		}
		return car;
	}

}
