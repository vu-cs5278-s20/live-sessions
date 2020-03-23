package edu.vanderbilt.cs.live8.trees;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

import edu.vanderbilt.cs.live8.trees.Node;

public class NodeTest {

	private SplitStrategy<Integer> unbalanced = new SplitStrategy<Integer>() {
		
		@Override
		public SplitPoint<Integer> split(List<Integer> data) {
			Collections.sort(data);
			
			int first = data.get(0);
			
			return new SplitPoint<Integer>() {
				
				@Override
				public boolean isLeft(Integer data) {
					return data.equals(first);
				}
			};
		}
	};
	
	@Test
	public void simpleTest() {
		
		Node<Integer> tree = new Node<>();
		tree.insert(unbalanced, Arrays.asList(100, 50, 98));
		
		
		assertFalse(tree.get(100).isEmpty());
		assertFalse(tree.get(50).isEmpty());
		assertFalse(tree.get(98).isEmpty());
		assertFalse(tree.get(97).isEmpty());
	}
	
	public int randomInteger(int min, int max) {
		int r = (int)Math.round(Math.random() * (max - min));
		return min + r;
	}
	
	@Test
	public void propertyTest() {
		
		int sampleSize = (int) randomInteger(1,10000);
		int min = Integer.MIN_VALUE;
		int max = Integer.MAX_VALUE;
		
		List<Integer> testKeys = new ArrayList<>();
		for(int i = 0; i < sampleSize; i++) {
			testKeys.add(randomInteger(min,max));
		}
		
		Node<Integer> tree = new Node<>();
		tree.insert(unbalanced, testKeys);
		
		for(Integer key : testKeys) {
			assertFalse(tree.get(key).isEmpty());
		}
	}

}
