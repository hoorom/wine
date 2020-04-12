package com.wine.bottle.domain;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.wine.bottle.util.BottleSize;
import com.wine.bottle.util.BottleStatus;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity	
/**
 * Bouteille
 */
@ToString
@EqualsAndHashCode
public class Bottle {
	
	@Id
    @GeneratedValue
    @Getter @Setter
	private Long id;
	
	@ManyToOne
    @JoinColumn(name="cellar_id")
	private Cellar cellar;
	
	@ManyToOne
	@JoinColumn(name="wine_id")
	private Wine wine;

	@Getter @Setter
	private String name;
	
	@Getter @Setter
	private Integer vintage;
	
	@Getter @Setter
	@Enumerated(EnumType.STRING)
	private BottleStatus status;
	
	@Getter @Setter
	private BottleSize size;
	
}
