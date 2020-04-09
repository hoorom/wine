package com.wine.bottle.domain;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.wine.bottle.util.WineColor;

import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity
@ToString
@EqualsAndHashCode
public class Wine {

	@GeneratedValue
	@Id
	private Long id;
	
	@Enumerated(EnumType.STRING)
	private WineColor color;
	
}
