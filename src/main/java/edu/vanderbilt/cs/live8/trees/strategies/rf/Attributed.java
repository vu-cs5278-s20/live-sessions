package edu.vanderbilt.cs.live8.trees.strategies.rf;

import java.util.Arrays;

public interface Attributed {
	
	// Factory Method Pattern
	public static Attributed attributes(double[] data) {
		return new Attributed() {
			
			@Override
			public int totalAttributes() {
				return data.length;
			}
			
			@Override
			public double attribute(int i) {
				return data[i];
			}
			
			public String toString() {
				return Arrays.toString(data);
			}
			
		};
	}
	
	public static Attributed attributesFrom(double... data) {
		return attributes(data);
	}
	
	

	public int totalAttributes();
	public double attribute(int i);
	
}
