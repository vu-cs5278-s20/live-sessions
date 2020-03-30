package edu.vanderbilt.cs.live9.car.impl;

import edu.vanderbilt.cs.live9.car.Engine;
import edu.vanderbilt.cs.live9.car.Status;

public class TempramentalEngine implements Engine {

	private boolean failedToStartFlag = false;
	private boolean started = false;
	
	public void jumpstart() {
		failedToStartFlag = false;
	}
	
	@Override
	public Status start() {
		
		Status status = null;
		
		if(this.failedToStartFlag || Math.random() < 0.2) {
			this.failedToStartFlag = true;
			status = new Status(0, "Failed to Start");
		}
		else {
			this.started = true;
			status = new Status(1, "Started");
		}
		
		return status;
	}

	@Override
	public Status stop() {
		this.started = false;
		return new Status(1, "Stopped");
	}

	@Override
	public void showCode(int code) {
		throw new RuntimeException(""+code);
	}

	@Override
	public void applyGas(int gasPedalPosition) {
		if(this.started) {
			throw new RuntimeException("Boom");
		}
	}

}
