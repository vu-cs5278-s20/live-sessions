package edu.vanderbilt.cs.live9.di.components;

import org.springframework.stereotype.Component;

@Component
public class ShockSettings {

	private Bicycle bicycle;

	public Bicycle getBicycle() {
		return bicycle;
	}

	public void setBicycle(Bicycle bicycle) {
		this.bicycle = bicycle;
	}

}
