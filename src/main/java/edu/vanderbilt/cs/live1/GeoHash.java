package edu.vanderbilt.cs.live1;



public class GeoHash {

	/**
	 * This first live session will focus on basic Java and some concepts important to
	 * functional programming, such as recursion. In addition, you will work with arrays
	 * in ways that will help you on Assignment 1. 
	 * 
	 * This class uses a main() method where we can write our own simple "experiments" to
	 * test how our code works. You are encouraged to modify the main method to play around
	 * with your code and understand it. When you have working code, you can extract it 
	 * into a method. When you have working examples with assertions, you can extract them
	 * into tests. 
	 * 
	 * 
	 * This class will provide an implementation of GeoHashes:
	 * 
	 * https://www.mapzen.com/blog/geohashes-and-you/
	 * https://en.wikipedia.org/wiki/Geohash
	 * 
	 * 
	 * GeoHash Spatial Precision:
	 * 
	 * Bits Spatial Tile Size 1 5,009.4km x 4,992.6km 2 1,252.3km x 624.1km 3
	 * 156.5km x 156km 4 39.1km x 19.5km 5 4.9km x 4.9km 6 1.2km x 609.4m 7 152.9m x
	 * 152.4m 8 38.2m x 19m 9 4.8m x 4.8m 10 1.2m x 59.5cm 11 14.9cm x 14.9cm 12
	 * 3.7cm x 1.9cm
	 * 
	 * See:
	 * https://releases.dataone.org/online/api-documentation-v2.0.1/design/geohash.html
	 */

	public static final double[] LATITUDE_RANGE = { -90, 90 };
	public static final double[] LONGITUDE_RANGE = { -180, 180 };

	public static boolean[] insert(boolean[] arr, int index, boolean v) {

		// @ToDo:
		//
		// Implement a method that takes an array, index, and value and
		// inserts the value at the specified index in the array.
		//
		// If the index is beyond the bounds of the array, create a new
		// array that has sufficient size, copy in the original data,
		// and add the value at the index.
		//
		// The updated array should be returned.
		//
		// This will help you with Assignment 1

		return arr;
	}

	// This could be more efficiently implemented with a BitSet!
	public static boolean[] geohash(double valueToHash, double[] valueRange, int bitsOfPrecision, boolean[] resultHash,
			int currentResultIndex) {

		// It may help you to print out what is happening:
		//
		// System.out.println("hash " + valueToHash +" [" + valueRange[0] +"," +
		// valueRange[1] + "]");

		// @ToDo:
		//
		// Implement GeoHashing with a recursive algorithm for a single value (NOT! a
		// latitude, longitude pair).
		//
		// For now, this method only needs to "geohash" either latitute or longitude
		// separately.
		//
		// You will be passed a valueToHash and a valueRange (e.g., the range of
		// longitudes or latitudes).
		//
		// The bits of precision is the number of bits that should be in your output
		// hash.
		//
		// The resultHash should be built of incrementally as you recursively compute
		// the bits of the
		// hash. You should use your insert() method to add bits to the hash.

		return null;
	}

	public static boolean[] geohash(double valueToHash, double[] valueRange, int bitsOfPrecision) {
		return geohash(valueToHash, valueRange, bitsOfPrecision, new boolean[1], 0);
	}

	public static boolean[] geohash(double lat, double lon, int bitsOfPrecision) {

		// @ToDo:
		//
		// Implement GeoHashing for latitude,longitude pairs using your existing geohash
		// implementation
		// for a single value.
		//
		// You will need to calculate two separate geoghash boolean[] arrays, one for
		// lat, and one for lon.
		// You will then need to combine the two arrays into a single array that
		// alternates values for
		// latitude and longitude.

		return null;
	}

	public static String toHashString(boolean[] geohash) {
		String hashString = "";
		for (boolean b : geohash) {
			hashString += (b ? "1" : "0");
		}
		return hashString;
	}

	public static String geohashString(double valueToHash, double[] valueRange, int bitsOfPrecision) {
		return toHashString(geohash(valueToHash, valueRange, bitsOfPrecision));
	}

	public static void assertEquals(String v1, String v2) {
		if(!v1.contentEquals(v2)) {
			throw new RuntimeException(v1 + " != " + v2);
		}
	}
	
	public static void main(String[] args) {
		
		// Feel free to experiment down here. 
		//
		// You can execute anything you put in here by right-click->run as->Java Application
		//
		
		
		assertEquals("00000", geohashString(LONGITUDE_RANGE[0], LONGITUDE_RANGE, 5));
		assertEquals("00000", geohashString(LATITUDE_RANGE[0], LATITUDE_RANGE, 5));
		assertEquals("11111", geohashString(LONGITUDE_RANGE[1], LONGITUDE_RANGE, 5));
		assertEquals("11111", geohashString(LATITUDE_RANGE[1], LATITUDE_RANGE, 5));
		assertEquals("10000", geohashString(0, LONGITUDE_RANGE, 5));
		assertEquals("11000", geohashString(90.0, LONGITUDE_RANGE, 5));
		assertEquals("11100", geohashString(135.0, LONGITUDE_RANGE, 5));
		assertEquals("11110", geohashString(157.5, LONGITUDE_RANGE, 5));
		assertEquals("11111", geohashString(168.75, LONGITUDE_RANGE, 5));
		assertEquals("01111", geohashString(-1, LONGITUDE_RANGE, 5));
		assertEquals("00111", geohashString(-91.0, LONGITUDE_RANGE, 5));
		assertEquals("00011", geohashString(-136.0, LONGITUDE_RANGE, 5));
		assertEquals("00001", geohashString(-158.5, LONGITUDE_RANGE, 5));
		assertEquals("00000", geohashString(-169.75, LONGITUDE_RANGE, 5));
	}

}
