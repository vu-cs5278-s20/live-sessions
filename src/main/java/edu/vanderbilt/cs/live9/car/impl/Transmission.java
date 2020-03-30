package edu.vanderbilt.cs.live9.car.impl;

import java.util.List;

import edu.vanderbilt.cs.live9.car.Engine;
import edu.vanderbilt.cs.live9.car.TractionControlSystem;
import edu.vanderbilt.cs.live9.car.Wheel;

public class Transmission {

	private TractionControlSystem tractionControlSystem;
	private List<Wheel> wheels;
	private Engine engine;

	public Transmission(TractionControlSystem config, List<Wheel> wheels) {
		super();
		this.tractionControlSystem = config;
		this.wheels = wheels;
	}

	public boolean applyPower(int rpms) {
		boolean slipping = this.tractionControlSystem.applyPower(rpms, wheels);
		if (slipping) {
			// wheels slipping!
			reportCode("wheel slip");
		}
		
		return slipping;
	}

	protected void reportCode(String name) {
		this.engine.showCode(43);
	}

	/**
	 * The setEngine method must be called after the Engine is constructed.
	 * This method MUST be called before the applyPower method is used.
	 * 
	 * @param engine
	 */
	public void setEngine(Engine engine) {
		this.engine = engine;
	}
	
	public Engine getEngine() {
		return this.engine;
	}

}
