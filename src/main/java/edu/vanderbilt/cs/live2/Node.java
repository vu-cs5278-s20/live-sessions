package edu.vanderbilt.cs.live2;

// @ToDo:
//
// How would you refactor this code
// to use Java generics?
//
public class Node {
	
	private long value;
	private Object data;

	
	private Node leftChild;

	private Node rightChild;

	public Node(long val) {
		this.value = val;
	}
	
	public Node(long val, Object data) {
		this.value = val;
		this.data = data;
	}

	public boolean isLeaf() {
		return this.leftChild == null;
	}
	
	public void split(long value, Object data) {
		long leftVal = Math.min(value, this.value);
		Object leftData = (leftVal == value)? data : this.data;
		
		long rightVal = (leftVal == value)? this.value : value;
		Object rightData = (leftVal == value)? this.data : data;
		
		leftChild = new Node(leftVal, leftData);
		rightChild = new Node(rightVal, rightData);
		
		this.value = 1 + (this.value + value) / 2;
		this.data = null;
	}
	
	public void insert(long value, Object data) {
		if (isLeaf() && this.value == value) {
			this.data = data;
		}
		else if (isLeaf()) {
			split(value, data);
		} else if (value < this.value) {
			this.leftChild.insert(value, data);
		} else {
			this.rightChild.insert(value, data);
		}

	}

	private boolean contains(long v, Node n) {
		return (n != null && n.contains(v));
	}
	
	public boolean contains(long v) {
		if(isLeaf() && this.value == v) {
			return true;
		}
		else if(v < this.value) {
			return contains(v, this.leftChild);
		}
		else {
			return contains(v, this.rightChild);
		}
	}
	
	public Object get(long v) {
		if(isLeaf() && this.value == v) {
			return this.data;
		}
		else if(v < this.value && !isLeaf()) {
			return this.leftChild.get(v);
		}
		else if(!isLeaf()){
			return this.rightChild.get(v);
		}
		else {
			return null;
		}
	}
	
	private String toString(String indent) {
		return indent + this.value + "[" + this.data + "]"
			   + (isLeaf()? "" : (this.leftChild.toString("\n" + indent + "  ") 
					           + (this.rightChild.toString("\n"+ indent + "  "))));   	
	}
	
	public String toString() {
		return toString("");
	}
	
	public static void main(String[] args) {
		System.out.println(99L / 2L);
		
		Node tree = new Node(0);
		tree.insert(100, "a");
		tree.insert(50, "b");
		tree.insert(98, "c");
		
		System.out.println(tree);
	
	}
}
