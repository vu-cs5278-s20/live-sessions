package edu.vanderbilt.cs.live7.withcommand.commands;

import edu.vanderbilt.cs.live7.withcommand.Result;

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
