package edu.vanderbilt.cs.live8.trees.strategies.rf;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import edu.vanderbilt.cs.live8.trees.Node;

// Essentially Bridge Pattern
public class RandomRegressionForest {

	private static List<Labeled> randomSample(List<Labeled> data, int size){
		Collections.shuffle(data);
		return data.subList(0, size);
	}
	
	private static Node<Labeled> buildTree(List<Labeled> data, int attributes) {
		Node<Labeled> n = new Node<>();
		
		List<Integer> indexes = IntStream.range(0, data.get(0).totalAttributes())
		          						 .boxed()
		          						 .collect(Collectors.toList());
				
		Collections.shuffle(indexes);
		
		int[] treeAttributes = indexes.stream()
				                      .limit(attributes)
				                      .mapToInt(i -> i.intValue())
				                      .toArray();
		
		n.insert(new RandomTreeSplitStrategy(treeAttributes), data);
		
		return n;
	}
	
	// Factory Method
	public static RandomRegressionForest train(List<Labeled> data, int totalTrees, int sampleSize, int attributesPerTree) {
		
		List<Node<Labeled>> trees = IntStream.range(0, totalTrees)
						  .mapToObj(i -> buildTree(randomSample(data, sampleSize), attributesPerTree))
						  .collect(Collectors.toList());
		
		return new RandomRegressionForest(trees);
	}
	
	
	List<Node<Labeled>> trees = new ArrayList<>();
	
	private RandomRegressionForest(List<Node<Labeled>> trees) {
		super();
		this.trees = trees;
	}

	
	public double predictLabel(Attributed data) {
		
		Labeled toPredict = Labeled.attributes(data, -1);
		
		return trees.stream()
					  .mapToDouble(t -> t.get(toPredict).stream().mapToDouble(d -> d.label()).average().getAsDouble())
					  .average()
					  .getAsDouble();
	}
	
	
	public static void main(String[] args) {
		
		int dataSetSize = 1000;
		List<Labeled> data = new ArrayList<Labeled>();
		
		for(int i = 0; i < dataSetSize; i++) {
			data.add(Labeled.attributes(new double[] { i % 100, (i % 100) + 3, i % 100}));
		}
		
		RandomRegressionForest forest = RandomRegressionForest.train(data, 100, dataSetSize / 10, 1);
		
		System.out.println(forest.predictLabel(Attributed.attributes( new double[] {5, 8})));
		System.out.println(forest.predictLabel(Attributed.attributes( new double[] {51, 54})));
		System.out.println(forest.predictLabel(Attributed.attributes( new double[] {501, 504})));
		System.out.println(forest.predictLabel(Attributed.attributes( new double[] {1001, 1004})));
	}
	
}
