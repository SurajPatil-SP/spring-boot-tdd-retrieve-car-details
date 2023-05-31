package com.main.sbp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.main.sbp.entity.Car;
import com.main.sbp.service.CarService;

@RestController
@RequestMapping("/cars")
public class CarController {
	
	@Autowired
	private CarService carService;
	
	@GetMapping("/{name}")
	public ResponseEntity<Car> getCarDetails (@PathVariable ("name") String name) {
		Car car = carService.getCarDetails (name);
		return new ResponseEntity<> (car, HttpStatus.OK);
		
	}
}
