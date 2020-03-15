package edu.vanderbilt.cs.live7.withcommand.commands;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import edu.vanderbilt.cs.live7.withcommand.Action;
import edu.vanderbilt.cs.live7.withcommand.Result;

public class CompositeAction implements Action {

	private class CompositeResult implements Result {
		private List<Result> results = new ArrayList<Result>();

		public boolean add(Result e) {
			return results.add(e);
		}

		@Override
		public String toHumanReadableString() {
			return results.stream().map(Result::toHumanReadableString).collect(Collectors.joining("\n"));
		}
	}
	
	
	private final List<Action> children = new ArrayList<Action>();

	public boolean add(Action e) {
		return children.add(e);
	}

	@Override
	public Result execute() {
		CompositeResult result = new CompositeResult();
		for(Action act : children) {
			result.add(act.execute());
		}
		return result;
	}
	
}
