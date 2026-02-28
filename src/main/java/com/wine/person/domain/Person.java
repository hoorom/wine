package com.wine.person.domain;

import com.wine.bottle.domain.Cellar;
import com.wine.person.util.Civility;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.time.LocalDate;
import java.util.Set;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Utilisateur
 */
@Entity
@Getter
@Setter
@ToString(exclude = "cellars")
@EqualsAndHashCode(exclude = "cellars")
public class Person {

	@Id
	@GeneratedValue
	private Long id;

	private Civility civility;

	private String firstName;

	private String lastName;

	private LocalDate birthdate;

	@OneToMany(targetEntity = Cellar.class, mappedBy = "person", orphanRemoval = true, cascade = CascadeType.ALL)
	private Set<Cellar> cellars;

}
