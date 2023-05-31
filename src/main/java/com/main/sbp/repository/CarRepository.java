package com.main.sbp.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.main.sbp.entity.Car;

public interface CarRepository extends JpaRepository<Car, Long> {

	public Optional<Car> findByName (String name);
}
