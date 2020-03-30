package edu.vanderbilt.cs.live9.car.impl;

import java.util.List;

import edu.vanderbilt.cs.live9.car.TractionControlSystem;
import edu.vanderbilt.cs.live9.car.Wheel;

public class GenericTransmission extends Transmission{

	private EngineCodes codes;
	
	public GenericTransmission(EngineCodes codes, TractionControlSystem config, List<Wheel> wheels) {
		super(config,wheels);
		this.codes = codes;
	}

	@Override
	protected void reportCode(String name) {
		int code = this.codes.getCode("wheel slip");
		this.getEngine().showCode(code);
	}
	
	
	
	
}
