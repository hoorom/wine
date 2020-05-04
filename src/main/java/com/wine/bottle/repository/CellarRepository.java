package com.wine.bottle.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wine.bottle.domain.Cellar;

public interface CellarRepository extends JpaRepository<Cellar, Long> {

	
}
