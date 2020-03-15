package edu.vanderbilt.cs.live7.withcommand.commands;

import java.util.UUID;

import edu.vanderbilt.cs.live7.withcommand.Action;
import edu.vanderbilt.cs.live7.withcommand.Result;

public class BookTicketsAction implements Action {

	public enum SeatCategory {
		BEST, AVERAGE, HORRIBLE
	}
	
	private final String event;
	
	private final SeatCategory seatCategory;
	
	private final int count;

	public BookTicketsAction(String event, SeatCategory seatCategory, int count) {
		super();
		this.event = event;
		this.seatCategory = seatCategory;
		this.count = count;
	}

	@Override
	public Result execute() {
		return new ConfirmationResult(this.event, UUID.randomUUID().toString());
	}
	
}
