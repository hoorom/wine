package com.wine.frmwrk.form;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 * 
 */
public interface WineForm extends Validator {

	@Override
	public abstract void validate(Object o, Errors errors);

}
