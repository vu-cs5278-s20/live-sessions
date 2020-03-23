package edu.vanderbilt.cs.live8.trees.strategies.binary;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import edu.vanderbilt.cs.live8.trees.Node;
import edu.vanderbilt.cs.live8.trees.SplitPoint;
import edu.vanderbilt.cs.live8.trees.SplitStrategy;
import edu.vanderbilt.cs.live8.trees.strategies.rf.AttrSplitPoint;
import edu.vanderbilt.cs.live8.trees.strategies.rf.Attributed;
import edu.vanderbilt.cs.live8.trees.strategies.rf.Labeled;

public class BinaryTreeSplitStrategy implements SplitStrategy<Double> {

	public BinaryTreeSplitStrategy() {
		super();
	}

	@Override
	public SplitPoint<Double> split(List<Double> data) {
		Collections.sort(data, (a,b) -> Double.compare(a,b));
		
		double splitValue = data.get(data.size() / 2);
				
		return new SplitPoint<Double>() {
			@Override
			public boolean isLeft(Double data) {
				return data < splitValue;
			}
			
			public String toString() {
				return ""+ splitValue;
			}
		};
	}
	
	public static void main(String[] args) {
		
		int dataSetSize = 1000;
		List<Double> data = new ArrayList<Double>();
		
		for(int i = 0; i < dataSetSize; i++) {
			data.add(i * Math.random());
		}
		
		BinaryTreeSplitStrategy binary = new BinaryTreeSplitStrategy();
		Node<Double> tree = new Node<>();
		tree.insert(binary, data);
		
		System.out.println(tree);
	}

}
