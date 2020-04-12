package com.wine.bottle.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * Appelation
 */
@Entity
@ToString
@EqualsAndHashCode
public class WineLabel {

	@GeneratedValue
	@Id
	private Long id;

}