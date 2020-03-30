package edu.vanderbilt.cs.live9.di.components;

import org.springframework.stereotype.Component;

@Component
public class FullSuspensionBike implements Bicycle {

	private ShockSettings settings;
	
	public FullSuspensionBike(ShockSettings settings) {
		this.settings = settings;
	}
	
	@Override
	public void ride() {
		System.out.println("Riding on a trail...");
	}

}
