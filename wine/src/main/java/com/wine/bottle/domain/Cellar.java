package com.wine.bottle.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity	
@ToString
@EqualsAndHashCode
/**
 * Cave
 */
public class Cellar {

	@Id
    @GeneratedValue
	private Long id;

	private String name;
	
	@OneToMany(mappedBy="cellar")
	private List<Bottle> bottles;

}
