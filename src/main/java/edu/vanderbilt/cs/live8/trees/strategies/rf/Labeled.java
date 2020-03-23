package edu.vanderbilt.cs.live8.trees.strategies.rf;

import java.util.Arrays;

public interface Labeled extends Attributed {

	// Factory Method Pattern
	public static Labeled attributes(double[] data) {
		return new Labeled() {
			
			@Override
			public int totalAttributes() {
				return data.length - 1;
			}
			
			@Override
			public double attribute(int i) {
				return data[i];
			}

			@Override
			public double label() {
				return data[data.length - 1];
			}
			
			public String toString() {
				return Arrays.toString(data);
			}
		};
	}
	
	public static Labeled attributesFrom(double... data) {
		return attributes(data);
	}
	
	// Factory Method Pattern
	public static Labeled attributes(Attributed data, double label) {
		return new Labeled() {
			
			@Override
			public int totalAttributes() {
				return data.totalAttributes() + 1;
			}
			
			@Override
			public double attribute(int i) {
				return (i < data.totalAttributes()) ? data.attribute(i) : label;
			}

			@Override
			public double label() {
				return label;
			}
			
			public String toString() {
				return data.toString() + " : " + label;
			}
		};
	}
	
	public double label();
	
}
