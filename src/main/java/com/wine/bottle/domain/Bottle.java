package com.wine.bottle.domain;


import com.wine.bottle.util.BottleSize;
import com.wine.bottle.util.BottleStatus;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
