package com.main.sbp.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.main.sbp.entity.Car;
import com.main.sbp.exception.CarNotFoundException;
import com.main.sbp.service.CarService;

@WebMvcTest(CarController.class)
public class CarControllerTest {
	
	@Autowired
	MockMvc mockMvc;
	
	@MockBean
	private CarService carService;
	
	@Test
	public void getCarDetailsTest () throws Exception {
		
		when(carService.getCarDetails(Mockito.anyString())).thenReturn(new Car(1, "Scala", "Sedan"));
		
		mockMvc.perform(get("/cars/{name}", "Scala")
				.contentType(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk())
		.andExpect(jsonPath("$.name").value("Scala"))
		.andExpect(jsonPath("$.type").value("Sedan"));
	}
	
	@Test
	public void carNotFoundTest () throws Exception {
		
		when(carService.getCarDetails(Mockito.anyString())).thenThrow(new CarNotFoundException());
		
		mockMvc.perform(get("/cars/{name}", "Scala")
				.contentType(MediaType.APPLICATION_JSON))
		.andExpect(status().isNotFound());

	}

}
