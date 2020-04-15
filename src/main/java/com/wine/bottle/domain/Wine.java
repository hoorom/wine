package com.wine.bottle.domain;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.wine.bottle.util.WineColor;

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
