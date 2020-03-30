package edu.vanderbilt.cs.live9.di.conf;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import edu.vanderbilt.cs.live9.di.components.Bicycle;
import edu.vanderbilt.cs.live9.di.components.BikeRide;
import edu.vanderbilt.cs.live9.di.components.RigidBike;

@EnableAutoConfiguration
@Configuration
public class RoadConfiguration {

	@Bean 
	public BikeRide getRide(Bicycle bike) {
		return new BikeRide(bike);
	}
	
	@Bean
	public Bicycle getBike() {
		return new RigidBike();
	}
}
