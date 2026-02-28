package com.wine.bottle.domain;


import com.wine.bottle.util.WineColor;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Vin
 */
@Entity
@ToString
@EqualsAndHashCode
public class Wine {

	@GeneratedValue
	@Id
	private Long id;
	
	/**
	 * Couleur du vin
	 */
	@Getter
	@Setter
	@Enumerated(EnumType.STRING)
	private WineColor color;
	
}
