package com.wine.bottle.domain;

import com.wine.bottle.util.CellarType;
import com.wine.person.domain.Person;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import java.util.List;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@ToString
@EqualsAndHashCode
/**
 * Cave
 */
public class Cellar {

	@Id
    @GeneratedValue
	private Long id;

	/**
	 * Nom
	 */
	@Getter
	@Setter
	private String name;
	
	/**
	 * Bouteilles rangees dedans
	 */
	@OneToMany(mappedBy="cellar")
	@Getter
	@Setter
	private List<Bottle> bottles;

	@Getter
	@Setter
	@ManyToOne
	@JoinColumn(name = "person_id")
	private Person person;

	/**
	 * Type de cave
	 */
	@Getter
	@Setter
	private CellarType type;

}
