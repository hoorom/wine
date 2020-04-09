package com.wine.bottle.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wine.bottle.domain.Bottle;

public interface BottleRepository extends JpaRepository<Bottle, Long> {

	
}
