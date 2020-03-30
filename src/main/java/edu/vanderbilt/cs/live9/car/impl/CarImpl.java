package edu.vanderbilt.cs.live9.car.impl;

import java.util.Collections;
import java.util.List;

import edu.vanderbilt.cs.live9.car.Car;
import edu.vanderbilt.cs.live9.car.Engine;
import edu.vanderbilt.cs.live9.car.Status;
import edu.vanderbilt.cs.live9.car.Wheel;

public class CarImpl implements Car {

	private final Engine engine;
	private final List<Wheel> wheels;
	private final Transmission transmission;
	
	
	public CarImpl(Engine engine, Transmission transmission, List<Wheel> wheels) {
		super();
		this.engine = engine;
		this.transmission = transmission;
		this.wheels = Collections.unmodifiableList(wheels);
	}

	@Override
	public Status start() {
		return this.engine.start();
	}

	@Override
	public Status stop() {
		return this.engine.stop();
	}

	@Override
	public Engine getEngine() {
		return this.engine;
	}
	
	public void applyGas(int gasPedalPosition) {
		this.engine.applyGas(gasPedalPosition);
	}

	@Override
	public List<Wheel> getWheels() {
		return this.wheels;
	}
	


}
