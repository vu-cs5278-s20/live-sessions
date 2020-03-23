package edu.vanderbilt.cs.live8.trees;

import java.util.List;

// Strategy Pattern
public interface SplitStrategy<T> {

	public SplitPoint<T> split(List<T> data);
}
