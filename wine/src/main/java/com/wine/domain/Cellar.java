package com.wine.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity	
@Table(name="CELLAR")
@Data
/**
 * Cave
 */
public class Cellar {

	@Id
    @GeneratedValue
	private Long id;

	@Column(name="name")
	private String name;
	
	@OneToMany(mappedBy="cellar")
	private List<Bottle> bottles;

}
