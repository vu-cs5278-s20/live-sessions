package edu.vanderbilt.cs.live7.withpatterns.commands;

import edu.vanderbilt.cs.live7.withpatterns.Action;
import edu.vanderbilt.cs.live7.withpatterns.Result;

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
