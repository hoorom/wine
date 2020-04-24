package com.wine.auth.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.wine.person.domain.Person;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


/**
 * Utilisateur
 */
@Entity	
@ToString
@EqualsAndHashCode
@Table(name = "USERS")
public class User {
	
	@Id
    @GeneratedValue
    @Getter @Setter
	private Long id;

	@Getter @Setter
	private String username;
	
	@Getter @Setter
	private String password;
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "person_id")
	@Getter
	@Setter
	private Person person;
	
}
