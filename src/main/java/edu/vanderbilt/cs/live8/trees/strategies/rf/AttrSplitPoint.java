package edu.vanderbilt.cs.live8.trees.strategies.rf;

import java.util.List;
import java.util.stream.Collectors;

import edu.vanderbilt.cs.live8.trees.SplitPoint;

public class AttrSplitPoint<T extends Attributed> implements SplitPoint<T> {

	private final int attribute;
	private final double value;

	public AttrSplitPoint(int attribute, double value) {
		super();
		this.attribute = attribute;
		this.value = value;
	}

	@Override
	public boolean isLeft(Attributed data) {
		return data.attribute(this.attribute) < value;
	}

	public String toString() {
		return attribute + ":" + value; 
	}
}
