package edu.vanderbilt.cs.live9.car.impl;

import edu.vanderbilt.cs.live9.car.Wheel;

public class WheelWithWornTire implements Wheel {

	public int rotate(int rpms) {
		
		return rpms / 2;
	}
	
}
