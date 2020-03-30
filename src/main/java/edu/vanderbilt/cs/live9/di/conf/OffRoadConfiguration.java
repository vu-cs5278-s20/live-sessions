package edu.vanderbilt.cs.live9.di.conf;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import edu.vanderbilt.cs.live9.di.components.Bicycle;
import edu.vanderbilt.cs.live9.di.components.BikeRide;
import edu.vanderbilt.cs.live9.di.components.FullSuspensionBike;
import edu.vanderbilt.cs.live9.di.components.ShockSettings;

@ComponentScan(basePackageClasses = {Bicycle.class})
@Configuration
public class OffRoadConfiguration {

}
