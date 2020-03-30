package edu.vanderbilt.cs.live9.car;

public class Status {

	public Status(int code, String message) {
		
	}
	
	public String getMessage() {
		return null;
	}
	
	public int getCode() {
		return -1;
	}

	@Override
	public String toString() {
		return "Status [" + getCode() + ":" + getMessage() + "]";
	}
	
}
