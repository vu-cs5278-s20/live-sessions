package edu.vanderbilt.cs.live8.trees;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Node<T> {

	private Node<T> leftChild;
	private Node<T> rightChild;
	
	private SplitPoint<T> splitPoint;
	
	private List<T> nodeData;
	
	public boolean isLeaf() {
		return this.leftChild == null && this.rightChild == null;
	}
	
	public void insert(SplitStrategy<T> splitStrategy, List<T> data) {
		
		this.splitPoint = splitStrategy.split(data);
		
		List<T> leftData = data.stream()
				                      .filter(d -> this.splitPoint.isLeft(d))
				                      .collect(Collectors.toList());
		
		List<T> rightData = data.stream()
				                      .filter(d -> !this.splitPoint.isLeft(d))
				                       .collect(Collectors.toList());
		
		if(leftData.isEmpty()) {
			this.nodeData = rightData;
		}
		else if (rightData.isEmpty()){
			this.nodeData = leftData;
		}
		else {
			this.leftChild = new Node<T>();
			this.leftChild.insert(splitStrategy, leftData);
			
			this.rightChild = new Node<T>();
			this.rightChild.insert(splitStrategy, rightData);
		}
	}
	
	public List<T> get(T data){
		if(isLeaf()) {
			return this.nodeData;
		}
		else if(this.splitPoint.isLeft(data)) {
			return this.leftChild.get(data);
		}
		else {
			return this.rightChild.get(data);
		}
	}
	
	private String toString(String indent) {
		return indent + this.splitPoint + "[" + this.nodeData + "]"
			   + (isLeaf()? "" : "\n" + (this.leftChild.toString(indent + "  ") 
					           + "\n" + (this.rightChild.toString(indent + "  "))));   	
	}
	
	public String toString() {
		return toString("");
	}
	
	
}
