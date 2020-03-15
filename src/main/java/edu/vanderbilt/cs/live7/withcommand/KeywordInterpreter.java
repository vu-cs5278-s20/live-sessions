package edu.vanderbilt.cs.live7.withcommand;

import java.util.Arrays;

public class KeywordInterpreter implements Interpreter {

	@Override
	public Request parse(String userRequest) {
		String[] parts = userRequest.trim().toLowerCase().split(" ");
		return new Request(parts[0], Arrays.asList(parts).subList(1,parts.length).toArray(new String[0]));
	}

}
