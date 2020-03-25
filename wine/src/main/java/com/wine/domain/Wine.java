package com.wine.domain;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.wine.util.WineColor;

import lombok.Data;

@Entity
@Table(name="WINE")
@Data
public class Wine {

	@GeneratedValue
	@Id
	private Long id;
	
	@Enumerated(EnumType.STRING)
	private WineColor color;
	
}
