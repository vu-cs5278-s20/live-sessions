package edu.vanderbilt.cs.live8.trees.strategies.rf;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import edu.vanderbilt.cs.live8.trees.SplitPoint;
import edu.vanderbilt.cs.live8.trees.SplitStrategy;

public class RandomTreeSplitStrategy implements SplitStrategy<Labeled> {

	private final int[] attributesToConsider;

	public RandomTreeSplitStrategy(int[] attributesToConsider) {
		super();
		this.attributesToConsider = attributesToConsider;
	}

	public double sumOfSquares(List<Labeled> data) {
		double mean = data.stream().mapToDouble(d -> d.label()).average().getAsDouble();

		double sum = data.stream().mapToDouble(d -> d.label()).map(d -> ((d - mean) * (d - mean))).sum();

		return sum;
	}

	public double sumOfSquaresForSplit(List<Labeled> data, int splitIndex) {
		return sumOfSquares(data.subList(0, splitIndex)) + sumOfSquares(data.subList(splitIndex, data.size()));
	}

	public double[] minimumSumOfSquares(List<Labeled> data, int attribute) {

		data.sort((a, b) -> Double.compare(a.attribute(attribute), b.attribute(attribute)));

		double[] minSplit = IntStream.range(1, data.size())
				.mapToObj(i -> (new double[] { i, data.get(i).attribute(attribute) }))
				.collect(Collectors.toMap(v -> v[1], v -> v[0], (a, b) -> Math.min(a, b))).entrySet().stream()
				.map(e -> (new double[] { e.getKey(), e.getValue(),
						sumOfSquaresForSplit(data, e.getValue().intValue()) }))
				.min((a, b) -> Double.compare(a[2], b[2])).orElse(new double[] { 0, 0, 0 });

		return minSplit;
	}

	@Override
	public SplitPoint<Labeled> split(List<Labeled> data) {
		int totalAttributes = attributesToConsider.length; 
		
		
		int randomIndex = (int) Math.rint(Math.random() * (totalAttributes - 1));
		int splitAttribute = attributesToConsider[randomIndex];
		int splitIndex = (int) minimumSumOfSquares(data, splitAttribute)[1];
		double value = data.get(splitIndex).attribute(splitAttribute);

		return new AttrSplitPoint<Labeled>(splitAttribute, value);
	}

	public static void main(String[] args) {
		RandomTreeSplitStrategy rs = new RandomTreeSplitStrategy(new int[] {0});

		List<Labeled> data = Arrays.asList(Labeled.attributes(new double[] { 1, 1 }),
				Labeled.attributes(new double[] { 1, 2 }), Labeled.attributes(new double[] { 4, 3 }),
				Labeled.attributes(new double[] { 9, 4 }), Labeled.attributes(new double[] { 11, 5 }),
				Labeled.attributes(new double[] { 4, 6 }));

		List<Labeled> data2 = Arrays.asList(Labeled.attributes(new double[] { 1, 1 }),
				Labeled.attributes(new double[] { 1, 2 }), Labeled.attributes(new double[] { 4, 3 }),
//						Labeled.attributes(new double[] {9,4}),
//						Labeled.attributes(new double[] {11,5}),
				Labeled.attributes(new double[] { 4, 6 }));

		System.out.println("Sum of Squares: " + rs.sumOfSquares(data));
		System.out.println("Sum of Squares: " + rs.sumOfSquares(data2));
		System.out.println("Min Sum of Squares Split: " + Arrays.toString(rs.minimumSumOfSquares(data, 0)));
	}

}
