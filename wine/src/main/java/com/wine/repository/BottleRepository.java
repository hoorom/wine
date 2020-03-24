package com.wine.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.Repository;

import com.wine.domain.Bottle;

public interface BottleRepository extends JpaRepository<Bottle, Long> {

	
}
