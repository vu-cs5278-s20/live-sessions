package edu.vanderbilt.cs.live9.di.components;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BikeRide implements CommandLineRunner {

	private Bicycle bicycle;
	private Rider rider;
	
	@Autowired
	public BikeRide(Bicycle bike) {
		this.bicycle = bike;
		this.rider = new Rider("Default Rider");
	}
	
	public BikeRide(Bicycle bike, Rider r) {
		this.bicycle = bike;
		this.rider = r;
	}
	
    public void run(String...args) throws Exception {
		this.bicycle.ride();
	}
	
}
