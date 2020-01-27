package edu.vanderbilt.cs.live2;

public class TreeMap {

	private Node root;

	private final HashFn hashFn;

	// @ToDo:
	//
	// How would you refactor this code
	// to use Java's built-in functional interfaces?
	//
	public TreeMap(HashFn hashFn) {
		this.hashFn = hashFn;
	}

	// @ToDo:
	//
	// How would you refactor this code
	// to use Java generics?
	//
	public void put(Object k, Object data) {
		long hashval = this.hashFn.getHash(k);

		if (root == null) {
			root = new Node(hashval, data);
		} else {
			root.insert(hashval, data);
		}
	}

	public boolean containsKey(Object k) {
		long hashval = this.hashFn.getHash(k);
		return (root != null) ? root.contains(hashval) : false;
	}

	public Object get(Object k) {
		long hashval = this.hashFn.getHash(k);

		return (root != null) ? root.get(hashval) : null;
	}

	public String toString() {
		return root.toString();
	}

	public static void main(String[] args) {
		// @ToDo:
		//
		// What is another way of implementing this  
		// with a method reference?
		//
		TreeMap tm = new TreeMap((o) -> o.hashCode());

		tm.put("a", 1);
		tm.put("b", 2);
		tm.put("c", 3);

		System.out.println(tm);

		System.out.println(tm.containsKey("a"));
		System.out.println(tm.containsKey("b"));
		System.out.println(tm.containsKey("c"));
	}

}
