package de.ihrigb.commons;

import java.util.function.Function;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UnitTest {

	private final static double DELTA = 0.0000000001d;

	@Test
	public void testConstructorAssertions() throws Exception {
		Assertions.assertAll(
				() -> Assertions.assertThrows(IllegalArgumentException.class, () -> new Unit(null, null, null) {
				}), () -> Assertions.assertThrows(IllegalArgumentException.class, () -> new Unit("sign", null, null) {
				}), () -> Assertions.assertThrows(IllegalArgumentException.class,
						() -> new Unit("sign", Function.identity(), null) {
						}));
	}

	@Test
	public void testUnit() throws Exception {
		Unit unit = new Unit("sign", v -> v * 2, v -> v / 2) {
		};

		Assertions.assertAll(() -> Assertions.assertEquals("sign", unit.getSign()),
				() -> Assertions.assertEquals("sign", unit.toString()),
				() -> Assertions.assertEquals(10, unit.toSi(5), DELTA),
				() -> Assertions.assertEquals(5, unit.fromSi(10), DELTA));
	}

	@Test
	public void testSiUnit() throws Exception {
		Unit unit = new Unit("siUnit") {
		};

		Assertions.assertAll(() -> Assertions.assertEquals("siUnit", unit.getSign()),
				() -> Assertions.assertEquals("siUnit", unit.toString()),
				() -> Assertions.assertEquals(5, unit.toSi(5), DELTA),
				() -> Assertions.assertEquals(10, unit.fromSi(10), DELTA));
	}

	@Test
	public void testDecimalPowersUnit() throws Exception {
		Unit unit = new Unit("mUnit", UnitPrefix.MILLI) {
		};

		Assertions.assertAll(() -> Assertions.assertEquals("mUnit", unit.getSign()),
				() -> Assertions.assertEquals("mUnit", unit.toString()),
				() -> Assertions.assertEquals(0.005, unit.toSi(5), DELTA),
				() -> Assertions.assertEquals(5, unit.fromSi(0.005), DELTA));
	}
}
