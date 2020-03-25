package com.wine.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity	
@Table(name="BOTTLE")
/**
 * Bouteille
 */
public class Bottle {
	
	@Id
    @GeneratedValue
	private Long id;
	
	@ManyToOne
    @JoinColumn(name="cellar_id")
	private Cellar cellar;
	
	@ManyToOne
	@JoinColumn(name="wine_id")
	private Wine wine;

	@Column(name="name")
	private String name;
	
	@Column(name="vintage")
	private Integer vintage;
	
	
	//TODO Quantit�	Appelation	Domaine	Cuv�e	Couleur	Ann�e	A boire � partir de	A boire jusqu'�	Lieu de stockage

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
	
	@Override
	public String toString() {
		return id + " : " + name;
	}
	
}
