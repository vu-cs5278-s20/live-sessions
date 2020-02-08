package edu.vanderbilt.cs.live4;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import edu.vanderbilt.cs.live4.BikeRide.LatLng;

public class BikeStats {

	// Step 6:
	//
	// Create a method that returns a stream of sliding windows of <windowSize> 
	// data points. You should only return complete windows. Each window should be
	// a list of the data points present at that step of the window sliding.
	public static <T> Stream<List<T>> slidingWindow(List<T> data, int windowSize){
		return Stream.empty();
	}
	

	public static void log(String key, Object v) {
		System.out.println(key + ": " + v);
	}

	public static void main(String[] args) throws Exception {
		BikeRide ride = BikeRide.loadSampleRide();
		
		// Step 1:
		//
		// Determine the min, max, and average velocity of the ride
		double minSpeed = 0;
		double maxSpeed = 0;
		double avgSpeed = 0;
	
		log("Data points", ride.velocity.length);
		log("Min speed", minSpeed);
		log("Max speed", maxSpeed);
		log("Avg speed", avgSpeed);
		
		// Step 4:
		//
		// Determine how many times the rider stopped
		//
		long stops = 0;
		
		log("Stops", stops);
		
		// Step 5:
		//
		// Determine the number of unique locations that the
		// rider stopped. A location is unique if there are no
		// other stops at the same latitude / longitude. 
		// Print out the location of each stop.
		//
		System.out.println("Locations with stops:");
		
		
		
		// Step 7:
		//
		// Calculate and print out the average speed over each window of 5 data points for the
		// entire bike ride.
		//
		List<Double> avgSpeeds = Collections.emptyList();
		
		System.out.println("Avg Speed Windows:");
		avgSpeeds.forEach(a -> System.out.println(a));
		
		
		// Step 8:
		//
		// Group your data points by the first 40bits of their geohashes and then print out all
		// data point coordinates that match on the first 40bits.
		
		Map<String,List<LatLng>> close = Collections.emptyMap();
		
		for(String key : close.keySet()) {
			System.out.println("At geohash prefix: " + key);
			for(LatLng coord : close.get(key)) {
				System.out.println(coord.latitude +","+ coord.longitude);
			}
		}
		
	}
	
}
