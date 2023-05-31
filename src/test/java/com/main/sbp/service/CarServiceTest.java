package com.main.sbp.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.main.sbp.entity.Car;
import com.main.sbp.exception.CarNotFoundException;
import com.main.sbp.repository.CarRepository;

@SpringBootTest
public class CarServiceTest {
	
	@MockBean
	private CarRepository carRepository;
	
	@Autowired
	private CarService carService;
	
	@Test
	public void getCarDeatilsTest () {
		
		when(carRepository.findByName("Pulse")).thenReturn(Optional.of(new Car(1 ,"Pulse", "Hatchback")));
		
		Car car = carService.getCarDetails("Pulse");
		
		assertNotNull(car);
		assertEquals("Pulse", car.getName());
		assertEquals("Hatchback", car.getType());
		
	}
	
	@Test
	public void getCarDeatilsNotFoundTest () {
		
		when(carRepository.findByName("Pulse")).thenThrow(new CarNotFoundException());
		
		assertThrows(CarNotFoundException.class, () -> carService.getCarDetails("Pulse"));
		
	}

}
