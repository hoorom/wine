package com.wine.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity	
@Table(name="CELLAR")
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Bottle> getBottles() {
		return bottles;
	}

	public void setBottles(List<Bottle> bottles) {
		this.bottles = bottles;
	}
	
	@Override
		public String toString() {
			return id + " " + name;
		}

}
