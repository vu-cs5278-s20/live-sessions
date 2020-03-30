package edu.vanderbilt.cs.live9.car.impl;

import java.util.List;

import edu.vanderbilt.cs.live9.car.TractionControlSystem;
import edu.vanderbilt.cs.live9.car.Wheel;

public class BasicTractionControlSystem implements TractionControlSystem {
	
	private double[] defaultPowerTransferCoefficients;
	private double[] powerTransferCoefficients;
	
	public BasicTractionControlSystem(double[] powerTransferCoefficients) {
		super();
	
		this.powerTransferCoefficients = powerTransferCoefficients;
		this.defaultPowerTransferCoefficients = powerTransferCoefficients;
	}
	
	public boolean applyPower(int rpms, List<Wheel> wheels) {
		
		boolean slipping = false;
		
		for(int i = 0; i < powerTransferCoefficients.length; i++) {
			int wheelRpms = (int) Math.rint( powerTransferCoefficients[i] * rpms );
			int actualRpms = wheels.get(i).rotate(wheelRpms);
			
			if(actualRpms != wheelRpms) {
				powerTransferCoefficients[i] = powerTransferCoefficients[i] / 2;
				slipping = true;
			}
			else {
				powerTransferCoefficients[i] = defaultPowerTransferCoefficients[i];
			}
		}
		
		return slipping;
	}
	
}
