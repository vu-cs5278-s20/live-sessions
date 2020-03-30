package edu.vanderbilt.cs.live9.car;

import java.util.List;

public interface TractionControlSystem {

	public boolean applyPower(int rpms, List<Wheel> wheels);
	
}
