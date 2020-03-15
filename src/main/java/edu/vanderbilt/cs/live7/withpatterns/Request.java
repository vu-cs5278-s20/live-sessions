package edu.vanderbilt.cs.live7.withpatterns;

public class Request {

	public final String requestType;
	
	public final String[] arguments;

	public Request(String requestType, String[] arguments) {
		super();
		this.requestType = requestType;
		this.arguments = arguments;
	}
	
	public String argAsString(int arg) {
		return arguments[arg];
	}
	
	public int argAsInt(int arg) {
		return Integer.parseInt(arguments[arg]);
	}
	
}
