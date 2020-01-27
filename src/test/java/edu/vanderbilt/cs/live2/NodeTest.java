package edu.vanderbilt.cs.live2;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class NodeTest {

	@Test
	public void simpleTest() {
		Node tree = new Node(0);
		tree.insert(100,"a");
		tree.insert(50,"b");
		tree.insert(98,"c");
		
		assertTrue(tree.contains(100));
		assertTrue(tree.contains(50));
		assertTrue(tree.contains(98));
		assertFalse(tree.contains(97));
	}
	
	public long randomLong(long min, long max) {
		long r = Math.round(Math.random() * (max - min));
		return min + r;
	}
	
	@Test
	public void propertyTest() {
		
		int sampleSize = (int) randomLong(1,100000);
		long min = Long.MIN_VALUE;
		long max = Long.MAX_VALUE;
		
		Node tree = new Node(randomLong(min,max));
		
		List<Long> testKeys = new ArrayList<>();
		for(int i = 0; i < sampleSize; i++) {
			testKeys.add(randomLong(min,max));
		}
		
		for(Long key : testKeys) {
			tree.insert(key, key);
		}
		
		for(Long key : testKeys) {
			assertTrue(tree.contains(key));
			assertTrue(key.equals(tree.get(key)));
		}
	}

}
