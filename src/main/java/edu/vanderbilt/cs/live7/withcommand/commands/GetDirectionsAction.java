package edu.vanderbilt.cs.live7.withcommand.commands;

import edu.vanderbilt.cs.live7.withcommand.Action;
import edu.vanderbilt.cs.live7.withcommand.Result;

public class GetDirectionsAction implements Action {

	private class GetDirectionsResult implements Result {

		public final String directions;
		
		public GetDirectionsResult(String directions) {
			super();
			this.directions = directions;
		}

		@Override
		public String toHumanReadableString() {
			return "Your directions to "+GetDirectionsAction.this.destination+" are: "+directions;
		}
		
	}
	
	private final String destination;
	
	public GetDirectionsAction(String destination) {
		super();
		this.destination = destination;
	}

	@Override
	public Result execute() {
		
		return new GetDirectionsResult("turn right, turn right, turn right, turn right...");
	}

}
