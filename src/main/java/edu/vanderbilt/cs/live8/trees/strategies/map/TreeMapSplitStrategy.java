package edu.vanderbilt.cs.live8.trees.strategies.map;

import java.util.Collections;
import java.util.List;
import java.util.function.Function;

import edu.vanderbilt.cs.live8.trees.SplitPoint;
import edu.vanderbilt.cs.live8.trees.SplitStrategy;
import edu.vanderbilt.cs.live8.trees.strategies.rf.AttrSplitPoint;
import edu.vanderbilt.cs.live8.trees.strategies.rf.Labeled;

public class TreeMapSplitStrategy<T> implements SplitStrategy<T> {

	private final Function<T, Long> hashFn;
	
	public TreeMapSplitStrategy(Function<T, Long> hash) {
		super();
		this.hashFn = hash; 
	}

	@Override
	public SplitPoint<T> split(List<T> data) {
		Collections.sort(data, (a,b) -> Long.compare(this.hashFn.apply(a), this.hashFn.apply(b)));
		
		long splitValue = data.get(data.size() / 2).hashCode();
				
		return new SplitPoint<T>() {
			@Override
			public boolean isLeft(T data) {
				return TreeMapSplitStrategy.this.hashFn.apply(data) < splitValue;
			}
			
			public String toString() {
				return ""+splitValue;
			}
		};
	}

}
