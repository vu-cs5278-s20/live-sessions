package edu.vanderbilt.cs.live1;

import static org.junit.Assert.*;

import org.junit.Test;

public class GeoHashTest {

	@Test
	public void lowerBoundTest() {
		assertEquals("00000", GeoHash.geohashString(GeoHash.LONGITUDE_RANGE[0], GeoHash.LONGITUDE_RANGE, 5));
		assertEquals("00000", GeoHash.geohashString(GeoHash.LATITUDE_RANGE[0], GeoHash.LATITUDE_RANGE, 5));
	}

	@Test
	public void upperBoundTest() {
		assertEquals("11111", GeoHash.geohashString(GeoHash.LONGITUDE_RANGE[1], GeoHash.LONGITUDE_RANGE, 5));
		assertEquals("11111", GeoHash.geohashString(GeoHash.LATITUDE_RANGE[1], GeoHash.LATITUDE_RANGE, 5));
	}

	@Test
	public void increasingTest() {
		assertEquals("10000", GeoHash.geohashString(0, GeoHash.LONGITUDE_RANGE, 5));
		assertEquals("11000", GeoHash.geohashString(90.0, GeoHash.LONGITUDE_RANGE, 5));
		assertEquals("11100", GeoHash.geohashString(135.0, GeoHash.LONGITUDE_RANGE, 5));
		assertEquals("11110", GeoHash.geohashString(157.5, GeoHash.LONGITUDE_RANGE, 5));
		assertEquals("11111", GeoHash.geohashString(168.75, GeoHash.LONGITUDE_RANGE, 5));
	}

	@Test
	public void decreasingTest() {
		assertEquals("01111", GeoHash.geohashString(-1, GeoHash.LONGITUDE_RANGE, 5));
		assertEquals("00111", GeoHash.geohashString(-91.0, GeoHash.LONGITUDE_RANGE, 5));
		assertEquals("00011", GeoHash.geohashString(-136.0, GeoHash.LONGITUDE_RANGE, 5));
		assertEquals("00001", GeoHash.geohashString(-158.5, GeoHash.LONGITUDE_RANGE, 5));
		assertEquals("00000", GeoHash.geohashString(-169.75, GeoHash.LONGITUDE_RANGE, 5));
	}

	public static String repeat(String toRepeat, int count) {
		String s = "";
		for (int i = 0; i < count; i++) {
			s += toRepeat;
		}
		return s;
	}

	private static double[] randomRange() {
		double max = Double.MAX_VALUE / 2;
		double min = Double.MIN_VALUE / 2;
		double[] range = { Math.random() * min, Math.random() * max };
		return range;
	}

	private static int randomBitsOfPrecision() {
		int bitsOfPrecision = (int) Math.rint(128 * Math.random());
		return bitsOfPrecision;
	}

	private static double[] calculateIncreasingMidPoints(double[] range, int bitsOfPrecision) {
		double[] midPoints = new double[bitsOfPrecision];

		midPoints[0] = (range[0] + range[1]) / 2;

		for (int i = 1; i < midPoints.length; i++) {
			midPoints[i] = (midPoints[i - 1] + range[1]) / 2;
		}
		return midPoints;
	}
	
	private static double[] calculateDecreasingMidPoints(double[] range, int bitsOfPrecision) {
		double[] midPoints = new double[bitsOfPrecision];

		midPoints[0] = (range[0] + range[1]) / 2;

		for (int i = 1; i < midPoints.length; i++) {
			midPoints[i] = (midPoints[i - 1] + range[0]) / 2;
		}
		return midPoints;
	}

	@Test
	public void aroundIncreasingMidPointsTest() {
		double[] range = randomRange();
		int bitsOfPrecision = randomBitsOfPrecision();
		double[] midPoints = calculateIncreasingMidPoints(range, bitsOfPrecision);

		for (int i = 0; i < midPoints.length; i++) {
			String hashstr = GeoHash.geohashString(midPoints[i], range, midPoints.length);
			assertEquals(repeat("1", i + 1), hashstr.substring(0, i + 1));
			
			if(i < midPoints.length - 1) {
				double aboveMidPoint = (midPoints[i] + midPoints[i + 1]) / 2;
				hashstr = GeoHash.geohashString(aboveMidPoint, range, midPoints.length);
				if (aboveMidPoint >= midPoints[i]) {
					assertEquals(repeat("1", i + 1), hashstr.substring(0, i + 1));
				}
			}
			
			if(i > 0) {
				double belowMidPoint = (midPoints[i] + midPoints[i - 1]) / 2;
				hashstr = GeoHash.geohashString(belowMidPoint, range, midPoints.length);
				if (belowMidPoint < midPoints[i]) {
					assertEquals(repeat("1", i) + "0", hashstr.substring(0, i + 1));
				}
			}
		}
	}
	
	@Test
	public void aroundDecreasingMidPointsTest() {
		double[] range = randomRange();
		int bitsOfPrecision = randomBitsOfPrecision();
		double[] midPoints = calculateDecreasingMidPoints(range, bitsOfPrecision);

		for (int i = 0; i < midPoints.length; i++) {
			String hashstr = GeoHash.geohashString(midPoints[i], range, midPoints.length);
			assertEquals(repeat("0", i) + "1", hashstr.substring(0, i + 1));
			
			if(i < midPoints.length - 1) {
				double aboveMidPoint = (midPoints[i] + midPoints[i + 1]) / 2;
				hashstr = GeoHash.geohashString(aboveMidPoint, range, midPoints.length);
				if (aboveMidPoint >= midPoints[i]) {
					assertEquals(repeat("0", i) + "1", hashstr.substring(0, i + 1));
				}
			}
			
			if(i > 0) {
				double belowMidPoint = (midPoints[i] + midPoints[i - 1]) / 2;
				hashstr = GeoHash.geohashString(belowMidPoint, range, midPoints.length);
				if (belowMidPoint < midPoints[i]) {
					assertEquals(repeat("1", i) + "0", hashstr.substring(0, i + 1));
				}
			}
		}
	}

	
	@Test
	public void latLngHashTest() {
		assertEquals("00000", GeoHash.toHashString(GeoHash.geohash(-90.0, -180.0, 5)));
		assertEquals("10101", GeoHash.toHashString(GeoHash.geohash(90.0, -180.0, 5)));
		assertEquals("0000000", GeoHash.toHashString(GeoHash.geohash(-90.0, -180.0, 7)));
		assertEquals("1010101", GeoHash.toHashString(GeoHash.geohash(90.0, -180.0, 7)));
		assertEquals("00000000", GeoHash.toHashString(GeoHash.geohash(-90.0, -180.0, 8)));
		assertEquals("10101010", GeoHash.toHashString(GeoHash.geohash(90.0, -180.0, 8)));	
		assertEquals("00100000", GeoHash.toHashString(GeoHash.geohash(-45.0, -180.0, 8)));
		assertEquals("00101000", GeoHash.toHashString(GeoHash.geohash(-22.5, -180.0, 8)));
	}
	
	
}
