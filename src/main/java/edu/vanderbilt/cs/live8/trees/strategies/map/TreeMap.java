package edu.vanderbilt.cs.live8.trees.strategies.map;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import edu.vanderbilt.cs.live8.trees.Node;

// Bridge Pattern
//
public class TreeMap<K,V> {
	
	public class KeyValue {
		public final K key;
		public final V value;
		
		public KeyValue(K k, V v) {
			this.key = k;
			this.value = v;
		}
	}
	
	private Node<KeyValue> root;
	
	public TreeMap(Function<K, Long> hashFn, List<K> keys, List<V> values) {
		List<KeyValue> data = IntStream.range(0, keys.size())
										.mapToObj(i -> new KeyValue(keys.get(i), values.get(i)))
										.collect(Collectors.toList());
		
		TreeMapSplitStrategy<KeyValue> strat = new TreeMapSplitStrategy<>(kv -> hashFn.apply(kv.key));
		root = new Node<>();
		root.insert(strat, data);
	}
	
	private Optional<V> filter(List<KeyValue> data, KeyValue kv) {
		return root.get(kv)
					.stream()
					.filter(tkv -> tkv.key.equals(kv.key))
					.map(tkv -> tkv.value)
					.findFirst();
	}
	
	public boolean containsKey(K k) {
		KeyValue kv = new KeyValue(k,null);
		return (root != null) ? filter(root.get(kv), kv).isPresent() : false;
	}

	public V get(K k) {
		KeyValue kv = new KeyValue(k,null);
		return (root != null) ? filter(root.get(kv), kv).orElse(null) : null;
	}
	
	public String toString() {
		return root.toString();
	}
	
	public static void main(String[] args) {
		
		List<String> keys = Arrays.asList("a", "b", "c");
		List<Integer> vals = Arrays.asList(1, 2, 3);
		
		TreeMap<String,Integer> tm = new TreeMap<>(k -> (long)k.hashCode(), keys, vals);
	
		System.out.println(tm.containsKey("a"));
		System.out.println(tm.containsKey("b"));
		System.out.println(tm.containsKey("c"));
		System.out.println(tm.containsKey("dasdf"));
	}
	
}
