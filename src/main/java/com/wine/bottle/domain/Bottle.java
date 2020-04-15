package com.wine.bottle.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
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
	
	@Getter
	@Setter
	@ManyToOne
    @JoinColumn(name="cellar_id")
	private Cellar cellar;
	
	/**
	 * Le vin contenu
	 */
	@Getter
	@Setter
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name="wine_id")
	private Wine wine;

	/**
	 * Le nom
	 */
	@Getter @Setter
	private String name;
	
	/**
	 * Le millesime
	 */
	@Getter @Setter
	private Integer vintage;
	
	/**
	 * Le statut
	 */
	@Getter @Setter
	@Enumerated(EnumType.STRING)
	private BottleStatus status;
	
	/**
	 * La taille
	 */
	@Getter @Setter
	private BottleSize size;
	
}
