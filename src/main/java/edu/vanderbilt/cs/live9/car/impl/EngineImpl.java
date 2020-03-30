package edu.vanderbilt.cs.live9.car.impl;

import edu.vanderbilt.cs.live9.car.Engine;
import edu.vanderbilt.cs.live9.car.Status;

public class EngineImpl implements Engine {

	private final Transmission transmission;
	
	private boolean started = false;
	
	public EngineImpl(Transmission tm) {
		this.transmission = tm;
	}
	
	@Override
	public Status start() {
		this.started = true;
		return new Status(1, "Started");
	}

	@Override
	public Status stop() {
		this.started = false;
		return new Status(1, "Stopped");
	}
	
	private int calculateEngineRpms(int power) {
		return power * 2;
	}

	public void applyGas(int gasPedalPosition) {
		if(this.started) {
			this.transmission.applyPower(calculateEngineRpms(gasPedalPosition));			
		}
	}
	
	public void showCode(int code) {
		System.out.println("Engine code reported: "+ code);
	}
}
