package edu.vanderbilt.cs.live7.withcommand.commands;

import edu.vanderbilt.cs.live7.withcommand.Action;
import edu.vanderbilt.cs.live7.withcommand.Result;

public class ReserveRestaurantAction implements Action {
	
	private final String restaurant;
	private final int guests;
	
	public ReserveRestaurantAction(String restaurant, int guests) {
		super();
		this.restaurant = restaurant;
		this.guests = guests;
	}

	@Override
	public Result execute() {
		return new ConfirmationResult(this.restaurant, "R" + ((int)(100 * Math.random())));
	}
	
}
