package de.ihrigb.commons;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class HaversineTest {

	private final static double DELTA = 0.001d;

	@Test
	public void test() throws Exception {
		Assertions.assertEquals(70432.888669d, Haversine.distance(49.654321, 8.654321, 49.123456, 8.123456).getMeter(),
				DELTA);
	}
}
