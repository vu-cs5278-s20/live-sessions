package edu.vanderbilt.cs.live4;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;

public class BikeRide {
	
	public static BikeRide loadSampleRide() throws IOException {
		ObjectMapper mapper = new ObjectMapper();
		return mapper.readValue(new FileInputStream("src/main/resources/data.json"), BikeRide.class);
	}
	
	public static class DataFrame {
		public final double velocity;
		public final double heartRate;
		public final double grade;
		public final double altitude;
		public final LatLng coordinate;
		
		public DataFrame(LatLng coordinate, double grade, double altitude, double velocity, double heartRate) {
			super();
			this.velocity = velocity;
			this.heartRate = heartRate;
			this.grade = grade;
			this.altitude = altitude;
			this.coordinate = coordinate;
		}
	}
	
	public static class LatLng {
		public final double latitude;
		public final double longitude;
		
		@JsonCreator
		public LatLng(double[] latlng) {
			this.latitude = latlng[0];
			this.longitude = latlng[1];
		}
		
		public boolean equals(Object o) {
			return (o instanceof LatLng) 
					&& ((LatLng)o).latitude == this.latitude
					&& ((LatLng)o).longitude == this.longitude;
		}
	}
	
	public static class LatLngStream {
		public final LatLng[] data;

		@JsonCreator
		public LatLngStream(@JsonProperty("data") LatLng[] data) {
			this.data = data;
		}
		
		@JsonAnySetter
		public void setOther(String key, Object v) {}
	}

	public static class DataStream {

		public final double[] data;

		@JsonCreator
		public DataStream(@JsonProperty("data") double[] data) {
			this.data = data;
		}
		
		@JsonAnySetter
		public void setOther(String key, Object v) {}

	}

	public final double[] heartRate;
	public final double[] velocity;
	public final double[] grade;
	public final double[] altitude;
	public final LatLng[] coordinates;

	@JsonCreator
	public BikeRide(@JsonProperty("heartrate") DataStream heartRate,
			@JsonProperty("velocity_smooth") DataStream velocity, 
			@JsonProperty("grade_smooth") DataStream grade,
			@JsonProperty("altitude") DataStream altitude,
			@JsonProperty("latlng") LatLngStream coordinates) {
		
		super();
		this.heartRate = heartRate.data;
		this.velocity = velocity.data;
		this.grade = grade.data;
		this.altitude = altitude.data;
		this.coordinates = coordinates.data;
	}
	
	// Step 2:
	//
	// Fill in these methods
	public DoubleStream heartRateStream() {
		return null;
	}
	
	public DoubleStream velocityStream() {
		return null;
	}
	
	public DoubleStream gradeStream() {
		return null;
	}
	
	public DoubleStream altitudeStream() {
		return null;
	}
	
	public Stream<LatLng> coordinateStream() {
		return null;
	}
	
	// Step 3:
	//
	//
	// Create a method that returns a stream of 
	// DataFrame objects, where each frame is built from
	// the coordinate, heart rate, grade, etc. that
	// occurs at each index in the data
	//
	public Stream<DataFrame> fusedFramesStream() {
		return Stream.empty();
	}
	
	@JsonAnySetter
	public void setOther(String key, Object v) {
		
	}
	


}
