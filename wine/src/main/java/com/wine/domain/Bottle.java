package com.wine.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity	
@Table(name="BOTTLE")
/**
 * Bouteille
 */
@Getter
@Setter
@ToString
@EqualsAndHashCode
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
	@Getter
	@Setter
	private String name;
	
	@Column(name="vintage")
	private Integer vintage;
	
}
