package edu.vanderbilt.cs.live7.withpatterns.commands;

import edu.vanderbilt.cs.live7.withpatterns.Result;

public class ConfirmationResult implements Result {

	private final String entity;
	private final String code;

	public ConfirmationResult(String entity, String code) {
		super();
		this.entity = entity;
		this.code = code;
	}

	@Override
	public String toHumanReadableString() {
		return "The confirmation for your booking to " + entity +" is: " + code;
	}

}
