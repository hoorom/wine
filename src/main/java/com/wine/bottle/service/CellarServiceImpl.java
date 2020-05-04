package com.wine.bottle.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wine.bottle.domain.Cellar;
import com.wine.bottle.repository.CellarRepository;

@Service
public class CellarServiceImpl implements CellarService {

	@Autowired
	private CellarRepository cellarRepository;


	@Override
	public List<Cellar> getCellars() {
		List<Cellar> cellars = cellarRepository.findAll();
		return cellars;
	}


}
