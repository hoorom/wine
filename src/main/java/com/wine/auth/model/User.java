package com.wine.auth.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

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
	
	
}
