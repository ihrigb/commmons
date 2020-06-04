package de.ihrigb.commons;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import de.ihrigb.commons.Distance.Unit;

public class DistanceTest {

	@Test
	public void test() throws Exception {
		Distance d2m = Distance.ofMeter(2);
		Assertions.assertAll(() -> Assertions.assertEquals(2000d, d2m.getMillimeter(), 0.0000001d),
				() -> Assertions.assertEquals(200d, d2m.getCentimeter(), 0.0000001d),
				() -> Assertions.assertEquals(20d, d2m.getDecimeter(), 0.0000001d),
				() -> Assertions.assertEquals(2d, d2m.getMeter(), 0.0000001d),
				() -> Assertions.assertEquals(.2d, d2m.getDecameter(), 0.0000001d),
				() -> Assertions.assertEquals(.02d, d2m.getHectometer(), 0.0000001d),
				() -> Assertions.assertEquals(.002d, d2m.getKilometer(), 0.0000001d));

		Assertions.assertAll(() -> Assertions.assertEquals("2.000000 m", d2m.toString()),
				() -> Assertions.assertEquals("200.000000 cm", d2m.toString(Unit.CENTIMETER)),
				() -> Assertions.assertEquals("0.002000 km", d2m.toString(Unit.KILOMETER)));
	}
}
