package edu.vanderbilt.cs.live2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;

public class TreeMapTest {

	@Test
	public void simpleTest() {
		TreeMap tree = new TreeMap(Object::hashCode);
		tree.put(100,"a");
		tree.put(50,"b");
		tree.put(98,"c");
		
		assertTrue(tree.containsKey(100));
		assertTrue(tree.containsKey(50));
		assertTrue(tree.containsKey(98));
		assertFalse(tree.containsKey(97));
	}
	
	public long randomLong(long min, long max) {
		long r = Math.round(Math.random() * (max - min));
		return min + r;
	}
	
	@Test
	public void propertyTest() {
		
		int sampleSize = (int)randomLong(1,100000);
		long min = Long.MIN_VALUE / 2;
		long max = Long.MAX_VALUE / 2;
		
		TreeMap tree = new TreeMap( v -> ((Long)v).longValue() );
		
		List<Long> keys = new ArrayList<>();
		for(int i = 0; i < sampleSize; i++) {
			keys.add(randomLong(min,max));
		}
		
		for(Long key : keys) {
			tree.put(key, key);
		}
		
		for(Long key : keys) {
			assertEquals(key, tree.get(key));
		}
	}

}
