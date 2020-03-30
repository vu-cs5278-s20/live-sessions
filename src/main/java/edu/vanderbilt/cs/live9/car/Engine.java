package edu.vanderbilt.cs.live9.car;

public interface Engine {

	public Status start();
	
	public Status stop();
	
	public void showCode(int code);
	
	public void applyGas(int gasPedalPosition);
}
